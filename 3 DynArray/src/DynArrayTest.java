import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

  DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);

  @Test
  void makeArrayTest() {
    int i = 0;
    dynArray.makeArray(i);
    assertEquals(16, dynArray.capacity);

    i = 16;
    dynArray.makeArray(i);
    assertEquals(i, dynArray.capacity);

    i = 20;
    dynArray.makeArray(i);
    assertEquals(i, dynArray.capacity);

    i = 56;
    dynArray.makeArray(i);
    assertEquals(i, dynArray.capacity);
  }

  @Test
  void getItemTest() {
    dynArray.makeArray(17);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.getItem(-12));

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.getItem(36));

    dynArray = makeRes(20);
    int [] check = new int[20];
    for (int i = 0; i < 20; i++) {
      check[i] = i;
    }
    assertEquals(check[0], dynArray.getItem(0));
    assertEquals(check[10], dynArray.getItem(10));
    assertEquals(check[19], dynArray.getItem(19));
  }

  @Test
  void insertTest() {
    dynArray = makeRes(20);
    dynArray.insert(21, 16);
    assertEquals(21, dynArray.getItem(16));
    assertEquals(32, dynArray.capacity);

    dynArray = makeRes(5);
    dynArray.insert(21, 3);
    assertEquals(21, dynArray.getItem(3));
    assertEquals(16, dynArray.capacity);

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.insert(21,-12));

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.insert(21,36));
  }

  @Test
  void removeTest() {
    dynArray = makeRes(20);
    dynArray.remove(10);
    assertEquals(11, dynArray.getItem(10));
    assertEquals(32, dynArray.capacity);

    dynArray = makeRes(16);
    dynArray.remove(10);
    assertEquals(11, dynArray.getItem(10));
    assertEquals(16, dynArray.capacity);

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.remove(-12));

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynArray.remove(36));
  }

  private DynArray<Integer> makeRes(int item) {
    dynArray = new DynArray<Integer>(Integer.class);
    for (int i = 0; i < item; i++) {
      dynArray.append(i);
    }
    return dynArray;
  }
}