package com.example;
import java.sql.SQLException;

import java.util.List;

public class ContaDAO implements IContaDAO {

    PreparedStatement create;
    public ContaDAO (Connection connection) throws SQLException {
        create = connection.prepareStatement("INSERT INTO contas(nro_conta, saldo) VALUES (?,?)");
    }

    public boolean criarConta(Conta conta) throws SQLException {
        create.setInt(1, conta.getNumero());
        create.setDouble(2, conta.getSaldo());
        if(create.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public List<Conta> lerTodasContas() throws SQLException {
        return null;
    }

    public Conta buscarPorNumero(int numeroConta) throws SQLException {
        return null;
    }

    public void atualizarConta(Conta conta) throws SQLException {
        return null;
    }


}
