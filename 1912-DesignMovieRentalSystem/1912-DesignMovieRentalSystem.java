// Last updated: 9/21/2025, 8:38:08 AM
import java.util.*;

class MovieRentingSystem {
    // Map (shop,movie) -> price
    private Map<String, Integer> priceMap;
    // For each movie: available copies (price, shop)
    private Map<Integer, TreeSet<int[]>> available;
    // Global rented set (price, shop, movie)
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();

        // Comparator for available[movie]: (price asc, shop asc)
        Comparator<int[]> compAvail = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        };

        // Comparator for rented: (price asc, shop asc, movie asc)
        Comparator<int[]> compRented = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        };

        rented = new TreeSet<>(compRented);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            String key = shop + "#" + movie;
            priceMap.put(key, price);

            available.putIfAbsent(movie, new TreeSet<>(compAvail));
            available.get(movie).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        int count = 0;
        for (int[] entry : available.get(movie)) {
            result.add(entry[1]); // shop id
            count++;
            if (count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        // Remove from available
        available.get(movie).remove(new int[]{price, shop});
        // Add to rented
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        // Remove from rented
        rented.remove(new int[]{price, shop, movie});
        // Add back to available
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            result.add(Arrays.asList(entry[1], entry[2])); // [shop, movie]
            count++;
            if (count == 5) break;
        }
        return result;
    }
}
