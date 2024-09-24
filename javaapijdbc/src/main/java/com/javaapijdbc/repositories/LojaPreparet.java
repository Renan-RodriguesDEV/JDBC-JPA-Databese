package com.javaapijdbc.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LojaPreparet {
    static String url = "jdbc:mysql://localhost:3306/loja";
    static String passwd = "";
    static String username = "root";

    public static void main(String[] args) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String input = JOptionPane.showInputDialog("Insira um produto");
        String query = "select descricao,preco,validade from loja.produto where descricao = ?";
        try {
            cnx = DriverManager.getConnection(url, username, passwd);
            pst = cnx.prepareStatement(query);
            pst.setString(1, input);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String nome = rs.getString(1);
                String preco = rs.getString(2);
                String data = rs.getString(3);
                JOptionPane.showMessageDialog(null, nome + " $" + preco + " " + data);
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    pst.close();
                    cnx.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
