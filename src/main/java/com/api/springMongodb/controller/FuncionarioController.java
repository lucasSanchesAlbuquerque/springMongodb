package com.api.springMongodb.controller;

import com.api.springMongodb.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.springMongodb.service.FuncionarioService;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    //Create
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return this.funcionarioService.criar(funcionario);
    }

    //Read
    @GetMapping
    public List<Funcionario> obterTodos(){
        return this.funcionarioService.obterTodos();
    }

    //Read one
    @GetMapping("/{codigo}")
    private Funcionario obterPorCodigo(@PathVariable String codigo){
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    //Update
    @PutMapping("/{codigo}")
    public Funcionario atualizarFuncionarioPorCodigo(@PathVariable String codigo, @RequestBody Funcionario funcionario){
        funcionario = this.funcionarioService.atualizaFuncionario(codigo, funcionario);
        return this.funcionarioService.atualizaFuncionario(codigo, funcionario);
    }


    //Delete
    @DeleteMapping("/{codigo}")
    public void deletarFuncionarioPorCodigo(@PathVariable String codigo){
        this.funcionarioService.deletarFuncionarioPorCodigo(codigo);
    }

}
