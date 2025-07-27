package twoResearch;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length; //[left,right)

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <=target) {
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return letters[left];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length; // [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 处理所有字符都不大于target的情况
        return left == letters.length ? letters[0] : letters[left];
    }
}
