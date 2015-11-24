/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.Employee;

import Service.EmployeeService;
import Service.EmployeeServiceImpl;
import employee.Employee.UI.EmployeeUI;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Ujjwal
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl(new Vector<>());
        EmployeeUI employeeUI = new EmployeeUI(scan, employeeService);
        while(true){
                System.out.println("Welcome to the Employee Management System");
                System.out.println("-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==");
                System.out.println("Press 1 to Enter new Employee Entries");
                System.out.println("Press 2 Deleting the Employee Entries");
                System.out.println("Press 3 to list all the employees");
                System.out.println("Press 4 to import Employee information from the file");
                System.out.println("Press 5 to export all the Employee entry into a CSV File");
                System.out.println("Press 6 to exit");
                System.out.println("Enter your Choice");
                
                switch(scan.nextInt()){
                    case 1:
                        employeeUI.addAllData();
                        break;
                    case 2:
                        employeeUI.deleteEmployeeData();
                        break;
                    case 3:
                        employeeUI.listAllEmployees();
                        break;
                    case 4 :
                        employeeUI.importInfoFromFile();
                        break;
                    case 5:
                        employeeUI.WriteTOCSV();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
        }
        
        
    }
    
}
