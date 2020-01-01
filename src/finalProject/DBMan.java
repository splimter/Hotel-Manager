/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

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
public class DBMan {

    // db parameters
    private static String url = "jdbc:sqlite:src\\finalProject\\hotel.db";
    private static Connection con = null;

    private static String sqlF(String s, int isEnd) {
        if (isEnd == 0) {
            return "'" + s + "',";
        } else {
            return "'" + s + "'";
        }
    }

    public static void init() {

        try {
            // create a connection to the database
            con = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            createNewTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createNewTable() {
        // SQL statement for creating a new table
        String sqlEmp = "CREATE TABLE IF NOT EXISTS emp (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    user TEXT  NOT NULL UNIQUE,\n"
                + "    pwd TEXT  NOT NULL,\n"
                + "    fname TEXT  NOT NULL,\n"
                + "    role TEXT  NOT NULL\n,"
                + "    ciid TEXT NOT NULL\n"
                + ");";

        String _setAdmin = sqlF("merah soheyb", 0) + sqlF("admin", 0)
                + sqlF("admin", 0) + sqlF("Admin", 0) + sqlF("171732002610", 1);

        String setAdmin = "INSERT INTO emp(fname,user,pwd,role,ciid) \n"
                + "VALUES (" + _setAdmin + ") ;";

        String sqlRoom = "CREATE TABLE IF NOT EXISTS room (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    type TEXT NOT NULL,\n"
                + "    clientID INTEGER,\n"
                + "    FOREIGN KEY(clientID) REFERENCES client(id)"
                + ");";

        String val = "(" + sqlF("standart", 1) + "),"
                + "(" + sqlF("standart", 1) + "),"
                + "(" + sqlF("standart", 1) + "),"
                + "(" + sqlF("standart", 1) + ")";

        String setRooms = "INSERT INTO room(type) VALUES" + val + " ;";

        String sqlClient = "CREATE TABLE IF NOT EXISTS client (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    fname TEXT NOT NULL,\n"
                + "    ciid TEXT NOT NULL,\n"
                + "    reservationDate TEXT NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sqlEmp);
            stmt.execute(setAdmin);
            stmt.execute(sqlRoom);
            stmt.execute(setRooms);
            stmt.execute(sqlClient);
            System.out.println("Done Creating Tables.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] getUser(String User, String Pwd)
            throws SQLException {

        Statement stmt = null;

        String query = "select * from emp where user=" + sqlF(User, 1) + " and pwd=" + sqlF(Pwd, 1);

        String fname = "", user = "", role = "";
        String[] s = new String[3];
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                user = rs.getString("user");
                fname = rs.getString("fname");
                role = rs.getString("role");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            s[0] = user;
            s[1] = fname;
            s[2] = role;
            if (stmt != null) {
                stmt.close();
            }
        }

        return s;
    }

    public static String[] getEmp(int id) throws SQLException {
        Statement stmt = null;

        String query = "select * from emp where id=" + id;

        String fname = "", user = "", pwd = "", role = "", ciid = "";
        String[] s = new String[5];
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                fname = rs.getString("fname");
                user = rs.getString("user");
                pwd = rs.getString("pwd");
                role = rs.getString("role");
                ciid = rs.getString("ciid");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            s[0] = fname;
            s[1] = user;
            s[2] = pwd;
            s[3] = role;
            s[4] = ciid;
            if (stmt != null) {
                stmt.close();
            }
        }

        return s;
    }

    public static boolean getEmp(String User)
            throws SQLException {

        Statement stmt = null;

        String query = "select * from emp where user=" + sqlF(User, 1) + " ;";

        String user = "";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                user = rs.getString("user");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {

            if (stmt != null) {
                stmt.close();
            }
        }

        if (user.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Emp> getAllEmp() throws SQLException {
        ArrayList<Emp> emp = new ArrayList<>();

        Statement stmt = null;

        String query = "select * from emp";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                emp.add(new Emp(rs.getInt("id"), rs.getString("fname"),
                        rs.getString("user"), rs.getString("pwd"), rs.getString("ciid"), rs.getString("role")));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return emp;

    }

    public static ArrayList<Room> getAllRoom() throws SQLException {
        ArrayList<Room> room = new ArrayList<>();

        Statement stmt = null;

        String query = "select * from room";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                room.add(new Room(
                        rs.getInt("id"), rs.getString("type"), rs.getInt("clientID")
                ));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return room;

    }

    public static void addUser(String[] data) throws SQLException {

        Statement stmt = null;

        String values = "(" + sqlF(data[0], 0) + sqlF(data[1], 0) + sqlF(data[2], 0)
                + sqlF(data[3], 0) + sqlF(data[4], 1) + ")";

        String query = "insert into emp (user,pwd,fname,role,ciid) values " + values + " ;";

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

    public static void addRoom(String Type) throws SQLException {

        Statement stmt = null;

        String query = "insert into room (type) values ("+sqlF(Type, 1)+")";

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
    
    public static void addClient(String[] data,String roomId) throws SQLException{
       
        Statement stmt = null;

        // Add clientID
        String query = "insert into client (fname,ciid,reservationDate) values ("
                +sqlF(data[0], 0)
                +sqlF(data[1], 0)
                +sqlF(data[2], 1)+")";
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
        
        //Get Client ID
        int cid=0;
        query = "select id from client where ciid=" + data[1];
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                cid = rs.getInt("id");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        //Set Client to Room
        query = "update room set clientID="+cid+" where id="+roomId;
        System.out.println("q: "+query);
        try {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            if (rs == 0) {
                System.out.println("Issue when adding user!");
            } else {
                 System.out.println("done updating user!");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
    }

    public static void updateUser(String[] data,String id) throws SQLException {
        Statement stmt = null;

        String values = "fname=" + sqlF(data[0], 0)
                + "user=" + sqlF(data[1], 0)
                + "pwd=" + sqlF(data[2], 0)
                + "role=" + sqlF(data[3], 0)
                + "ciid=" + sqlF(data[4], 1);

        String query = "update emp set " + values + " where id="+ id;
        System.out.println(query);
        try {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            if (rs == 0) {
                System.out.println("Issue when adding user!");
            } else {
                 System.out.println("done updating user!");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
    
    public static void updateRoom(String id,String type)throws SQLException{
        Statement stmt = null;
        String query = "update room set type=" + sqlF(type, 1) + " where id="+ sqlF(id, 1);
        System.out.println(query);
        try {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            if (rs == 0) {
                System.out.println("Issue when adding user!");
            } else {
                 System.out.println("done updating user!");
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

class Emp {

    int id;
    String fullname, user, pwd, ciid, role;

    public Emp(int id, String fullname, String user, String pwd, String ciid, String role) {
        this.id = id;
        this.fullname = fullname;
        this.user = user;
        this.pwd = pwd;
        this.ciid = ciid;
        this.role = role;
    }
    
}

class Room {

    int id, clientID;
    String type;
    public Room(int id, String type, int clientID) {
        this.id = id;
        this.type = type;
        this.clientID = clientID;
    }
    
}
