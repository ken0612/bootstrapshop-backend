package main.java.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.shop.model.ProductsEntity;



public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
	List<ProductsEntity> getProductsEntitiesByCategory(String category);

}
