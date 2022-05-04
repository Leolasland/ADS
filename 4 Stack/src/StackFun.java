public class StackFun {

  public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();
    for (char ch : input.toCharArray()) {
      if (ch == '(') {
        stack.push(ch);
      }
      else if (ch == ')') {
        if (stack.peek() == null) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.peek() == null;
  }
}
