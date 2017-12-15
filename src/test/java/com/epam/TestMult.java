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
public class TestMult {

    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"3", "2", 6},
                {"3", "-2", -6},
                {"10", "5.5", 55},
                {"0", "5", 0}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {3, 2, 6},
                {3, -2, -6},
                {10,5.5, 55},
                {0, 5, 0}
        };
    }

    @DataProvider(name = "dataProviderLong")
    public Object[][] provideDataLong(){
        return new Object[][]{
                {3, 2, 6},
                {3, -2, -6},
                {0, 5, 0}
        };
    }

    @Test(dataProvider = "dataProviderString")
    public void testMultString(String a, String b, double result){
        assertThat(calculator.mult(Double.parseDouble(a), Double.parseDouble(b)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testMultDouble(double c, double d, double result) {
        assertThat(calculator.mult(c, d), is(result));
    }

    @Test(dataProvider = "dataProviderLong")
    public void testMultLong(long e, long f, long result){
        assertThat(calculator.mult(e, f), is(result));
    }

    @Test
    public void testMultWithPoint(){
        assertThat(calculator.mult(-2.5, 7.5), is(-18.75));
    }


    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
