package org.example.gtgapi.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.gtgapi.models.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolDAOImpl implements RolDAO {

    private final EntityManager entityManager;

    @Autowired
    public RolDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Rol rol) {
        entityManager.persist(rol);
    }

    @Override
    public Rol findById(long id) {
        return entityManager.find(Rol.class, id);
    }

    @Override
    public Rol[] findAll() {
        Query q1 = entityManager.createQuery("from Rol");

        return (Rol[]) q1.getResultList().toArray(Rol[]::new);
    }

    @Override
    @Transactional
    public void update(Rol rol) {

            entityManager.merge(rol);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Rol");
        q1.executeUpdate();
    }
}
