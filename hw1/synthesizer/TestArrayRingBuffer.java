package synthesizer;
//import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        assertTrue(arb.isEmpty());
        arb.enqueue(10);
        arb.enqueue(9);
        arb.enqueue(8);
        assertFalse(arb.isFull());
        assertFalse(arb.isEmpty());
        arb.enqueue(6);
        arb.enqueue(1);
        assertTrue(arb.isFull());
        assertEquals(10, arb.peek().intValue());
        assertEquals(10, arb.dequeue().intValue());
        assertFalse(arb.isFull());
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(123);
        arb.enqueue(125);
        assertEquals(6, arb.dequeue().intValue());
        assertEquals(3, arb.fillCount());
        arb.enqueue(126);
        arb.enqueue(123434);

        assertTrue(arb.isFull());

        for (Integer integer : arb) {
            System.out.println(integer);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
