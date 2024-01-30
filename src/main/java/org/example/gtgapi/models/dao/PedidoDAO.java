package org.example.gtgapi.models.dao;


import org.example.gtgapi.models.entity.Pedido;


public interface PedidoDAO {
    void save(Pedido rol);

    Pedido findById(long id);

    Pedido[] findAll();

    void update(Pedido rol);

    void delete(long id);

    void deleteAll();
}
