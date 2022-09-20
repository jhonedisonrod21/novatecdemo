package com.demo.novatecdemo.dto;

import java.util.Objects;
import com.demo.novatecdemo.model.Rol;
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
public class RolDTO {
	private Long id_rol;	
	private String nombre_rol;	
	
	public static RolDTO fromModel(Rol value) {		
		if(!Objects.isNull(value)) {
			RolDTO data = new RolDTO(value.getId_rol(),value.getNombre_rol());
			return data;
		}
		return null;
	}
	
	public static Rol toModel(RolDTO value) {
		if(!Objects.isNull(value)) {
			Rol data = new Rol(value.getId_rol(),value.getNombre_rol());
			return data;
		}
		return null;		
	}
}
