package ru.appline.renesansFramework.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.renesansFramework.managers.DriverManager;
import ru.appline.renesansFramework.managers.InitManager;
import ru.appline.renesansFramework.managers.PageManager;


public class Setup {

    PageManager app = PageManager.getPageManager();

    @BeforeClass
    public static void setup(){
        InitManager.initFramework();
    }

    @Before
    public void start(){
        InitManager.initStart();
    }

    @AfterClass
    public static void quit(){
        DriverManager.getDriver().quit();
    }
}
