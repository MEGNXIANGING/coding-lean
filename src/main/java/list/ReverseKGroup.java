package list;

public class ReverseKGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy;
        ListNode end=dummy;
        while (end.next!=null){
            for (int i = 0; i < k && end!=null; i++) {
                end=end.next;
            }
            if (end==null)break;
            //记录下一个节点
            ListNode temp=end.next;
            //断开节点
            end.next=null;
            //设置开始节点
            ListNode start=pre.next;
            //翻转链接
            pre.next =reverse(start);
            //链接下一个节点
            start.next=temp;
            //调整变量
            pre=start;
            end=start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
