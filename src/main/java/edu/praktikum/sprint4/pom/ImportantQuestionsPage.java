package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ImportantQuestionsPage {

    private WebDriver webDriver;

    public ImportantQuestionsPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    //Массив корректных ответов из списка "Вопросы о важном"
    public static final String[] ANSWERS = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                                            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                                            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                                            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                                            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                                            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                                            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                                            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    //Массив локаторов вопросов из списка "Вопросы о важном"
    private  final  By[] locatorsQuestions = {By.xpath(".//div[@class='accordion']/div[1]"),
                                              By.xpath(".//div[@class='accordion']/div[2]"),
                                              By.xpath(".//div[@class='accordion']/div[3]"),
                                              By.xpath(".//div[@class='accordion']/div[4]"),
                                              By.xpath(".//div[@class='accordion']/div[5]"),
                                              By.xpath(".//div[@class='accordion']/div[6]"),
                                              By.xpath(".//div[@class='accordion']/div[7]"),
                                              By.xpath(".//div[@class='accordion']/div[8]")
    };

    //Массив локаторов ответов из списка "Вопросы о важном"
    private  final  By[] locatorsAnswers = {By.xpath(".//div[@id='accordion__panel-0']/p"),
                                            By.xpath(".//div[@id='accordion__panel-1']/p"),
                                            By.xpath(".//div[@id='accordion__panel-2']/p"),
                                            By.xpath(".//div[@id='accordion__panel-3']/p"),
                                            By.xpath(".//div[@id='accordion__panel-4']/p"),
                                            By.xpath(".//div[@id='accordion__panel-5']/p"),
                                            By.xpath(".//div[@id='accordion__panel-6']/p"),
                                            By.xpath(".//div[@id='accordion__panel-7']/p")
    };

    //Скролл до списка "Вопросы о важном"
    public void scrollListAnswers(int locator) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(locatorsQuestions[locator]));

    }

    //Метод для клика на поле списка "Вопросы о важном"
    public void clickListAnswers(int locator) {

        webDriver.findElement(locatorsQuestions[locator]).click();
    }

    public void scrollAndClickListAnswers(int locator){
        scrollListAnswers(locator);
        clickListAnswers(locator);
    }

    //Метод возвращает текст ответов из списка "Вопросы о важном"
    public String answersListText(int number){

        return webDriver.findElement(locatorsAnswers[number]).getText();
    }


}

