import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

  @Test
  void addAsc() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(111);
    orderedList.add(3);
    orderedList.add(2);
    orderedList.add(-5);
    assertEquals(-5, orderedList.head.value);
    assertEquals(111, orderedList.tail.value);
    assertEquals(6, orderedList.count());
  }

  @Test
  void addDesc() {
    OrderedList<Integer> orderedList = new OrderedList<>(false);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(111);
    orderedList.add(3);
    orderedList.add(2);
    orderedList.add(-15);
    orderedList.add(2);
    assertEquals(111, orderedList.head.value);
    assertEquals(-15, orderedList.tail.value);
    assertEquals(7, orderedList.count());
  }

  @Test
  void findAsc() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(5);
    orderedList.add(2);
    assertNull(orderedList.find(7));
    assertEquals(10, orderedList.find(10).value);
  }

  @Test
  void findDesc() {
    OrderedList<Integer> orderedList = new OrderedList<>(false);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(5);
    orderedList.add(2);
    assertNull(orderedList.find(7));
    assertEquals(10, orderedList.find(10).value);
  }

  @Test
  void findString() {
    OrderedList<String> orderedList = new OrderedList<>(true);
    orderedList.add("sdf");
    orderedList.add("fff");
    orderedList.add("zfgsfe");
    orderedList.add("argaaa");
    assertNull(orderedList.find("bgt"));
    assertEquals("fff", orderedList.find("fff").value);
  }

  @Test
  void find() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(-1);
    assertEquals(10, orderedList.find(10).value);
    assertNull(orderedList.find(2));
  }

  @Test
  void findEmpty() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    assertNull(orderedList.find(2));
  }

  @Test
  void delete() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    orderedList.add(0);
    orderedList.add(10);
    orderedList.add(-1);
    orderedList.add(-2);
    orderedList.add(-2);
    orderedList.add(-5);
    orderedList.delete(10);
    assertEquals(5, orderedList.count());
  }

  @Test
  void deleteString() {
    OrderedList<String> orderedList = new OrderedList<>(true);
    orderedList.add("sdf");
    orderedList.add("fff");
    orderedList.add("zfgsfe");
    orderedList.add("argaaa");
    orderedList.delete("fff");
    assertEquals(3, orderedList.count());
  }

  @Test
  void deleteEmpty() {
    OrderedList<Integer> orderedList = new OrderedList<>(true);
    orderedList.delete(10);
    assertEquals(0, orderedList.count());
  }
}