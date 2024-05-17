package application;


import java.util.List;

import entities.Departamento;
import entities.Vendedor;
import model.DaoFactory;
import model.dao.VendedorDAO;

public class Program {
    public static void main(String[] args) {
        
    VendedorDAO vendedorDAO = DaoFactory.createVendedorDao();


    System.out.println("--- Teste 1: Vendedor findById ---");
    Vendedor vendedor = vendedorDAO.findById(3);
    System.out.println(vendedor);

    System.out.println("\n--- Teste 2: Vendedor findByDepartamento ---");
    Departamento departamento = new Departamento(2, null);
    List<Vendedor> list = vendedorDAO.findByDepartamento(departamento);
    for (Vendedor obj : list) {
        System.out.println(obj);
    }

    }
}
