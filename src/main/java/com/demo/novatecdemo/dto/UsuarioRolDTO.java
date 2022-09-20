package com.demo.novatecdemo.dto;

import java.util.Objects;
import com.demo.novatecdemo.model.UsuarioRol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioRolDTO {
	
	private Long id_usuariorol;	
	private UsuarioDTO usuario;
	private RolDTO rol;
	
	public static UsuarioRolDTO fromModel(UsuarioRol value) {		
		if(!Objects.isNull(value)) {
			UsuarioRolDTO data = new UsuarioRolDTO(value.getId_usuariorol(),UsuarioDTO.fromModel(value.getUsuarios()),RolDTO.fromModel(value.getRoles()));
			return data;
		}
		return null;
	}
	
	public static UsuarioRol toModel(UsuarioRolDTO value) {
		if (value == null) {
			return null;
		}
		UsuarioRol data = new UsuarioRol(value.getId_usuariorol(),UsuarioDTO.toModel(value.getUsuario()),RolDTO.toModel(value.getRol()));
		return data;		
			
	}

}
