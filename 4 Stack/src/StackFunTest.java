import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackFunTest {

  @Test
  void isBalanced() {
    assertTrue(StackFun.isBalanced(""));
    assertTrue(StackFun.isBalanced("()"));
    assertTrue(StackFun.isBalanced("()()"));
    assertTrue(StackFun.isBalanced("(()())"));
    assertTrue(StackFun.isBalanced("(())()"));
    assertTrue(StackFun.isBalanced("(())(())"));

    assertFalse(StackFun.isBalanced("("));
    assertFalse(StackFun.isBalanced(")"));
    assertFalse(StackFun.isBalanced(")))"));
    assertFalse(StackFun.isBalanced("((("));
    assertFalse(StackFun.isBalanced("))(("));
    assertFalse(StackFun.isBalanced("())()()))"));
    assertFalse(StackFun.isBalanced("())("));
    assertFalse(StackFun.isBalanced("))(("));
    assertFalse(StackFun.isBalanced("((())"));
  }
}