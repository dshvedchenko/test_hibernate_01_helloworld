package hibernate.test;

import hibernate.test.dto.EmployeeEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TestHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        // Add new Employee object
        List<EmployeeEntity> e = new LinkedList<>();
        for (int i=0;i < 10;i++) {
            EmployeeEntity emp = new EmployeeEntity();
            emp.setEmail("demo" + Math.random() + "-user@mail.com");
            emp.setFirstName("demo");
            emp.setLastName("user");
            emp.setCreateAt(LocalDateTime.now());
            entityManager.persist(emp);
        }

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();

        System.out.println(TestSngl.INSTANCE.getName());

    }
}