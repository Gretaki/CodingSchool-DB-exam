package repositories;

import entities.Exam;
import entities.ResultChoice;
import org.hibernate.Session;

import java.util.List;

public class ExamRepository {
    private final Session session;

    public ExamRepository(Session session) {
        this.session = session;
    }

    public Exam add(Exam exam) {
        session.getTransaction().begin();
        session.persist(exam);
        session.getTransaction().commit();
        System.out.println("exam saved");
        return exam;
    }

    public List<Exam> getAll() {
        return session.createQuery(String.format("from %s", "Exam"), Exam.class).list();
    }

    public Exam getById(long id) {
        return session.get(Exam.class, id);
    }

    public Exam update(Exam exam, String updatedExamName) {
        session.getTransaction().begin();
        exam.setName(updatedExamName);
        session.merge(exam);
        session.getTransaction().commit();
        return exam;
    }

    public void delete(Exam exam) {
        session.getTransaction().begin();
        session.remove(exam);
        session.getTransaction().commit();
    }


//    @Override
//    String getTableName() {
//        return "Exam";
//    }
//
//    @Override
//    Class<Exam> getEntityClass() {
//        return Exam.class;
//    }
}
