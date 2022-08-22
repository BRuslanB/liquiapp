package kz.bitlab.springbootpro.liquibaseApp.liquiapp.service;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.ItemDto;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.mapper.ItemMapper;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Item;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDto> getItems(){
        return itemMapper.toItemDtoList(itemRepository.findAll());
    }

    public ItemDto getItem(Long id){
        return itemMapper.toItemDto(itemRepository.findById(id).orElseThrow());
    }

    public ItemDto addItem(ItemDto itemDto){
        Item item = itemMapper.toEntity(itemDto);
        Item insertedItem = itemRepository.save(item);
        return itemMapper.toItemDto(insertedItem);
    }
}
