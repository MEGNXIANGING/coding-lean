public class AddTwoSum {
    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode(0);
            ListNode cur = l3;
            int tmp = 0;
            while (l1 != null || l2 != null) {
                int l1v = l1 == null ? 0 : l1.val;
                int l2v = l2 == null ? 0 : l2.val;
                int res=l1v+l2v+tmp;
                tmp=res/10;
                cur.next=new ListNode(res%10);
                cur=cur.next;
                if (l1!=null){
                    l1=l1.next;
                }
                if (l2!=null){
                    l2=l2.next;
                }
            }
            if (tmp==1){
                cur.next=new ListNode(1);
            }
            return l3.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
