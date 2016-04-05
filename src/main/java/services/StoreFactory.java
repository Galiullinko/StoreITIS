package services;

import dao.ItemsDao;
import services.StoreService;

import java.io.FileInputStream;
import java.util.Properties;

public class StoreFactory {

    private static StoreFactory instance;
    private Properties properties;
    private ItemsDao itemsDao;
    private StoreService storeService;

    private StoreFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("/Users/admin/IdeaProjects/ITIS/Store/src/main/resources/dao.properties"));

            String daoClass = properties.getProperty("dao.class");
            String serviceClass = properties.getProperty("service.class");

            this.itemsDao = (ItemsDao) Class.forName(daoClass).newInstance();
            this.storeService = (StoreService) Class.forName(serviceClass).newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new StoreFactory();
    }

    public static StoreFactory getInstance() {
        return instance;
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }

    public StoreService getStoreService() {
        return storeService;
    }
}