package repositories;

import entities.Exam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
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

    public List<Object[]> a(){
        String hql = "select e.id, name, count(r.id) from Exam e left join Result r on e.id = r.exam_id group by e.id, name";
        List<Object[]> query = session.createQuery(hql, Object[].class).list();



        Query qry= session.createQuery("select c.customerName, c.customerCity, i.itemName,i.price from Customer c "
                + "left join c.items i");

//        session.createQuery(
//                "select exam.id, name, count(result.id) from Exam left join Result on exam.id = :result_exam_id group by exam.id, name", Object.class)
//                .setParameter()
//                .list();


        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> cbQuery = cb.createQuery(Object[].class);

        Root<Exam> root = cbQuery.from( Exam.class );


        Join<Object, Object> productsJoin = root.join( "result", JoinType.LEFT );
//        cbQuery.multiselect(root.);
        List<Object[]> result = session.createQuery(cbQuery).getResultList();
        return query;
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
