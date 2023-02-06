import entities.Exam;
import entities.Participant;
import entities.Result;
import entities.ResultChoice;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private Session session;

    @BeforeEach
    void start() {
        session = SessionFactoryMaker.getFactory().openSession();
    }

    @AfterEach
    void end() {
        session.close();
    }

    @Test
    void testParticipantFlow() {
        Scanner sc = new Scanner("""
                1
                My Super Custom Name
                1
                1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n
                x
                """);
        Main.runProgram(sc, session);

        // get name from participant table
        List<Participant> participants = session.createQuery("from Participant", Participant.class).list();
        Participant participant =participants.get(participants.size() - 1);
        assertEquals("My Super Custom Name", participant.getName());

        // get result with status completed from result table
        List<Result> results = session.createQuery("from Result", Result.class).list();
        results.forEach(result -> {
            if (result.getParticipant().getId() == participant.getId()) {
                assertEquals(1L, result.getExam().getId());
                assertEquals(participant.getId(), result.getParticipant().getId());
            }
        });
    }
}
