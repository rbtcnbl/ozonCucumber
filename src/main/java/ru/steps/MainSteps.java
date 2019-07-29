package ru.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pages.MainPage;
import ru.util.DriverManager;

public class MainSteps {

    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

    @Step("Выбираем пункт Войти")
    public void stepSelectEnter() {
        mainPage.enterBtn.click();
    }

    @Step("Заполняем строку поиска значением - {1}")
    public void stepFillSearchLine(String name, String text) throws ClassNotFoundException {
        mainPage.fillField(name, text);
        //wait.until(ExpectedConditions.visibilityOf(mainPage.frameSearch));
        mainPage.searchLine.sendKeys(Keys.ENTER);
        //mainPage.searchBtn.click();
//mainPage.find(text);
    }

    @Step("Выходим из аккаунта")
    public void stepExitAccount() {
        mainPage.enterBtn.click();
        wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.xpath("//div[contains(@class, '_327ec')]"))));
        mainPage.exitBtn.click();
    }

    @Step("Выбираем вновь пункт Войти")
    public void stepSelectEnterAgain() {
        wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.xpath("//span[contains(text(), 'Войти')]"))));
        mainPage.enterBtn.click();
    }

}
