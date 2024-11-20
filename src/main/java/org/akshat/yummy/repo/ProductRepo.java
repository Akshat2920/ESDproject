package org.akshat.yummy.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.akshat.yummy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long>{
    Optional<Product> findByPname(String Name);

    @Query("SELECT p FROM Product p WHERE p.Price BETWEEN :minPrice AND :maxPrice ORDER BY p.Price DESC LIMIT 2")
    List<Product> findProductbyPrice(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
}
