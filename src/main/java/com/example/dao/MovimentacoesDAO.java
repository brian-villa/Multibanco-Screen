package com.example.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import com.example.util.ConexaoBancoDados;
import com.example.model.Movimentacoes;

import java.sql.*;

public class MovimentacoesDAO {


    public void inserirMovimentacoes(Movimentacoes movimentacoes, int numeroConta) throws SQLException {
        movimentacoes.setId(UUID.randomUUID());
        try (Connection connection = ConexaoBancoDados.conectar();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO movimentacoes (uuid, data, tipo, valor, numeroConta) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, movimentacoes.getUuid().toString());
            statement.setString(2, String.valueOf(Date.valueOf(movimentacoes.getData())));
            statement.setString(3, movimentacoes.getTipoOperacao());
            statement.setDouble(4, movimentacoes.getValor());
            statement.setInt(5, numeroConta);
            statement.executeUpdate();
        }
    }

    public List<Movimentacoes> listarMovimentacoes(int numeroConta) throws SQLException {
        List<Movimentacoes> movimentacoes = new ArrayList<>();
        try (Connection connection = ConexaoBancoDados.conectar();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movimentacoes WHERE numeroConta = ?")) {
            statement.setInt(1, numeroConta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UUID uuid = UUID.fromString(resultSet.getString("uuid"));
                LocalDate data = resultSet.getDate("data").toLocalDate();
                String tipoOperacao = resultSet.getString("tipo");
                double valor = resultSet.getDouble("valor");
                Movimentacoes movimentacao = new Movimentacoes(uuid, data, tipoOperacao, valor);
                movimentacoes.add(movimentacao);
            }
            movimentacoes.sort(Comparator.comparing(Movimentacoes::getData));
        }
        return movimentacoes;
    }
}
