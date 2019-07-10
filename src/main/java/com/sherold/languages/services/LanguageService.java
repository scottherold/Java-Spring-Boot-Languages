package com.sherold.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sherold.languages.models.Language;
import com.sherold.languages.repositories.LanguageRepository;

@Service // Denotes this class as a service
public class LanguageService {
	// <----- Attributes ----->
	// Dependency injection
	private final LanguageRepository languageRepo;
	
	// <----- Constructors ----->
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	// <----- Methods ----->
	// SELECT * FROM language
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	
	// ADD
	public Language createLanguage(Language lang) {
		return languageRepo.save(lang);
	}
	
	// SELECT * FROM language WHERE id =
	public Language findLanguage(Long id) {
		// Optional allows for data to not persist for event handler
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	// UPDATE * FROM language WHERE id =
	public Language updateLanguage(Long id, String name, String creator, String version) {
		// Optional allows for data to not persist for event handler
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			// Create a Language object to update
			Language updateLang = optionalLang.get();
			
			// Update fields
			updateLang.setName(name);
			updateLang.setCreator(creator);
			updateLang.setVersion(version);
			
			return languageRepo.save(updateLang);
		} else {
			return null;
		}
	}
	
	// DELETE * FROM language WHERE id =
	public void deleteLanguage(Long id) {
		// Optional allows for data to not persist for event handler
		Optional<Language> optionalLang = languageRepo.findById(id);
		if (optionalLang.isPresent()) {
			languageRepo.deleteById(id);
		}
	}
	
}
