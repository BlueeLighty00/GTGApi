package org.example.gtgapi.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import org.example.gtgapi.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MenuDAOImpl implements MenuDAO {

    private final EntityManager entityManager;

    @Autowired
    public MenuDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Menu menu) {
        entityManager.persist(menu);
    }

    @Override
    public Menu findById(long id) {
        Menu menu = entityManager.find(Menu.class, id);
        if (menu == null) {
            throw new EntityNotFoundException("Menu with id " + id + " not found");
        }
        return menu;
    }

    @Override
    public Menu[] findAll() {
        Query query = entityManager.createQuery("from Menu");
        return (Menu[]) query.getResultList().toArray(Menu[]::new);
    }

    @Override
    @Transactional
    public void update(Menu menu) {
        entityManager.merge(menu);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Menu menu = findById(id);
        entityManager.remove(menu);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Menu");
        query.executeUpdate();
    }
}
