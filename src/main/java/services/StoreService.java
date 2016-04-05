package services;


import dao.ItemsDao;
import dao.models.Item;

import java.util.List;

public interface StoreService {
    /**
     * Покупка товара по имени
     * @param itemName имя товара
     */
    void buy(String itemName);

    /**
     * Проверяет, есть ли товар на складе
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName);

    void setDao(ItemsDao itemsDao);

    List<Item> getItems();

    Item selectItemById(int id);

    Item selectItemByName(String name);

    void addItem(Item item);
}
