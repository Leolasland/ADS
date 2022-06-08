import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

  @Test
  void size() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdvf");
    ps.put("sdfsf");
    ps.put("sd");
    assertEquals(4, ps.size());
  }

  @Test
  void put() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdg");
    ps.put("sd");
    ps.put("sd");
    ps.put("sdf");
    ps.put("s");
    ps.put("ss");
    ps.put("sss");
    ps.put("ssss");
    assertEquals(7, ps.size());
  }

  @Test
  void get() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdg");
    ps.put("sd");
    ps.put("sd");
    ps.put("sdf");
    ps.put("s");
    ps.put("ss");
    ps.put("sss");
    ps.put("ssss");
    assertTrue(ps.get("sd"));
    assertFalse(ps.get("sdq"));
  }

  @Test
  void remove() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdg");
    ps.put("sd");
    ps.put("sd2");
    ps.put("sdf2");
    ps.put("s");
    ps.put("ss");
    ps.put("sss");
    ps.put("ssss");

    ps.remove("s");
    ps.remove("sd");
    assertEquals(7, ps.size());
    assertFalse(ps.remove("aaa"));
    assertTrue(ps.get("sdg"));
    assertTrue(ps.get("sdf2"));
    assertTrue(ps.get("ss"));
    assertTrue(ps.get("sdf"));
    assertTrue(ps.get("ssss"));
    assertTrue(ps.get("sss"));
    assertTrue(ps.get("sd2"));
    assertTrue(ps.remove("sss"));
  }

  @Test
  void intersection() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    ps2.put("aaa");
    ps2.put("sdv");
    ps2.put("hg");
    ps2.put("sd");
    assertEquals(2, ps.intersection(ps2).size());
  }

  @Test
  void intersectionEmpty() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    ps2.put("aaa");
    ps2.put("sdv1");
    ps2.put("hg");
    ps2.put("sd11");
    assertEquals(0, ps.intersection(ps2).size());
  }

  @Test
  void union() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    ps.put("hg");
    PowerSet ps2 = new PowerSet();
    ps2.put("aaa");
    ps2.put("sdv1");
    ps2.put("hg");
    for (String s : ps.union(ps2).slots) {
      System.out.println(s);
    }
  }

  @Test
  void unionEmpty() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    assertEquals(4, ps.union(ps2).size());
  }

  @Test
  void difference() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    ps2.put("aaa");
    ps2.put("sdv1");
    ps2.put("sd");
    assertEquals(3, ps.difference(ps2).size());
        /*for (String s : ps.difference(ps2).slots) {
            System.out.println(s);
        }*/
  }

  @Test
  void differenceEmpty() {
    PowerSet ps = new PowerSet();
    ps.put("111");
    ps.put("222");
    PowerSet ps2 = new PowerSet();
    ps2.put("111");
    ps2.put("222");
    assertEquals(0, ps.difference(ps2).size());
  }

  @Test
  void isSubsetFalse() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    ps2.put("aaa");
    ps2.put("sdv1");
    ps2.put("sd");
    assertFalse(ps.isSubset(ps2));
  }

  @Test
  void isSubset1() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    ps.put("sd");
    PowerSet ps2 = new PowerSet();
    ps2.put("sdv");
    ps2.put("sdf");
    assertTrue(ps.isSubset(ps2));
  }

  @Test
  void isSubset2() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    PowerSet ps2 = new PowerSet();
    ps2.put("sdv");
    ps2.put("sdf");
    ps2.put("sdfsf");
    assertTrue(ps.isSubset(ps2));
  }

  @Test
  void isSubset3() {
    PowerSet ps = new PowerSet();
    ps.put("sdf");
    ps.put("sdv");
    ps.put("sdfsf");
    PowerSet ps2 = new PowerSet();
    ps2.put("sdv");
    ps2.put("sdf");
    ps2.put("sdfsf");
    ps2.put("aaa");
    assertFalse(ps.isSubset(ps2));
  }
}