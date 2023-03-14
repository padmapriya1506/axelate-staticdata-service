package com.axelate.staticdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.staticdata.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

import com.axelate.staticdata.exception.NotFoundException;
import com.axelate.staticdata.model.Language;


@Transactional
@RequiredArgsConstructor
@Service
public class LanguageService {
	
private final LanguageRepository repository;
	
    public List<Language> findAll() {
        return repository.findAll();
    }
    public Language save(Language language) {
        return repository.save(language);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Language findLanguageById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No language found with id: " + id));
               
    }
	public Language updateLanguage(Long id, Language language) {
		return repository.save(language);
		
	}


}
