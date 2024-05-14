package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.ImportantQuestionsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

import static java.time.temporal.ChronoUnit.SECONDS;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
    private WebDriver webDriver;
    private final int number;

    public ImportantQuestionsTest(int number) {

        this.number = number;
    }

    //Подставляем все вопросы и ответы
    @Parameterized.Parameters(name= "Тестовый набор данных: {0} {1} {2} {3} {4} {5} {6} {7}")
    public  static  Object[][] getNumber() {
        return new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        };
    }

    @Before
    public void setup() {
        //webDriver = new ChromeDriver();
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void questionList(){
        ImportantQuestionsPage importantQuestionsPage = new ImportantQuestionsPage(webDriver);
        importantQuestionsPage.scrollAndClickListAnswers(number);
        assertEquals("Текст не соответствует", ImportantQuestionsPage.answers[number], importantQuestionsPage.answersListText(number));
    }

    @After
    public void tearDown(){

        webDriver.quit();
    }


}
