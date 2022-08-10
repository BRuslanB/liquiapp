package kz.bitlab.springbootpro.liquibaseApp.liquiapp.api;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.CategoryDto;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategoriesDTO(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CategoryDto> getCategoryDTO(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }
}