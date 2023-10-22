package util;

import java.util.List;

import entity.Worker;

public class Helper {

    /**
     * Finds a worker with a specified code.
     *
     * @param code  the code of the worker to find
     * @param list  the list of worker
     * @return the worker with the specified code, or null if the worker is not
     * found
     */
    public static int findWorkerByCode(String code, List<Worker> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        System.out.println(code + " does not exist.");
        return -1;
    }
}
