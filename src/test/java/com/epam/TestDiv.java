package com.epam;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Iana_Kasimova on 12/15/2017.
 */
public class TestDiv {
    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"6", "2", 3},
                {"6", "-2", -3},
                {"28.8", "2.4", 12},
                {"0", "5", 0}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {6, 2, 3},
                {6, -2, -3},
                {28.8, 2.4, 12},
                {0, 5, 0}
        };
    }

    @DataProvider(name = "dataProviderLong")
    public Object[][] provideDataLong(){
        return new Object[][]{
                {6, 2, 3},
                {6, -2, -3},
                {24, 2, 12},
                {0, 5, 0}
        };
    }

    @Test(dataProvider = "dataProviderString")
    public void testDivString(String a, String b, double result){
        assertThat(calculator.div(Double.parseDouble(a), Double.parseDouble(b)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testDivDouble(double c, double d, double result) {
        assertThat(calculator.div(c, d), is(result));
    }

    @Test(dataProvider = "dataProviderLong")
    public void testDivLong(long e, long f, long result){
        assertThat(calculator.div(e, f), is(result));
    }

    @Test
    public void testDivWithPoint(){
        assertThat(calculator.div(3.0, 2.0), is(1.5));
    }

    @Test(expectedExceptions = Exception.class)
    public void testDivByZeroDouble(){
        calculator.div(3, 0.0);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDivByZeroLong(){
        calculator.div(4, 0L);
    }

    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
