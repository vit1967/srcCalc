package main;

import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {

    @Test
    public void inputToIntFromArab() {
        Main.tipRA= Main.RomArab.Arab;
        try {
            Assert.assertEquals("Не считывается 5 в тесте",5,StringParser.inputToInt("5"));
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }
    }
    @Test
    public void inputToIntFromRom() {
        Main.tipRA= Main.RomArab.Rom;
        try {
            Assert.assertEquals("Не считывается VII ->7 в тесте",7,StringParser.inputToInt("VII"));
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }
    }
    @Test
    public void rezToString() {
        Main.tipRA= Main.RomArab.Rom;

        try {
            Assert.assertEquals("Не выводится VII <-7 в тесте","VII",StringParser.rezToString(7));
        } catch (NoValidateTipExeption noValidateTipExeption) {
            noValidateTipExeption.printStackTrace();
        }
    }

    @Test
    public void toAction() {
    }

//    @Test
//    public void arabicToRoman() {
//        Assert.assertEquals("VII",StringParser.arabicToRoman(7));
//    }
}