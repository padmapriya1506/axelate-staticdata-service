package com.axelate.staticdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axelate.staticdata.model.Language;

@Repository
public interface LanguageRepository  extends JpaRepository<Language, Long> {

}
