package com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.sql.DriverManager.getConnection;

public class ConnectionFactory {
    //Nome do usuario do banco
    private static final String USERNAME = "root";

    // Senha banco
    private  static  final String PASSWORD = "1234";

    // URL do banco/nome banco
    private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/agenda";


    // criando conexão com o banco
    public static Connection createConnectionToMysql() throws Exception {
        //carrengado a classe pela jvm
        Class.forName("com.mysql.jdbc.Driver");

        // crinado conexao com banco
        Connection connection = DriverManager.getConnection("DATABASE_URL","USERNAME","PASSWORD");
        return connection;
    }

    public static void main(String[] args) {

        // recupperação de conexao com o banco
    }
}
