package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBancoDados {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=multibanco_app;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
    private static final String USUARIO = "sa";
    private static final String SENHA = "Bri@nvilla1993";

    public static Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado com sucesso!");
            return conexao;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    };
}
