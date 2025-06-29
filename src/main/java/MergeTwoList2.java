public class MergeTwoList2 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode cur=listNode;
        while (list1!=null || list2!=null){
            if (list1==null){
                cur.next=list2;
                break;
            }
            if (list2==null){
                cur.next=list1;
                break;
            }
            if (list1.val<=list2.val){
                cur.next=new ListNode(list1.val);
                list1=list1.next;
            }else {
                cur.next=new ListNode(list2.val);
                list2=list2.next;
            }
            cur=cur.next;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);
        mergeTwoLists(listNode,listNode2);


    }


    public static class ListNode {
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
