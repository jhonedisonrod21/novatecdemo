package com.demo.novatecdemo.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.novatecdemo.dto.UsuarioDTO;
import com.demo.novatecdemo.exeption.ResourceNotFoundException;
import com.demo.novatecdemo.model.Usuario;
import com.demo.novatecdemo.repository.UsuarioRepository;

@Service
public class UsuarioService implements Function<Usuario, UsuarioDTO>{
	
	@Autowired
	public UsuarioRepository repo;
	
	public List<UsuarioDTO> getAll(){
		List<UsuarioDTO> data = (List<UsuarioDTO>) repo.findAll().stream().map(this).collect(Collectors.toList());
		return data;				
	}
	
	public UsuarioDTO getOne(long id) throws ResourceNotFoundException {
		return UsuarioDTO.fromModel(this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("El usuario con ID = "+id+"; no fue encontrado en la base de datos")));
	}
	
	public UsuarioDTO post(UsuarioDTO value) {
		value.setId_usuario(null);
		Usuario entity = UsuarioDTO.toModel(value);
		Usuario auxEntity = this.repo.save(entity);
		return UsuarioDTO.fromModel(auxEntity);
	}
	
	public UsuarioDTO put(Long id, UsuarioDTO value) throws ResourceNotFoundException {
		Usuario entity = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID = "+id+"; no fue encontrado en la base de datos"));
		Usuario entity2 = UsuarioDTO.toModel(value);
		entity2.setId_usuario(entity.getId_usuario());
		Usuario auxEntity = this.repo.save(entity2);
		return UsuarioDTO.fromModel(auxEntity);
	}
	
	public UsuarioDTO delete(Long id) throws ResourceNotFoundException {
		if (!this.repo.existsById(id)) {
			throw new ResourceNotFoundException("El usuario con ID = "+id+"; no fue encontrado en la base de datos");
		}		
		return this.repo.findById(id).map(entity->{
			this.repo.deleteById(id);
			return UsuarioDTO.fromModel(entity);
		}).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID = "+id+"; no fue encontrado en la base de datos"));
	}	
	
	@Override
	public UsuarioDTO apply(Usuario t) {
		return UsuarioDTO.fromModel(t);
	}

}
