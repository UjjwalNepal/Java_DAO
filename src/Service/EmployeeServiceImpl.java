/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import EmployeeDAO.EmployeeDAO;
import EmployeeDAO.EmployeeDAOImpl;
import EmployeeEntity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ujjwal
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl (List<Employee> employeeList){
        employeeDAO = new EmployeeDAOImpl(employeeList);
    }
    
    @Override
    public void insert(Employee e) {
        employeeDAO.insert(e);
    }

    @Override
    public void edit(Employee e) {
        employeeDAO.insert(e);
    }

    @Override
    public boolean delete(int id) {
        return employeeDAO.delete(id);
    }

    @Override
    public List<Employee> getAll() {
      return employeeDAO.getAll();
    }

    @Override
    public void writeToCSV(Employee e) {
        employeeDAO.writeToCSV(e);

}

    @Override
    public void importFromFile() {
        employeeDAO.importFromFile();
    }

    @Override
    public boolean doesEmailAlreadyExistInTheList(String param) {
       return employeeDAO.doesEmailAlreadyExistInTheList(param);
    }
}
