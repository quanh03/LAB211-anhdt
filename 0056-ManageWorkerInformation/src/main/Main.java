package main;

import bo.WorkerBo;
import constant.IConstant;
import mock.Data;
import util.Helper;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        WorkerBo workerBo = new WorkerBo(Data.workerList, Data.modifiedWorkerList);

        int choice;

        do {
            System.out.println("\n ======== Worker Management =========");
            System.out.println("1. Add worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display information");
            System.out.println("5. Exit");
            choice = Validate.getInt(
                    "Enter choice: ",
                    "Input must be from 1 to 5.",
                    "Input must be in correct format.",
                    1, 5);
            switch (choice) {
                case 1:
                    workerBo.addWorker();
                    break;
                case 2:
                    // up salary
                    System.out.println("------- Up/Down Salary --------");
                    String code;
                    do {
                        code = Validate.getString("Enter code: ",
                                "Input must be in correct format",
                                IConstant.REGEX_CODE);
                    } while (Helper.findWorkerByCode(code, workerBo.getList()) == -1);
                    double amount = Validate.getDouble(
                            "Enter Salary: ",
                            "Salary must be greater than 0",
                            "Input must be in correct format",
                            0.0,
                            Double.MAX_VALUE);
                    workerBo.changeSalary(IConstant.STATUS_UP, code, amount);
                    break;
                case 3:
                    // down salary
                    System.out.println("------- Up/Down Salary --------");
                    do {
                        code = Validate.getString("Enter code: ",
                                "Input must be in correct format",
                                IConstant.REGEX_CODE);
                    } while (Helper.findWorkerByCode(code, workerBo.getList()) == -1);
                    amount = Validate.getDouble(
                            "Enter Salary: ",
                            "Salary must be greater than 0",
                            "Input must be in correct format",
                            0.0,
                            Double.MAX_VALUE);
                    workerBo.changeSalary(IConstant.STATUS_DOWN, code, amount);
                    break;
                case 4:
                    workerBo.displaySalaryHistory();
                    break;
            }
        } while (choice != 5);
    }
}
