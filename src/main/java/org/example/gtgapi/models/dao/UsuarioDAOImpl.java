package org.example.gtgapi.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private final EntityManager entityManager;

    @Autowired
    public UsuarioDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario findById(long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario[] findAll() {
        Query query = entityManager.createQuery("from Usuario");
        return (Usuario[]) query.getResultList().toArray(Usuario[]::new);
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Usuario");
        query.executeUpdate();
    }
}
