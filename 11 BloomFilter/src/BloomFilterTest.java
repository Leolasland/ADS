import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

  private String [] checks;

  @BeforeEach
  void setUp() {
    checks = new String[10];
    checks[0] = "0123456789";
    checks[1] = "1234567890";
    checks[2] = "2345678901";
    checks[3] = "3456789012";
    checks[4] = "4567890123";
    checks[5] = "5678901234";
    checks[6] = "6789012345";
    checks[7] = "7890123456";
    checks[8] = "8901234567";
    checks[9] = "9012345678";
  }

  @Test
  void test() {
    BloomFilter bf = new BloomFilter(32);

    for (int i = 0; i < checks.length; i++) {
      bf.add(checks[i]);
      assertTrue(bf.isValue(checks[i]));
    }
  }
}