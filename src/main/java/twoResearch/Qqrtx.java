package twoResearch;

public class Qqrtx {
    public static void main(String[] args) {
        System.out.println( mySqrt(8));
    }
    public static int mySqrt(int x) {
        //分类讨论<=4  都为1
        //大于4的 在2到 x/2区间中
        if (x==0){
            return 0;
        }
        if (x<4){
            return 1;
        }
        int left=2;
        int right=x/2;
        while (left<right){
            int mid=(right+left+1)/2;
            if (x/mid==mid){
                return mid;
            }
            if (x/mid<mid){
                right=mid-1;
            }else {
                left=mid;
            }
        }
        return left;
    }
}
