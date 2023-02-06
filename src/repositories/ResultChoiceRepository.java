package repositories;

import entities.Result;
import entities.ResultChoice;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class ResultChoiceRepository {
    private final Session session;

    public ResultChoiceRepository(Session session) {
        this.session = session;
    }

    public ResultChoice add(ResultChoice resultChoice) {
        session.getTransaction().begin();
        session.persist(resultChoice);
        session.getTransaction().commit();
        return resultChoice;
    }

    public List<ResultChoice> getByResult(Result result) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ResultChoice> cbQuery = cb.createQuery(ResultChoice.class);
        Root<ResultChoice> root = cbQuery.from(ResultChoice.class);
        cbQuery.select(root).where(cb.equal(root.get("result"), result));
        return session.createQuery(cbQuery).getResultList();
    }

    public List<Object[]> getAnswerChoicesByQuestion() {
        String query = "select  q.id, q.question,\n" +
                "count(case when (a.id - 3 * (q.id - 1) = 1) then 1 end ) as A,\n" +
                "count(case when (a.id - 3 * (q.id - 1) = 2) then 1 end ) as B,\n" +
                "count(case when (a.id - 3 * (q.id - 1) = 3) then 1 end ) as C \n" +
                "from ResultChoice rc\n" +
                "join rc.question q\n" +
                "join rc.answer a\n" +
                "group by q.id, q.question\n";
        return session.createQuery(query, Object[].class).list();
    }
}
