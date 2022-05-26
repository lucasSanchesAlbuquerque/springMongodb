package com.api.springMongodb.service;

import com.api.springMongodb.repository.FuncionarioRepository;
import com.api.springMongodb.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository.findById(codigo).orElseThrow(
                () -> new IllegalArgumentException("Funcionario não existe."));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public void deletarFuncionarioPorCodigo(String codigo) {
        this.funcionarioRepository.deleteById(codigo);
    }

    @Override
    public Funcionario atualizaFuncionario(String codigo, Funcionario funcionario) {
        Funcionario fun  = funcionarioRepository.findById(codigo).orElseThrow(
                () -> new IllegalArgumentException());
        update(fun,funcionario);
        return funcionarioRepository.save(fun);
    }

    private void update (Funcionario fun, Funcionario funcionario) {
        fun.setNome(funcionario.getNome());
        fun.setIdade(funcionario.getIdade());
        fun.setSalario(funcionario.getSalario());
    }

}
