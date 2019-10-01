package main;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class InputOutputMainTests {


    @Test
    public void shouldTakeUserInput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

//        Main inputOutput= new Main();
        try {
            Main.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }
        Assert.assertThat(output.toString(), Is.is("Введи выр. вида 1+9 или 121 +43- 64 +765*5 / 2 или римск. вида VII+IIL - XVI ."));
//        assertEquals("add 5", Main.main(null););
    }
}
