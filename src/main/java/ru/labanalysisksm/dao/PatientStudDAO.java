package ru.labanalysisksm.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class PatientStudDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void sum() {
        Session session = entityManager.unwrap(Session.class);

        session.createQuery("", PatientStudDAO.class);
    }
}
