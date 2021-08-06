package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
    private List<EmployeePayrollData> employeePayrollDataList;

    public EmployeePayrollService(){}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList){
        this.employeePayrollDataList = employeePayrollDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    }
    //method to read data
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id:");
        int id=consoleInputReader.nextInt();
        System.out.println("Enter Employee name:");
        consoleInputReader.nextLine();
        String name=consoleInputReader.nextLine();
        System.out.println("Enter Employee salary:");
        double salary=consoleInputReader.nextInt();
        employeePayrollDataList.add(new EmployeePayrollData(id,name,salary));
    }
    //method to write data on console
    public void writeEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\nWriting Employee Payroll Roaster To console::\n"+employeePayrollDataList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollDataList);
    }
    //method to count entries in a file
    public long count(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    //method to print entries from a file
    public void printData(IOService ioService){
        if(ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public void readDataFromFile(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO)){
            new EmployeePayrollFileIOService().readDataFromFile();
        }
    }
}