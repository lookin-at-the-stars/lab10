import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ContaDAO implements IContaDAO {

    public boolean criarConta(Conta conta) throws SQLException {
        String sql = "INSERT INTO contas (numero, saldo) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement create = conn.prepareStatement(sql)) {
            create.setInt(1, conta.getNumero());
            create.setDouble(2, conta.getSaldo());
            int rowsInserted = create.executeUpdate();
            return rowsInserted > 0;
        }
    }
}