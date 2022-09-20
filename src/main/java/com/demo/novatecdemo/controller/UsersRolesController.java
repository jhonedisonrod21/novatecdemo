package com.demo.novatecdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.novatecdemo.dto.UsuarioRolDTO;
import com.demo.novatecdemo.exeption.ResourceNotFoundException;
import com.demo.novatecdemo.service.UsuarioService;
import com.demo.novatecdemo.service.UsuariosRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/UsuariosRoles")
public class UsersRolesController {
	@Autowired
    private UsuariosRolesService service;
	@Autowired
	private UsuarioService userserv;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioRolDTO> getallRoles() {		
		return this.service.getAll();		
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioRolDTO getone(@PathVariable Long id) throws ResourceNotFoundException {
		return this.service.getOne(id);
	}
	
	@GetMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioRolDTO> getByUser(@PathVariable Long id) throws ResourceNotFoundException {
		return this.service.getByUser(userserv.getOne(id));
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioRolDTO post(@Valid @RequestBody UsuarioRolDTO value) {		
		return this.service.post(value);
	}
	
	@PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioRolDTO put(@PathVariable Long id,@Valid @RequestBody UsuarioRolDTO value) throws ResourceNotFoundException {
		return this.service.put(id, value);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable Long id) throws ResourceNotFoundException {
		this.service.delete(id);
		return "{\"eliminado\":true}";
	}
}
