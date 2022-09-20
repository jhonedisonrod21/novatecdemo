package com.demo.novatecdemo.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.novatecdemo.dto.RolDTO;
import com.demo.novatecdemo.exeption.ResourceNotFoundException;
import com.demo.novatecdemo.model.Rol;
import com.demo.novatecdemo.repository.RolRepository;

@Service
public class RolService  implements Function<Rol, RolDTO> {
	
	@Autowired
	public RolRepository repo;
	
	public List<RolDTO> getAll(){
		List<RolDTO> data = (List<RolDTO>) repo.findAll().stream().map(this).collect(Collectors.toList());
		return data;			
	}
	
	public RolDTO getOne(long id) throws ResourceNotFoundException {
		return RolDTO.fromModel(this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("El rol con ID = "+id+"; no fue encontrado en la base de datos")));
	}
	
	public RolDTO post(RolDTO value) {
		value.setId_rol(null);
		Rol entity = RolDTO.toModel(value);
		Rol auxEntity = this.repo.save(entity);
		return RolDTO.fromModel(auxEntity);
	}
	
	public RolDTO put(Long id, RolDTO value) throws ResourceNotFoundException {
		Rol entity = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El usuario con ID = "+id+"; no fue encontrado en la base de datos"));
		Rol entity2 = RolDTO.toModel(value);
		entity2.setId_rol(entity.getId_rol());
		Rol auxEntity = this.repo.save(entity2);
		return RolDTO.fromModel(auxEntity);
	}
	
	public RolDTO delete(Long id) throws ResourceNotFoundException {
		if (!this.repo.existsById(id)) {
			throw new ResourceNotFoundException("El rol con ID = "+id+"; no fue encontrado en la base de datos");
		}		
		return this.repo.findById(id).map(entity->{
			this.repo.deleteById(id);
			return RolDTO.fromModel(entity);
		}).orElseThrow(() -> new ResourceNotFoundException("El rol con ID = "+id+"; no fue encontrado en la base de datos"));
	}

	@Override
	public RolDTO apply(Rol t) {
		return RolDTO.fromModel(t);
	}
}
