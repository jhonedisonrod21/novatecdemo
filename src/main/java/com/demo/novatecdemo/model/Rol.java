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
@Table(name = "ROLES")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
public class Rol {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_ROL",length = 15,nullable = false)
	private Long id_rol;
	
	@Column(name = "NOMBRE_ROL",length = 120,nullable = false)
	private String nombre_rol;
	
}
