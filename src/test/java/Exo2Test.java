import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Exo2Test {

    @Test
    public void testWith2() throws Exception {
        String test = "15\n34\n25\n10\n";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exo2.main(null);

        Assert.assertEquals(outContent.toString().trim(), "44");
    }

}