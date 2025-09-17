// Last updated: 9/17/2025, 8:04:23 PM
class FoodEntry {
    int index;
    int rating;

    public FoodEntry(int index, int rating) {
        this.index = index;
        this.rating = rating;
    }
}

class FoodRatings {
    String[] foods;
    String[] cuisines;
    int[] ratings;
    Map<String, PriorityQueue<FoodEntry>> mapCuisines = new TreeMap<>();
    Map<String, Integer> map = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;

        for (int i = 0; i < foods.length; i++) {
            map.put(foods[i], i);
        }

        makeCuisineMap();
    }

    public void makeCuisineMap() {
        for (String s : cuisines) {
            PriorityQueue<FoodEntry> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (b.rating != a.rating) {
                        return b.rating - a.rating;  // Higher rating first
                    } else {
                        return foods[a.index].compareTo(foods[b.index]);  // Lexicographical order if ratings equal
                    }
                }
            );
            mapCuisines.putIfAbsent(s, pq);
        }

        for (int i = 0; i < foods.length; i++) {
            mapCuisines.get(cuisines[i]).offer(new FoodEntry(i, ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        int index = map.get(food);
        ratings[index] = newRating;
        mapCuisines.get(cuisines[index]).offer(new FoodEntry(index, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodEntry> pq = mapCuisines.get(cuisine);

        while (true) {
            FoodEntry top = pq.peek();
            // Check if the rating is still valid
            if (ratings[top.index] == top.rating) {
                return foods[top.index];
            } else {
                // Remove outdated entry
                pq.poll();
            }
        }
    }
}
