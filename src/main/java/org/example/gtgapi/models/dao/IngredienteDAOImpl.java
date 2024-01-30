package org.example.gtgapi.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.gtgapi.models.entity.Ingrediente;
import org.example.gtgapi.models.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredienteDAOImpl implements IngredienteDAO {

    private final EntityManager entityManager;

    @Autowired
    public IngredienteDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Ingrediente ingrediente) {
        entityManager.persist(ingrediente);
    }

    @Override
    public Ingrediente findById(long id) {
        return entityManager.find(Ingrediente.class, id);
    }

    @Override
    public Ingrediente[] findAll() {
        Query q1 = entityManager.createQuery("from Ingrediente");

        return (Ingrediente[]) q1.getResultList().toArray(Ingrediente[]::new);
    }

    @Override
    @Transactional
    public void update(Ingrediente ingrediente) {

            entityManager.merge(ingrediente);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Ingrediente");
        q1.executeUpdate();
    }
}
