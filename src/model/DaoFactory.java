package model;

import db.DB;
import model.dao.VendedorDAO;
import model.dao.implementacao.VendedorDaoJDBC;

public class DaoFactory {
    public static VendedorDAO createVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }
    
}
