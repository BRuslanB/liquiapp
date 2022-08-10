package kz.bitlab.springbootpro.liquibaseApp.liquiapp.service;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.mapper.CategoryMapper;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.CategoryDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryDto getCategory(Long id){
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());
    }

    public List<CategoryDto> getCategories(){
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }
}