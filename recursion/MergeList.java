
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        if(list1.val>list2.val) {
            merge(list2, list1, null);
            return list2;
        }
        merge(list1, list2, null);
        return list1;
    }

    public void merge(ListNode list1, ListNode list2, ListNode prev) {

        if(list1 != null && list2 != null) {
            if(list1.val>list2.val) {
                ListNode temp = list2.next;
                prev.next = list2;
                list2.next = list1;
                prev = list2;
                list2 = temp;
            } else {
                prev = list1;
                list1 = list1.next;
            }
        } else {
            if(list1==null && list2==null) {
                return;
            } else if (list1==null) {
                ListNode temp = list2.next;
                prev.next = list2;
                list2.next = null;
                prev = list2;
                list2 = temp;
            } else{
                return;
            }
        }
        merge(list1, list2, prev);
    }

}