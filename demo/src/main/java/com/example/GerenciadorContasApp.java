package com.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import java.util.List;

class GerenciadorContasApp {
  Scanner scanner = new Scanner(System.in);
  private IContaDAO contaDAO;

  public GerenciadorContasApp(IContaDAO contaDAO) {
    this.contaDAO = contaDAO;
  }

  public static void main(String[] args) throws SQLException {
    Connection connection = ConnectionFactory.getConnection();
    IContaDAO contaDAO = new ContaDAO(connection);
    GerenciadorContasApp app = new GerenciadorContasApp(contaDAO);
    System.out.println("TESTE");
    app.solicitarOperacao();
  }

  public void solicitarOperacao() {
    while (true) {
      menuPrincipal();
    }
  }

  public void menuPrincipal() {
    System.out.println("===== Menu Principal =====");
    System.out.println("1. Criar Conta");
    System.out.println("2. Mostrar Contas");
    System.out.println("3. Alterar Conta");
    System.out.println("4. Apagar Conta");
    System.out.println("5. Sair");
    System.out.print("Escolha uma opção: ");

    int opcao = scanner.nextInt();
    scanner.nextLine(); // Limpa o buffer

    switch (opcao) {
      case 1:
        try {
          criarConta();
        } catch (SQLException e) {
          System.out.println("Erro no banco" + e);
        }

        break;
      case 2:
        try {
          mostrarContas();
        } catch (SQLException e) {
          System.out.println("Erro no banco"+ e);
        }

        break;
      case 3:
        try {
          alterarConta();
        } catch (SQLException e) {
          System.out.println("Erro no banco" + e);
        }

        break;
      case 4:
        try {
          apagarConta();
        } catch (SQLException e) {
          System.out.println("Erro no banco");
        }

        break;
      case 5:
        System.out.println("Saindo...");
        System.exit(0);
        break;
      default:
        System.out.println("Opção inválida!");
    }
  }

  

  public void criarConta() throws SQLException {
    System.out.println("Informe o número da conta: ");
    int numero = scanner.nextInt();
    System.out.println("Informe o saldo da conta: ");
    double saldo = scanner.nextDouble();
    Conta conta = new Conta(numero, saldo);
    if (contaDAO.criarConta(conta)) {
      System.out.println("Conta criada com sucesso! Pressione enter para continuar...");
      scanner = new Scanner(System.in);
      scanner.nextLine();
    } else {
      System.out.println("Erro ao criar a conta: ");
    }
  }
 
	/* -CRIE os métodos faltantes: 
		monstrarContas, alterarConta e apagarConta -*/
		
}