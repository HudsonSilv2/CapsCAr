package dao;

import model.Filial;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilialDAO {
    public void inserir(Filial filial) throws SQLException {
        String sql = "INSERT INTO filial (nome, endereco, telefone, horarioabertura, horariofechamento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filial.getNome());
            stmt.setString(2, filial.getEndereco());
            stmt.setString(3, filial.getTelefone());
            stmt.setObject(4, filial.getHorarioAbertura());
            stmt.setObject(5, filial.getHorarioFechamento());
            stmt.executeUpdate();
        }
    }
}