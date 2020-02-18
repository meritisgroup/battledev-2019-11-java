import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class Exo3Test {

    @Test
    public void testPasPossible() throws Exception {
        String test = "6 7\n" +
                "1 3\n" +
                "1 4\n" +
                "2 8\n" +
                "1 5\n" +
                "1 6\n" +
                "1 7\n" +
                "1 9";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exo3.main(null);

        Assert.assertEquals("pas possible", outContent.toString().trim());
    }

    @Test
    public void testSimple() throws Exception {
        String test = "6 7\n" +
                "1 3\n" +
                "1 4\n" +
                "1 5\n" +
                "1 6\n" +
                "1 7\n" +
                "2 9\n" +
                "3 11";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exo3.main(null);

        String result = outContent.toString().trim();
        String[] array = result.split(" ");
        Assert.assertEquals(7, array.length);

        Set<Integer> first = new TreeSet<Integer>();
        for (int i = 0; i < 6; i++) first.add(Integer.parseInt(array[i]));

        Assert.assertTrue(Collections.min(first) == 1);
        Assert.assertTrue(Collections.max(first) == 6);
        Assert.assertEquals(1, Integer.parseInt(array[6]));
    }

}
