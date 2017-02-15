package com.yangyang.Java8;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashCode {

    public static void main(String[] args) {
        //String s = "this "+20+" is "+Boolean.valueOf(true);
        //System.out.println(s);
        String s1 = "hello";
        String s2 ="world";
        System.out.println(s1.concat(s2));

        HashMap<Object, Object> hashMap = new HashMap<>();


    }
    public static void main1(String[] args) {
        Map<Employee,String> cahce = loadEmpCache();
        Employee lookUpEmp = new Employee("103","1010187");

        String name = cahce.get(lookUpEmp);
        System.out.println("name: " + name);

    }
    static Map<Employee ,String> loadEmpCache(){
        Map<Employee,String> cache = new HashMap<>();
        Employee e1 = new Employee("100","1010184");
        Employee e2 = new Employee("101","1010185");
        Employee e3 = new Employee("102","1010186");
        Employee e4 = new Employee("103","1010187");
        cache.put(e1,"bob");
        cache.put(e2,"steve");
        cache.put(e3,"robot");
        cache.put(e4,"yangyang");
        return cache;
    }
}
class Employee{
    String empId;
    String dob;

    public Employee(String empId, String dob) {
        this.empId = empId;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empId != null ? !empId.equals(employee.empId) : employee.empId != null) return false;
        return dob != null ? dob.equals(employee.dob) : employee.dob == null;
    }

    @Override
    public int hashCode() {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }
}
