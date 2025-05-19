package dao;

import model.Aluguel;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AluguelDAO {

    public void inserir(Aluguel aluguel) throws SQLException {
        String sql = "INSERT INTO aluguel (filial, veiculo, cliente, retirada, devolucao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluguel.getFilial());
            stmt.setString(2, aluguel.getVeiculo());
            stmt.setString(3, aluguel.getCliente());
            stmt.setObject(4, aluguel.getRetirada());
            stmt.setObject(5, aluguel.getDevolucao());
            stmt.executeUpdate();
        }
    }
}
