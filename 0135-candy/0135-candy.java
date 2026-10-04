class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // First pass: left → right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass: right → left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); // max we write max because in left pass it write the max maybe so we dont write the smller vlsue
            }
        }

        // Calculate total
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}

// intuition in this we have to gove every one a candy and if rating is greater then the neighbours we will assign more candy 

// as  the first child we will not comapre wd its prev because it will go out of bound
// left pass starts from 1 index if the current  greater than its previous we will increment the candy by one from its previous 

// but why we need the second pass what abut if the example 12321 cojes 3 is the peak here .. we have to satisfy the both 
// in the example 12321 first pass from left to right 12311
// in second pass 12321

//second pass is required if ex 212 left pass 122 
// but 2 greater than 1 so ans would be 212 so right need 
