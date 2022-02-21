package com.inmobiliaria.administracionservice.models.service;

import java.util.ArrayList;
import java.util.List;

import com.inmobiliaria.administracionservice.models.dao.IUserDao;
import com.inmobiliaria.administracionservice.models.entity.Role;
import com.inmobiliaria.administracionservice.models.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userDao.findByusername(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (usuario == null) {
            throw new UsernameNotFoundException("El usuario no existe");
        }
        for (Role role : usuario.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        if (authorities.isEmpty()) {
            throw new UsernameNotFoundException("El usuario no tiene roles");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
                authorities);
    }

}
