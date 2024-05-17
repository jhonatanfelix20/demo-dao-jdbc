package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.SQLException;
import java.sql.Statement;



public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();

            int linha1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /* 
            int x = 1;
            if (x < 2){
                throw new SQLException("Fake error");
            }
            */
            
            int linha2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("linha1 " + linha1);
            System.out.println("linha2 " + linha2);
        }
        catch (SQLException e){
            try {
                conn.rollback();
                throw new DbIntegrityException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to roolback! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
