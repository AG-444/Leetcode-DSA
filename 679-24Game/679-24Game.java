// Last updated: 8/28/2025, 9:58:00 AM
class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) {
            nums.add((double) c);
        }
        return dfs(nums);
    }

    private boolean dfs(List<Double> numbers) {
        if (numbers.size() == 1) {
            return Math.abs(numbers.get(0) - 24) < EPS;
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < numbers.size(); k++) {
                    if (k != i && k != j) {
                        next.add(numbers.get(k));
                    }
                }

                for (double val : compute(numbers.get(i), numbers.get(j))) {
                    next.add(val);
                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    // Generate all possible results from a and b with + - * /
    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPS) results.add(a / b);
        if (Math.abs(a) > EPS) results.add(b / a);
        return results;
    }
}
