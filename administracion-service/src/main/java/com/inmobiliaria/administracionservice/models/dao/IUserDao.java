package com.inmobiliaria.administracionservice.models.dao;

import com.inmobiliaria.administracionservice.models.entity.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<Usuario,Long>{

    public Usuario findByusername(String username);
}
