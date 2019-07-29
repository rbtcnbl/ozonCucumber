package ru.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pages.MarketPage;
import ru.util.DriverManager;


public class MarketSteps {
    MarketPage marketPage = new MarketPage();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);


    @Step("Цена ограничена до - {1}")
    public void stepRangePrice(String name, String value) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(marketPage.rangePrice));
        marketPage.rangePrice.click();
        marketPage.rangePrice.sendKeys(Keys.CONTROL + "a");
        marketPage.rangePrice.sendKeys(Keys.DELETE);
        marketPage.rangePrice.sendKeys(value);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//input[@data-test-id='range-filter-to-input']"), "60000"));
        marketPage.rangePrice.sendKeys(Keys.ENTER);

    }

//    @Step("Подсчитываем сумму товара")
//    public void stepCountSum(String price) throws Exception {
//        wait.until(ExpectedConditions.visibilityOf(marketPage.line));
//        marketPage.getPrice(price);
//    }

    @Step("Добавляем товары в корзину")
    public void stepChoisIphone() throws ClassNotFoundException {
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='1']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='3']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='5']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='7']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='9']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='11']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='13']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='15']//button[@class='button blue enlarged buy-text-button']")));
    }

    @Step("Добавляем товар в корзину")
    public void stepChoisHead() throws ClassNotFoundException {
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='0']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='2']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='4']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='6']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='8']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='10']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='12']//button[@class='button blue enlarged buy-text-button']")));
        marketPage.scrollAndClick(DriverManager.getDriver().findElement(By.xpath("//div[@data-index='14']//button[@class='button blue enlarged buy-text-button']")));
    }

    @Step("Выбираем список брендов")
    public void stepCheckBrands(){
        marketPage.scrollAndClick(marketPage.brandsList);
        wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.xpath("//div[@class='search-show-container']"))));
        marketPage.scrollAndClick(marketPage.beatsCheck);
        marketPage.scrollAndClick(marketPage.samsungCheck);
    }
}
