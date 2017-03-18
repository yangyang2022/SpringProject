import com.yangyang.dao.AddressRepo;
import com.yangyang.dao.PersonRepository;
import com.yangyang.model.Address;
import com.yangyang.model.Person;
import com.yangyang.service.IPersonService;
import com.yangyang.utils.NameUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestConnection {

    @Resource
    private DataSource dataSource;

    @Resource
    private PersonRepository personRepository;
    @Resource
    private AddressRepo addressRepo;

    @Resource
    private IPersonService personService;

    @Test
    public void testConnection() throws SQLException {

        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testSavePersons() {
        Random random = new Random();
        Iterator<Address> addIter = addressRepo.findAll().iterator();
        List<Address> adds = new ArrayList<>();
        while (addIter.hasNext()){
            adds.add(addIter.next());
        }

        List<String> names = NameUtil.getNames(500);
        names.forEach(e->personRepository.save(new Person(e,random.nextInt(100),e+"@qq.com", LocalDate.now(),adds.get(random.nextInt(adds.size())))));
    }
    @Test
    public void testPersonGetByLastname() {

        //Person yangyang = personRepository.getByLastname("yangyang");
        //System.out.println(yangyang);

        //Person maxIdPerson = personRepository.getMaxIdPerson();
        //System.out.println(maxIdPerson);

        //Person admin = personRepository.getPerson("admin", "admin@qq.com");
        //System.out.println(admin);

        //List<Person> people = personRepository.likeParam("沈", "牛");
        //System.out.println(people.size());
        //System.out.println("count: " + personRepository.getCount());

        //personRepository.updatePersonEmail(1,"test@qq.com");
        personService.updatePersonEmail(1,"test@qq.com");
    }

    @Test
    public void testPageAndSort() {
        int pageNo = 3-1;//page number is from zero
        int pageSize = 5;

        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"age");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC,"email");
        Sort sort = new Sort(order1,order2);

        PageRequest pageRequest = new PageRequest(pageNo,pageSize,sort);

        Page<Person> page = personRepository.findAll(pageRequest);

        System.out.println("totalElements: " + page.getTotalElements());
        System.out.println("currentPageNumber: "+(page.getNumber()+1));
        System.out.println("totalPages: "+page.getTotalPages());
        System.out.println("currentPageList: " + page.getContent());
        System.out.println("currentPageRecords: " + page.getNumberOfElements());

    }

    @Test
    public void testJpaSpeacificExcutor() {
        //JpaSpecificationExecutor 实现带查询条件的分页
        int pageNum = 3-1;
        int pageSize = 5;

        PageRequest pageRequest = new PageRequest(pageNum,pageSize);

        //root 代表查询的实体类
        //query 可以从中得到root对象,即告知criteria jpa查询哪个实体类,还可以用来添加查询条件,
        //还可以告知EntityManager对象得到最终的查询TypeQuery对象
        //cb
        Specification<Person> spec = (root, query, cb) -> cb.gt(root.get("age"),60);

        Page<Person> page = personRepository.findAll(spec, pageRequest);

        System.out.println("totalElements: " + page.getTotalElements());
        System.out.println("currentPageNumber: "+(page.getNumber()+1));
        System.out.println("totalPages: "+page.getTotalPages());
        System.out.println("currentPageList: " + page.getContent());
        System.out.println("currentPageRecords: " + page.getNumberOfElements());

    }

    @Test
    public void testDefinition() {
        //这里是自定义接口                 personDao
        //                       personRepository personRepositoryImpl
        personRepository.test();
    }

    @Test
    public void testStream() throws ExecutionException, InterruptedException {
        //List<Person> personList = personService.findPersons().collect(Collectors.toList());
        //System.out.println(personList.size());

        //Person person = personRepository.findByLastname("刘与冲").get();
        //Thread.sleep(1000);
        //System.out.println(person);

    }
    @Test
    public void testQueryDsl() {

        //List<Person> persons = personRepository.findBySpel("刘与冲");
        //System.out.println(persons);

        //NoAddress noAddress = personRepository.findByLastname("刘与冲");
        //System.out.println(noAddress.getId() + " : " + noAddress.getLastname() + " : " + noAddress.getEmail());

        //String lastname = "刘与冲1";
        //RenamedProperty renamedProperty = personRepository.findByLastname(lastname);
        //System.out.println(renamedProperty.getName());
        //System.out.println(renamedProperty.getLastname());

        //Integer res = personRepository.explicitlyNamedPlus1inout(23);
        //System.out.println(res);

        Specification<Person> ageLess80 = ((root, query, cb) -> cb.lt(root.get("age"), 80));
        Specification<Person> ageLarer60 = ((root, query, cb) -> cb.gt(root.get("age"), 60));

        Page<Person> personPage = personRepository.findAll(Specifications.where(ageLess80).and(ageLarer60),
                new PageRequest(0, 10));

        System.out.println(personPage.getContent());


    }
}
