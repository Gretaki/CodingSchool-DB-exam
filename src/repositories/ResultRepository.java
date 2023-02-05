package repositories;

import entities.Participant;
import entities.Result;
import entities.ResultStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class ResultRepository {
    private final Session session;

    public ResultRepository(Session session) {
        this.session = session;
    }

    public Result add(Result result) {
        session.getTransaction().begin();
        session.persist(result);
        session.getTransaction().commit();
        return result;
    }

    public List<Object[]> getResultGroupedByParticipant(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cbQuery = cb.createQuery(Object[].class);
        Root<Result> root = cbQuery.from(Result.class);

        CriteriaQuery<Object[]> a = cbQuery.multiselect(root.get("exam"), cb.count(root)).groupBy(root.get("exam"));
//        cbQuery.select()

//        cbQuery.select(root).where(cb.equal(root.get("exam"), exam));

        return session.createQuery(cbQuery).getResultList();
    }

    public void makeExamStatusCompleted(Result result) {
        session.getTransaction().begin();
        result.setStatus(ResultStatus.COMPLETED);
        session.merge(result);
        session.getTransaction().commit();
    }
}
