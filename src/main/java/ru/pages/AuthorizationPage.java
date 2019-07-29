package ru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.annotation.FieldName;

public class AuthorizationPage extends BaseObjectPage {

    @FieldName(name = "Окно авторизации")
    @FindBy(xpath = "//div[@class ='modal-container']")
    public WebElement modalContainer;

    @FieldName(name = "Заполните телефон")
    @FindBy(xpath = "//input[@data-test-id = 'phoneLoginField']")
    public WebElement phoneLine;

    @FieldName(name = "Войти по почте")
    @FindBy(xpath = "//a[contains(@data-test-id, 'goToEmailLink')]")
    public WebElement goToEmailLinkBtn;

    @FieldName(name = "Почта")
    @FindBy(xpath = "//input[@data-test-id = 'emailField']")
    public WebElement emailField;

    @FieldName(name = "Пароль")
    @FindBy(xpath = "//input[@data-test-id = 'passwordField']")
    public WebElement passField;

    @FieldName(name = "Войти")
    @FindBy(xpath = "//button[text()='Войти']")
    public WebElement enterBtn;

    @FieldName(name = "Личный кабинет")
    @FindBy(xpath = "//div[contains(@class, '_327ec')]")
    public WebElement accountFrame;

    @FieldName(name = "Выход")
    @FindBy(xpath = "//button[@class='eda59']")
    public WebElement exitBtn;

    @Override
    WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.AuthorizationPage");
    }
}
