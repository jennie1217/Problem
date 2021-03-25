package com.company.palindromic.controller;

import com.company.palindromic.entity.Palindromic;
import com.company.palindromic.service.PalindromicServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/palindromic")
public class PalindromicController {
    PalindromicServiceImpl palindromicServiceImpl;

    PalindromicController(PalindromicServiceImpl palindromicServiceImpl) {
        this.palindromicServiceImpl = palindromicServiceImpl;
    }

    @GetMapping("/{origin}")
    public Palindromic getLongestPalindromicSubstring(@PathVariable String origin) {
        return palindromicServiceImpl.findPalindromic(origin);
    }
    
    @GetMapping("/getAll")
    public List<Palindromic> getAll() {
        return palindromicServiceImpl.findAll();
    }
}
