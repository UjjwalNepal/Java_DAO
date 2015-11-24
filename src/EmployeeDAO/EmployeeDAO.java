/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDAO;

import EmployeeEntity.Employee;
import java.util.List;

/**
 *
 * @author Ujjwal
 */
public interface EmployeeDAO {
    void insert(Employee e);
    void edit(Employee e);
    boolean delete(int id);
    List<Employee> getAll();
    void importFromFile();
    boolean doesEmailAlreadyExistInTheList(String param);
    void writeToCSV(Employee e);
}
