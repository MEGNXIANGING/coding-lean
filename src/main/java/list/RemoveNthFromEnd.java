package list;

public class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum=new ListNode();
        dum.next=head;
        ListNode left=dum;
        ListNode right=dum;
        for (int i = 0; i < n; i++) {
            right=right.next;
        }
        while (right.next!=null){
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;
        return dum.next;
    }
}
