package kz.bitlab.springbootpro.liquibaseApp.liquiapp.mapper;


import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.ItemDto;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto toItemDto(Item item);
    Item toEntity(ItemDto itemDto);

    List<ItemDto> toItemDtoList(List<Item> items);
    List<Item> toItemEntityList(List<ItemDto> items);

}