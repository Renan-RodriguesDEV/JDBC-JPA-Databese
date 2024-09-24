package com.javaapijdbc.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

public class InsertMarcos {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/loja";
        String driver_path = "com.mysql.cj.jdbc.Driver";
        Connection cnx = null;
        PreparedStatement pst = null;
        try {
            String query = "insert into loja.produto (descricao,preco) values (?,?)";
            Class.forName(driver_path);
            String nome = JOptionPane.showInputDialog("Produto:");
            String preco = JOptionPane.showInputDialog("Preço:");
            cnx = DriverManager.getConnection(url, "root", "");
            pst = cnx.prepareStatement(query);
            pst.setString(1, nome);
            pst.setDouble(2, Double.parseDouble(preco));
            Calendar dia = new GregorianCalendar();
            int rows = pst.executeUpdate();
            if (rows > 0) {
                String s = String.format("Produto %s inserido com sucesso, valor de %s", nome, preco);
                JOptionPane.showMessageDialog(null, s);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Não foi possivel carregar o driver");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                pst.close();
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
