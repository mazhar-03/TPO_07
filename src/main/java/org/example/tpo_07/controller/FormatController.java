package org.example.tpo_07.controller;

import com.google.googlejavaformat.java.FormatterException;
import org.example.tpo_07.model.JavaFormatter;
import org.example.tpo_07.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormatController {
    private final JavaFormatter formatter;
    private final StorageService storageService;

    public FormatController(JavaFormatter formatter, StorageService storageService) {
        this.formatter = formatter;
        this.storageService = storageService;
    }

}
