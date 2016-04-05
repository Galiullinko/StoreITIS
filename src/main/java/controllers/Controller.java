package controllers;

import dao.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.StoreService;

import java.util.List;

/**
 * Created by Galiullin_ko on 30/03/16.
 */
@RestController
public class Controller {
    @Autowired
    private StoreService service;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
        return service.getItems();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable int id){
        return service.selectItemById(id);
    }

    @RequestMapping(value = "/items/{name}", method = RequestMethod.GET)
    public Item getItemByName(@PathVariable String name){
        return service.selectItemByName(name);
    }

    @RequestMapping(value = "/items/availability/{name}", method = RequestMethod.GET)
    public void itemAvailiability(@PathVariable String name){
        service.isExist(name);
    }

    @RequestMapping(value = "/items/purchase/{name}", method = RequestMethod.GET)
    public void buy(@PathVariable String name){
        service.buy(name);
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }
}
