package list;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p0 = dummy;
        for (int i = 0; i < left-1; i++) {
            p0=p0.next;
        }
        ListNode cur=p0.next;
        ListNode pre=null;
        for (int i = left; i <=right; i++) {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        p0.next.next=cur;
        p0.next=pre;
        return dummy.next;
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
