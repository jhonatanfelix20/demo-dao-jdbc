package model.dao;
import entities.Departamento;
import java.util.List;

public interface DepartamentoDAO {

    public void insert(Departamento obj);

    public void update(Departamento obj);

    public void deleteById(Integer id);

    public Departamento findById(Integer id);

    public List<Departamento> findAll();
}
