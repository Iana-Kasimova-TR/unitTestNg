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
public class TestPow {

    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"4", "0.5", 2},
                {"2", "-1", 0.5},
                {"-3", "2", 9},
                {"0", "5", 0},
                {"0", "5", 0},
                {"5", "0", 1}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {4, 0.5, 2},
                {2, -1, 0.5},
                {-3, 2, 9},
                {0, 5, 0},
                {0, 5, 0},
                {5, 0, 1}
        };
    }


    @Test(dataProvider = "dataProviderString")
    public void testMultString(String a, String b, double result){
        assertThat(calculator.pow(Double.parseDouble(a), Double.parseDouble(b)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testMultDouble(double c, double d, double result) {
        assertThat(calculator.pow(c, d), is(result));
    }


    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
