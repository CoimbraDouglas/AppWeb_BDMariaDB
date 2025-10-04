package com.exemplo.universidade.controller;

import com.exemplo.universidade.model.Curso;
import com.exemplo.universidade.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return cursoService.salvar(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.atualizar(id, curso);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cursoService.deletar(id);
    }
}
