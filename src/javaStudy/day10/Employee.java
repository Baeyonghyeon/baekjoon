package javaStudy.day10;

public class Employee {
    int empNo;
    String name;
    String deptName;

    public Employee(int empNo, String name, String deptName) {
        this.empNo = empNo;
        this.name = name;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }
}
