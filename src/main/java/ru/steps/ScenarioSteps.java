package ru.steps;


import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;
import ru.pages.AuthorizationPage;
import ru.pages.MainPage;

import java.util.Map;

import static ru.steps.BaseSteps.pageObject;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MarketSteps marketSteps = new MarketSteps();
    CartSteps cartSteps = new CartSteps();

    @Когда("выбран пункт меню \"(.*)\"")
    public void selectLk(String name) {
        mainSteps.stepSelectEnter();
    }

    @Когда("выбираем вход по почте")
    public void selectGoToEmail() throws Exception {
       authorizationSteps.stepGoToEmail();
    }

    @Когда("заполняем поле \"(.*)\" значением \"(.*)\"")
    public void selectFillMail(String name, String mail) throws Exception {
       authorizationSteps.stepInputMail(name, mail);
    }

    @Когда("заполняем \"(.*)\" значением \"(.*)\"")
    public void selectFillPass(String name, String pass) throws Exception {
        authorizationSteps.stepInputPass(name, pass);
    }

    @Когда("нажимаем \"(.*)\"")
    public void selectEnterBtn(String name) throws Exception {
        authorizationSteps.stepEnterAccount();
    }

    @Когда("вводим в поле \"(.*)\" значение \"(.*)\" и выполняем поиск")
    public void selectSearchLine(String name, String value) throws Exception {
        mainSteps.stepFillSearchLine(name,value);
    }

    @Когда("ограничим \"(.*)\" до \"(.*)\"")
    public void selectMaxPrice(String name, String value) throws Exception {
        marketSteps.stepRangePrice(name, value);
    }

//    @Когда("выделим  \"(.*)\" элемента \"(.*)\"")
//    public void selectPrice(String price) throws Exception {
//        marketSteps.stepCountSum(price);
//        //marketSteps.stepChoisIphone(name);
//    }
    @Когда("добавим товары  \"(.*)\"")
    public void selectIphone(String name) throws Exception {
        marketSteps.stepChoisIphone();
        //marketSteps.stepChoisIphone(name);
    }

    @Когда("добавим товар  \"(.*)\"")
    public void selectHead(String name) throws Exception {
        marketSteps.stepChoisHead();
        //marketSteps.stepChoisIphone(name);
    }

    @Когда("выбираем пункт  \"(.*)\"")
    public void selectCart(String name) throws Exception {
        cartSteps.stepGoToCart();

    }

    @Когда("переходим к очистке  Корзины")
    public void selectCleanCart() throws Exception {
        cartSteps.stepCleanCart();

    }

    @Когда("выходим из Аккаунта")
    public void selectExit() throws Exception {
        mainSteps.stepExitAccount();

    }

    @Когда("выполняем Авторизацию")
    public void selectAutorization() throws Exception {
        mainSteps.stepSelectEnterAgain();
        authorizationSteps.stepGoToEmail();

    }

    @Когда("вводим в поле \"(.*)\" значение \"(.*)\"")
    public void selectFillEmail(String name, String mail) throws Exception {
        authorizationSteps.stepInputMail(name, mail);
    }

    @Когда("вводим в \"(.*)\" значение \"(.*)\"")
    public void selectFillPassword(String name, String pass) throws Exception {
        authorizationSteps.stepInputPass(name, pass);
        authorizationSteps.stepEnterAccount();
    }

    @Когда("проверяем очистилась ли корзина")
    public void selectCheckCart() throws Exception {
        cartSteps.stepCheckEmptyCart();
    }

    @Когда("проверяем список брендов")
    public void selectCheckBrands() throws Exception {
        marketSteps.stepCheckBrands();
    }

}
