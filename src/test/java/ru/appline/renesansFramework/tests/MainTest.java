package ru.appline.renesansFramework.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainTest extends Setup {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"RUB", "300000", "6", "50000", "true", "8 704,31", "250 000", "558 704,31"},
                {"USD", "500000", "9", "25000", "true", "668,53", "200 000", "700 668,53"}
        });
    }

    @Parameterized.Parameter(0)
    public String currency;

    @Parameterized.Parameter(1)
    public String depositSum;

    @Parameterized.Parameter(2)
    public String time;

    @Parameterized.Parameter(3)
    public String monthlyReplenishment;

    @Parameterized.Parameter(4)
    public String percent;

    @Parameterized.Parameter(5)
    public String accruedPercent;

    @Parameterized.Parameter(6)
    public String replenishment;

    @Parameterized.Parameter(7)
    public String result;

    @Epic("Тест для Ренесанс")
    @Feature(value = "Тест вклада")
    @Test
    public void scenario() {
        app.getStartPage()
                .clickDeposits()
                .insertForm(currency, depositSum, time, monthlyReplenishment, percent)
                .checkAccruedPercent(accruedPercent)
                .checkReplenishment(replenishment)
                .checkResult(result);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
