package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Departamento;
import entities.Vendedor;
import model.dao.VendedorDAO;
import java.sql.SQLException;

public class VendedorDaoJDBC implements VendedorDAO{

    private Connection conn;

    public VendedorDaoJDBC(Connection conn){
        this.conn = conn;
    }	
   
    @Override
    public void insert(Vendedor obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Vendedor obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Vendedor findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "where seller.Id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Departamento dep = new Departamento();
                dep.setId(rs.getInt("DepartmentId")); 
                dep.setNome(rs.getString("DepName"));
                Vendedor obj = new Vendedor();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setDataNascimento(rs.getDate("BirthDate"));
                obj.setSalarioBase(rs.getDouble("BaseSalary"));
                obj.setDepartamento(dep);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Vendedor> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    

}
