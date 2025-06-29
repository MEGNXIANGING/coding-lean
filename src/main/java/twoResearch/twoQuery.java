package twoResearch;

public class twoQuery {
    public int guessNumber(int n) {
        int left=0;
        int right=n;
        while (left<=right){
            int mid=left+(right-left)/2;
            int i= guess(mid);
            if (i==-1){
                right=mid-1;
            }else if (i==0){
                return mid;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
