import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashSet;

class Leetcode2554 {
    public static void main(String[] args) {
        // int[] banned = {1,6,5};
        // int n = 5;
        // int maxSum = 6;

        int[] banned = { 87, 193, 85, 55, 14, 69, 26, 133, 171, 180, 4, 8, 29, 121, 182, 78, 157, 53, 26, 7, 117, 138,
                57, 167, 8, 103, 32, 110, 15, 190, 139, 16, 49, 138, 68, 69, 92, 89, 140, 149, 107, 104, 2, 135, 193,
                87, 21, 194, 192, 9, 161, 188, 73, 84, 83, 31, 86, 33, 138, 63, 127, 73, 114, 32, 66, 64, 19, 175, 108,
                80, 176, 52, 124, 94, 33, 55, 130, 147, 39, 76, 22, 112, 113, 136, 100, 134, 155, 40, 170, 144, 37, 43,
                151, 137, 82, 127, 73 };
        int n = 1079;
        int maxSum = 87;

        System.out.println(maxCount2(banned, n, maxSum));
    }

    static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        TreeSet<Integer> numbers = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        for (int num : banned) {
            numbers.remove(num);
        }

        int count = 0;
        int sum = 0;
        for (int num : numbers) {
            if (num + sum <= maxSum) {
                sum += num;
                count++;
            } else
                break;
        }
        return count;
    }

    static int maxCount1(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0;
        int count = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j < banned.length && banned[j] == i) {
                while (j < banned.length && banned[j] == i)
                    j++;
            } else {
                if (maxSum >= i + sum) {
                    sum += i;
                    count++;
                } else
                    break;
            }
        }
        for (int i = 0; i < banned.length; i++) {
            System.out.print(banned[i] + ", ");
        }
        System.out.println();
        return count;
    }


    // This is ChatGpt Code
    static int maxCount2(int[] banned, int n, int maxSum) {
        // Add banned numbers to a HashSet for quick lookup
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int sum = 0;
        int count = 0;

        // Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            } else if (sum + i > maxSum) {
                break; // No need to continue as sum exceeds maxSum
            }
        }
        return count;
    }

}
