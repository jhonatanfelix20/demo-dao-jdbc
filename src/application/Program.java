package application;


import java.util.List;

import entities.Departamento;
import entities.Vendedor;
import model.DaoFactory;
import model.dao.VendedorDAO;
import java.util.Date;

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

    System.out.println("\n--- Teste 3: Vendedor findAll ---");
    list = vendedorDAO.findAll();
    for (Vendedor obj : list) {
        System.out.println(obj);
    }

    
    System.out.println("\n--- Teste 4: Vendedor insert ---");
    Vendedor newVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
    vendedorDAO.insert(newVendedor);
    System.out.println("Inserted! New id = " + newVendedor.getId());

    System.out.println("\n--- Teste 5: Vendedor update ---");
    vendedor = vendedorDAO.findById(1);
    vendedor.setNome("Martha Waine");
    vendedorDAO.update(vendedor);
    System.out.println("Update completed");

    }
}
