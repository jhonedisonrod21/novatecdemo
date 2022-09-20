package com.demo.novatecdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.novatecdemo.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
