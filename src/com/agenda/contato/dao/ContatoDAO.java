package com.agenda.contato.dao;

import com.agenda.factory.ConnectionFactory;
import com.agenda.model.Agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/*
* O dao é basicamente onde fica as regra s de negocio
* onde o crud é de fato feito
* onde moldamos o java com o banco relacional
* DAO é um acrônimo do inglês Data Access Object - DAO
* ou seja Objeto de acesso a dados */
public class ContatoDAO {

    // metodo save é o create
    public void save(Agenda contato) throws Exception {
        // string de insersão
        String sql = "INSERT INTO contato(nome, idade,dataCadastro) " +
                      "VALUES(?, ?, ?)";
        //crinado conexão banco
        Connection conn = null;
        //utilizado para execultar consutas
        PreparedStatement pstm = null;

        // tentar conectar no banco
        try {
            // cria a conexão com banco
                conn = ConnectionFactory.createConnectionToMysql();

            // crinado uma PreparedStatement para execultar o comando sql
                pstm = (PreparedStatement)  conn.prepareStatement(sql);
            //setando os valores para gravar em banco
                pstm.setString(1, contato.getNome());
                pstm.setInt(2,contato.getIdade());
                pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //execultado a query
                pstm.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // fechar todas as conexões com o banco
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn !=null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
