import java.util.*;


class Node<T> {
  public T value;
  public Node<T> next, prev;

  public Node(T _value) {
    value = _value;
    next = null;
    prev = null;
  }
}

public class OrderedList<T> {
  public Node<T> head, tail;
  private boolean _ascending;
  public int length;

  public OrderedList(boolean asc) {
    head = null;
    tail = null;
    _ascending = asc;
    length = 0;
  }

  public int compare(T v1, T v2) {
    if (v1 instanceof Integer && v2 instanceof Integer)
      return ((Integer) v1).compareTo((Integer) v2);
    if (v1 instanceof String && v2 instanceof String) {
      return (((String) v1).trim()).compareTo(((String) v2).trim());
    }
    return 0;
  }

  public void add(T value) {
    Node<T> node = new Node<T>(value);
    if (head == null) {
      head = node;
      tail = head;

    } else if ((_ascending && compare(value, head.value) <= 0) || (!_ascending && compare(value, head.value) >= 0)) {
      node.next = head;
      head.prev = node;
      head = node;

    } else if ((_ascending && compare(value, tail.value) >= 0) || (!_ascending && compare(value, tail.value) <= 0)) {
      node.prev = tail;
      tail.next = node;
      tail = node;

    } else {
      Node<T> headNode = head;
      while (headNode != null) {
        if ((_ascending && compare(value, headNode.next.value) <= 0) || (!_ascending && compare(value, headNode.next.value) >= 0)) {
          headNode.next.prev = node;
          node.next = headNode.next;
          node.prev = headNode;
          headNode.next = node;
          return;
        }
        headNode = headNode.next;
      }
    }
  }

  public Node<T> find(T val) {
    if (val != null && head != null) {
      Node<T> node = head;
      while (node != null) {
        if (node.value == val) {
          return node;
        }
        if ((_ascending && compare(node.value, val) == 1) || (!_ascending && compare(node.value, val) == -1)) {
          return null;
        }
        node = node.next;
      }
    }
    return null;
  }

  public void delete(T val) {
    Node<T> node = head;
    if (node != null) {
      node.prev = null;
    }
    while (node != null) {
      if (node.value == val) {
        if (node.prev != null) {
          if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

          } else {
            this.tail = node.prev;
            node.prev.next = null;
          }
        } else {
          head = head.next;
          if (node.next != null) {
            node.next.prev = null;
          }
          if (head == null) {
            tail = null;
          }
        }
        return;
      }
      node = node.next;
    }
  }

  public void clear(boolean asc) {
    _ascending = asc;
    head = null;
    tail = null;
  }

  public int count() {
    Node<T> node = head;
    int count = 0;
    while (node != null) {
      node = node.next;
      count++;
    }
    return count;
  }

  ArrayList<Node<T>> getAll()
  {
    ArrayList<Node<T>> r = new ArrayList<Node<T>>();
    Node<T> node = head;
    while (node != null) {
      r.add(node);
      node = node.next;
    }
    return r;
  }
}