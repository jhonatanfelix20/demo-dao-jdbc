package application;

import java.util.Date;

import entities.Departamento;
import entities.Vendedor;

public class Program {
    public static void main(String[] args) {
        
    Departamento obj = new Departamento(1, "Livros");
    System.out.println(obj);

    Vendedor vendedor = new Vendedor(21, "Maria", "maria@gmail.com", new Date(), 3000.0, obj);

    

    }
}
