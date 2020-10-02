package ru.appline.renesansFramework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.appline.renesansFramework.utils.StaticField.PATH_CHROME_DRIVER;

public class DriverManager {

    private static WebDriver driver;

    /**
     * Инициализация драйвера
     */
    private DriverManager(){

    }

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
