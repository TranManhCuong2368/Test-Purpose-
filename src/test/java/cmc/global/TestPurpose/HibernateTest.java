package cmc.global.TestPurpose;

import cmc.global.TestPurpose.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateTest {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testPersistMethod() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        People people = new People("abc", 23);

        session.persist(people);
        transaction.commit();
        session.close();

        assertNotNull(people.getId());
        assertNull(session.get(People.class, people.getId()));
    }

//    @Test
//    public void testSaveMethod() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        User user = new User();
//        user.setName("John Doe");
//        user.setEmail("johndoe@example.com");
//
//        Integer id = (Integer) session.save(user);
//        transaction.commit();
//        session.close();
//
//        assertNotNull(id);
//        assertNotNull(session.get(User.class, id));
//    }

}

