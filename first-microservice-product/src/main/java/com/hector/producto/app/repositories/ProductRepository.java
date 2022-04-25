package com.hector.producto.app.repositories;

import com.hector.producto.app.entity.Producto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void create(Producto producto){
        entityManager.persist(producto);
    }

    @Transactional
    public void delete(Long id){
        Producto producto = entityManager.createQuery("SELECT p FROM Producto p WHERE p.id = :id")
                .setParameter("id", id)
                .unwrap(Producto.class);
        entityManager.remove(producto);
    }

    @Transactional
    public List<Producto> listAll(){
        return entityManager.createQuery("SELECT p FROM Producto p").getResultList();
    }

}
