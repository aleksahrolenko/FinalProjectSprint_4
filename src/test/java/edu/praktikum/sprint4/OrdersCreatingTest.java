package edu.praktikum.sprint4;

import dev.failsafe.internal.util.Durations;
import edu.praktikum.sprint4.pom.ForWhomAboutRentPage;
import edu.praktikum.sprint4.pom.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static edu.praktikum.sprint4.pom.HomePage.URL;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrdersCreatingTest {
    private WebDriver webDriver;

    private  final String firstName;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String deliveryDate;
    private final String rentTime;
    private final String comment;

    public OrdersCreatingTest(String firstName, String surName, String address, String metroStation, String telephone, String deliveryDate, String rentTime, String comment){
        this.firstName = firstName;
        this.secondName = surName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.deliveryDate = deliveryDate;
        this.rentTime = rentTime;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовый набор данных: {0} {1} {2} {3} {4} {5} {6} {7}")

    public  static  Object[][] getNumber() {
        return new Object[][] {
                {"Александра", "Хроленко", "ул. Комсомольская д.7 кв.5", "Комсомольская", "89998887766", "16.05.2024", "сутки", "Тестовый коммент 1"},
                {"Иван", "Иванов", "ул. Ефремова д.6 кв.4", "Сокольники", "89998885544", "17.05.2024", "двое суток", "Тестовый коммент 2"}
        };
    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        //webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
        webDriver.get(URL);
    }

    @Test
    public void testOrderWithBottomButton() {
        HomePage homePage = new HomePage(webDriver);
        homePage.scrollToBottomButton();
        homePage.clickToOrderBottomButton();

        ForWhomAboutRentPage forWhomAboutRentPage = new ForWhomAboutRentPage(webDriver);
        forWhomAboutRentPage.closeCookieButton();
        forWhomAboutRentPage.orderPageFirstInput(firstName, secondName, address, metroStation, telephone);
        forWhomAboutRentPage.tapOnBlackCheckBox();
        forWhomAboutRentPage.orderPageSecondInput(deliveryDate, rentTime, comment);
        forWhomAboutRentPage.tapToButtonYes();

        assertTrue("Не отображается окно с сообщением об успешном создании заказа.", forWhomAboutRentPage.orderCompleted());
    }
    @Test
    public void testOrderWithUpButton(){
        HomePage homePage = new HomePage(webDriver);
        homePage.clickToOrderUpButton();

        ForWhomAboutRentPage forWhomAboutRentPage = new ForWhomAboutRentPage(webDriver);
        forWhomAboutRentPage.closeCookieButton();
        forWhomAboutRentPage.orderPageFirstInput(firstName, secondName, address, metroStation, telephone);
        forWhomAboutRentPage.tapOnGreyCheckBox();
        forWhomAboutRentPage.orderPageSecondInput(deliveryDate, rentTime, comment);
        forWhomAboutRentPage.tapToButtonYes();

        assertTrue("Не отображается окно с сообщением об успешном создании заказа.", forWhomAboutRentPage.orderCompleted());
    }
    @After
    public  void tearDown(){

        webDriver.quit();
    }


}
