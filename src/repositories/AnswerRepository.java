package repositories;

import entities.Answer;
import entities.Exam;
import entities.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class AnswerRepository {
    private final Session session;

    public AnswerRepository(Session session) {
        this.session = session;
    }

    public Answer add(Answer answer) {
        session.getTransaction().begin();
        session.persist(answer);
        session.getTransaction().commit();
        System.out.println("answer saved");
        return answer;
    }

    public Answer getById(long id) {
        return session.get(Answer.class, id);
    }

    public List<Answer> getByQuestion(Question question) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Answer> cbQuery = cb.createQuery(Answer.class);
        Root<Answer> root = cbQuery.from(Answer.class);
        cbQuery.select(root).where(cb.equal(root.get("question"), question));
        return session.createQuery(cbQuery).getResultList();
    }

    public Answer update(Answer answer, String updatedAnswerName, boolean updatedCorrectness, Question updatedQuestion) {
        session.getTransaction().begin();
        if (!updatedAnswerName.isEmpty()) {
            answer.setAnswer(updatedAnswerName);
        }
        if (answer.isAnswerIsCorrect() != updatedCorrectness) {
            answer.setAnswerIsCorrect(updatedCorrectness);
        }
        if (updatedQuestion != null && answer.getQuestion().getId() != updatedQuestion.getId()) {
            answer.setQuestion(updatedQuestion);
        }
        session.merge(answer);
        session.getTransaction().commit();
        return answer;
    }

    public void delete(Answer answer) {
        session.getTransaction().begin();
        answer.setQuestion(null);
        session.remove(answer);
        session.getTransaction().commit();
    }
}
