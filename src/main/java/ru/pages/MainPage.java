package ru.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.annotation.FieldName;
import ru.util.DriverManager;

import java.util.List;

public class MainPage extends BaseObjectPage {

    @FieldName(name = "Авторизация")
    @FindBy(xpath = "//div[contains(@class, '_651b6 _8f882')]")
    public WebElement enterBtn;

    @FieldName(name = "Корзина")
    @FindBy(xpath = "//a[contains(@data-test-id, 'header-cart')]")
    public WebElement cartBtn;

    @FieldName(name = "Поиск по Ozon")
    @FindBy(xpath = "//input[@class='search-input']")
    public WebElement searchLine;

    @FieldName(name = "Найти")
    //@FindBy(xpath = "//div[@data-test-id='suggestions-item']")
    @FindBy(xpath = "//button[@data-test-id='header-search-go']")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@class='suggestion-group']")
    public WebElement frameSearch;

    @FieldName(name = "Выход")
    @FindBy(xpath = "//button[@class='eda59']")
    public WebElement exitBtn;


    @Override
    WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.MainPage");
    }
}
