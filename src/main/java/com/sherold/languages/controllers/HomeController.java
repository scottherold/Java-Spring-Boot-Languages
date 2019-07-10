package com.sherold.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sherold.languages.models.Language;
import com.sherold.languages.services.LanguageService;

@Controller // Annotation to designate class as a controller
public class HomeController {
	// <---- Attributes ----->
	// Dependency injection
	private final LanguageService langService;
	
	// <------ Constructors ----->
	public HomeController(LanguageService langService) {
		this.langService = langService;
	}
	
	// <----- Methods ----->
	// GET route for languages
	@RequestMapping(value="languages", method=RequestMethod.GET)
	// Model used for template binding, empty language object for form Binding
	public String index(Model model, @ModelAttribute("language") Language language) {
		// Queries for all languages, adds to model
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		
		return "/languages/index.jsp";
	}
	
	// POST route to create new language
	@RequestMapping(value="languages", method=RequestMethod.POST)
	// The @Valid annotation checks to see if the submitted object passed validation
	// @BindingResult must come immediately after the @Valid annotation parameter. This tells the application to check for errors!
	// Model added to show languages along with form errors
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		// Event handler for error checking
		if (result.hasErrors()) {
			// Queries for all languages, adds to model to display with validation errors
			List<Language> languages = langService.allLanguages();
			model.addAttribute("languages", languages);
			
			return "/languages/index.jsp";
		} else {
			langService.createLanguage(language);
			
			return "redirect:/languages";
		}
	}
	
	// GET route for show
	@RequestMapping(value="languages/{id}", method=RequestMethod.GET)
	// @PathVariable for query, Model for binding to view
	public String show(@PathVariable("id") Long id, Model model) {
		// Queries the DB for the language
		Language language = langService.findLanguage(id);
		
		// Binds queried data to model for view
		model.addAttribute("language", language);
		
		return "/languages/show.jsp";
	}
	
	// GET route for edit language form
	@RequestMapping(value="languages/edit/{id}", method=RequestMethod.GET)
	// @PathVariable for query, Model for binding to view
	public String edit(@PathVariable("id") Long id, Model model) {
		// Queries DB for the language
		Language language = langService.findLanguage(id);
		
		// Binds queried data to model for view
		model.addAttribute("language", language);	
		
		return "/languages/edit.jsp";
	}
	
	// PUT route for update language by id
	@RequestMapping(value="languages/{id}", method=RequestMethod.PUT)
	// The @Valid annotation checks to see if the submitted object passed validation
	// @BindingResult must come immediately after the @Valid annotation parameter. This tells the application to check for errors!
	public String update(
			@Valid
			@ModelAttribute("language") Language language,
			BindingResult result,
			@PathVariable("id") Long id,
			@RequestParam(value="name") String name, 
			@RequestParam(value="creator") String creator, 
			@RequestParam(value="version") String version
			) {
		// EventHandler for error checking
		if (result.hasErrors()) {
			return "languages/edit.jsp";
		} else {
			langService.updateLanguage(id, name, creator, version);
			return "redirect:/languages";
		}
	}
	
	// DELETE Route for language by id
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destory(@PathVariable("id") Long id) {
		// Queries and deletes language from PathVariable
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
