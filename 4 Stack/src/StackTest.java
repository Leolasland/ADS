import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  @Test
  void size() {
    Stack<Integer> stack = new Stack<>();
    assertEquals(0, stack.size());
    stack.push(1);
    assertEquals(1, stack.size());
    stack.push(2);
    assertEquals(2, stack.size());
    stack.push(3);
    assertEquals(3, stack.size());
    stack.pop();
    assertEquals(2, stack.size());
    stack.pop();
    assertEquals(1, stack.size());
    stack.pop();
    assertEquals(0, stack.size());
  }

  @Test
  void pop() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.size());
    assertEquals(3, stack.peek());
    stack.pop();
    assertEquals(2, stack.size());
    assertEquals(2, stack.peek());
    stack.pop();
    assertEquals(1, stack.size());
    assertEquals(1, stack.peek());
    stack.pop();
    assertEquals(0, stack.size());
  }

  @Test
  void push() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.size());
  }

  @Test
  void peek() {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(2);
    stack.push(1);
    assertEquals(1, stack.peek());
  }
}