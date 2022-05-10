public class QueueRotate {

    public Queue rotate(Queue queue, int n) {

        for (int i = 0; i < n; i++) {
            queue.enqueue(queue.dequeue());
        }
        return queue;
    }
}
