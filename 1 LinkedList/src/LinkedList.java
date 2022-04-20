import java.util.*;

public class LinkedList
{
  public Node head;
  public Node tail;

  public LinkedList()
  {
    head = null;
    tail = null;
  }

  public void addInTail(Node item) {
    if (this.head == null)
      this.head = item;
    else
      this.tail.next = item;
    this.tail = item;
  }

  public Node find(int value) {
    Node node = this.head;
    while (node != null) {
      if (node.value == value)
        return node;
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value) {
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
    Node pre = this.head;
    while (pre != null) {
      if (this.head.value == _value) {
        this.head = pre.next;
        if (this.tail.value == _value) {
          this.tail = pre.next;
        }
        return true;
      }
      Node del = pre.next;
      if (del != null) {
        Node aft = del.next;
        if (del.value == _value) {
          pre.next = aft;
          if (aft == null) {
            this.tail = pre;
          }
          return true;
        }
      }
      pre = pre.next;
    }
    return false;
  }

  public void removeAll(int _value)
  {
    Node pre = this.head;
    while (pre != null) {
      if (this.head.value == _value) {
        this.head = pre.next;
        if (this.tail.value == _value) {
          this.tail = pre.next;
        }
        pre = pre.next;
        continue;
      }
      Node del = pre.next;
      if (del != null) {
        Node aft = del.next;
        if (del.value == _value) {
          pre.next = aft;
          if (aft == null) {
            this.tail = pre;
          }
          continue;
        }
      }
      pre = pre.next;
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
    if (_nodeAfter == null) {
      if (this.head == null) {
        this.head = _nodeToInsert;
        this.tail = _nodeToInsert;
      } else {
        _nodeToInsert.next = this.head;
        this.head = _nodeToInsert;
      }
    }
    else {
      Node node = this.head;
      while (node != null) {
        if (_nodeAfter == node) {
          if (_nodeAfter == this.tail) {
            _nodeAfter.next = _nodeToInsert;
            this.tail = _nodeToInsert;
          } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
          }
        }
        node = node.next;
      }
    }
  }
  
}

class Node
{
  public int value;
  public Node next;
  public Node(int _value)
  {
    value = _value;
    next = null;
  }
}