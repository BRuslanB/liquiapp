package kz.bitlab.springbootpro.liquibaseApp.liquiapp.mapper;

import org.mapstruct.Mapper;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.CategoryDto;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDTO);
    List<CategoryDto> toDtoList(List<Category> categoriesList);
}
