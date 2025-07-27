package list;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> sets = new HashSet<>();
        ListNode curA=headA;
        while (curA!=null){
            sets.add(curA);
            curA=curA.next;
        }
        ListNode curB=headB;
        while (curB!=null){
            if (sets.contains(curB)){
                return curB;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
