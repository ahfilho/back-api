package br.com.api.entity;

import lombok.Data;

@Data
public class ImagemOfertaResponse {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String name;
	private Long size;
	private String url;
	private String contentType;

}
