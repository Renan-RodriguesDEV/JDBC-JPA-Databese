package com.javaapijdbc;

import java.sql.*;

import javax.swing.JOptionPane;

public class SelectJava {
    static private String url = "jdbc:mysql://localhost:3306/loja";
    static private String username = "root";
    static private String password = "";

    public static void main(String[] args) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String input = JOptionPane.showInputDialog("Insira um ID de produto");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, username, password);
            String query = "select * from loja.produto where idProduto = ?";
            pst = cnx.prepareStatement(query);
            int id = Integer.parseInt(input);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Produto: " + rs.getString("descricao"));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    if (pst != null) {
                        pst.close();
                    }
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
