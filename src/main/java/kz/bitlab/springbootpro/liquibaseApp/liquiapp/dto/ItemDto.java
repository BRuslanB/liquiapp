package kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private Long id;
    private String name;
    private double price;
    private int amount;
    private String description;
    private Category category;
}
