package com.company.palindromic.service;

import com.company.palindromic.entity.Palindromic;

import java.util.List;

public interface PalindromicService {
    void savePalindromic(String origin);
    Palindromic findPalindromic(String origin);
    List<Palindromic> findAll();
    String getLongestPalindromicSubstring(String origin);
}
