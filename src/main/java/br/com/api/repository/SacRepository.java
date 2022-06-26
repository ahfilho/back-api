package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.SacModel;

public interface SacRepository extends JpaRepository<SacModel, Long> {

	

}
