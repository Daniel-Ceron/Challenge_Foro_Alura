package com.gep.foro_alura.Models.respuesta.validaciones.actualizar;

import com.gep.foro_alura.Models.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}
