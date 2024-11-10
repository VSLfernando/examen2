package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Usuario;
import com.hospital.examen.modelo.dto.UsuarioRegistroDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {
    public Usuario save(UsuarioRegistroDTO registroDTO);
    public List <Usuario> listarUsuarios ();
}
