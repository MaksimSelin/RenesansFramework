package ru.appline.renesansFramework.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.renesansFramework.utils.StaticField.*;

/**
 * инициализация теста
 */
public class InitManager {
    public static void initFramework(){
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(IMPLICITLY_WAIT), TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(PAGE_LOAD_TIMEOUT), TimeUnit.SECONDS);
    }

    public static void initStart(){
        DriverManager.getDriver().get(APP_URL);
    }
}
