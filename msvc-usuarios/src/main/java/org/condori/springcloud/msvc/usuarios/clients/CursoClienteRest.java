package org.condori.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="msvc-cursos", url = "host.docker.internal:8002") cuando el msvc-cursos estaba en la mqa local
//@FeignClient(name="msvc-cursos", url = "${msvc.cursos.url}")
@FeignClient(name="msvc-cursos")
public interface CursoClienteRest {

    @DeleteMapping("/eliminar-curso-usuario/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);
}
