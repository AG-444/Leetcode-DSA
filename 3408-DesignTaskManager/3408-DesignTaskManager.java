// Last updated: 9/18/2025, 8:42:33 AM
import java.util.*;


class TaskManager {
    private Map<Integer, int[]> taskInfo;
    private PriorityQueue<int[]> heap;

    public TaskManager(List<List<Integer>> tasks) {
        taskInfo = new HashMap<>();
        heap = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1]; // higher priority first
                return b[0] - a[0]; // tie-break by larger taskId
            }
        );
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            taskInfo.put(taskId, new int[]{userId, priority});
            heap.offer(new int[]{taskId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskInfo.put(taskId, new int[]{userId, priority});
        heap.offer(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int userId = taskInfo.get(taskId)[0];
        taskInfo.put(taskId, new int[]{userId, newPriority});
        heap.offer(new int[]{taskId, newPriority}); // push updated entry
    }

    public void rmv(int taskId) {
        taskInfo.remove(taskId); // lazy: old heap entries are ignored later
    }

    public int execTop() {
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int taskId = top[0];
            int priority = top[1];

            if (taskInfo.containsKey(taskId) && taskInfo.get(taskId)[1] == priority) {
                int userId = taskInfo.get(taskId)[0];
                taskInfo.remove(taskId); // remove after executing
                return userId;
            }
        }
        return -1; // no tasks left
    }
}
