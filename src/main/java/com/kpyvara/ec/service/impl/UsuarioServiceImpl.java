package com.kpyvara.ec.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.kpyvara.ec.model.Retencion;
import com.kpyvara.ec.model.Usuario;
import com.kpyvara.ec.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService{
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    @Autowired
    private IUsuarioRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repo.findOneByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getEmpresas().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);
        return ud;
    }

    public Usuario save(Usuario obj) {
        obj.setPassword(bcrypt.encode(obj.getPassword()));
        return repo.save(obj);
    }

    public Usuario getEmpresas(String obj) {

        return repo.findOneByUsername(obj);
    }

}