package sort;

import java.util.Arrays;

public class NumRescueBoats {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(numRescueBoats(nums, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // 使用内置排序方法更高效
        int i = 0;
        int j = people.length - 1;
        int res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            res++;
            j--;
        }
        return res;
    }

    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people); // 使用内置排序方法更高效

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // 尝试让最轻的和最重的一起乘船
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // 无论如何，最重的人都要乘船
            right--;
            boats++;
        }

        return boats;
    }

    private static void mrSort(int[] people, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mrSort(people, left, mid, temp);
        mrSort(people, mid + 1, right, temp);
        for (int i = left; i <= right; i++) {
            temp[i] = people[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                people[k] = temp[j++];
            } else if (j > right) {
                people[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                people[k] = temp[i++];
            } else {
                people[k] = temp[j++];
            }
        }
    }
}
