package org.example.tpo_07.controller;

import com.google.googlejavaformat.java.FormatterException;
import org.example.tpo_07.model.FormattedVersion;
import org.example.tpo_07.model.JavaFormatter;
import org.example.tpo_07.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class FormatController {
    private final JavaFormatter formatter;
    private final StorageService storageService;

    public FormatController(JavaFormatter formatter, StorageService storageService) {
        this.formatter = formatter;
        this.storageService = storageService;
    }

    @GetMapping("/code")
    public String formSide() {
        return "form";
    }

    @PostMapping("/code")
    public String formatCode(@RequestParam String id,
                             @RequestParam String code,
                             @RequestParam int duration,
                             Model model) {
        if (duration < 10 || duration > 7776000) {
            model.addAttribute("message", "Invalid duration: must be between 10 seconds and 90 days.");
            return "error";
        }

        try{
            String formatted = formatter.format(code);
            FormattedVersion saved = new FormattedVersion();

            saved.setId(id);
            saved.setOriginalVersion(code);
            saved.setFormattedVersion(formatted);
            saved.setCreationTime(LocalDateTime.now());
            saved.setExpireInSeconds(duration);

            storageService.save(saved);

            model.addAttribute("original", code);
            model.addAttribute("formatted", formatted);
            return "result";
        }catch (FormatterException e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
