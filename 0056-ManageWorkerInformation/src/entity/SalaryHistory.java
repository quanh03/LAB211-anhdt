package entity;

public class SalaryHistory extends Worker {

    private String status;
    private String date;

    public SalaryHistory() {
    }

    public SalaryHistory(
            String code,
            String name,
            int age,
            double salary,
            String workLocation,
            String status,
            String date) {
        super(code, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
/**
 * 
 */
    @Override
    public void display() {
        System.out.printf(
                "%-6s|%-20s|%-6d|%-8.2f|%-8s|%-12s",
                this.getCode(),
                this.getName(),
                this.getAge(),
                this.getSalary(),
                this.getStatus(),
                this.getDate());
    }
}
