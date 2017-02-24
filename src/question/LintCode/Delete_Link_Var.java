package question.LintCode;

/**
 * 给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
 * Created by kevin on 2/24/17.
 */
public class Delete_Link_Var {
  /**
   * @param head a ListNode
   * @param val an integer
   *
   * @return a ListNode
   */
  public ListNode removeElements(ListNode head, int val) {
    ListNode result = head;
    if (head == null) {
      return null;
    } else {

      while (head.next != null) {
        if (head.next.val == val) {
          if (head.next.next != null) {
            head.next = head.next.next;
          } else {
            head.next = null;
            break;
          }
        } else {
          head = head.next;
        }
      }
      if (result.val == val) return result.next;
      return result;
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}

