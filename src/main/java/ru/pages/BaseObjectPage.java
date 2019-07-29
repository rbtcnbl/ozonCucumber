package ru.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.annotation.FieldName;
import ru.util.DriverManager;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class BaseObjectPage {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);


    public BaseObjectPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement getField(String name, String className) throws ClassNotFoundException {
        Class classExample = Class.forName(className);
        List<Field> fields = Arrays.asList(classExample.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equals(name)) {
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    abstract WebElement getField(String name) throws ClassNotFoundException;

    public void fillField(String name, String value) throws ClassNotFoundException {
        WebElement element = getField(name);
        element.clear();
        element.sendKeys(value);
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void click(String name) throws ClassNotFoundException {
        WebElement element = getField(name);
        click(element);
    }

    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        //js.executeScript("window.scrollBy(0,250)");
        js.executeScript("return arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



    public void selectItem(List<WebElement> items, String name) {
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(name)) {
                item.click();
                return;
            }
        }

        Assert.fail("Не найден элемент коллекции с наименованием" + name);
    }



    public void waitToDOwnload(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 5000, 200);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }





}


