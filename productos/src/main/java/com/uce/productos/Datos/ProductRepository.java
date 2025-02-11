package com.uce.productos.Datos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNombre(String nombre);
    Optional<Product> findByCodigo(String codigo);
} 




