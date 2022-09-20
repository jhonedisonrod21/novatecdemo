package com.demo.novatecdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIOS")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO")
	private Long id_usuario;
	
	@Column(name = "NOMBRES_USUARIO",nullable = false)
	private String nombres_usuario;
	
	@Column(name = "APELLIDOS_USUARIO",nullable = false)
	private String apellidos_usuario;	
	
	
}
