package br.com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contact")
@Entity
public class ContactModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String subject;

	@NotNull
	private String telefone;

	@NotNull
	private String message;

}
