package org.example.tpo_07.model;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Component;

@Component
public class JavaFormatter {
    public String format(String input) throws FormatterException {
        return new Formatter().formatSource(input);
    }
}
