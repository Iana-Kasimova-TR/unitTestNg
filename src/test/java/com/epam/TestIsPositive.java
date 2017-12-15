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
public class TestIsPositive {
    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"-1", false},
                {"0", false},
                {"2", true}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {-1, false},
                {0, false},
                {2, true}
        };
    }


    @Test(dataProvider = "dataProviderString")
    public void testIsPositiveString(String a, boolean result){
        assertThat(calculator.isPositive(Long.parseLong(a)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testIspositiveLong(long b, boolean result) {
        assertThat(calculator.isPositive(b), is(result));
    }

    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }

}
