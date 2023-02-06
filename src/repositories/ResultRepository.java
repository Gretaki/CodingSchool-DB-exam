package repositories;

import entities.Result;
import entities.ResultStatus;
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

    public List<Result> getAll() {
        return session.createQuery(String.format("from %s", "Result"), Result.class).list();
    }

    public void makeExamStatusCompleted(Result result) {
        session.getTransaction().begin();
        result.setStatus(ResultStatus.COMPLETED);
        session.merge(result);
        session.getTransaction().commit();
    }
}
