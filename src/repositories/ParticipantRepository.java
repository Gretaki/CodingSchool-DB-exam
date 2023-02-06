package repositories;

import entities.Participant;
import org.hibernate.Session;

public class ParticipantRepository {
    private final Session session;

    public ParticipantRepository(Session session) {
        this.session = session;
    }

    public Participant add(Participant participant) {
        session.getTransaction().begin();
        session.persist(participant);
        session.getTransaction().commit();
        return participant;
    }
}
