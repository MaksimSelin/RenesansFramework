package ru.appline.renesansFramework.managers;

import ru.appline.renesansFramework.pages.DepositsPage;
import ru.appline.renesansFramework.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
    private static StartPage startPage;
    private static DepositsPage depositsPage;

    /**
     * Мжнеджер страниц
     */
    private PageManager(){

    }

    public static PageManager getPageManager(){
        if (pageManager == null)
            pageManager = new PageManager();
        return pageManager;
    }

    public static StartPage getStartPage(){
        if (startPage == null)
            startPage = new StartPage();
        return startPage;
    }

    public static DepositsPage getDepositsPage(){
        if (depositsPage == null)
            depositsPage = new DepositsPage();
        return depositsPage;
    }
}
