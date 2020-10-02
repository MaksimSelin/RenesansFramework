package ru.appline.renesansFramework.entity;

/**
 * Сущность формы для заполнения
 */
public class FormParam {

    private static FormParam formParam;

    private static String currency;
    private static String depositSum;
    private static String time;
    private static String monthlyReplenishment;
    private static String percent;

    private FormParam(){

    }

    public static FormParam getForm(){
        createFormParam();
        initForm();
        return formParam;
    }

    public static FormParam getForm(String currency, String depositSum, String time, String monthlyReplenishment, String percent){
        createFormParam();
        initForm(currency, depositSum, time, monthlyReplenishment, percent);
        return formParam;
    }

    private static FormParam createFormParam(){
        if (formParam == null)
            formParam = new FormParam();
        return formParam;
    }

    /**
     * инициализация дефолтными значениями
     */
    private static void initForm(){
        currency = "RUB";
        depositSum = "300000";
        time = "6";
        monthlyReplenishment = "50000";
        percent = "true";
    }

    /**
     * инициализация кастомными значениями
     * @param currencyParam - валюта
     * @param depositSumParam - сумма вклада
     * @param timeParam - срок вклада
     * @param monthlyReplenishmentParam - ежемесячное пополнение вклада
     * @param percentParam - капитализация
     */
    private static void initForm(String currencyParam, String depositSumParam, String timeParam, String monthlyReplenishmentParam, String percentParam){
        currency = currencyParam;
        depositSum = depositSumParam;
        time = timeParam;
        monthlyReplenishment = monthlyReplenishmentParam;
        percent = percentParam;
    }



    public String getCurrency() {
        return currency;
    }

    public String getDepositSum() {
        return depositSum;
    }

    public String getTime() {
        return time;
    }

    public String getMonthlyReplenishment() {
        return monthlyReplenishment;
    }

    public String getPercent() {
        return percent;
    }
}
