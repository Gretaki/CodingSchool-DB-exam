package repositories;

import entities.Answer;
import entities.Exam;
import entities.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class QuestionRepository{
    private final Session session;

    public QuestionRepository(Session session) {
        this.session = session;
    }

    public Question add(Question question) {
        session.getTransaction().begin();
        session.persist(question);
        session.getTransaction().commit();
        System.out.println("question saved");
        return question;
    }

    public Question getById(long id) {
        return session.get(Question.class, id);
    }

    public List<Question> getByExam(Exam exam){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Question> cbQuery = cb.createQuery(Question.class);
        Root<Question> root = cbQuery.from(Question.class);
        cbQuery.select(root).where(cb.equal(root.get("exam"), exam));
        return session.createQuery(cbQuery).getResultList();
    }

    public Question update(Question question, String updatedQuestionName, Exam updatedQuestionExam) {
        session.getTransaction().begin();
        if (!updatedQuestionName.isEmpty()) {
            question.setQuestion(updatedQuestionName);
        }
        if (updatedQuestionExam != null && question.getExam().getId() != updatedQuestionExam.getId()) {
            question.setExam(updatedQuestionExam);
        }
        session.merge(question);
        session.getTransaction().commit();
        return question;
    }

    public void delete(Question question) {
        session.getTransaction().begin();
        question.setExam(null);
        session.remove(question);
        session.getTransaction().commit();
    }
}
