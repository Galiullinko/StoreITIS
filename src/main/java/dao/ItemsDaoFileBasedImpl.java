package dao;

import dao.models.Item;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;

@Component
public class ItemsDaoFileBasedImpl implements ItemReader{
    HashMap<String, Item> hashMap = null;
    BufferedReader br = null;

    public ItemsDaoFileBasedImpl(String pathString) throws IOException {
        try {
            br = new BufferedReader(new FileReader(pathString));
            String sCurrentLine;
            String key = null;
            Integer q = null;
            int i = 0;
            hashMap = new HashMap<>();
            while ((sCurrentLine = br.readLine()) != null) {
                i++;
                if (i % 2 == 1) {
                    key = sCurrentLine;
                } else {
                    q = Integer.valueOf(sCurrentLine);
                    hashMap.put(key, new Item(key, q));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Item> getHashMap() {
        return hashMap;
    }
}
