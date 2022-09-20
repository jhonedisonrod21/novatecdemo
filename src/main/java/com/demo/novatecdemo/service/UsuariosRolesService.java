package com.demo.novatecdemo.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.novatecdemo.dto.UsuarioDTO;
import com.demo.novatecdemo.dto.UsuarioRolDTO;
import com.demo.novatecdemo.exeption.ResourceNotFoundException;
import com.demo.novatecdemo.model.UsuarioRol;
import com.demo.novatecdemo.repository.UsuarioRolRepository;

@Service
public class UsuariosRolesService implements Function<UsuarioRol, UsuarioRolDTO>{
	
	@Autowired
	public UsuarioRolRepository repo;
	
	public List<UsuarioRolDTO> getAll(){
		List<UsuarioRolDTO> data = (List<UsuarioRolDTO>) repo.findAll().stream().map(this).collect(Collectors.toList());
		return data;				
	}

	public List<UsuarioRolDTO> getByUser(UsuarioDTO usuarioDTO){
		List<UsuarioRolDTO> data = (List<UsuarioRolDTO>) repo.findByUsuarios(UsuarioDTO.toModel(usuarioDTO)).stream().map(this).collect(Collectors.toList());
		return data;		
	}

	public UsuarioRolDTO getOne(long id) throws ResourceNotFoundException {
		return UsuarioRolDTO.fromModel(this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("El Usuario-Rol con ID = "+id+"; no fue encontrado en la base de datos")));
	}

	public UsuarioRolDTO post(UsuarioRolDTO value) {
		System.out.println(value.toString());
		value.setId_usuariorol(null);
		UsuarioRol entity = UsuarioRolDTO.toModel(value);
		UsuarioRol auxEntity = this.repo.save(entity);
		return UsuarioRolDTO.fromModel(auxEntity);
	}

	public UsuarioRolDTO put(Long id, UsuarioRolDTO value) throws ResourceNotFoundException {
	    UsuarioRol entity = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Usuario-Rol con ID = "+id+"; no fue encontrado en la base de datos"));
	    UsuarioRol entity2 = UsuarioRolDTO.toModel(value);
		entity2.setId_usuariorol(entity.getId_usuariorol());
		UsuarioRol auxEntity = this.repo.save(entity2);
		return UsuarioRolDTO.fromModel(auxEntity);
	}

	public UsuarioRolDTO delete(Long id) throws ResourceNotFoundException {
		if (!this.repo.existsById(id)) {
			throw new ResourceNotFoundException("El Usuario-Rol con ID = "+id+"; no fue encontrado en la base de datos");
		}		
		return this.repo.findById(id).map(entity->{
			this.repo.deleteById(id);
			return UsuarioRolDTO.fromModel(entity);
		}).orElseThrow(() -> new ResourceNotFoundException("El Usuario-Rol con ID = "+id+"; no fue encontrado en la base de datos"));
	}
	
	

	@Override
	public UsuarioRolDTO apply(UsuarioRol t) {		
		return UsuarioRolDTO.fromModel(t);
	}

}
