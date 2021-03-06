package ru.appline.renesansFramework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.renesansFramework.managers.DriverManager;

/**
 * Кастомный листенер для добавления скриншотов
 */
public class MyAllureListener extends AllureJunit4 {

    @Override
    public void testFinished(Description description) {
        addScreenshot();
        super.testFinished(description);
    }

    @Override
    public void testFailure(Failure failure) {
        addScreenshot();
        super.testFailure(failure);
    }

    @Attachment(value = "Скриншот по окончнию теста", type = "image/png")
    public static byte[] addScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
