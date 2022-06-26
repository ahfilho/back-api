package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
