package com.recipe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recipe.demo.dao.RecipeRepos;
import com.recipe.demo.entities.Recipe;
//import com.recipe.demo.request.beans.Recipe;

@Service
public class RecipeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RecipeRepos recipeRepos;
	
	public List<Recipe> getRecipes() {
		
		ResponseEntity<List<Recipe>> responseEntity = 
				  restTemplate.exchange("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json",
				    HttpMethod.GET,
				    null,
				    new ParameterizedTypeReference<List<Recipe>>() {}
				  );
				List<Recipe> recipeList = responseEntity.getBody();
				recipeRepos.saveAll(recipeList);
				return recipeRepos.findAll();
		
		
	}

	public Optional<Recipe> getRecipeById(Integer id) {
		
		return recipeRepos.findById(id);
	}

	public String getRecipeImageById(Integer id) {
		String url = recipeRepos.findById(id).get().getImage();
		return url;
	}

	public Recipe saveRecipe(Recipe recipe) {
		 return recipeRepos.save(recipe);		
	}

}
