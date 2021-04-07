package ru.nazariene.stack;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListQueueTest {

    @Test
    public void testqueue_Regular() {
        Queue queue = new LinkedListQueue();
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

    @Test
    public void testqueue_popWhenEmpty() {
        Queue queue = new LinkedListQueue();

        try {
            queue.dequeue();
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(queue.isEmpty());
        }
    }

    @Test
    public void testqueue_EnsureCapacity() {
        Queue queue = new LinkedListQueue();

        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 15; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }
    }
}
