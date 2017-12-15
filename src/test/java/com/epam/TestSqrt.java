package com.epam;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Iana_Kasimova on 12/15/2017.
 */
public class TestSqrt {

    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"4", 2},
                {"-4", NaN},
                {"0", 0}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {4, 2},
                {-4, NaN},
                {0, 0}
        };
    }


    @Test(dataProvider = "dataProviderString")
    public void testSqrtString(String a, double result){
        assertThat(calculator.sqrt(Double.parseDouble(a)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testSqrtDouble(double b, double result) {
        assertThat(calculator.sqrt(b), is(result));
    }

    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
