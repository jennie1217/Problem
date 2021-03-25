package com.company.palindromic.service;

import com.company.palindromic.entity.Palindromic;
import com.company.palindromic.repository.PalindromicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalindromicServiceImpl implements PalindromicService{

    PalindromicRepository palindromicRepository;

    public PalindromicServiceImpl(PalindromicRepository palindromicRepository) {
        this.palindromicRepository = palindromicRepository;
    }

    @Override
    public void savePalindromic(String origin) {
        String longest = getLongestPalindromicSubstring(origin);
        palindromicRepository.save(new Palindromic(origin, longest));
    }

    @Override
    public Palindromic findPalindromic(String origin) {
        Optional<Palindromic> palinOptional = palindromicRepository.findByOrigin(origin);
        if (palinOptional.isPresent()) {
            return palinOptional.get();
        }
        String longest = getLongestPalindromicSubstring(origin);
        Palindromic palinEntity = new Palindromic(origin, longest);
        palindromicRepository.save(palinEntity);
        return palinEntity;
    }

    @Override
    public List<Palindromic> findAll() {
        return palindromicRepository.findAll();
    }

    @Override
    public String getLongestPalindromicSubstring(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String oddPalindrome = searchPalindrome(s, i, i);
            if (oddPalindrome.length() > res.length()) {
                res = oddPalindrome;
            }
            String evenPalindrome = searchPalindrome(s, i, i + 1);
            if (evenPalindrome.length() > res.length()) {
                res = evenPalindrome;
            }
        }
        return res;
    }

    public String searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }
}
