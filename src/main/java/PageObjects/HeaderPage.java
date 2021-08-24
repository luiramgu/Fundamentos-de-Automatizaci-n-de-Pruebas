package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");
    private By LogOutButtonLocator = By.linkText("Logout");
    private By currencyChangerButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/button");
    private By currencyDolarsLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");
    private By currencyEuroLocator =By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    private By currencyPoundLocator =By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");


    public HeaderPage(WebDriver _driver){
        super(_driver);
    }
    private void clickOnCurrency(){
        driver.findElement(currencyChangerButtonLocator).click();
    }
    public void changeCurrencyToDollars(){
        clickOnCurrency();
        driver.findElement(currencyDolarsLocator).click();
    }
    public void changeCurrencytoEuros(){
        clickOnCurrency();
        driver.findElement(currencyEuroLocator).click();
    }
    public void changeCurrencytoPounds(){
        clickOnCurrency();
        driver.findElement(currencyPoundLocator).click();
    }
    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }
    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}

    public boolean CanLogOut (){
        clickOnMyAccount();

        boolean aux =  false;
        if (driver.findElement(LogOutButtonLocator).isDisplayed()){
            aux = true;
        }
        return aux;
    }
}
