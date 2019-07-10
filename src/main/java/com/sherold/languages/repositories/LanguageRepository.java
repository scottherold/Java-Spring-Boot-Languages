package com.sherold.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sherold.languages.models.Language;

@Repository // Designates the interface as a repository

// Extends the CRUD repository using the Language object and the id's data type
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// SELECT *
	// Transmutes type to Language object
	List<Language> findAll();
}
