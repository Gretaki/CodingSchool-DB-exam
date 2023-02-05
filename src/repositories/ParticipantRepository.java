package repositories;

import entities.Participant;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

public class ParticipantRepository {
    private final Session session;

    public ParticipantRepository(Session session) {
        this.session = session;
    }

    public void add(Participant participant) {
        session.getTransaction().begin();
        session.persist(participant);
        session.getTransaction().commit();
    }

    public Participant getByName(String name) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Participant> cbQuery = cb.createQuery(Participant.class);
        Root<Participant> root = cbQuery.from(Participant.class);
        cbQuery.select(root).where(cb.equal(root.get("name"), name));
        return session.createQuery(cbQuery).getResultList().get(0);
    }
}
