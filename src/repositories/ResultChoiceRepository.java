package repositories;

import entities.Result;
import entities.ResultChoice;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class ResultChoiceRepository {
    private final Session session;

    public ResultChoiceRepository(Session session) {
        this.session = session;
    }

    public void add(ResultChoice resultChoice) {
        session.getTransaction().begin();
        session.persist(resultChoice);
        session.getTransaction().commit();
        System.out.println("answer saved");
    }

    public List<ResultChoice> getByResult(Result result) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ResultChoice> cbQuery = cb.createQuery(ResultChoice.class);
        Root<ResultChoice> root = cbQuery.from(ResultChoice.class);
        cbQuery.select(root).where(cb.equal(root.get("result"), result));
        return session.createQuery(cbQuery).getResultList();
    }

    public List<ResultChoice> getResultChoiceJoinedWithResult(){
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<ResultChoice> cbQuery = cb.createQuery(ResultChoice.class);
        Root<ResultChoice> root = cbQuery.from( ResultChoice.class );
        Join<Object, Object> productsJoin = root.join( "result" );
//        cbQuery.multiselect(root.);
        List<ResultChoice> result = session.createQuery(cbQuery).getResultList();
        return result;
    }
}
