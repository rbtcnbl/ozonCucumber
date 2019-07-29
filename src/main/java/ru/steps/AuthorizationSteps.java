package ru.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pages.AuthorizationPage;
import ru.util.DriverManager;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

    @Step("Выполняем вход по почте")
    public void stepGoToEmail() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(authorizationPage.modalContainer));
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.phoneLine));
        authorizationPage.goToEmailLinkBtn.click();
    }

    @Step("Заполняем почту")
    public void stepInputMail(String name, String mail) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(authorizationPage.emailField));
        authorizationPage.emailField.click();
        authorizationPage.fillField(name, mail);
        //authorizationPage.goToEmailLinkBtn.click();
    }

    @Step("Заполняем пароль")
    public void stepInputPass(String name, String pass) throws Exception {
        //authorizationPage.waitToDOwnload(authorizationPage.modalContainer);
        authorizationPage.passField.click();
        authorizationPage.fillField(name, pass);
        //authorizationPage.goToEmailLinkBtn.click();
    }

    @Step("Входим в аккаунт")
    public void  stepEnterAccount(){
        authorizationPage.enterBtn.click();
    }


@Step("Выполняем авторизацию на сервисе")
    public void stepAutorization(){

}
}

