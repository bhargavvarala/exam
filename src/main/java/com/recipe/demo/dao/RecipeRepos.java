package com.recipe.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.demo.entities.Recipe;

@Repository
public interface RecipeRepos extends JpaRepository<Recipe, Integer> {

}
