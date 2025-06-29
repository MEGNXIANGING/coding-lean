package sort;

import java.util.Arrays;
import java.util.Random;

public class FrequencySort {
    private final static Random random = new Random(System.currentTimeMillis());

    private static int freq[] ;


    public static String frequencySort(String s) {
        freq = new int[128];
        char[] charArray = s.toCharArray();
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        quickSort(charArray, 0, s.length() - 1);
        return String.valueOf(charArray);
    }

    private static void quickSort(char[] charArray, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(charArray,randomIndex,left);
        char pivot = charArray[left];
        int lt = left + 1;
        int gt = right;
        int i = left + 1;

        while (i <= gt) {
            if (freq[charArray[i]] > freq[pivot]) {
                swap(charArray, i, lt);
                lt++;
                i++;
            } else if (charArray[i] == pivot) {
                i++;
            } else {
                swap(charArray, i, gt);
                gt--;
            }
        }
        swap(charArray, left, lt - 1);
        quickSort(charArray, left, lt - 2);
        quickSort(charArray, gt + 1, right);
    }

    private static void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}

