package com.demo.novatecdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "USUARIOS_ROLES")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
public class UsuarioRol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO_ROL",nullable = false)
	private Long id_usuariorol;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "ID_USUARIO",nullable = false, foreignKey = @ForeignKey(name = "USR_ROLES_USR_FK"))
	private Usuario usuarios;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROL",nullable = false, foreignKey = @ForeignKey(name = "USR_ROLES_ROL_FK"))
	private Rol roles;
}
