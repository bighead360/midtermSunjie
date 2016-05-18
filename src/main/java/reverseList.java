/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/17/16.
 *
 * Time complexity: O(n).
 */
public class reverseList {

    public  static class ListNode {
        public int val;
        ListNode next;

    }
    public static ListNode reverseMichael(ListNode head,int startIndex) {
        ListNode newhead = new ListNode();
        ListNode prevNewhead = new ListNode();

        for (int i =0; i < startIndex; i++ ){
            newhead = head.next;
            if (i==(startIndex-2)){
                prevNewhead = head.next;

            }
            head = newhead;

        }
        ListNode prevNode = null;
        ListNode curNode = newhead;
        ListNode nextNode;
        while (curNode != null) {

            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;

            curNode = nextNode;

        }

        return prevNode;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode();
        ListNode curb = new ListNode();
        ListNode head = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode();
        ListNode l6 = new ListNode();
        head.val = 1;
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        l2.val = 2;
        l3.val = 3;
        l4.val = 4;
        l5.val = 5;
        l6.val = 6;

        cur = reverseMichael(head,2);

        ListNode headb = head;
        for (int i = 1; i<2; i++){

            curb = headb.next;
            headb = curb;

        }
        curb.next = cur;

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }


}
