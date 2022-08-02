package com.agenda.contato.dao;

import com.agenda.model.Agenda;

/*
* O dao é basicamente onde fica as regra s de negocio
* onde o crud é de fato feito
* onde moldamos o java com o banco relacional
* DAO é um acrônimo do inglês Data Access Object - DAO
* ou seja Objeto de acesso a dados */
public class ContatoDAO {

    // metodo save é o create
    public void save(Agenda contato){
        String sql = "INSERT INTO contato(nome, idade,dataCadastro) " +
                      "VALUES(?,?,)";
    }

}
