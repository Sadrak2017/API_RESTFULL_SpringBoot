package br.com.sadrak.api_restfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadrak.api_restfull.service.ServiceImpl;

@RestController
public class Controller {

	@Autowired
	private ServiceImpl service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getResource(@RequestParam("q") String query) {
		try {
			Object relatorio = service.getResource(query);
			if (relatorio == null) {
				return new ResponseEntity<>(relatorio, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(relatorio, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> postResource(@RequestBody String body) {
		try {
			service.postResource(body);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping(consumes = "application/json")
	public ResponseEntity<?> patchResource(@RequestBody String body) {
		try {
			service.patchResource(body);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(consumes = "application/json")
	public ResponseEntity<?> deleteResource(@RequestBody String body) {
		try {
			service.deleteResource(body);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
