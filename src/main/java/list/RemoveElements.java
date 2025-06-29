package list;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=new ListNode();
        pre.next=head;
        ListNode cul=pre;
        while (cul.next!=null){
            if (cul.next.val==val){
                cul.next=cul.next.next;
            }else {
                cul=cul.next;
            }
        }
        return pre.next;
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
