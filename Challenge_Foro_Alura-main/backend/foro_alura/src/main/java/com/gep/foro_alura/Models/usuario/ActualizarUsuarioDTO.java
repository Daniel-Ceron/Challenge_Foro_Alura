package com.gep.foro_alura.Models.usuario;

public record ActualizarUsuarioDTO(
   String password,
   Role role,
   String nombre,
   String apellido,
   String email,
   Boolean enabled

) {
}


