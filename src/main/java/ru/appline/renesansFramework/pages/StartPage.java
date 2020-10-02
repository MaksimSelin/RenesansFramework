package ru.appline.renesansFramework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.renesansFramework.managers.PageManager;

/**
 * Начальная страница
 */
public class StartPage extends BasePage {

    @FindBy(xpath = "//div[text()='Вклады']/..")
    private WebElement deposits;

    /**
     * Переход к вкладам
     * @return
     */
    @Step("Перехов к вкладам")
    public DepositsPage clickDeposits(){
        deposits.click();
        return PageManager.getDepositsPage();
    }
}
