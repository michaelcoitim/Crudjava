package com.agenda.contato.dao;

import com.agenda.factory.ConnectionFactory;
import com.agenda.model.Agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                System.out.println("Contato salvo com sucesso");


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


    /* esse metedo basicamente pegar os dados vindo do banco
     * salva em uma variavel, por esse motivo parece que estamos gravando novamente esses dados porem
     * só estamos listando essa variavel
     */
    public List<Agenda> listaContatos(){
        // string de sql **SELECT***
        String sql = "SELECT * FROM contato;";

        //crinado conexão banco
        Connection conn = null;

        //utilizado para execultar consutas
        PreparedStatement pstm = null;

        // variavel guarda  informações vindas do banco, para ser "manipuladas" no java (pega o conjuto de resut set
        // e coloca dentro de um array)
        List<Agenda> contatos = new ArrayList<Agenda>();

        // recupera os dados do banco
        ResultSet rste = null;
        try {
            conn = ConnectionFactory.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //a variavael rste está com um "array" do contatos vindo do banco
            rste = pstm.executeQuery();

            // percorendo lista vindo do banco
            while (rste.next()){

                // "criando um novo contato" para ser salvo na que é do tipo list
                Agenda contato = new Agenda();

                // recuperando id (grava a informação do id que esta vindo do banco  em contato)
                contato.setId(rste.getInt("id"));

                // recupenado nome
                contato.setNome(rste.getString("nome"));

                // recuperando idade
                contato.setIdade(rste.getInt("idade"));

                // recuperando data de cadastro

                contato.setDataCadastro(rste.getDate("dataCadastro"));

                // adicionando contato na lista
                contatos.add(contato);

            }


        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //finalizando conexões
            try {
                if(conn != null){
                    conn.close();
                }

                if (pstm != null){
                    pstm.close();
                }
                if (rste != null){
                    rste.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return contatos;


    }

    public void atualizaContato(Agenda contato){
        String sql ="UPDATE FROM contato SET nome = ? , idade = ? , datacadastro = ? " +
                "where id = ?";
        Connection con = null;
        PreparedStatement ppst = null;


    }

}
