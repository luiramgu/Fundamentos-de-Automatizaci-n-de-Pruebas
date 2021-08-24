package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage{

    public String ProductNameLocator = "//div[@id='content']//a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<name>')]";
    private WebElement productRow;
    private By inputRowSelector = By.cssSelector("input");
    private By imageSelector = By.cssSelector("img");
    private By shoppingCartRows = By.xpath("//div[@id='content']//div[contains(@class, 'table-responsive')]//tr");
    private By alertMessageLocator = By.xpath ("//*[@id='checkout-cart']/div[1]");
    private By totalPriceAmountLocator = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]");


    public ShoppingCartPage(WebDriver _driver){
        super(_driver);
    }

    public String getTotalPriceAmountLocator() {
        return driver.findElement(totalPriceAmountLocator).getText();

    }

    public boolean isAlertMessageLocator (){
        String failMessage= "Products marked with *** are not available in the desired quantity or not in stock!";
        boolean aux = true;

        if (driver.findElement(alertMessageLocator).getText().contains(failMessage)){
            aux = true;
        }
        return aux;
    }
    public boolean isProductNameDisplayed(String name){
        return driver.findElement(By.xpath(ProductNameLocator.replace("<name>", name))).isDisplayed();
    }
    public int getProductQuantity(){
        return Integer.parseInt(driver.findElement(ProductQuantityLocator).getAttribute("value"));
    }
    public boolean isProductRowDisplayed(String name){
        this.productRow =
                driver.findElement(
                        By.xpath(productRowLocator.replace("<name>", name)));
        return this.productRow.isDisplayed();
    }
    public int getProductRowQuantity(){
        String sAmount = productRow.findElement(inputRowSelector)
                .getAttribute("value");
        return Integer.parseInt(sAmount);
    }
    public String getProductImageURL(){
        String imageURL = productRow.findElement(imageSelector)
                .getAttribute("src");
        return imageURL;
    }
    public int getAmountOfShoppingCartRows(){
        return driver.findElements(shoppingCartRows).size() - 1;
    }
}
