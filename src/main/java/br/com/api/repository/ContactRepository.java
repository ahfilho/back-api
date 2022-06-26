package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long> {



}
