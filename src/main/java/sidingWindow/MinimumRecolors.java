package sidingWindow;

public class MinimumRecolors {

    public static void main(String[] args) {
        String str = "WBWBBBW";
        System.out.println(minimumRecolors(str, 2));
    }

    public static int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int ans = Integer.MAX_VALUE;
        int cnW = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'W') {
                cnW++;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.min(cnW, ans);
            if (chars[i - k + 1] == 'W') {
                cnW--;
            }
        }
        return ans;
    }

    public static int minimumRecolors2(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int cnW = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'W') {
                cnW++;
            }
        }
        int ans = cnW;
        for (int i = k; i < chars.length; i++) {
            if (chars[i] == 'W') {
                cnW++;
            }
            if (chars[i-k]=='W'){
                cnW--;
            }
            ans=Math.min(cnW,ans);
        }
        return ans;
    }

}
