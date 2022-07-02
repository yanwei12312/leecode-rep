


/**
 * @author yw
 * @since 2022/02/20
 *
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode res = new ListNode();
        if(list1.val > list2.val) {
            res.val = list2.val;
            res.next = mergeTwoLists(list1,list2.next);
        } else {
            res.val = list1.val;
            res.next = mergeTwoLists(list2,list1.next);
        }
        return res;
    }
}
