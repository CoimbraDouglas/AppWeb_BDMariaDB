package com.exemplo.universidade.service;


import com.exemplo.universidade.model.Curso;
import com.exemplo.universidade.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public Curso atualizar(Long id, Curso cursoAtualizado) {
        Curso curso = buscarPorId(id);
        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
        return cursoRepository.save(curso);
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}