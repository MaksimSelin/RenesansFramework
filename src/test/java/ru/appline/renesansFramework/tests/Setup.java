package ru.appline.renesansFramework.tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.appline.renesansFramework.managers.DriverManager;
import ru.appline.renesansFramework.managers.InitManager;
import ru.appline.renesansFramework.managers.PageManager;
import ru.appline.renesansFramework.utils.MyAllureListener;


public class Setup {

    PageManager app = PageManager.getPageManager();

    @BeforeAll
    public static void setup(){
        InitManager.initFramework();
    }

    @BeforeEach
    public void start(){
        InitManager.initStart();
    }

    @AfterEach
    public void screen(){
        new MyAllureListener().addScreenshot();
    }

    @AfterAll
    public static void quit(){
        DriverManager.getDriver().quit();
    }
}
