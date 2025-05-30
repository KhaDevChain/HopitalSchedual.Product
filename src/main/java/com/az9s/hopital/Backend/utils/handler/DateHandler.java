package com.az9s.hopital.Backend.utils.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateHandler {
    private String format;
    
    public DateHandler() {
        this.format = "dd/MM/yyyy";
    }
    
    public DateHandler(String format) {
        this.format = format;
    }
    
    public String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.format);
        return dateTime.format(formatter);
    }
    
    public LocalDateTime parseDateTime(String dateTimeStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.format);
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public boolean isBetween(LocalDateTime target, LocalDateTime start, LocalDateTime end) {
        return (target.isEqual(start) || target.isAfter(start)) 
                && (target.isEqual(end) || target.isBefore(end));
    }

    public boolean isAfter(LocalDateTime target, LocalDateTime dateTime) {
        return target.isAfter(dateTime);
    }
    
    public boolean isBefore(LocalDateTime target, LocalDateTime dateTime) {
        return target.isBefore(dateTime);    
    }
}
