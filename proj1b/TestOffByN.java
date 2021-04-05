import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(4);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', (char) ('a' - 4)));
        assertTrue(offByN.equalChars('z', (char) ('z' + 4)));
        assertFalse(offByN.equalChars('a', 'b'));
        assertFalse(offByN.equalChars('a', 'a'));
        assertFalse(offByN.equalChars('z', 'a'));
    }
}
