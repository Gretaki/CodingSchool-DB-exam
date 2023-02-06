package repositories;

import entities.Exam;
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

    public List<Object[]> getPeopleByExam() {
        String query = "select e.id, name, count(r.id) from Exam e left join e.results r group by e.id, name";
        return session.createQuery(query, Object[].class).list();
    }

    public List<Object[]> getResultChoiceByParticipantByExam() {
        String query = "select e.id, name, count(distinct(r.participant)), sum(a.answerIsCorrect) correct, count(a.id) total from Exam e\n" +
                "left join e.results r\n" +
                "join r.resultChoices rc\n" +
                "join rc.answer a\n" +
                "where r.status = 1\n" +
                "group by e.id, name";
        return session.createQuery(query, Object[].class).list();
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
}
