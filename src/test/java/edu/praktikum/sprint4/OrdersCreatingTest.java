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

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrdersCreatingTest {
    private WebDriver webDriver;

    private  final String FIRSTNAME;
    private final String SURNAME;
    private final String ADDRESS;
    private final String METROSTATION;
    private final String TELEPHONE;
    private final String DELIVERYDATE;
    private final String RENTTIME;
    private final String COMMENT;

    public OrdersCreatingTest(String firstName, String surName, String address, String metroStation, String telephone, String deliveryDate, String rentTime, String comment){
        this.FIRSTNAME = firstName;
        this.SURNAME = surName;
        this.ADDRESS = address;
        this.METROSTATION = metroStation;
        this.TELEPHONE = telephone;
        this.DELIVERYDATE = deliveryDate;
        this.RENTTIME = rentTime;
        this.COMMENT = comment;
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
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testOrderWithBottomButton() {
        HomePage homePage = new HomePage(webDriver);
        homePage.scrollToBottomButton();
        homePage.clickToOrderBottomButton();

        ForWhomAboutRentPage forWhomAboutRentPage = new ForWhomAboutRentPage(webDriver);
        forWhomAboutRentPage.closeCookieButton();
        forWhomAboutRentPage.orderPageFirstInput(FIRSTNAME, SURNAME, ADDRESS, METROSTATION, TELEPHONE);
        forWhomAboutRentPage.tapOnBlackCheckBox();
        forWhomAboutRentPage.orderPageSecondInput(DELIVERYDATE, RENTTIME, COMMENT);
        forWhomAboutRentPage.tapToButtonYes();

        assertTrue("Не отображается окно с сообщением об успешном создании заказа.", forWhomAboutRentPage.OrderCompleted());
    }
    @Test
    public void testOrderWithUpButton(){
        HomePage homePage = new HomePage(webDriver);
        homePage.clickToOrderUpButton();

        ForWhomAboutRentPage forWhomAboutRentPage = new ForWhomAboutRentPage(webDriver);
        forWhomAboutRentPage.closeCookieButton();
        forWhomAboutRentPage.orderPageFirstInput(FIRSTNAME, SURNAME, ADDRESS, METROSTATION, TELEPHONE);
        forWhomAboutRentPage.tapOnGreyCheckBox();
        forWhomAboutRentPage.orderPageSecondInput(DELIVERYDATE, RENTTIME, COMMENT);
        forWhomAboutRentPage.tapToButtonYes();

        assertTrue("Не отображается окно с сообщением об успешном создании заказа.", forWhomAboutRentPage.OrderCompleted());
    }
    @After
    public  void tearDown(){

        webDriver.quit();
    }


}
