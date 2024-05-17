package db;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {

    private static final String dburl ="jdbc:mysql://localhost:3306/coursejdbc";
    private static final String user = "Developer";
    private static final String password = "Maria2020!";
    private static final Boolean useSSL = false;

    private static Connection com = null;  

    public static Connection getConnection(){
        if (com == null){
            try {
                com = DriverManager.getConnection(dburl, user, password);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return com;
    }

    public static void closeConnection(){
        if (com != null){
            try {
                com.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    
    }
    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
