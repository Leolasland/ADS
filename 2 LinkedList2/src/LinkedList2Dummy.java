import java.util.*;

public class LinkedList2Dummy
{
  public DNode dummyHead;
  public DNode dummyTail;

  public LinkedList2Dummy()
  {
    dummyHead = new DNode();
    dummyTail = new DNode();
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;

  }

  public void addInTail(Node _item)
  {
    this.dummyTail.prev.next = _item;
    _item.prev = this.dummyTail.prev;
    _item.next = this.dummyTail;
    this.dummyTail.prev = _item;
  }

  public Node find(int _value)
  {
    Node node = dummyHead.next;
    while (!(node instanceof DNode)) {
      if (node.value == _value) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value)
  {
    ArrayList<Node> nodes = new ArrayList<>();
    Node node = dummyHead.next;
    while (!(node instanceof DNode)) {
      if (node.value == _value) {
        nodes.add(node);
      }
      node = node.next;
    }
    return nodes;
  }

  public boolean remove(int _value)
  {
    Node node = dummyHead.next;
    while (!(node instanceof DNode)) {
      if (node.value == _value) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return true;
      }
      node = node.next;
    }
    return false;
  }

  public void removeAll(int _value)
  {
    Node node = dummyHead.next;
    while (!(node instanceof DNode)) {
      if (node.value == _value) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      }
      node = node.next;
    }
  }

  public void clear()
  {
    this.dummyHead.next = this.dummyTail;
    this.dummyTail.prev = this.dummyHead;
    this.dummyHead.prev = this.dummyTail.next = null;
  }

  public int count()
  {
    int result = 0;
    Node node = this.dummyHead.next;
    while (!(node instanceof DNode)) {
      result++;
      node = node.next;
    }
    return result;
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
  {
    if (_nodeAfter == null) {
      this.dummyHead.next.prev = _nodeToInsert;
      _nodeToInsert.next = this.dummyHead.next;
      _nodeToInsert.prev = this.dummyHead;
      this.dummyHead.next = _nodeToInsert;
      return;
    }
    _nodeAfter.next.prev = _nodeToInsert;
    _nodeToInsert.next = _nodeAfter.next;
    _nodeAfter.next = _nodeToInsert;
    _nodeAfter.prev = _nodeAfter;
  }
}

class DNode extends Node{
  public DNode() {
    super();
  }
}

class Node{
  public int value;
  public Node next;
  public Node prev;

  public Node() {
    next = null;
    prev = null;
  }

  public Node(int _value) {
    value = _value;
    next = null;
    prev = null;
  }
}
