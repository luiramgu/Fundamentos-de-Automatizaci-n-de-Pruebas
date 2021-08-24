package selenium;

import PageObjects.*;
import dataProviders.ProductProvider;
import dataProviders.SearchProvider;
import pojo.Products;
import selenium.BaseClass;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        int quantity = 5;
        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");
    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }

    @Description ("Segunda Prueba del Proyecto Final")
    @Test
    private void CantCheckoutProduct (){
        String searchCriteria = "MacBook Air";
        HomePage homePage = new HomePage(driver);
        homePage().LookForSearchCriteria(searchCriteria);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.isProductNameDisplayed(searchCriteria);
        searchResultsPage().addToShopingCart();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCartButton();
        Assert.assertTrue(shoppingCartPage.isAlertMessageLocator());
        }

    @Description("Tercer Caso de Prueba del Proyecto Final")
    @Test(dataProvider ="geProductsDataFromJson", dataProviderClass = ProductProvider.class)
    public void TestProductCurrency (Products testProduct){
        //Agregamos el item al carrito
        int quantity = 1;
        HomePage homePage =new HomePage(driver);
        homePage.LookForSearchCriteria(testProduct.getProduct());

        String name = homePage().selectFirstProductAndGetName();
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        //Vamos a hacer checkout para validar los precios son correctos
        headerPage().clickOnCartButton();


        //Cambiamos el currency
        headerPage().changeCurrencyToDollars();
        String dolarTotalAmount = shoppingCartPage().getTotalPriceAmountLocator();
        headerPage().changeCurrencytoEuros();
        String euroTotalAmount =shoppingCartPage().getTotalPriceAmountLocator();
        headerPage().changeCurrencytoPounds();
        String poundTotalAmount=shoppingCartPage().getTotalPriceAmountLocator();

        //Assertions
        double dolar= Utils.limpiaCurrency(dolarTotalAmount);
        double euro =Utils.limpiaCurrency(euroTotalAmount);
        double pound=Utils.limpiaCurrency(poundTotalAmount);
        Assert.assertEquals(dolar,testProduct.getDolarsPrice());
        Assert.assertEquals(euro,testProduct.getEuroPrice());
        Assert.assertEquals(pound,testProduct.getPoundsPrice());
    }

}
