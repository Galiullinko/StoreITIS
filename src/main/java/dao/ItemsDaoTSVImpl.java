package dao;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import dao.models.Item;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Galiullin_ko on 02/03/16.
 */
@Component
public class ItemsDaoTSVImpl implements ItemReader {
    private HashMap<String, Item> hashMap = null;
    private BufferedReader reader = null;

    public ItemsDaoTSVImpl(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
            hashMap = new HashMap<>();

            TsvParserSettings settings = new TsvParserSettings();
            settings.getFormat().setLineSeparator("\n");
            TsvParser parser = new TsvParser(settings);
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

    @Override
    public Map getHashMap() {
        return hashMap;
    }
}
