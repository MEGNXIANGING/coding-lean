package list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverse(ListNode cul,ListNode pre){
        if (cul==null){
            return pre;
        }
        ListNode temp=cul.next;
        cul.next=pre;
        return reverse(temp,cul);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre=null;
        ListNode cul=head;
        while (cul!=null){
            ListNode next=cul.next;
            cul.next=pre;
            pre=cul;
            cul=next;
        }
        return pre;
    }
    public ListNode reverseLis2t(ListNode head) {
        ListNode pre=null;
        ListNode cul=head;
        while(cul!=null){
            ListNode next=cul.next;
            cul.next=pre;
            pre=cul;
            cul=next;
        }
        return pre;
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
