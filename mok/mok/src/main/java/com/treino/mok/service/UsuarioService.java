package com.treino.mok.service;

import com.treino.mok.model.UsuarioModel;
import com.treino.mok.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> todosUsuarios(){
        return usuarioRepository.findAll();
    }
    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        if(usuarioRepository.existsById(usuarioModel.getId())){
            throw new RuntimeException("Usuario já cadastrado");
        }else {
            usuarioRepository.save(usuarioModel);
            return usuarioModel;
        }
    }
}
