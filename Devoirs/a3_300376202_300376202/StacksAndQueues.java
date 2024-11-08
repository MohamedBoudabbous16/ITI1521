import java.util.EmptyStackException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksAndQueues {

    public static void reverseQueue(Queue<String> inputQueue) {
        if (inputQueue == null) {
            throw new IllegalArgumentException();
        } else {
            LinkedStack<String> tempStack = new LinkedStack<>();
            while (!inputQueue.isEmpty()) {
                tempStack.push(inputQueue.dequeue());
            }
            while (!tempStack.isEmpty()) {
                inputQueue.add(tempStack.pop());
            }
        }
    }

    public static void reverseStack(Stack<String> inputStack) {
        if (inputStack == null) {
            throw new IllegalArgumentException();
        } else {
            Stack<String> tempFirst = new LinkedStack <String>();
            Stack<String> tempSecond = new LinkedStack<String>();
            while (!inputStack.isEmpty()) {
                tempFirst.push(inputStack.pop());
            }
            while (!tempFirst.isEmpty()) {
                tempSecond.push(tempFirst.pop());
            }
            while (!tempSecond.isEmpty()) {
                inputStack.push(tempSecond.pop());
            }
        }
    }

    public static void removeAll(Queue<String> inputQueue, String elementToRemove) {
        if (inputQueue == null) {
            throw new IllegalArgumentException();
        } else if (inputQueue.isEmpty()) {
            throw new EmptyQueueException();
        } else {
            Queue<String> tempQueue = new LinkedQueue<String>();
            int elementCount = 0;
            while (!inputQueue.isEmpty()) {
                tempQueue.enqueue(inputQueue.dequeue());
                elementCount++;
            }
            for (int i = 0; i < elementCount; i++) {
                String currentItem = tempQueue.dequeue();
                if (!currentItem.equals(elementToRemove)) {
                    tempQueue.enqueue(currentItem);
                }
            }
            while (!tempQueue.isEmpty()) {
                inputQueue.enqueue(tempQueue.dequeue());
            }
        }
    }

    public static void removeAll(Stack<String> inputStack, String elementToRemove) {
        if (inputStack == null) {
            throw new IllegalArgumentException();
        } else if (inputStack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            Stack<String> tempStack = new LinkedStack<>();
            while (!inputStack.isEmpty()) {
                String currentItem = inputStack.pop();
                if (!currentItem.equals(elementToRemove)) {
                    tempStack.push(currentItem);
                }
            }
            while (!tempStack.isEmpty()) {
                inputStack.push(tempStack.pop());
            }
        }
    }

    public static void removeFirst(Queue<String> inputQueue, String elementToRemove) {
        if (inputQueue == null) {
            throw new IllegalArgumentException();
        } else if (inputQueue.isEmpty()) {
            throw new EmptyQueueException();
        } else {
            Queue<String> tempQueue = new LinkedQueue<>();
            int elementCount = 0;
            boolean isRemoved = false;
            while (!inputQueue.isEmpty()) {
                String currentItem = inputQueue.dequeue();
                elementCount++;
                if (!isRemoved && currentItem.equals(elementToRemove)) {
                    isRemoved = true;
                } else {
                    tempQueue.enqueue(currentItem);
                }
            }
            while (!tempQueue.isEmpty()) {
                inputQueue.enqueue(tempQueue.dequeue());
            }
        }
    }

    public static void removeFirst(Stack<String> inputStack, String elementToRemove) {
        if (inputStack == null) {
            throw new IllegalArgumentException();
        } else if (inputStack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            Stack<String> tempStack = new LinkedStack<>();
            boolean isRemoved = false;
            while (!inputStack.isEmpty()) {
                String currentItem = inputStack.pop();
                if (!isRemoved && currentItem.equals(elementToRemove)) {
                    isRemoved = true;
                } else {
                    tempStack.push(currentItem);
                }
            }
            while (!tempStack.isEmpty()) {
                inputStack.push(tempStack.pop());
            }
        }
    }


    public static void main(String[] args) {
Queue<String> q1;
        q1 = new LinkedQueue<String>();
        q1.enqueue ("a");
        q1.enqueue ("b");
        q1.enqueue ("c");
        q1.enqueue ("d");
        System.out.println("reverse Queue");
        System.out.println(q1);
        StacksAndQueues.reverseQueue(q1);
        System.out.println(q1);
        System.out.println();

        Stack<String> s1;
        s1 = new LinkedStack<String>();
        s1.push ("a");
        s1.push ("b");
        s1.push ("c");
        s1.push ("d");
        System.out.println("reverse Stack");
        System.out.println(s1);
        StacksAndQueues.reverseStack(s1);
        System.out.println(s1);
        System.out.println();

        Queue<String> q2;
        q2 = new LinkedQueue<String>();
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        System.out.println("remove All a for Queue");
        System.out.println(q2);
        StacksAndQueues.removeAll(q2, "a");
        System.out.println(q2);
        System.out.println();

        Stack<String> s2;
        s2 = new LinkedStack<String>();
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        System.out.println("remove All a for Stack");
        System.out.println(s2);
        StacksAndQueues.removeAll(s2, "a");
        System.out.println(s2);
        System.out.println();

        Queue<String> q3;
        q3 = new LinkedQueue<String>();
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        System.out.println("remove First a for Queue - Scenario 1");
        System.out.println(q3);
        StacksAndQueues.removeFirst(q3, "a");
        System.out.println(q3);
        System.out.println();

        //removeFirst queue 2e exemple
        Queue<String> q4;
        q4 = new LinkedQueue<String>();
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        System.out.println("remove First b for Queue - Scenario 2");
        System.out.println(q4);
        StacksAndQueues.removeFirst(q4, "b");
        System.out.println(q4);
        System.out.println();

        Stack<String> s3;
        s3 = new LinkedStack<String>();
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        System.out.println("remove First c for Stack - Scenario 1");
        System.out.println(s3);
        StacksAndQueues.removeFirst(s3, "c");
        System.out.println(s3);
        System.out.println();

        //removeFirst stack 2e exemple
        Stack<String> s4;
        s4 = new LinkedStack<String>();
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        System.out.println("remove First b for Stack - Scenario 2");
        System.out.println(s4);
        StacksAndQueues.removeFirst(s4, "b");
        System.out.println(s4);
        System.out.println();
    }
}