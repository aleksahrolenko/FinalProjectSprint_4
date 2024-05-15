package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webDriver;
    public final static String URL = "https://qa-scooter.praktikum-services.ru/";

    public HomePage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    //Верхняя кнопка "Заказать"
    private final By orderUpButton = By.className("Button_Button__ra12g");

    //Нижняя кнопка "Заказать"
    private final By orderBottomButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button");

    // Скролл к нижней кнопке "Заказать"
    public void scrollToBottomButton() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(orderBottomButton));
    }

    // Метод кликает на верхнюю кнопку "Заказать"
    public void clickToOrderUpButton() {

        webDriver.findElement(orderUpButton).click();
    }

    // Метод кликает на нижнюю кнопку "Заказать"
    public void clickToOrderBottomButton() {

        webDriver.findElement(orderBottomButton).click();
    }

}


