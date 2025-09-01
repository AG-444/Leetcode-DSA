// Last updated: 9/1/2025, 3:41:58 PM
import java.util.PriorityQueue;

class Solution {
    // Helper class to store each class's state
    static class ClassInfo {
        int pass, total;
        double gain;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.gain = calcGain(pass, total);
        }

        // Calculate the marginal gain of adding one extra student
        static double calcGain(int pass, int total) {
            return ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
        }

        // Update the class with one extra student
        void addStudent() {
            pass++;
            total++;
            gain = calcGain(pass, total);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Max heap ordered by marginal gain
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain, a.gain)
        );

        // Initialize heap with all classes
        for (int[] c : classes) {
            maxHeap.add(new ClassInfo(c[0], c[1]));
        }

        // Distribute extra students
        for (int i = 0; i < extraStudents; i++) {
            ClassInfo top = maxHeap.poll();   // class with max gain
            top.addStudent();                 // assign one student
            maxHeap.add(top);                 // push back with updated gain
        }

        // Compute final average
        double total = 0.0;
        while (!maxHeap.isEmpty()) {
            ClassInfo ci = maxHeap.poll();
            total += (double) ci.pass / ci.total;
        }

        return total / n;
    }
}
