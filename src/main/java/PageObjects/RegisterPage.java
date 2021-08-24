package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    //private WebDriver driver;

    //Elementos
    private By NameLocator = By.name("firstname");
    private By LastNameLocator = By.name("lastname");
    private By EmailLocator = By.name("email");
    private By TelephoneLocator = By.name("telephone");
    private By PasswordLocator = By.name("password");
    private By ConfirmLocator = By.name("confirm");
    //private By ConfirmRegisterMessageLocator = By.xpath("//div[contains(@id,'content')]/h1");
    private By ConfirmRegisterMessageLocator = By.id("content");
    private By TermsCheckBoxLocator = By.name("agree");
    private By ContinueButtonLocator = By.xpath("//input[@value='Continue']");



    public RegisterPage(WebDriver _driver){

        super(_driver);
    }
    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }



    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(NameLocator).sendKeys(firstName);
        driver.findElement(LastNameLocator).sendKeys(lastName);
        driver.findElement(EmailLocator).sendKeys(email);
        driver.findElement(TelephoneLocator).sendKeys(telephone);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(ConfirmLocator).sendKeys(password);
        driver.findElement(TermsCheckBoxLocator).click();
        driver.findElement(ContinueButtonLocator).click();
    }

    public String GetConfirmationMessage(){
        //Utils.waitForElement(driver,ConfirmRegisterMessageLocator);
        WebElement tittleContainer=driver.findElement(ConfirmRegisterMessageLocator);
        WebElement tittle=tittleContainer.findElement(By.cssSelector("h1"));
        String tittleContent=tittle.getText();

       return tittleContent;
       // return driver.findElement(ConfirmRegisterMessageLocator).getText();

    }


}
