package application;

import java.util.Date;

import entities.Departamento;
import entities.Vendedor;
import model.DaoFactory;
import model.dao.VendedorDAO;

public class Program {
    public static void main(String[] args) {
        
    Departamento obj = new Departamento(1, "Livros");
    System.out.println(obj);

    Vendedor vendedor = new Vendedor(21, "Maria", "maria@gmail.com", new Date(), 3000.0, obj);

    VendedorDAO vendedorDAO = DaoFactory.createVendedorDao();

    System.out.println(vendedor);

    }
}
