package com.example.mithunkumerghose.xmlpullparserdemo;

/**
 * @author Mithun Kumer Ghose.
 */

public class Student {
    private String name;
    private String department;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{\n" +
                "name='" + name + '\'' +
                "\ndepartment='" + department + '\'' +
                "\nid=" + id +
                "\n}";
    }
}
