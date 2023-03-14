package com.axelate.staticdata.controller;

import static com.axelate.staticdata.controller.CurrencyController.CURRENCY_BASE_URL;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axelate.staticdata.model.Currency;
import com.axelate.staticdata.model.Language;
import com.axelate.staticdata.service.CurrencyService;
import com.axelate.staticdata.service.LanguageService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(CURRENCY_BASE_URL)
@Validated
@AllArgsConstructor
public class CurrencyController {
	
	public static final String CURRENCY_BASE_URL = "/currency";
	public static final String CURRENCY_BY_ID_URL = "/currency/{id}";

	private final CurrencyService service;

	@Operation(summary = "Get  list of currencies", description = "Get list of currencies")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Currency> findAll() {
		return service.findAll();
	}

	@Operation(summary = "Get a currency  by Id", description = "Get a currency by Id")
	@GetMapping(value = CURRENCY_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Currency findById(@PathVariable Long id) {
		return service.findCurrencyById(id);
	}

	@Operation(summary = "save a currency", description = "Save currency")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Currency saveLanguage(@RequestBody Currency currency) {
		return service.save(currency);
	}

	@Operation(summary = "delete a currency", description = "Delete a currency")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCurrency(@PathVariable Long id) {
		service.deleteById(id);
	}

	@Operation(summary = "update a language", description = "update a language")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Currency updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails) {
		Currency currency = service.findCurrencyById(id);
		currency.toBuilder().code(currencyDetails.getCode())
		.description(currencyDetails.getDescription())
		.symbol(currencyDetails.getSymbol())
		.build();
	return service.updateCurrency(id, currency);
	}


}
