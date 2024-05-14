package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ForWhomAboutRentPage {
    private WebDriver webDriver;

    public ForWhomAboutRentPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    // Локаторы первой страницы заказа: "Для кого самокат"
    //Поле "Имя"
    private final By fName = By.xpath(".//input[contains(@placeholder,'Имя')]");

    //Поле "Фамилия"
    private final By sName = By.xpath(".//input[contains(@placeholder,'Фамилия')]");

    //Поле "Адрес: куда привезти заказ"
    private final By addres = By.xpath(".//input[contains(@placeholder,'Адрес')]");

    //Поле "Станция метро"
    private final By metro = By.xpath(".//input[contains(@placeholder,'Станция')]"); // вводим сюда значение

    //Поле "Телефон: на него позвонит курьер"
    private final By phone = By.xpath(".//input[contains(@placeholder,'Телефон')]");

    //Кнопка "Далее"
    private final By firstButtonNext = By.xpath(".//button[contains(text(),'Далее')]");

    //Локаторы второй страницы заказа: "Про аренду"
    //Поле "Когда привезти самокат"
    private final By dateWhenToBring = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //Поле "Срок аренды"
    private final By rentalDate = By.className("Dropdown-placeholder");

    //Поле "Цвет самоката"
    private final By colorBlack = By.id("black");
    private final By colorGrey = By.id("grey");

    //Поле "Комментарий для курьера"
    private final By commen = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Далее"
    private final By secondButtonNext = By.xpath("//div[@class ='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка "Да" в всплывающем модальном окне: "Хотите оформить заказ?"
    private final By buttonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка согласия принятия куки
    private By cookie = By.className("App_CookieButton__3cvqF");

    //Окно - "Заказ оформлен"
    private final By Completed = By.xpath(".//div[starts-with(@class, 'Order_ModalHeader')]");

    // Метод вводид значение в поле "Имя"
    public void inputToFirstName(String firstName) {
        webDriver.findElement(fName).click();
        webDriver.findElement(fName).sendKeys(firstName);
    }

    // Метод вводит значение в поле "Фамилия"
    public void inputToSecondName(String surName) {
        webDriver.findElement(sName).click();
        webDriver.findElement(sName).sendKeys(surName);
    }

    // Метод вводит значение в поле "Адрес: куда привезти заказ"
    public void inputToAddress(String address) {
        webDriver.findElement(addres).click();
        webDriver.findElement(addres).sendKeys(address);
    }

    // Метод вводит значение в поле "Станция метро"
    public void inputToMetroStation(String metroStation) {
        webDriver.findElement(metro).click();
        webDriver.findElement(metro).sendKeys(metroStation);
        webDriver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
    }

    // Метод вводит значение в поле "Телефон: на него позвонит курьер"
    public void inputToPhone(String telephone) {
        webDriver.findElement(phone).click();
        webDriver.findElement(phone).sendKeys(telephone);
    }

    // Метод кликает по кнопке Далее
    public void clickFirstButtonNext() {
        webDriver.findElement(firstButtonNext).click();
    }

    // Объединяем все методы ввода значений на первой странице и клик по кнопке "Далее"
    public void orderPageFirstInput(String firstName, String surName, String address, String metroStation, String telephone) {
        inputToFirstName(firstName);
        inputToSecondName(surName);
        inputToAddress(address);
        inputToMetroStation(metroStation);
        inputToPhone(telephone);
        clickFirstButtonNext();
    }

    // Метод вводит значение в поле "Когда привезти самокат"
    public void inputDateToBring(String date) {
        webDriver.findElement(dateWhenToBring).click();
        webDriver.findElement(dateWhenToBring).sendKeys(date);
        webDriver.findElement(dateWhenToBring).sendKeys(Keys.ENTER);
    }

    // Метод вводит значение в поле "Срок аренды"
    public void inputToRentalDate(String time) {
        webDriver.findElement(rentalDate).click();
        webDriver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" + time + "']")).click();
    }

    // Кликаем на чек-бокс цвета самоката (Чёрный)
    public void tapOnBlackCheckBox() {
        webDriver.findElement(colorBlack).click();
    }

    // Кликаем на чек-бокс цвета самоката (Серый)
    public void tapOnGreyCheckBox() {
        webDriver.findElement(colorGrey).click();
    }

    // Метод вводит значение в поле "Комментарий для курьера"
    public void inputToComment(String comm) {
        webDriver.findElement(commen).click();
        webDriver.findElement(commen).sendKeys(comm);
    }

    // Кликаем по кнопке "Заказать"
    public void tapToSecondButtonNext() {
        webDriver.findElement(secondButtonNext).click();
    }

    // Объединяем все методы ввода значений на второй странице и клик по кнопке "Заказать"
    public void orderPageSecondInput(String deliveryDate, String rentTime, String comment) {
        inputDateToBring(deliveryDate);
        inputToRentalDate(rentTime);
        inputToComment(comment);
        tapToSecondButtonNext();
    }

    // Кликаем по кнопке "Да"
    public void tapToButtonYes() {

        webDriver.findElement(buttonYes).click();
    }

    // Проверяем что появилось окно с сообщением об успешном создании заказа.
    public boolean OrderCompleted() {

        return webDriver.findElement(Completed).getText().contains("Заказ оформлен");
    }

    public void closeCookieButton() {

        webDriver.findElement(cookie).click();
    }


}
