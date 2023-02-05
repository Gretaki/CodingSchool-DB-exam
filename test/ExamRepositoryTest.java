import entities.Exam;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamRepositoryTest {

    @Test
    void test() {
        Session session = SessionFactoryMaker.getFactory().openSession();
        var transaction = session.beginTransaction();
        session.createQuery("delete from Exam").executeUpdate();
        Exam exam = new Exam("froma code");
        session.save(exam);
        List<Exam> employees = session.createQuery("from Exam", Exam.class).list();

        assertEquals("froma code", employees.get(0).getName());
        transaction.rollback();
        session.close();
    }
}