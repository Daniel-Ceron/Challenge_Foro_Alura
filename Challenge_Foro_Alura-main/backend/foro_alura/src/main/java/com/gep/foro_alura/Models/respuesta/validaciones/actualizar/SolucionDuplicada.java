package com.gep.foro_alura.Models.respuesta.validaciones.actualizar;

import com.gep.foro_alura.Models.respuesta.ActualizarRespuestaDTO;
import com.gep.foro_alura.Models.respuesta.Respuesta;
import com.gep.foro_alura.Models.respuesta.RespuestaRepository;
import com.gep.foro_alura.Models.topico.Estado;
import com.gep.foro_alura.Models.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
       if (data.solucion()){
           Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
           var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
           if (topicoResuelto.getEstado() == Estado.CLOSED){
               throw new ValidationException("Este topico ya esta solucionado.");
           }
       }
    }
}


