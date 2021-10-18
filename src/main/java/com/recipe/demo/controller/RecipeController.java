package com.recipe.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.demo.entities.Recipe;
import com.recipe.demo.service.RecipeService;


@RestController
@RequestMapping("/")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public List<Recipe> getAllRecipes(){
		List<Recipe> recipeList = recipeService.getRecipes();
		return recipeList;
	}
	@GetMapping("/{id}")
	public Recipe getById(@PathVariable Integer id){
		Optional<Recipe> recipe = recipeService.getRecipeById(id);
		return recipe.get();
	}
	@GetMapping("/{id}/show")
	public String getImageById(@PathVariable Integer id){
		return recipeService.getRecipeImageById(id);
	}
	@PostMapping
	public Recipe SaveRecipe(@RequestBody Recipe recipe){
		return recipeService.saveRecipe(recipe);
	}
}
