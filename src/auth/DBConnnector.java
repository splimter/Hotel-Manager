/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author splimter
 */
public class DBConnnector {

    public static String nom = "";

    static Connection initDB() {
        try {
            Connection con;
            String host = "jdbc:derby://localhost:1527/users";
            String uName = "splimter";
            String uPass = "tenno";
            con = DriverManager.getConnection(host, uName, uPass);
            System.out.println("OK!");
            return con;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    private static String sqlF(String s) {
        return "'" + s + "'";
    }

    public static boolean getUser(Connection con, String User, String Pwd)
            throws SQLException {

        Statement stmt = null;

        String query = "select * from UTILISATUER where NOM=" + sqlF(User) + " and PWD=" + sqlF(Pwd);

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                nom = rs.getString("nom");
//                int id = rs.getInt("id");
//                String pwd = rs.getString("pwd");

                //System.out.println(id + "\t" + nom + "\t" + pwd);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        if (nom.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static void addUser(Connection con, String User, String Pwd)
            throws SQLException {

        Statement stmt = null;

        String query = "insert into UTILISATUER (nom,pwd) values (" + sqlF(User) + ", " + sqlF(Pwd) + ")";

        try {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            if (rs == 0) {
                System.out.println("Issue when adding user!");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
    
}