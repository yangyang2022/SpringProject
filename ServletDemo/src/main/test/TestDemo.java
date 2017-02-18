import com.yangyang.model.Book;
import org.junit.Test;

public class TestDemo {

    @Test
    public void testDemo1() {
        Book i1 = new Book();
        Book i2 = new Book();

        System.out.println(i1.hashCode() + " : " + i2.hashCode());

    }
}
