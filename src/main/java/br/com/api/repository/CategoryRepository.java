package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.CategoriaProdutoModel;

public interface CategoryRepository extends JpaRepository<CategoriaProdutoModel, Long>{

}
