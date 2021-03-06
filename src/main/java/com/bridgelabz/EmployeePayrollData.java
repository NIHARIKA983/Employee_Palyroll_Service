package com.bridgelabz;

import java.time.LocalDate;

public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    LocalDate startDate;

    public EmployeePayrollData(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    public EmployeePayrollData(int id,String name,double salary,LocalDate startDate){
        this(id, name, salary);
        this.startDate = startDate;
    }
    @Override
    public String toString(){
        return "EmployeePayRollData [id="+id+" name="+name+" salary="+salary+"]";
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) obj;
        return id   ==  that.id &&
                Double.compare(salary,that.salary)==0 &&
                name.equals(that.name);
    }
}