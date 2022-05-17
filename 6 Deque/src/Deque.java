import java.util.*;

public class Deque<T>
{
    public LinkedList<T> deque;

    public Deque()
    {
        deque = new LinkedList<>();
    }

    public void addFront(T item)
    {
        deque.addFirst(item);
    }

    public void addTail(T item)
    {
        deque.addLast(item);
    }

    public T removeFront()
    {
        return deque.pollFirst();
    }

    public T removeTail()
    {
        return deque.pollLast();
    }

    public int size()
    {
        return deque.size();
    }
}
