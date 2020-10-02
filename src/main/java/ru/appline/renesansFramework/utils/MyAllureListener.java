package ru.appline.renesansFramework.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.renesansFramework.managers.DriverManager;

/**
 * Кастомный листенер для добавления скриншотов
 */
public class MyAllureListener{

    @Attachment(value = "Скриншот по окончнию теста", type = "image/png")
    public static byte[] addScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
