package com.api.springMongodb.service;

import com.api.springMongodb.model.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncionarioService {


    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public void deletarFuncionarioPorCodigo(String codigo);

    public Funcionario atualizaFuncionario(String codigo, Funcionario funcionario);

}
