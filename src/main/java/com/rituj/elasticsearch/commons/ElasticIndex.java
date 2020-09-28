package com.rituj.elasticsearch.commons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ElasticIndex {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public String getIndexDate() {
        return formatter.format(LocalDate.now());
    }
}   