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
public class TestSum {

    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"3", "2", 5},
                {"-3", "-2", -5},
                {"3", "-2", 1},
                {"2.5", "5.5", 8},
                {"0", "0", 0}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {3, 2, 5},
                {-3, -2, 5},
                {3, -2, 1},
                {2.5,5.5, 8},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "dataProviderLong")
    public Object[][] provideDataLong(){
        return new Object[][]{
                {3, 2, 5},
                {-3, -2, 5},
                {3, -2, 1},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "dataProviderString")
    public void testSumString(String a, String b, double result){
        assertThat(calculator.sum(Double.parseDouble(a), Double.parseDouble(b)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testSumDouble(double c, double d, double result) {
        assertThat(calculator.sum(c, d), is(result));
    }

    @Test(dataProvider = "dataProviderLong")
    public void testSumLong(long e, long f, long result){
        assertThat(calculator.sum(e, f), is(result));
    }


    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
