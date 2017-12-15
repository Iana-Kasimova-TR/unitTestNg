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
public class TestCtg {

    Calculator calculator;

    @BeforeClass
    public void beforeTest(){
        calculator = new Calculator();
    }

    @DataProvider(name = "dataProviderString")
    public Object[][] provideDataString(){
        return new Object[][]{
                {"90", 0},
                {"45", 1},
                {"0", NaN}
        };
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {90, 0},
                {45,1},
                {0, NaN}
        };
    }

    @Test(dataProvider = "dataProviderString")
    public void testCtgString(String a, double result){
        assertThat(calculator.ctg(Math.toRadians(Double.parseDouble(a))), is(result));
    }


    @Test(dataProvider = "dataProvider")
    public void testCtgDouble(double b, double result) {
        assertThat(calculator.ctg(Math.toRadians(b)), is(result));
    }

    @AfterClass
    public void afterTest(){
        System.out.println("tests are finished");
        calculator = null;
    }
}
