package main;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class MainTest {

    @Test
    public void mainTst() {
        String string = "aaa";
        InputStream stringStream = new java.io.ByteArrayInputStream(string.getBytes());
        try {
            Main.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }

    }

    /**
     * Тестируем случай когда пользователь ввел не число, а чтото другое.
     * Ожидаемый результат, программа отработает без ошибок и вернет какойто не пустой ответ.
     */
    @Test
    public void testWrongInput(){
        String input = "3+ 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //подготавливаю тесторую ситуацию
//        ByteArrayInputStream input = new ByteArrayInputStream("5+3".getBytes());
//        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        //запускаю тестируемый код
        try {
            Main.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }
        String result = new String(output.toByteArray());

        //проверяю соответствует ли результат ожиданиям
        Assert.assertEquals("не совпало","5",result );
    }
}