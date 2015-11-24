/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.Employee.UI;

import EmployeeEntity.Employee;
import Service.EmployeeService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import sun.awt.datatransfer.DataTransferer;

/**
 *
 * @author Ujjwal
 */
public class EmployeeUI {
    
    private Scanner scanner;
    private EmployeeService employeeService;
    public EmployeeUI(Scanner scanner, EmployeeService employeeService){
     this.scanner = scanner;   
     this.employeeService=employeeService;
    }
    public void addAllData(){
        while(true){
            Employee e = new Employee();
             System.out.println("Enter ID");
             e.setId(scanner.nextInt());
             System.out.println("Enter FirstName");
             e.setFirstName(scanner.next());
             System.out.println("Enter Lastname");
             e.setLastName(scanner.next());
             System.out.println("Enter Email");
             e.setEmail(scanner.next());
             System.out.println("Enter Contact No");
             e.setContactNo(scanner.next());
             System.out.println("Enter status of Employee");
             e.setStatus(scanner.nextBoolean());
             employeeService.insert(e);
             System.out.println("Do you want to add next Entry?(Y/N)");
             if(scanner.next().equalsIgnoreCase("n")){
                 break;
             }
            }
   
    }
    public void listAllEmployees(){
        System.out.println("Listing all names of the Employees");
        System.out.println("-=--=-==--=-=-=-=--=-=-=-=-=-=-=-=-=-=-==-=");
        employeeService.getAll().forEach(e->{
            System.out.println(e.toString());
        });
    }
    public void deleteEmployeeData(){
        System.out.println("Enter the id of employee which you want to delete");
        int x = scanner.nextInt();
        employeeService.delete(x);
        
    }
    public void importInfoFromFile(){
        employeeService.importFromFile();
    }
    public void WriteTOCSV(){
        Employee e = new Employee();
        employeeService.writeToCSV(e);
    }
}