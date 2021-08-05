package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService{
        CONSOLE_IO,FILE_IO,DB_IO,REST_IO
    }
    private List<EmployeePayrollData> employeePayrolllist;

    public EmployeePayrollService(){ }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrolllist) {
        this.employeePayrolllist = employeePayrolllist;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee PlayRoll Service");
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();

    }

    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID : ");
        int id = consoleInputReader.nextInt();
        System.out.println("enter Employee Name : ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrolllist.add(new EmployeePayrollData(id,name,salary));
    }

    private void writeEmployeePayrollData(){
        System.out.println("Writing Employee Payroll Roaster to Console\n" + employeePayrolllist);
    }
}
