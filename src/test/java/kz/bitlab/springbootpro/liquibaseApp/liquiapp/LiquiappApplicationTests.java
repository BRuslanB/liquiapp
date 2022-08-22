package kz.bitlab.springbootpro.liquibaseApp.liquiapp;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.dto.ItemDto;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.mapper.ItemMapper;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Category;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Item;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.repository.ItemRepository;
import kz.bitlab.springbootpro.liquibaseApp.liquiapp.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LiquiappApplicationTests {

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void checkMappingOfItem(){
		Item testItem = new Item();
		testItem.setId(1L);
		testItem.setName("IPhone 13");
		testItem.setDescription("This is new IPhone");
		testItem.setPrice(300000);
		testItem.setAmount(10);

		ItemDto convertedItem = itemMapper.toItemDto(testItem);

		Assertions.assertEquals(testItem.getId(), convertedItem.getId());
		Assertions.assertEquals(testItem.getName(), convertedItem.getName());
		Assertions.assertEquals(testItem.getDescription(), convertedItem.getDescription());
		Assertions.assertEquals(testItem.getPrice(), convertedItem.getPrice());
		Assertions.assertEquals(testItem.getAmount(), convertedItem.getAmount());
	}

	@Test
	void checkMappingToEntity(){
		ItemDto testItem = new ItemDto();
		testItem.setId(1L);
		testItem.setName("IPhone 13");
		testItem.setDescription("This is new IPhone");
		testItem.setPrice(300000);
		testItem.setAmount(10);

		Item convertedItem = itemMapper.toEntity(testItem);

		Assertions.assertEquals(testItem.getId(), convertedItem.getId());
		Assertions.assertEquals(testItem.getName(), convertedItem.getName());
		Assertions.assertEquals(testItem.getDescription(), convertedItem.getDescription());
		Assertions.assertEquals(testItem.getPrice(), convertedItem.getPrice());
		Assertions.assertEquals(testItem.getAmount(), convertedItem.getAmount());
	}

	@Test
	void testItemServiceInsert(){
		ItemDto itemDto = new ItemDto();
		Category category= new Category();
		category.setId(1L);

		//itemDto.setId(-1L);
		itemDto.setName("Test Phone");
		itemDto.setPrice(500000);
		itemDto.setAmount(100);
		itemDto.setDescription("Some Description");
		itemDto.setCategory(category);

		ItemDto checkItem = itemService.addItem(itemDto);

		Assertions.assertNotNull(checkItem);
		Assertions.assertNotNull(checkItem.getId());
		Assertions.assertEquals(checkItem.getName(), itemDto.getName());
		//Assertions.assertEquals(checkItem.getId(), itemDto.getId());
		Assertions.assertEquals(checkItem.getPrice(), itemDto.getPrice());
		Assertions.assertEquals(checkItem.getAmount(), itemDto.getAmount());
		Assertions.assertEquals(checkItem.getDescription(), itemDto.getDescription());
		Assertions.assertEquals(checkItem.getCategory(), itemDto.getCategory());

		itemRepository.deleteById(checkItem.getId());
	}

	@Test
	void testGetAllItems(){
		ItemDto itemDto = new ItemDto();
		Category category= new Category();
		category.setId(2L);

		//itemDto.setId(30L);
		itemDto.setName("Test Phone");
		itemDto.setPrice(500000);
		itemDto.setAmount(200);
		itemDto.setDescription("Some Description");
		itemDto.setCategory(category);

		ItemDto newItem = itemService.addItem(itemDto);

		List<ItemDto> itemDtoList = itemService.getItems();

		Assertions.assertNotNull(newItem);
		Assertions.assertNotNull(newItem.getId());
		Assertions.assertNotNull(itemDtoList);
		Assertions.assertTrue(itemDtoList.size()>0);

		itemRepository.deleteById(newItem.getId());
	}

	@Test
	void testGetItemById(){
		ItemDto itemDto = new ItemDto();
		Category category= new Category();
		category.setId(3L);

		//itemDto.setId(30L);
		itemDto.setName("Test Phone");
		itemDto.setPrice(300000);
		itemDto.setAmount(300);
		itemDto.setDescription("Some Description");
		itemDto.setCategory(category);

		ItemDto newItem = itemService.addItem(itemDto);

		Assertions.assertNotNull(newItem);
		Assertions.assertNotNull(newItem.getId());

		ItemDto testItem = itemService.getItem(newItem.getId());
		Assertions.assertNotNull(testItem);
		Assertions.assertNotNull(testItem.getId());
		Assertions.assertEquals(testItem.getId(), newItem.getId());

		itemRepository.deleteById(newItem.getId());
	}

}
