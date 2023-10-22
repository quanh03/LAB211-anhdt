package entity;

import java.util.List;

import constant.IConstant;
import util.Validate;

public class Worker {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker() {
    }

    /**
     * Constructor to add new worker
     *
     * @param code         worker's code
     * @param name         worker's name
     * @param age          worker's age
     * @param salary       worker's salary
     * @param workLocation worker's work location
     */
    public Worker(
            String code,
            String name,
            int age,
            double salary,
            String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public void display() {
        System.out.printf(
                "%-6s|%-20s|%-6d|%-8d|%-8s|%-12s",
                this.code,
                this.name,
                this.age,
                this.salary);
    }
    
    /**
     * This function to get the new worker code for the list of workers.
     *
     * @param list a list of Worker objects to
     *        check if the new worker code is unique
     * @return the string is the new worker code
     */
    private String getCode(List<Worker> list) {
        do {
            String code = Validate.getString(
                    "Enter code: ",
                    "Input must be in correct format",
                    IConstant.REGEX_CODE);
            boolean isExist = list.stream().anyMatch(
                    w -> w.getCode().equalsIgnoreCase(code));
            if (isExist) {
                System.out.println("Code is exist, try again");
            } else {
                return code;
            }
        } while (true);
    }

    /**
     * This function to enter information of a Worker object from the keyboard.
     * 
     * @param list the list of Worker objects to
     *        check if the new worker code is unique
     */
    public void input(List<Worker> list) {
        this.code = getCode(list);
        this.name = Validate.getString(
                "Enter name: ",
                "Input must be in correct format",
                IConstant.REGEX_NAME);

        this.age = Validate.getInt(
                "Enter age: ",
                "Input must be between 18 to 50",
                "Input must be in correct format",
                18, 50);

        this.salary = Validate.getDouble(
                "Enter salary: ",
                "Salary must be greater than 0",
                "Input must be in correct format",
                0.0,
                Double.MAX_VALUE);

        this.workLocation = Validate.getString(
                "Enter work location: ",
                "Input must be in correct format, no more than 200 characters",
                IConstant.REGEX_WORK_LOCATION);
    }
}
