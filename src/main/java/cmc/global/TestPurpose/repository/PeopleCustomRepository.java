package cmc.global.TestPurpose.repository;

import cmc.global.TestPurpose.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public class PeopleCustomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(final People people) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Long lastId = (Long) session.save("people", people);
//        System.out.println("recent lastId " + lastId);
        session.persist(people);
        Long lastId = getLastIdByNativeQuery(session);
        System.out.println("LastId get by native Query before flush in the same session " + lastId);
        System.out.println("Last people after call persist in same session " + getPeopleFrom(session, lastId));
        System.out.println("LastId get by native Query before flush " + getLastIdByNativeQuery());
        session.flush();
        System.out.println("LastId get by native Query after flush and before commit in the same session " + getLastIdByNativeQuery(session));
        System.out.println("LastId get by native Query after flush and before commit " + getLastIdByNativeQuery());
        System.out.println("Last people after call flush in another session " + getPeopleFrom(this.sessionFactory.openSession(), lastId));
        transaction.commit();
        session.close();
        System.out.println("Last people after call persist and close in same session " + getPeopleFrom(session, lastId));
        System.out.println("LastId get by native Query after commit " + getLastIdByNativeQuery());
    }

    private People getPeopleFrom(Session session, Long id) {
        People people = (People) session.get(People.class, id);
        return people;
    }

    private Long getLastIdByNativeQuery() {
        Session session = this.sessionFactory.openSession();
        Query sqlQuery = session.createNativeQuery("SELECT MAX(id) from people", Long.class);
        List<Object[]> result = sqlQuery.getResultList();
        Object firstRs = result.get(0);
        return (Long) firstRs;
    }

    private Long getLastIdByNativeQuery(Session session) {
        Query sqlQuery = session.createNativeQuery("SELECT MAX(id) from people", Long.class);
        List<Object[]> result = sqlQuery.getResultList();
        Object firstRs = result.get(0);
        return (Long) firstRs;
    }
}
