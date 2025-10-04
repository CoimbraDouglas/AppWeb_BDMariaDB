package com.exemplo.universidade.service;

import com.exemplo.universidade.model.Aluno;
import com.exemplo.universidade.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno aluno = buscarPorId(id);
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setDataNascimento(alunoAtualizado.getDataNascimento());
        aluno.setCurso(alunoAtualizado.getCurso());
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}
