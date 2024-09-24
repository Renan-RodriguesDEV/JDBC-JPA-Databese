package com.javaapijdbc;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class InsereStatement {
    static private String url = "jdbc:mysql://localhost:3306/loja";
    static private String username = "root";
    static private String password = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            String commandSql = "insert into loja.produto (descricao,preco,validade) values ('banana',5.98,'2024-09-09');";
            // antes de executar vc deve criar um Statement
            st = conn.createStatement();
            int result = st.executeUpdate(commandSql);
            if (result > 0) {
                System.out.println("result = " + result);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    if (st != null) {
                        st.close();

                    }
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
