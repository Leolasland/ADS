import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

  private HashTable table;

  @BeforeEach
  void setUp() {
    table = new HashTable(7, 3);
  }

  @Test
  void hashFun() {
    assertEquals(1, table.hashFun("a"));
    assertEquals(2, table.hashFun("ab"));
    assertEquals(2, table.hashFun("aa"));
    assertEquals(6, table.hashFun("aavvdf"));
  }

  @Test
  void seekSlot() {
    assertEquals(1, table.seekSlot("a"));
    assertEquals(1, table.seekSlot("12345678"));
  }

  @Test
  void put() {
    assertEquals(1, table.put("a"));
    assertEquals(4, table.put("12345678"));
  }

  @Test
  void find() {
    assertEquals(1,table.put("a"));
    assertEquals(4,table.put("12345678"));
    assertEquals(4,table.find("12345678"));
    assertEquals(-1,table.find("1"));
  }
}