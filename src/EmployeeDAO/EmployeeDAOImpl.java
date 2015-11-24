/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDAO;

import EmployeeEntity.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Ujjwal
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    List<String> emailCheck = new ArrayList<>();
    List<Employee> employeeCollection = new ArrayList<>();
    File f1,f2;

    private List<Employee> employeeList;
    Scanner scanner = new Scanner(System.in);
    public EmployeeDAOImpl(List<Employee> employeeList){
        this.employeeList = employeeList;
    }
    
    @Override
    public void insert(Employee e) {
        employeeList.add(e);
    }

    @Override
    public void edit(Employee e) {
      employeeList.add(e);
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Employee f = new Employee();
       for(Employee e: employeeList){
           if(e.getId()==id){
               flag = true;
               f = e;
           }    
       }
       if(flag==true){
           employeeList.remove(f);
       }
       return flag;
    }

    @Override
    public List<Employee> getAll() {
       return employeeList;
    }

    @Override
    public void writeToCSV(Employee e) {
        System.out.println("Enter the name of CSV file to export the data");
        try{
        FileWriter writer = new  FileWriter(new File(scanner.next()));
        for(Employee f: employeeList){
            writer.write(toCSV(f));
        }
        writer.close();
        }catch(IOException io){
        System.out.println(io.getMessage());
        }
        }
    public String toCSV(Employee e){
        return e.getId()+","+ e.getFirstName()+","+e.getLastName()+","+e.getEmail()+","+e.getContactNo()+","+e.isStatus()+"\r\n";
    }

    @Override
    public boolean doesEmailAlreadyExistInTheList(String param) {
        boolean a = true;
        if( emailCheck.contains(param) ){    
            a= false;// false means the value exists
        }    
        return a;//if return true, then mathi gayera arraylist ma add garne
    }

    @Override
    public void importFromFile() {
        try{
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter the file loaction to import");
            String x = reader.next();
            BufferedReader br = new BufferedReader(new FileReader(new File(x) ) );
            String line="";       
            System.out.println("Enter the location to save duplicate data with File name");
            String y = reader.next();
            FileWriter fw = new FileWriter( new File(y) );
            while ( (line=br.readLine())!=null ){
                StringTokenizer token = new StringTokenizer(line, ",");
                Employee e = new Employee();
                e.setId(Integer.parseInt(token.nextToken()));
                e.setFirstName(token.nextToken());
                e.setLastName(token.nextToken());
                e.setEmail(token.nextToken());
                e.setContactNo(token.nextToken());
                e.setStatus(Boolean.parseBoolean(token.nextToken() ) );
                
                if( doesEmailAlreadyExistInTheList(e.getEmail() ) ){
                    emailCheck.add(e.getEmail());  // since the email doesnt match so adding it to the record
                    employeeCollection.add(e);  // and saving the objects into arraylist to get if afterwards
                }
                else{  // the case for which the email exists 
                    fw.write(line);
                }
            }
            br.close();
            fw.close();            
        }catch(IOException ioe){
            System.out.println(ioe.getMessage() );
        }
        
    }
    }

