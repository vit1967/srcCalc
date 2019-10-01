package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpressionTest {
    Expression expt;
    @Before
    public void setUp() throws Exception {
        expt=new Expression();
    }

    @Test (expected = NoValidateTipExeption.class)
    public void calc1() throws NoValidateTipExeption{

        int r=expt.calc(5,Main.Action.none);
        Assert.assertEquals(8,expt.calc(3,Main.Action.Plus));
    }
    @Rule
    public final ExpectedException exeption= ExpectedException.none();

    @Test
    public void calc2() throws NoValidateTipExeption{
        exeption.expect(NoValidateTipExeption.class);
        int r=expt.calc(5,Main.Action.none);
        Assert.assertEquals(8,expt.calc(3,Main.Action.Plus));
    }

    @Test
    public void getiRez() {
    }
}