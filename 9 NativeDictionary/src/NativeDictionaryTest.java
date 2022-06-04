import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

  private NativeDictionary nativeDictionary;

  @BeforeEach
  void setUp() {
    nativeDictionary = new NativeDictionary(7, Integer.class);
  }

  @Test
  void isKey() {
    nativeDictionary.put("aaa", 0);
    nativeDictionary.put("a", 1);
    nativeDictionary.put("aab", 2);
    assertTrue(nativeDictionary.isKey("aaa"));
    assertTrue(nativeDictionary.isKey("a"));
    assertTrue(nativeDictionary.isKey("aab"));
    assertFalse(nativeDictionary.isKey("z"));
    assertFalse(nativeDictionary.isKey("zz"));
  }

  @Test
  void put() {
    nativeDictionary.put("aaa", 0);
    nativeDictionary.put("a", 1);
    nativeDictionary.put("aab", 2);
    assertEquals(0, nativeDictionary.get("aaa"));
    assertEquals(1, nativeDictionary.get("a"));
    assertEquals(2, nativeDictionary.get("aab"));
    nativeDictionary.put("a", 7);
    assertEquals(7, nativeDictionary.get("a"));
  }

  @Test
  void get() {
    assertNull(nativeDictionary.get("zzz"));
    nativeDictionary.put("aaa", 0);
    assertEquals(0, nativeDictionary.get("aaa"));
    nativeDictionary.put("aab", 2);
    assertEquals(2, nativeDictionary.get("aab"));
  }
}