package br.com.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class ProductModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String product_name;

	@OneToOne(mappedBy = "produtoImg", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private ImgProdutoModel imgProduto;

	@OneToOne(mappedBy = "produtosCategoria")
	private CategoriaProdutoModel categoriaProduto;

}
