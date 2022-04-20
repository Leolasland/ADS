public class LinkedListTwo {

  public static LinkedList twoLinkedList(LinkedList firstLinkedList, LinkedList secondLinkedList) {
    if ((firstLinkedList == null || secondLinkedList == null) ||
            (firstLinkedList.count() != secondLinkedList.count()))
      return null;

    LinkedList result = new LinkedList();
    Node firstListNode = firstLinkedList.head;
    Node secondListNode = secondLinkedList.head;

    while (firstListNode != null) {
      Node tmp = new Node(firstListNode.value + secondListNode.value);
      result.addInTail(tmp);
      firstListNode = firstListNode.next;
      secondListNode = secondListNode.next;
    }

    return result;
  }

}
