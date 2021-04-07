package ru.nazariene.stack;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void testLinkedListQueue() {
        Queue queue = new LinkedListQueue();
        runTests(queue);
    }

    private void runTests(Queue queue) {
        testqueue_Regular(queue);
        testqueue_popWhenEmpty(queue);
        testqueue_EnsureCapacity(queue);
    }

    private void testqueue_Regular(Queue queue) {
        queue.enqueue(1);
        int result = queue.dequeue();
        Assert.assertEquals(1, result);
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertTrue(queue.isEmpty());
    }

    private void testqueue_popWhenEmpty(Queue queue) {
        try {
            queue.dequeue();
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(queue.isEmpty());
        }
    }

    private void testqueue_EnsureCapacity(Queue queue) {
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 15; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }
    }
}
