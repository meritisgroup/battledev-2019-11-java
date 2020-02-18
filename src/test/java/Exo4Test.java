import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Exo4Test {

    @Test
    public void test1() throws Exception {
        String test = "2 2 100\n" +
                "600 40\n" +
                "1000 50\n" +
                "20 40\n" +
                "15 80";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exo4.main(null);

        Assert.assertEquals("1950", outContent.toString().trim());
    }

}
