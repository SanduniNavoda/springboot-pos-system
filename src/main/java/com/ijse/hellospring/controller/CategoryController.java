package com.ijse.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.CategoryDto;
import com.ijse.hellospring.entity.Category;
import com.ijse.hellospring.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category =  categoryService.getCategoryById(id);

        if(category == null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(200).body(category);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createCategory = categoryService.createCategory(category);
        return ResponseEntity.status(201).body(createCategory);
    }

     @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        
        Category category = new Category();
        category.setName(categoryDto.getName());


        Category updateCategory = categoryService.updateCategory(id, category);

        if(updateCategory == null){
            return ResponseEntity.status(404).build();
        }else {
            return ResponseEntity.status(200).body(updateCategory);
        }
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
