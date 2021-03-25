package com.company.palindromic.repository;

import com.company.palindromic.entity.Palindromic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PalindromicRepository extends CrudRepository<Palindromic, String> {
    Optional<Palindromic> findByOrigin(String origin);
    Palindromic save(Palindromic palin);
    List<Palindromic> findAll();
}
