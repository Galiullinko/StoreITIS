import dao.ItemsDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.StoreService;
import services.StoreServiceImpl;

import java.io.IOException;


/**
 * Created by Galiullin_ko on 11/02/16.
 */
public class MockTest {
    public static void main(String[] args) throws IOException {
        //    Factory
        //    ItemsDao itemsDao = StoreFactory.getInstance().getItemsDao();
        //    StoreService service = StoreFactory.getInstance().getStoreService();
        //    service.setDao(itemsDao);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(WebAppContext.class);

        StoreService ss = context.getBean(StoreServiceImpl.class);

        System.out.println(ss.isExist("pen"));
        System.out.println(ss.isExist("toy"));
        System.out.println(ss.isExist("rat"));
    }

}
