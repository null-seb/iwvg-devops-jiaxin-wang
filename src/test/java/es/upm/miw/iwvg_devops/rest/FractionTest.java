package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private Fraction fraction;
    @BeforeEach
    void before() {
        fraction = new Fraction(0, 1);
    }

    @Test
    void testFraction() {
        assertEquals(0, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }
    @Test
    void testFractionSetNumerator() {
        fraction.setNumerator(1);
        assertEquals(1, fraction.getNumerator());
    }
    @Test
    void testFractionSetDenominator() {
        fraction.setDenominator(2);
        assertEquals(2, fraction.getDenominator());
    }
    @Test
    void testFractionGetNumerator() {
        assertEquals(0, fraction.getNumerator());
    }
    @Test
    void testFractionGetDenominator(){
        assertEquals(1, fraction.getDenominator());
    }
    @Test
    void testFractionDecimal(){
        assertEquals(0, fraction.decimal());
    }
    @Test
    void testIsProper(){
        assertEquals(true,fraction.isProper(1,2));
    }
    @Test
    void testISImproper(){
        assertEquals(false,fraction.isImproper(1,2));
    }
    @Test
    void testIsEquivalent(){
        assertEquals(true,fraction.isEquivalent(1,1));
    }
    @Test
    void testAdd(){
        Fraction fractionTemp;
        Fraction fractionSum ;
        fractionTemp=new Fraction(1,3);
        fractionSum=new Fraction(0,1);
        assertEquals(fractionSum.toString(),fraction.add(fraction).toString());
    }
    @Test
    void testMultiply(){
        Fraction fractionTemp;
        Fraction fractionResult ;
        fractionTemp=new Fraction(3,5);
        fractionResult=new Fraction(0,5);
        assertEquals(fractionResult.toString(),fraction.multiply(fractionTemp).toString());
    }
    @Test
    void testDivide(){
        Fraction fractionTemp;
        Fraction fractionResult ;
        fractionTemp=new Fraction(2,3);
        fractionResult=new Fraction(0,2);
        assertEquals(fractionResult.toString(),fraction.divide(fractionTemp).toString());
    }
}
