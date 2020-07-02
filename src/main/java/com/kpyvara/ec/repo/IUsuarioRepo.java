package com.kpyvara.ec.repo;

import com.kpyvara.ec.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

    //select * from usuario where username = ?
    Usuario findOneByUsername(String username);
}