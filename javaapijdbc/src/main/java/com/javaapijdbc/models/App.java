package com.javaapijdbc.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class App {
    static String name = "funcionarios";
    static String port = "3306";
    static String user = "root";
    static String password = "";
    static String url = String.format("jdbc:mysql://localhost:3306/%s", name);

    public static void main(String[] args) {

        while (true) {
            String options = JOptionPane.showInputDialog(
                    "Digite 1 para consultar ou 2 para atualizar o salario Obs: Digite exit para sair");
            if (options.equals("exit")) {
                JOptionPane.showMessageDialog(null, "Saindo do programa...");
                break;
            }
            String nome = JOptionPane.showInputDialog("Digite o nome do empregado");
            switch (options) {
                case "1":
                    querySQL(nome);
                    break;

                case "2":
                    String salario = JOptionPane.showInputDialog("Insira seu salario!!");
                    if (updateSQL(nome, Float.parseFloat(salario))) {
                        JOptionPane.showMessageDialog(null, "Salario atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "is not possible update your salario!");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!!!");
                    break;
            }

        }

    }

    static boolean updateSQL(String nome, float salario) {
        Connection cnx = null;
        PreparedStatement pst = null;
        boolean isUpdated = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);
            pst = cnx.prepareStatement("UPDATE empregados SET empregadoSalario = ? WHERE empregadoNome = ?");
            pst.setFloat(1, salario);
            pst.setString(2, nome);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                isUpdated = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao carregar o driver", e);
            isUpdated = false;
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao executar sentenças sql!!!", e);
            isUpdated = false;
        } finally {
            if (cnx != null) {
                try {
                    pst.close();
                    cnx.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao executar sentenças sql!!!", e);
                }
            }
        }
        return isUpdated;
    }

    static void querySQL(String nome) {
        Connection cnx = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // Carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Obtem uma estancia da conexão
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Load connection...");

            String query = "SELECT * FROM empregados  WHERE empregadoNome = ?";

            // Cria um estado para sentencas parametrzadas mysql
            pst = cnx.prepareStatement(query);
            pst.setString(1, nome);
            // Executa a query e pega seu resultado
            rs = pst.executeQuery();

            while (rs.next()) {
                // Exibindo conteudo com getString,getFloat e getInt
                int id = rs.getInt(1); // id coluna 1
                String funcionario = rs.getString(2);// nome coluna 2
                String endereco = rs.getString(3);// endereco coluna 3
                String cidade = rs.getString(4); // Cidade coluna 4
                float salario = rs.getFloat(5); // salario coluna 4
                JOptionPane.showMessageDialog(null,
                        "ID: " + id + "\nNome: " + funcionario + "\nCidade: " + cidade + "\nEndereco: " + endereco
                                + "\nSalario: R$" + salario,
                        "### Dados do funcionario ###", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao carregar o driver", e);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao executar sentenças sql!!!", e);
        } finally {
            if (cnx != null) {
                try {
                    rs.close();
                    pst.close();
                    cnx.close();
                    System.out.println("Conexão fechada com sucesso!!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Erro ao tentar fechar conexão", e);
                }

            }
        }
    }
}
