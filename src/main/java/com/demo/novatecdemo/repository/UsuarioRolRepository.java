package com.demo.novatecdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.novatecdemo.model.Usuario;
import com.demo.novatecdemo.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{	
	public List<UsuarioRol> findByUsuarios(Usuario usuario);
}
