import java.util.*;

public class Stack<T>
{

  private LinkedList<T> stackList;

  public Stack()
  {
    stackList = new LinkedList<>();
  }

  //O(1)
  public int size()
  {
    return stackList.size();
  }

  //O(1)
  public T pop()
  {
    try {
      return stackList.pop();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  //O(1)
  public void push(T val)
  {
    stackList.push(val);
  }

  //O(1)
  public T peek()
  {
    return stackList.peekFirst();
  }
}
