package br.com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.entity.SacModel;
import br.com.api.service.SacService;

@RestController
@RequestMapping("cadsac")
public class SacController {

	@Autowired
	private SacService service;

	@PostMapping
	public ResponseEntity<SacModel> sacSave(@RequestBody SacModel sacModel) {
		return ResponseEntity.ok().body(this.service.saveSac(sacModel));
	}

	@GetMapping
	public ResponseEntity<List<SacModel>> sacList() {
		return ResponseEntity.ok().body(this.service.sacList());
	}

	@PutMapping("/{id}")
	public ResponseEntity<SacModel> sacUpdate(@PathVariable Long id, @RequestBody SacModel sacmodel) throws Exception {
		sacmodel.setId(id);
		return ResponseEntity.ok().body(this.service.sacUpdate(sacmodel));

	}

	@DeleteMapping("/{id}")
	public HttpStatus sacDelete(@PathVariable Long id) throws Exception {
		this.service.delete(id);
		return HttpStatus.OK;
	}
}