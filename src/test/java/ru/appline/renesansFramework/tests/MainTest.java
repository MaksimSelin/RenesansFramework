package ru.appline.renesansFramework.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainTest extends Setup {


    @Epic("Тест для Ренесанс")
    @Feature(value = "Тест вклада")
    @ParameterizedTest(name = "My test")
    @ValueSource(strings = {"RUB_300000_6_50000_true_8 704,31_250 000_558 704,31",
            "USD_500000_9_25000_true_668,53_200 000_700 668,53"})
    public void scenario(String str) {
        List<String> paramList = new ArrayList<>(Arrays.asList(str.split("_")));
        app.getStartPage()
                .clickDeposits()
                .insertForm(paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4))
                .checkAccruedPercent(paramList.get(5))
                .checkReplenishment(paramList.get(6))
                .checkResult(paramList.get(7));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
