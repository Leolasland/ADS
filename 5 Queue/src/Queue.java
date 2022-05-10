import java.util.LinkedList;

public class Queue<T>
{
    private LinkedList<T> queueList;

    public Queue()
    {
        queueList = new LinkedList<>();
    }

    // O(1)
    public void enqueue(T item)
    {
        queueList.addFirst(item);
    }

    // O(1)
    public T dequeue()
    {
        if (queueList.size() == 0) {
            return null;
        }
        return queueList.getLast();
    }

    public int size()
    {
        return queueList.size();
    }

}
