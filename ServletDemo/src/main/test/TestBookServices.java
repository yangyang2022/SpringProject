import com.yangyang.model.Book;
import com.yangyang.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans-mvc.xml")
public class TestBookServices {

    @Autowired
    private BookService bookService;

    @Test
    public void testBookService() {

        List<Book> books = bookService.getBooks();
        System.out.println(books);
        System.out.println("size: "+books.size());
        books.remove(new  Book(1l));
        System.out.println("size: "+books.size());
        System.out.println(books);
    }
}
