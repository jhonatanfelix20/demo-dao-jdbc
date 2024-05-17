package application;


import entities.Vendedor;
import model.DaoFactory;
import model.dao.VendedorDAO;

public class Program {
    public static void main(String[] args) {
        
    VendedorDAO vendedorDAO = DaoFactory.createVendedorDao();


    System.out.println("--- Teste 1: Vendedor findById ---");
    Vendedor vendedor = vendedorDAO.findById(3);

    System.out.println(vendedor);

    }
}
