package ru.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pages.CartPage;
import ru.util.DriverManager;

public class CartSteps {

    CartPage cartPage = new CartPage();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);


    @Step("Выполнен переход в корзину")
    public void stepGoToCart(){
        cartPage.cartBtn.click();
    }

    @Step("Удалены все товары")
    public void stepCleanCart(){
        //wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.xpath("//div[@class='list']"))));
        cartPage.deleteField.click();
        //wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.xpath("//div[@class= 'modal-container']"))));
        cartPage.confirmBtn.click();
    }

    @Step("Проверка пустой корзины")
    public void stepCheckEmptyCart(){
        cartPage.checkEmptyness();
    }

}
