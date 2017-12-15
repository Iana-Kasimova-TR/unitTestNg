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
public class TestIsNegative {
    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"-1", true},
                {"0", false},
                {"2", false}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {-1, true},
                {0, false},
                {2, false}
        };
    }


    @Test(dataProvider = "dataProviderString")
    public void testIsnegativeString(String a, boolean result){
        assertThat(calculator.isNegative(Long.parseLong(a)), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testIsNegativeLong(long b, boolean result) {
        assertThat(calculator.isNegative(b), is(result));
    }

    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
