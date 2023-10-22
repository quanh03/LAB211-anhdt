package bo;

import java.util.ArrayList;
import java.util.List;

import constant.IConstant;
import entity.SalaryHistory;
import entity.Worker;
import util.Helper;
import util.Validate;

public class WorkerBo {
    
    private List<Worker> list;
    private List<SalaryHistory> salaryHistoryList;
    
    public WorkerBo() {
        this.list = new ArrayList<>();
        this.salaryHistoryList = new ArrayList<>();
    }

    public WorkerBo(List<Worker> list) {
        this.list = list;
    }

    public WorkerBo(List<Worker> list, List<SalaryHistory> salaryHistoryList) {
        this.list = list;
        this.salaryHistoryList = salaryHistoryList;
    }

    public List<Worker> getList() {
        return list;
    }

    public List<SalaryHistory> getSalaryHistoryList() {
        return salaryHistoryList;
    }

    /**
     * Creates new Workers object and adds it to the list of worker.
     */
    public void addWorker() {
        Worker worker = new Worker();
        worker.input(list);
        this.list.add(worker);
    }

    /**
     * This method changes the salary of a worker based on the given status and
     * code.
     * It first finds the worker in the list using the code, then creates a new
     * SalaryHistory object and adds it to the salaryHistoryList.
     * If the status is "UP", it adds the amount to the existing salary and sets it
     * as the new salary.
     * If the status is "DOWN", it subtracts the amount from the existing salary and
     * sets it as the new salary.
     * The new salary is then set for that worker.
     *
     * @param status The status of change (UP or DOWN).
     * @param code   The code of worker whose salary needs to be changed.
     * @param amount The amount by which to change the salary.
     */
    public void changeSalary(String status, String code, double amount) {
        Worker worker = this.list.get(Helper.findWorkerByCode(code, this.list));
        double newSalary;
        SalaryHistory salaryHistory = new SalaryHistory();
        salaryHistory.setCode(worker.getCode());
        salaryHistory.setName(worker.getName());
        salaryHistory.setAge(worker.getAge());
        salaryHistory.setSalary(worker.getSalary());
        salaryHistory.setWorkLocation(worker.getWorkLocation());
        salaryHistory.setStatus(status);
        salaryHistory.setDate(Validate.getCurrentDate(IConstant.DATE_FORMAT));
        if (IConstant.STATUS_DOWN.equals(status)) {
            if (amount >= worker.getSalary()) {
                newSalary = 0;
            } else {
                newSalary = worker.getSalary() - amount;
            }
        } else {
            newSalary = amount + worker.getSalary();
        }
        salaryHistory.setSalary(newSalary);
        salaryHistory.setStatus(status);
        this.salaryHistoryList.add(salaryHistory);
        worker.setSalary(newSalary);
    }

    /**
     * Display salary history of worker with its code, name, salary, status,
     * date.
     */
    public void displaySalaryHistory() {
        if (this.salaryHistoryList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("--------------------Display "
                    + "Information Salary-----------------------");
            System.out.format(
                    "%-3s|%-6s|%-20s|%-6s|%-8s|%-8s|%-12s\n",
                    "No", "Code", "Name", "Age", "Salary", "Status", "Date");
            int numeralOrder = 1;
            for (SalaryHistory salaryHistory : this.salaryHistoryList) {
                System.out.printf("%-3s|", numeralOrder);
                salaryHistory.display();
                System.out.printf("\n");
                numeralOrder++;
            }
        }
    }
}
