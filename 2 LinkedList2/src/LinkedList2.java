import java.util.*;

public class LinkedList2
{
  public Node head;
  public Node tail;

  public LinkedList2()
  {
    head = null;
    tail = null;
  }

  public void addInTail(Node _item)
  {
    if (head == null) {
      this.head = _item;
      this.head.next = null;
      this.head.prev = null;
    } else {
      this.tail.next = _item;
      _item.prev = tail;
    }
    this.tail = _item;
  }

  public Node find(int _value)
  {
    Node node = this.head;
    while (node != null) {
      if (node.value == _value) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value)
  {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node node = this.head;
    while (node != null) {
      if (node.value == _value) {
        nodes.add(node);
      }
      node = node.next;
    }
    return nodes;
  }

  public boolean remove(int _value)
  {
    if (this.head == null && this.tail == null) return false;

    if (this.tail != null && this.tail.equals(this.head)) {
      if (this.head.value == _value) {
        clear();
        return true;
      }
      return false;
    }

    Node node = find(_value);
    if (node != null) {

      if (this.head != null && this.head.equals(node)) {
        this.head = this.head.next;
        this.head.prev = null;
        return true;
      }

      if (this.tail != null && this.tail.equals(node)) {
        this.tail = this.tail.prev;
        this.tail.next = null;
        return true;
      }

      node.prev.next = node.next;
      node.next.prev = node.prev;
      return true;
    }

    return false;
  }

  public void removeAll(int _value)
  {
    if (this.head == null && this.tail == null) {
      return;
    }

    if (this.tail != null && this.tail.equals(this.head)) {
      if (this.head.value == _value) {
        clear();
        return;
      }
      return;
    }

    ArrayList<Node> allNodesThatMustRemoved = findAll(_value);
    for (Node node : allNodesThatMustRemoved) {
      if (this.tail != null && this.tail.equals(this.head) && this.head.value == _value) {
        clear();
        return;
      }

      if (this.head != null && this.head.equals(node)) {
        this.head = this.head.next;
        this.head.prev = null;
      } else if (this.tail != null && this.tail.equals(node)) {
        this.tail = this.tail.prev;
        this.tail.next = null;
      } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      }

    }
  }

  public void clear()
  {
    this.head = null;
    this.tail = null;
  }

  public int count()
  {
    int result = 0;
    Node node = this.head;
    while (node != null) {
      result++;
      node = node.next;
    }
    return result;
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
  {
    if (_nodeToInsert == null) {
      return;
    }

    if (this.head == null && this.tail == null) {
      addInTail(_nodeToInsert);
      return;
    }

    if (_nodeAfter == null) {
      _nodeToInsert.next = this.head;
      this.head = _nodeToInsert;
      this.head.next.prev = _nodeToInsert;

      return;
    }

    if (this.tail != null && this.tail.equals(_nodeAfter)) {
      _nodeToInsert.prev = this.tail;
      this.tail.next = _nodeToInsert;
      this.tail = _nodeToInsert;
      return;
    }

    _nodeToInsert.prev = _nodeAfter;
    _nodeToInsert.next = _nodeAfter.next;
    _nodeAfter.next = _nodeToInsert;
    _nodeToInsert.next.prev = _nodeToInsert;
  }
}

class Node
{
  public int value;
  public Node next;
  public Node prev;

  public Node(int _value)
  {
    value = _value;
    next = null;
    prev = null;
  }
}
