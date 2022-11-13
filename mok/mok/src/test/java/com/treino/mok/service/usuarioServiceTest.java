package com.treino.mok.service;

import com.treino.mok.model.UsuarioModel;
import com.treino.mok.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class usuarioServiceTest {
    @Mock
    UsuarioService usuarioService;
    @MockBean
    UsuarioRepository usuarioRepository;
    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializadora(){
        MockitoAnnotations.openMocks (this);
        UsuarioModel usuarioModel = new UsuarioModel(1L, "Luiz","1234");
    }

    @Test
    void exibirUsuarioTest(){
       // UsuarioService mockUsuario = Mockito.mock (UsuarioService.class);
        List<UsuarioModel> todosUsuarios = usuarioService.todosUsuarios ();
        Assertions.assertTrue (todosUsuarios.isEmpty ());
    }

    @Test
    public void testeCadasrtoFuncionando() {
        Mockito.when (usuarioRepository.existsById (Mockito.anyLong())).thenReturn (true);
        usuarioRepository.save (usuarioModel);
        Mockito.verify(usuarioRepository, Mockito.times (1)).save (usuarioModel);

    }

}
