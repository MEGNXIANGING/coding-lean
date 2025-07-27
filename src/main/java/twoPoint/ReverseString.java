package twoPoint;

public class ReverseString {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){
            char pre=s[left];
            s[left]=s[right];
            s[right]=pre;
            left++;
            right--;
        }
    }
}
