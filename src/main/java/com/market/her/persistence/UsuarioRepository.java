package com.market.her.persistence;

import com.market.her.domain.User;
import com.market.her.domain.repository.UserRepository;
import com.market.her.persistence.crud.UsuarioCrudRepository;
import com.market.her.persistence.entity.Usuario;
import com.market.her.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public List<User> getAll() {
        List<Usuario> productos = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(productos);
    }

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public Optional<User> loginUser(String user, String password ){
        Optional<Usuario> usuario = usuarioCrudRepository.findByNomUsuarioAndContrasenia(user, password);
        return Optional.of(mapper.toUser(usuario.get()));
    }


}
