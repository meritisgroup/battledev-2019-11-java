import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Exo1Test {

    @Test
    public void testWith2() throws Exception {
        String test = "2\ndude 3\nbuddy 15\n";
        ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exo1.main(null);

        Assert.assertEquals(outContent.toString().trim(), "dude");
    }

}
