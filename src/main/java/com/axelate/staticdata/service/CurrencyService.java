package com.axelate.staticdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axelate.staticdata.exception.NotFoundException;
import com.axelate.staticdata.model.Currency;
import com.axelate.staticdata.repository.CurrencyRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CurrencyService {
	
private final CurrencyRepository repository;
	
    public List<Currency> findAll() {
        return repository.findAll();
    }
    public Currency save(Currency currency) {
        return repository.save(currency);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Currency findCurrencyById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No currency found with id: " + id));
               
    }
	public Currency updateCurrency(Long id, Currency currency) {
		return repository.save(currency);
		
	}

}
