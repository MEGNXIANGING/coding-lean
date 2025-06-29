package list;

public class MrTwoListNode {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode cul=pre;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
                cul.next=list1;
                list1=list1.next;
            }else {
                cul.next=list2;
                list2=list2.next;
            }
            cul=cul.next;
        }
        cul.next=(list1==null)?list2:list1;
        return pre.next;
    }

}
