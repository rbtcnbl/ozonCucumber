package ru.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.annotation.FieldName;
import ru.util.DriverManager;

public class CartPage extends BaseObjectPage {
    private static final String patternForMenuWhenEntered = "//span[contains(text(),'%s')]";


    @FieldName(name = "Корзина")
    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    public WebElement cartBtn;


    @FieldName(name = "Удалить выбранные")
    @FindBy(xpath = "//button[contains(text(),'Удалить выбранные')]")
    public WebElement deleteField;

    @FieldName(name = "Удалить все")
    @FindBy(xpath = "//button[contains(text(),'Удалить все')]")
    public WebElement deleteAll;

    @FieldName(name = "Подтверждение удаления")
    @FindBy(xpath = "//button[contains(@data-test-id,'checkcart-confirm-modal-confirm-button')]")
    public WebElement confirmBtn;

    //span[@class='main']

//div[@class='list'] рамка корзины

    //div[@class= 'modal-container'] рамка удаления товаров


    public void checkEmptyness(){
        new WebDriverWait(DriverManager.getDriver(),15)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'modal-container']")));
        new WebDriverWait(DriverManager.getDriver(),30)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[contains(text(),'Корзина')]")));
        cartBtn.click();

        try{
            WebElement emptyCart = DriverManager.getDriver()
                    .findElement(By.xpath(String.format(patternForMenuWhenEntered,"пуста")));
            new WebDriverWait(DriverManager.getDriver(),30)
                    .until(ExpectedConditions
                            .elementToBeClickable(emptyCart));
        }catch (org.openqa.selenium.NoSuchElementException e){
            Assert.assertNotEquals(" корзина не пуста ","","");
        }
    }
    @Override
    WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.CartPage");
    }
}
