package dao;


import dao.models.Item;

import java.util.List;

public interface ItemsDao {

    /**
     * Удаляет товар из хранилища
     * @param itemName
     */
    void delete(String itemName);

    /**
     * Возвращает описание товара из БД
     * @param itemName
     * @return
     */
    Item select(String itemName);

    List<Item> getItems();

    Item selectItemById(int id);

    void addItem(Item item);
}
