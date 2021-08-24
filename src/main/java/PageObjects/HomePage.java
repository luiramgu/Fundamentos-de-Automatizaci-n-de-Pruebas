package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By SearchBarLocator = new By.ByXPath("//div/input[contains(@name,'search')]");
    private By SearchButtonLocator = new By.ByXPath("//button[contains(@class,'btn-default')]");

    public HomePage(WebDriver _driver){
        super(_driver);
    }

    public String getFirstProductName(){
        return driver.findElement(HomePageLocators.FirstProductTitleSelector).getText();
    }
    public void selectProductByName(String name){
        driver.findElement(By.xpath(HomePageLocators.FirstH4Locator.replace("<name>", name))).click();
    }
    public String selectFirstProductAndGetName(){
        String name = getFirstProductName();
        selectProductByName(name);
        return name;
    }
    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

    public void LookForSearchCriteria (String criteria){
        driver.findElement(SearchBarLocator).sendKeys(criteria);
        driver.findElement(SearchButtonLocator).click();

    }

}
