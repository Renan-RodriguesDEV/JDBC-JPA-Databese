package com.javaapijdbc.repositories;

import java.sql.*;

public class LojaMarcos {
    static String url = "jdbc:mysql://localhost:3306/loja";

    public static void main(String[] args) {
        Connection cnx = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, "root", "");
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM loja.produto");
            while (rs.next()) {
                System.out.println(rs.getString("descricao"));
                System.out.println(rs.getString("preco"));
                System.out.println(rs.getString("validade"));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Erro ao carregar o driver");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Err mysql");
            e.printStackTrace();
        } finally {
            if (cnx != null) {
                try {
                    st.close();
                    cnx.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }
}
