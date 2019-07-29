package ru.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.annotation.FieldName;


import java.util.List;

public class MarketPage extends BaseObjectPage {

    @FieldName(name = "Страница магазина")
    @FindBy(xpath = "//div[@class='block-vertical']")
    public WebElement requestLine;

    @FieldName(name = "Максимальная цена")
    @FindBy(xpath = "//input[@data-test-id='range-filter-to-input']")
    public WebElement rangePrice;

    @FieldName(name = "Iphone")
    @FindBy(xpath = "//div[@class='paginator column__item_remove-margin']//*[@data-index]/following::button")
    //@FindBy(xpath = "//span[text()='от 13 до 60 000']")
    public List<WebElement> phoneCollection;

    @FindBy(xpath = "//span[text()='от 13 до 60 000']/ancestor::div[@class='filter']")
    public WebElement line;

    @FieldName(name = "В корзину")
    @FindBy(xpath = "//div[@data-index='1']//button[@class='button blue enlarged buy-text-button']")
    public WebElement cartBtn;

    @FieldName(name = "Цена")
    @FindBy(xpath = "//div[@data-index]//span[@data-test-id='tile-price']")
    public List<WebElement> priceField;

    @FieldName(name = "Просмотреть все")
    @FindBy(xpath = "//div[@data-test-id='filter-block-brand']//span[contains(text(),'Посмотреть все')]")
    public WebElement brandsList;

    @FieldName(name = "Beats")
    @FindBy(xpath = "//span[contains(text(),'Beats')]")
    public WebElement beatsCheck;

    @FieldName(name = "Samsung")
    @FindBy(xpath = "//span[contains(text(),'Samsung')]")
    public WebElement samsungCheck;

    public int getPrice(String price) {
        for (WebElement item : priceField) {
            if (item.findElement(By.xpath(".//div[@data-index]")).getAttribute("data-index").equalsIgnoreCase(price)) {
                String el = item.getText().replaceAll("\u20BD", "");
                int totalPrice = Integer.parseInt(el);
                return totalPrice;
            }
        }
        Assert.fail("Не найден товар - " + price);
        return 0;
    }
//    public void getPrice(WebElement element){
//         String el = element.getText().replaceAll("\u20BD", "");
//         int totalPrice = Integer.parseInt(el);
//    }

    @Override
    public WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.MarketPage");
    }
}
