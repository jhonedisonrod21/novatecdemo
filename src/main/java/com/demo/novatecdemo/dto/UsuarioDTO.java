package com.demo.novatecdemo.dto;

import java.util.Objects;
import com.demo.novatecdemo.model.Usuario;
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
public class UsuarioDTO {
	
	private Long id_usuario;	
	private String nombres_usuario;	
	private String apellidos_usuario;	
	
	
	
	public static UsuarioDTO fromModel(Usuario value) {		
		if(!Objects.isNull(value)) {
			UsuarioDTO data = new UsuarioDTO(value.getId_usuario(),value.getNombres_usuario(),value.getApellidos_usuario());
			return data;
		}
		return null;
	}
	
	public static Usuario toModel(UsuarioDTO value) {
		if(!Objects.isNull(value)) {
			Usuario data = new Usuario(value.getId_usuario(),value.getNombres_usuario(),value.getApellidos_usuario());
			return data;
		}
		return null;		
	}
	
}
