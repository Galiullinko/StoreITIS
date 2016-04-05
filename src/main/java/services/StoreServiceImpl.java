package services;


import dao.models.Item;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.ItemsDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreServiceImpl implements StoreService {
    @Autowired
    private ItemsDao itemsDao;


    public void setDao(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    @Override
    public List<Item> getItems() {
        return itemsDao.getItems();
    }

    @Override
    public Item selectItemById(int id) {
        return itemsDao.selectItemById(id);
    }

    @Override
    public Item selectItemByName(String name) {
        return itemsDao.select(name);
    }

    @Override
    public void addItem(Item item) {
        itemsDao.addItem(item);
    }

    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);


    public void buy(String itemName) {
        itemsDao.delete(itemName);
        log.info("Buy StoreServiceImpl: " + itemName);
    }

    public boolean isExist(String itemName) {
        log.info("isExist StoreServiceImpl: " + itemName);
        return itemsDao.select(itemName) != null;
    }
}

