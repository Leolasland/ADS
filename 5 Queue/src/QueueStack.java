import java.util.Stack;

public class QueueStack<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    public QueueStack() {
        stack1 = new Stack<T>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        stack2 = new Stack<T>();
        while (stack1.size() > 1) {
            if (stack2.size() == 0) {
                stack2.push(stack1.pop());
            } else if (stack2.size() > 0) {
                T k = stack2.pop();
                stack2.push(stack1.pop());
                stack2.push(k);
            }
        }
        T j = stack1.pop();
        stack1 = stack2;
        return j;
    }

    public int size() {
        return stack1.size();
    }
}
