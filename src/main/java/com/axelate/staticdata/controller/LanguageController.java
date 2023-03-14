package com.axelate.staticdata.controller;

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

import com.axelate.staticdata.model.Language;
import com.axelate.staticdata.service.LanguageService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.axelate.staticdata.controller.LanguageController.LANGUAGE_BASE_URL;

@Slf4j
@RestController
@RequestMapping(LANGUAGE_BASE_URL)
@Validated
@AllArgsConstructor
public class LanguageController {

	public static final String LANGUAGE_BASE_URL = "/language";
	public static final String LANGUAGE_BY_ID_URL = "/language/{id}";

	private final LanguageService service;

	@Operation(summary = "Get  list of languages", description = "Get list of languages")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Language> findAll() {
		return service.findAll();
	}

	@Operation(summary = "Get a language  by Id", description = "Get a language by Id")
	@GetMapping(value = LANGUAGE_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Language findById(@PathVariable Long id) {
		return service.findLanguageById(id);
	}

	@Operation(summary = "save a language", description = "Save language")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Language saveLanguage(@RequestBody Language language) {
		return service.save(language);
	}

	@Operation(summary = "delete a language", description = "Delete a language")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteLanguage(@PathVariable Long id) {
		service.deleteById(id);
	}

	@Operation(summary = "update a language", description = "update a language")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Language updateLanguage(@PathVariable Long id, @RequestBody Language languageDetails) {
		Language language = service.findLanguageById(id);
		language.toBuilder().code(languageDetails.getCode())
		.description(languageDetails.getDescription())
		.build();
	return service.updateLanguage(id, language);
	}

}
