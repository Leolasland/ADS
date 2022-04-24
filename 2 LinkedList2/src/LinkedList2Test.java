import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

  public static LinkedList2 createWithSize(int size) {
    LinkedList2 linkedList = new LinkedList2();

    for (int i = 0; i < size; i++) {
      Node node = new Node(i);
      linkedList.addInTail(node);
    }
    return linkedList;
  }

  public static LinkedList2 creatWithValues(int... values) {
    LinkedList2 linkedList = new LinkedList2();

    for (int value : values) {
      Node node = new Node(value);
      linkedList.addInTail(node);
    }

    return linkedList;
  }

  public static LinkedList2 createWithNodes(Node... nodes) {
    LinkedList2 linkedList = new LinkedList2();

    for (Node node : nodes) {
      linkedList.addInTail(node);
    }

    return linkedList;
  }

  @Test
  void find() {
    LinkedList2 list = LinkedList2Test.creatWithValues(1, 2, 3);
    assertEquals(list.head, list.find(1));
    assertEquals(list.head.next, list.find(2));
    assertEquals(list.tail, list.find(3));
    assertNull(list.find(4));
  }

  @Test
  void findAll() {
    LinkedList2 emptyList = LinkedList2Test.creatWithValues();
    ArrayList<Node> case1Result = emptyList.findAll(5);
    assertEquals(0, case1Result.size());

    LinkedList2 listWithValuesOne = LinkedList2Test.creatWithValues(1);
    ArrayList<Node> case2Result = listWithValuesOne.findAll(1);
    assertEquals(1, case2Result.size());

    LinkedList2 listWithManyDifferentValues = LinkedList2Test.creatWithValues(0, 1, 6, 2, 6, 1, 1, 7, 0, 0, 0, 0, 1);
    ArrayList<Node> case3Result = listWithManyDifferentValues.findAll(1);
    assertEquals(4, case3Result.size());

    ArrayList<Node> case4Result = listWithManyDifferentValues.findAll(0);
    assertEquals(5, case4Result.size());

    ArrayList<Node> case5Result = listWithManyDifferentValues.findAll(6);
    assertEquals(2, case5Result.size());

    ArrayList<Node> case6Result = listWithManyDifferentValues.findAll(7);
    assertEquals(1, case6Result.size());

    ArrayList<Node> case7Result = listWithManyDifferentValues.findAll(666);
    assertEquals(0, case7Result.size());
  }

  @Test
  void remove() {
    LinkedList2 emptyList = LinkedList2Test.creatWithValues();
    assertFalse(emptyList.remove(5));

    LinkedList2 notExistValueList = LinkedList2Test.creatWithValues(1);
    assertFalse(notExistValueList.remove(666));
    assertFalse(notExistValueList.remove(42));

    LinkedList2 oneElementListContainValue = LinkedList2Test.creatWithValues(1);
    assertTrue(oneElementListContainValue.remove(1));
    assertEquals(0 , oneElementListContainValue.count());

    LinkedList2 oneElementListNotContainValue = LinkedList2Test.creatWithValues(3);
    assertFalse(oneElementListNotContainValue.remove(1));
    assertEquals(1 , oneElementListNotContainValue.count());

    LinkedList2 valueContainInHeadList = LinkedList2Test.creatWithValues(1, 2, 3);
    assertTrue(valueContainInHeadList.remove(1));
    assertEquals(2, valueContainInHeadList.head.value);
    assertEquals(3, valueContainInHeadList.head.next.value);
    assertNull(valueContainInHeadList.head.next.next);
    assertEquals(3, valueContainInHeadList.tail.value);
    assertEquals(2, valueContainInHeadList.tail.prev.value);
    assertNull(valueContainInHeadList.tail.prev.prev);

    LinkedList2 valueContainInTailList = LinkedList2Test.creatWithValues(1, 2, 3);
    assertTrue(valueContainInTailList.remove(3));
    assertEquals(1, valueContainInTailList.head.value);
    assertEquals(2, valueContainInTailList.head.next.value);
    assertNull(valueContainInTailList.head.next.next);
    assertEquals(2, valueContainInTailList.tail.value);
    assertEquals(1, valueContainInTailList.tail.prev.value);
    assertNull(valueContainInTailList.tail.prev.prev);

    LinkedList2 valueContainInMiddleList = LinkedList2Test.creatWithValues(1, 2, 3, 4);
    assertTrue(valueContainInMiddleList.remove(3));
    assertEquals(1, valueContainInMiddleList.head.value);
    assertEquals(2, valueContainInMiddleList.head.next.value);
    assertEquals(4, valueContainInMiddleList.head.next.next.value);
    assertNull(valueContainInMiddleList.head.next.next.next);
    assertEquals(4, valueContainInMiddleList.tail.value);
    assertEquals(2, valueContainInMiddleList.tail.prev.value);
    assertEquals(1, valueContainInMiddleList.tail.prev.prev.value);
    assertNull(valueContainInMiddleList.tail.prev.prev.prev);

    LinkedList2 valueNotContainInListList = LinkedList2Test.creatWithValues(1, 2, 3);
    assertFalse(valueNotContainInListList.remove(4));
    assertEquals(1, valueNotContainInListList.head.value);
    assertEquals(2, valueNotContainInListList.head.next.value);
    assertEquals(3, valueNotContainInListList.head.next.next.value);
    assertNull(valueNotContainInListList.head.next.next.next);
    assertEquals(3, valueNotContainInListList.tail.value);
    assertEquals(2, valueNotContainInListList.tail.prev.value);
    assertEquals(1, valueNotContainInListList.tail.prev.prev.value);
    assertNull(valueNotContainInListList.tail.prev.prev.prev);
  }

  @Test
  void removeAll() {
    //empty list case
    LinkedList2 emptyList = new LinkedList2();
    assertDoesNotThrow(() -> emptyList.removeAll(10));

    LinkedList2 oneElementContainValueList = LinkedList2Test.creatWithValues(1);
    assertDoesNotThrow(() -> oneElementContainValueList.removeAll(1));
    assertEquals(0, oneElementContainValueList.count());

    LinkedList2 oneElementNotContainValueList = LinkedList2Test.creatWithValues(1);
    assertDoesNotThrow(() -> oneElementNotContainValueList.removeAll(0));
    assertEquals(1, oneElementNotContainValueList.count());
    assertEquals(1, oneElementNotContainValueList.head.value);
    assertEquals(1, oneElementNotContainValueList.tail.value);
    assertEquals(oneElementNotContainValueList.head, oneElementNotContainValueList.tail);

    LinkedList2 valuesContainsInAllList = LinkedList2Test.creatWithValues(1, 1, 1, 1, 1);
    assertDoesNotThrow(() -> valuesContainsInAllList.removeAll(1));
    assertEquals(0, valuesContainsInAllList.count());

    LinkedList2 valuesContainsInTheHeadList = LinkedList2Test.creatWithValues(1, 1, 1, 2, 3, 4);
    assertDoesNotThrow(() -> valuesContainsInTheHeadList.removeAll(1));
    assertEquals(2, valuesContainsInTheHeadList.head.value);
    assertEquals(3, valuesContainsInTheHeadList.head.next.value);
    assertEquals(4, valuesContainsInTheHeadList.head.next.next.value);
    assertNull(valuesContainsInTheHeadList.head.next.next.next);
    assertEquals(4, valuesContainsInTheHeadList.tail.value);
    assertEquals(3, valuesContainsInTheHeadList.tail.prev.value);
    assertEquals(2, valuesContainsInTheHeadList.tail.prev.prev.value);
    assertNull(valuesContainsInTheHeadList.tail.prev.prev.prev);

    LinkedList2 valuesContainsInTheTailList = LinkedList2Test.creatWithValues(2, 3, 4, 1, 1, 1);
    assertDoesNotThrow(() -> valuesContainsInTheTailList.removeAll(1));
    assertEquals(2, valuesContainsInTheTailList.head.value);
    assertEquals(3, valuesContainsInTheTailList.head.next.value);
    assertEquals(4, valuesContainsInTheTailList.head.next.next.value);
    assertNull(valuesContainsInTheTailList.head.next.next.next);
    assertEquals(4, valuesContainsInTheTailList.tail.value);
    assertEquals(3, valuesContainsInTheTailList.tail.prev.value);
    assertEquals(2, valuesContainsInTheTailList.tail.prev.prev.value);
    assertNull(valuesContainsInTheTailList.tail.prev.prev.prev);

    LinkedList2 valuesContainsInTheMiddleList = LinkedList2Test.creatWithValues(2, 1, 3, 1, 4);
    assertDoesNotThrow(() -> valuesContainsInTheMiddleList.removeAll(1));
    assertEquals(2, valuesContainsInTheMiddleList.head.value);
    assertEquals(3, valuesContainsInTheMiddleList.head.next.value);
    assertEquals(4, valuesContainsInTheMiddleList.head.next.next.value);
    assertNull(valuesContainsInTheMiddleList.head.next.next.next);
    assertEquals(4, valuesContainsInTheMiddleList.tail.value);
    assertEquals(3, valuesContainsInTheMiddleList.tail.prev.value);
    assertEquals(2, valuesContainsInTheMiddleList.tail.prev.prev.value);
    assertNull(valuesContainsInTheMiddleList.tail.prev.prev.prev);

    LinkedList2 valuesContainsEverywhereList = LinkedList2Test.creatWithValues(1, 1, 2, 1, 1, 3, 1, 1, 4, 1, 1);
    assertDoesNotThrow(() -> valuesContainsEverywhereList.removeAll(1));
    assertEquals(2, valuesContainsEverywhereList.head.value);
    assertEquals(3, valuesContainsEverywhereList.head.next.value);
    assertEquals(4, valuesContainsEverywhereList.head.next.next.value);
    assertNull(valuesContainsEverywhereList.head.next.next.next);
    assertEquals(4, valuesContainsEverywhereList.tail.value);
    assertEquals(3, valuesContainsEverywhereList.tail.prev.value);
    assertEquals(2, valuesContainsEverywhereList.tail.prev.prev.value);
    assertNull(valuesContainsEverywhereList.tail.prev.prev.prev);

    LinkedList2 notContainValueList = LinkedList2Test.creatWithValues(2, 3, 4);
    assertDoesNotThrow(() -> notContainValueList.removeAll(1));
    assertEquals(2, notContainValueList.head.value);
    assertEquals(3, notContainValueList.head.next.value);
    assertEquals(4, notContainValueList.head.next.next.value);
    assertNull(notContainValueList.head.next.next.next);
    assertEquals(4, notContainValueList.tail.value);
    assertEquals(3, notContainValueList.tail.prev.value);
    assertEquals(2, notContainValueList.tail.prev.prev.value);
    assertNull(notContainValueList.tail.prev.prev.prev);
  }

  @Test
  void clear() {
    LinkedList2 linkedList2 = LinkedList2Test.createWithSize(5);
    assertEquals(5, linkedList2.count());

    linkedList2.clear();
    assertEquals(0, linkedList2.count());
    assertNull(linkedList2.tail);
    assertNull(linkedList2.head);

    linkedList2 = new LinkedList2();
    linkedList2.clear();
    assertEquals(0, linkedList2.count());
    assertNull(linkedList2.tail);
    assertNull(linkedList2.head);
  }

  @Test
  void count() {
    for (int count = 0; count < 10; count++) {
      LinkedList2 linkedList2 = LinkedList2Test.createWithSize(count);
      assertEquals(count, linkedList2.count());
    }
  }

  @Test
  void insertAfter() {
    LinkedList2 emptyList = new LinkedList2();
    emptyList.insertAfter(null, new Node(1));
    assertEquals(1, emptyList.head.value);
    assertEquals(1, emptyList.tail.value);
    assertEquals(emptyList.head, emptyList.tail);
    assertEquals(1, emptyList.count());

    Node node1 = new Node(1);
    Node node2 = new Node(0);
    LinkedList2 oneElementAddInHeadList = LinkedList2Test.createWithNodes(node1);
    oneElementAddInHeadList.insertAfter(null, node2);
    assertEquals(0, oneElementAddInHeadList.head.value);
    assertEquals(1, oneElementAddInHeadList.head.next.value);
    assertNull(oneElementAddInHeadList.head.next.next);
    assertEquals(1, oneElementAddInHeadList.tail.value);
    assertEquals(0, oneElementAddInHeadList.tail.prev.value);
    assertNull(oneElementAddInHeadList.tail.prev.prev);

    node1 = new Node(1);
    node2 = new Node(0);
    LinkedList2 oneElementAddInTailList = LinkedList2Test.createWithNodes(node1);
    oneElementAddInTailList.insertAfter(node1, node2);
    assertEquals(1, oneElementAddInTailList.head.value);
    assertEquals(0, oneElementAddInTailList.head.next.value);
    assertNull(oneElementAddInTailList.head.next.next);
    assertEquals(0, oneElementAddInTailList.tail.value);
    assertEquals(1, oneElementAddInTailList.tail.prev.value);
    assertNull(oneElementAddInTailList.tail.prev.prev);

    node1 = new Node(1);
    node2 = new Node(2);
    Node node3 = new Node(3);
    LinkedList2 addElementInTheMiddle = LinkedList2Test.createWithNodes(node1, node3);
    addElementInTheMiddle.insertAfter(node1, node2);
    assertEquals(1, addElementInTheMiddle.head.value);
    assertEquals(2, addElementInTheMiddle.head.next.value);
    assertEquals(3, addElementInTheMiddle.head.next.next.value);
    assertNull(addElementInTheMiddle.head.next.next.next);
    assertEquals(3, addElementInTheMiddle.tail.value);
    assertEquals(2, addElementInTheMiddle.tail.prev.value);
    assertEquals(1, addElementInTheMiddle.tail.prev.prev.value);
    assertNull(addElementInTheMiddle.tail.prev.prev.prev);
  }
}