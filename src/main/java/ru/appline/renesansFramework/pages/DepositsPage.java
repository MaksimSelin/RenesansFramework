package ru.appline.renesansFramework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.appline.renesansFramework.entity.FormParam;

import java.util.List;

/**
 * страница с формой вклада
 */
public class DepositsPage extends BasePage {

    private FormParam formParam;
    private String param;

    @FindBy(xpath = "//span[@class = 'js-calc-rate']")
    private WebElement waitElement;

    @FindBy(xpath = "//span[text()='Рубли']/../..")
    private WebElement currencyRUB;

    @FindBy(xpath = "//span[text()='Доллары США']")
    private WebElement currencyUSD;

    @FindBy(xpath = "//label[text()='Сумма вклада']/..//input[contains(@class, 'slide-input')]")
    private WebElement depositSum;

    @FindBy(xpath = "//div[@class='jq-selectbox__select-text']")
    private WebElement time;

    @FindBy(xpath = "//div[@class='jq-selectbox__dropdown']//li")
    private List<WebElement> liElementsList;

    @FindBy(xpath = "//label[text()='Ежемесячное пополнение']/..//input")
    private WebElement monthlyReplenishment;

    @FindBy(xpath = "//input[@name='capitalization']/..")
    private WebElement percent;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement accruedPercent;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement replenishment;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement result;

    /**
     * инициализация формы дефолтными значениями
     *
     * @return
     */
    @Step("Инициализация формы")
    public DepositsPage insertForm() {
        formParam = FormParam.getForm();
        scenario();
        return this;
    }

    /**
     * инициализация формы кастомными значениями
     *
     * @param currency             - валюта
     * @param depositSum           - сумма вклада
     * @param time                 - срок вклада
     * @param monthlyReplenishment - едемесячное пополнение
     * @param percent              - капитализация
     * @return
     */
    @Step("Инициализация формы")
    public DepositsPage insertForm(String currency, String depositSum, String time, String monthlyReplenishment, String percent) {
        formParam = FormParam.getForm(currency, depositSum, time, monthlyReplenishment, percent);
        scenario();
        return this;
    }

    /**
     * сценарий заполнения формы
     */
    private void scenario() {
        waitLoadPage();
        inputCurrency();
        inputDepositSum();
        inputTime();
        insertMonthlyReplenishment();
        insertPercent();
    }

    /**
     * выбор валюты
     */
    private void inputCurrency() {
        if (!formParam.getCurrency().equals("RUB")) {
            param = waitElement.getText();
            currencyUSD.click();
            wait.until(new ExpectedCondition<Object>() {
                public Object apply(WebDriver driver) {
                    return !param.equals(waitElement.getText());
                }
            });

        }
    }

    /**
     * ввод суммы депозита
     */
    private void inputDepositSum() {
        depositSum.clear();
        depositSum.sendKeys(formParam.getDepositSum());
    }

    /**
     * выбор срока
     */
    private void inputTime() {
        waitUntilElementToBeVisibilityOf(time);
        scrollToElement(time);
        time.click();
        liElementsList.forEach(webElement -> {
            if (webElement.getText().trim().split(" ")[0].equals(formParam.getTime())) {
                webElement.click();
                return;
            }
        });
        time.click();
    }

    /**
     * ввод суммы ежемесячного пополнения
     */
    private void insertMonthlyReplenishment() {
        scrollToElement(monthlyReplenishment);
        monthlyReplenishment.clear();
        monthlyReplenishment.sendKeys(formParam.getMonthlyReplenishment());
    }

    /**
     * выбор ежемесячной капитализации
     */
    private void insertPercent() {
        param = accruedPercent.getText();
        if (formParam.getPercent().equals("true")) {
            if (percent.getAttribute("class").equals("jq-checkbox calculator__check")) {
                percent.click();
                waitElement();
            }
        } else if (!percent.getAttribute("class").equals("jq-checkbox calculator__check")) {
            percent.click();
            waitElement();
        }
    }

    private void waitElement() {
        wait.until(new ExpectedCondition<Object>() {
            public Object apply(WebDriver driver) {
                return !param.equals(accruedPercent.getText());
            }
        });
    }

    /**
     * проверка начисленных процентов
     *
     * @param value - значение для проверки
     * @return
     */
    @Step("Проверка начисленных процентов")
    public DepositsPage checkAccruedPercent(String value) {
        scrollToElement(accruedPercent);
        waitUntilElementToBeVisibilityOf(accruedPercent);
        wait.until(new ExpectedCondition<Object>() {
            public Object apply(WebDriver driver) {
                return !param.equals(accruedPercent.getText());
            }
        });
        Assert.assertEquals("Проверка поля 'Начислено %'", accruedPercent.getText(), value);
        return this;
    }

    /**
     * проверка пополнений за весь срок
     * @param value - значение для проверки
     * @return
     */
    @Step("Проверка пополнений")
    public DepositsPage checkReplenishment(String value) {
        Assert.assertEquals("Проверка поля 'пополнение за " + formParam.getTime() + " месяцев'",
                replenishment.getText(), value);
        return this;
    }

    /**
     * проверка итоговой суммы
     * @param value - значение для проверки
     * @return
     */
    @Step("Проверка итоговой суммы")
    public DepositsPage checkResult(String value) {
        Assert.assertEquals("Проверка поляня 'К снятию через " + formParam.getTime() + " месяцев'",
                result.getText(), value);
        return this;
    }

}
