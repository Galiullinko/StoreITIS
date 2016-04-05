package dao;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import dao.models.Item;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Galiullin_ko on 02/03/16.
 */
@Component
public class ItemsDaoCSVImpl implements ItemReader {
    private HashMap<String, Item> hashMap = null;
    private BufferedReader reader = null;

    public ItemsDaoCSVImpl(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
            hashMap = new HashMap<>();

            CsvParserSettings settings = new CsvParserSettings();
            settings.getFormat().setLineSeparator("\n");
            CsvParser parser = new CsvParser(settings);
            List<String[]> allRows = parser.parseAll(reader);

            Iterator<String[]> it = allRows.iterator();

            while(it.hasNext()) {
                String[] sArray = it.next();
                hashMap.put(sArray[0], new Item(sArray[0], Integer.parseInt(sArray[1])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Item> getHashMap(){
        return hashMap;
    }
}