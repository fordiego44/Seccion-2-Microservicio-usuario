package org.condori.springcloud.msvc.cursos.clients;

import org.condori.springcloud.msvc.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@FeignClient(name="msvc-usuarios", url="localhost:8001") para cuando el msvc-usuarios estaba en local
//@FeignClient(name="msvc-usuarios", url="${msvc.usuarios.url}")
@FeignClient(name="msvc-usuarios")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    Usuario detalle(@PathVariable Long id);

    @PostMapping("/")
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
