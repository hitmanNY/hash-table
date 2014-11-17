package jason.example.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    private HashTable table;

    @Before
    public void setup() {
        table = new HashTable();

    }

    @Test
    public void testSizeSingleGood() {
        table.put("one", "number 1");

        Integer expected = 1;
        Integer response = table.size();

        assertEquals(expected, response);
    }

    @Test
    public void testRemoveGood() {
        table.put("one", "number 1");
        table.put("two", "number 2");
        table.put("three", "number 3");

        String expected = "number 2";
        String result = table.remove("two");

        assertEquals(expected, result);
    }

    @Test
    public void testSizeDuplicateGood() {
        table.put("one", "number 1");
        table.put("two", "number 2");
        table.put("three", "number 3");
        table.put("four", "number 4");
        table.put("five", "number 5");
        table.put("six", "number 6");
        table.put("seven", "number 7");
        table.put("eight", "number 8");
        table.put("nine", "number 9");
        table.put("10", "number 10");

        Integer expected = 10;
        Integer response = table.size();
        assertEquals(expected, response);
    }

    @Test
    public void testGetGood() {
        String expected = "number 1";

        table.put("one", "number 1");

        String result = table.get("one");

        assertEquals(expected, result);
    }

    @Test
    public void testGetNullGood() {
        assertNull(table.get(null));
    }

    @Test
    public void testGetNotExistGood() {
        table.get("Does not exist");
    }
}
