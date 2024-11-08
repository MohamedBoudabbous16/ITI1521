import org.junit.Test;
import static org.junit.Assert.*;
import java.util.EmptyStackException;

/**
 * la classe de Unit test qui teste les questions du devoir 3
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 03/17/2024
 */
public class TestDevoir3 { 
    // Q1 - reverseQueue
    @Test (expected = IllegalArgumentException.class)
    public void testQ1Exception(){
        Queue<String> q = null;
        StacksAndQueues.reverseQueue(q);
    }

    @Test 
    public void testQ1EmptyQueue(){
        Queue<String> q = new LinkedQueue<>();
        String stringBefore = q.toString();
        StacksAndQueues.reverseQueue(q);
        String stringAfter = q.toString();
        assertEquals(stringBefore, stringAfter);
    }

    @Test 
    public void testQ1(){
        Queue<String> q1;
        q1 = new LinkedQueue<String>();
        q1.enqueue ("a");
        q1.enqueue ("b");
        q1.enqueue ("c");
        q1.enqueue ("d");
        StacksAndQueues.reverseQueue(q1);
        assertEquals(q1.toString(), "(front) -> [d, c, b, a] <- (rear)");
    }

    // Q2 - reverseStack

    @Test (expected = IllegalArgumentException.class)
    public void testQ2Exception(){
        Stack<String> s=null;
        StacksAndQueues.reverseStack(s);
    }

    @Test 
    public void testQ2EmptyStack(){
        Stack<String> s = new LinkedStack<>();
        String stringBefore = s.toString();
        StacksAndQueues.reverseStack(s);
        String stringAfter = s.toString();
        assertEquals(stringBefore, stringAfter);
    }


    @Test 
    public void testQ2(){
        Stack<String> s1;
        s1 = new LinkedStack<String>();
        s1.push ("a");
        s1.push ("b");
        s1.push ("c");
        s1.push ("d");
        StacksAndQueues.reverseStack(s1);
        assertEquals(s1.toString(), "(top) -> [a, b, c, d] <- (bottom)");
    }

    // Q3 - removeAll (Queue)
    @Test (expected = IllegalArgumentException.class)
    public void testQ3ArgumentNullException(){
        Queue<String> q = null;
        StacksAndQueues.removeAll(q, "N/A");
    }

    @Test (expected = EmptyQueueException.class)
    public void testQ3EmptyQueue(){
        Queue<String> q = new LinkedQueue<String>();
        StacksAndQueues.removeAll(q, "N/A");
    }

    @Test 
    public void testQ3(){
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
        StacksAndQueues.removeAll(q2, "a");
        assertEquals(q2.toString(), "(front) -> [b, c, b, c, b, c] <- (rear)");
    }

    @Test 
    public void testQ3NotPresent(){
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
        StacksAndQueues.removeAll(q2, "z");
        assertEquals(q2.toString(), "(front) -> [a, b, c, a, b, c, a, b, c] <- (rear)");
    }

  // Q4 - removeAll (Stack)

    @Test (expected = IllegalArgumentException.class)
    public void testQ4ArgumentNullException(){
        Stack<String> s=null;
        StacksAndQueues.removeAll(s, "N/A");
    }

    @Test (expected = EmptyStackException.class)
    public void testQ4EmptyStackException(){
        Stack<String> s= new LinkedStack<String>();
        StacksAndQueues.removeAll(s, "N/A");
    }

    @Test 
    public void testQ4(){
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
        StacksAndQueues.removeAll(s2, "a");
        assertEquals(s2.toString(), "(top) -> [c, b, c, b, c, b] <- (bottom)");
    }

    @Test 
    public void testQ4NotPresent(){
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
        StacksAndQueues.removeAll(s2, "z");
        assertEquals(s2.toString(), "(top) -> [c, b, a, c, b, a, c, b, a] <- (bottom)");
    }

    // Q5 - removeFirst (Queue)
    @Test (expected = IllegalArgumentException.class)
    public void testQ5ArgumentNullException(){
        Queue<String> q = null;
        StacksAndQueues.removeFirst(q, "N/A");
    }

    @Test (expected = EmptyQueueException.class)
    public void testQ5EmptyQueue(){
        Queue<String> q = new LinkedQueue<String>();
        StacksAndQueues.removeFirst(q, "N/A");
    }

    @Test 
    public void testQ5Scenario1(){
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
        StacksAndQueues.removeFirst(q3, "a");
        assertEquals(q3.toString(), "(front) -> [b, c, a, b, c, a, b, c] <- (rear)");
    }

    @Test 
    public void testQ5Scenario2(){
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
        StacksAndQueues.removeFirst(q4, "b");
        assertEquals(q4.toString(), "(front) -> [a, c, a, b, c, a, b, c] <- (rear)");
    }

    @Test 
    public void testQ5Scenario3(){
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
        StacksAndQueues.removeFirst(q4, "z");
        assertEquals(q4.toString(), "(front) -> [a, b, c, a, b, c, a, b, c] <- (rear)");
    }

    // Q6 - removeFirst (Stack)
    @Test (expected = IllegalArgumentException.class)
    public void testQ6ArgumentNullException(){
        Stack<String> s = null;
        StacksAndQueues.removeFirst(s, "N/A");
    }

    @Test (expected = EmptyStackException.class)
    public void testQ6EmptyStack(){
        Stack<String> s = new LinkedStack<String>();
        StacksAndQueues.removeFirst(s, "N/A");
    }

    @Test 
    public void testQ6Scenario1(){
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
        StacksAndQueues.removeFirst(s3, "c");
        assertEquals(s3.toString(), "(top) -> [b, a, c, b, a, c, b, a] <- (bottom)");
    }

    @Test 
    public void testQ6Scenario2(){
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
        StacksAndQueues.removeFirst(s4, "b");
        assertEquals(s4.toString(), "(top) -> [c, a, c, b, a, c, b, a] <- (bottom)");
    }

    @Test 
    public void testQ6Scenario3(){
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
        StacksAndQueues.removeFirst(s4, "z");
        assertEquals(s4.toString(), "(top) -> [c, b, a, c, b, a, c, b, a] <- (bottom)");
    }

    public static void main(String[] args) {
        TestUtils.runClass(TestDevoir3.class);        
    }
    
}

// Pour compiler ce fichier
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestDevoir3.java
// Pour executer les tests
// java -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestDevoirD3