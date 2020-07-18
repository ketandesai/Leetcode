import java.util.ArrayList;
import java.util.List;

/**
 * 19. Remove Nth Node From End of List (Medium)
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 */

public class RemoveNthNode {

    public static void main (String args[]){
        ListNode head = new ListNode(1,
                        new ListNode(2));

        ListNode result = removeNthFromEnd(head, 1);
        print(result);
    }

    public static void print(ListNode result){
        while(result != null){
            System.out.print(result.val + " --> ");
            result = result.next;
            if (result == null)
            {
                System.out.print("NULL");
            }
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList();
        while (head != null){
            list.add(head);
            head = head.next;
        }

        int toRemove = list.size() - n;
        int before = toRemove -1;
        if (before >= 0){
            int after = toRemove + 1;
            list.get(before).next = null;
            if (after < list.size())
            {
                list.get(before).next = list.get(after) ;
            }


        }
        list.remove(toRemove);

        ListNode result = new ListNode();
        ListNode curr = result;
        for(int i = 0; i < list.size(); i++){
            curr.next = list.get(i);
            curr = curr.next;
        }
        return result.next;
    }
}


