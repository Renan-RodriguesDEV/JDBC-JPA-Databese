package com.javaapijdbc;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class InserePreparet {
    public static void main(String[] args) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String url = "jdbc:mysql://localhost:3306/loja";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, username, password);
            String querySql = "INSERT INTO loja.produto(descricao,preco,validade) VALUES (?,?,?)";
            // alterando pela ordem dos (?) -> 1,2,3 e pelo tipo de produdo
            // 1 = descricao | 2 = preco | 3 = validade
            pst = cnx.prepareStatement(querySql);
            pst.setString(1, "kilo de abroba");
            pst.setDouble(2, 29.90);
            pst.setDate(3, java.sql.Date.valueOf("2024-09-09"));
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("produtos inseridos com sucesso!!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
