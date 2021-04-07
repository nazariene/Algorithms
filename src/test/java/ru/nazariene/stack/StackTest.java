package ru.nazariene.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testArrayStack() {
        Stack stack = new ArrayStack();
        runTests(stack);
    }

    @Test
    public void testLinkedListStack() {
        Stack stack = new LinkedListStack();
        runTests(stack);
    }

    private void runTests(Stack stack) {
        testStack_Regular(stack);
        testStack_popWhenEmpty(stack);
        testStack_EnsureCapacity(stack);
    }

    private void testStack_Regular(Stack stack) {
        stack.push(1);
        int result = stack.pop();
        Assert.assertEquals(1, result);
        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(2, stack.pop());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(1, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    private void testStack_popWhenEmpty(Stack stack) {
        try {
            stack.pop();
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(stack.isEmpty());
        }
    }

    private void testStack_EnsureCapacity(Stack stack) {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        for (int i = 14; i >= 0; i--) {
            Assert.assertEquals(i, stack.pop());
        }
    }


}
