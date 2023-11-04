package com.innings2023.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
public class LeetCodeApplication {

    public static void main(String[] args) {
        System.out.println(new ArrayList<>(Thread.getAllStackTraces()
                .keySet()));
        SpringApplication.run(LeetCodeApplication.class, args);
    }

}
