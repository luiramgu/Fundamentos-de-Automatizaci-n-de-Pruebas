package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";

    //elementos
    private By resultsSelector = By.cssSelector(".product-thumb");
    private By noResultsSelector = By.id("content");
    private By addToShoppingCartSelectorSingleItem = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private By shoppingCartButtonSelector = By.xpath("//*[@id=\"cart\"]/button");
    private By checkoutLinkSelector = By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }
    public int getResultsCount(){
        return driver.findElements(resultsSelector).size();
    }
    public boolean isNoResultsVisible(){
        return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);
    }
    public void addToShopingCart(){
        driver.findElement(addToShoppingCartSelectorSingleItem).click();
    }
    private void clickOnShoppingCart(){
        driver.findElement(shoppingCartButtonSelector).click();
    }

    public void clickOnCheckOutWhileOpen (){
        driver.findElement(checkoutLinkSelector).click();
    }
    public void clickOnCheckOutComplete(){
        clickOnShoppingCart();
        clickOnCheckOutWhileOpen();
    }
}
