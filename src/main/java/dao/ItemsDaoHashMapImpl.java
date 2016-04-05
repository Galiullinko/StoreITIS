package dao;

import org.springframework.beans.factory.annotation.Autowired;
import dao.models.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Galiullin_ko on 03/03/16.
 */
@Component
public class ItemsDaoHashMapImpl implements ItemsDao {
    Map<String, Item> map = null;

    @Autowired
    @Qualifier("itemsDaoCSVImpl")
    ItemReader<String, Item> ir;

    public ItemsDaoHashMapImpl() {
        map = ir.getHashMap();
        
    }

    @Override
    public void delete(String itemName) {
        Item item = map.get(itemName);
        int value = item.getAmount();
        value--;
        item.setAmount(value);
        if (value >= 0)
            map.replace(itemName, item);
    }

    @Override
    public Item select(String itemName) {
        Item item = map.get(itemName);
        if (item == null)
            return null;
        else if (item.getAmount() == 0)
            return null;
        else
            return item;
    }

    @Override
    public List<Item> getItems() {
        return new LinkedList<>(map.values());
    }

    @Override
    public Item selectItemById(int id) {
        Item item = null;
        for(Map.Entry<String, Item> entry : map.entrySet()){
            if (entry.getValue().getId() == id) {
                item = entry.getValue();
            }
        }
        return item;
    }

    @Override
    public void addItem(Item item) {
        map.put(item.getItemName(), item);
    }
}
