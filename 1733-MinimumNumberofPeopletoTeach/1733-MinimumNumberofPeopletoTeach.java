// Last updated: 9/10/2025, 9:15:48 PM
import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        // Convert each user's languages into a HashSet for quick lookup
        List<Set<Integer>> userLanguages = new ArrayList<>();
        for (int[] langs : languages) {
            Set<Integer> set = new HashSet<>();
            for (int lang : langs) {
                set.add(lang);
            }
            userLanguages.add(set);
        }

        // Find problem friendships (where two friends share no common language)
        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; // convert to 0-based
            int v = f[1] - 1;

            Set<Integer> setU = userLanguages.get(u);
            Set<Integer> setV = userLanguages.get(v);

            // Check if they can already communicate
            boolean canCommunicate = false;
            for (int lang : setU) {
                if (setV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            // If not, both are candidates to be taught
            if (!canCommunicate) {
                candidates.add(u);
                candidates.add(v);
            }
        }

        // If no candidates, all friendships are fine already
        if (candidates.isEmpty()) {
            return 0;
        }

        // Try each language and calculate how many candidates need it
        int result = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int needToTeach = 0;
            for (int user : candidates) {
                if (!userLanguages.get(user).contains(lang)) {
                    needToTeach++;
                }
            }
            result = Math.min(result, needToTeach);
        }

        return result;
    }
}
