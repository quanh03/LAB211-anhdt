package mock;

import java.util.ArrayList;
import java.util.List;

import entity.SalaryHistory;
import entity.Worker;

public class Data {

    public static List<Worker> workerList = new ArrayList<>();

    static {
        workerList.add(new Worker("W1", "Nguyen Van A", 30, 3000, "Hoa Lac"));
        workerList.add(new Worker("W2", "Nguyen Van B", 29, 2900, "Hoa Lac"));
        workerList.add(new Worker("W3", "Nguyen Van C", 28, 2800, "Hoa Lac"));
        workerList.add(new Worker("W4", "Nguyen Van D", 27, 4000, "Hoa Lac"));
        workerList.add(new Worker("W5", "Nguyen Van E", 26, 5000, "Hoa Lac"));
    }

    public static List<SalaryHistory> modifiedWorkerList = new ArrayList<>();

    static {
        modifiedWorkerList.add(new SalaryHistory(
                "W6",
                "Nguyen Van F",
                26, 5000,
                "Hoa Lac",
                "UP",
                "20/07/2023")
        );
    }
}
