package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void round_EightyFiveCents_ReturnsEightyFiveCents() {
        final double expected = 0.85;
        final double actual = App.roundNum(0.85);
        Assert.assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void round_ZeroCents_ReturnsZeroCents() {
        final double expected = 0;
        final double actual = App.roundNum(0);
        Assert.assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void round_HalfCent_ReturnsOneCent() {
        final double expected = 0.01;
        final double actual = App.roundNum(0.005);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_Book_ReturnsZero() {
        final double expected = 0.00;
        final double actual = App.roundTax(12.49, 0.00);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_MusicCD_ReturnsOneDollarFiftyCents() {
        final double expected = 1.50;
        final double actual = App.roundTax(14.99, 0.10);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_ChocolateBar_ReturnsZero() {
        final double expected = 0.00;
        final double actual = App.roundTax(0.85, 0.00);
        Assert.assertEquals(expected, actual, 0.001);
    }


    @Test
    public void roundTax_ImportedBoxChocolates_ReturnsFiftyCents() {
        final double expected = 0.50;
        final double actual = App.roundTax(10.00, 0.05);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_ImportedPerfume_ReturnsSevenDollarsFifteenCents() {
        final double expected = 7.15;
        final double actual = App.roundTax(47.50, 0.15);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_ImportedBottlePerfume_ReturnsFourDollarsTwentyCents() {
        final double expected = 4.20;
        final double actual = App.roundTax(27.99, 0.15);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_BottlePerfume_ReturnsOneDollarNinetyCents() {
        final double expected = 1.90;
        final double actual = App.roundTax(18.99, 0.10);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_PacketHeadachePills_ReturnsZero() {
        final double expected = 0;
        final double actual = App.roundTax(9.75, 0.00);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void roundTax_ImportedBoxChocolates_ReturnsSixtyCents() {
        final double expected = 0.60;
        final double actual = App.roundTax(11.25, 0.05);
        Assert.assertEquals(expected, actual, 0.001);
    }
}