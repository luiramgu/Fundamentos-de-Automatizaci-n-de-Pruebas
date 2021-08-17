package PageObjects;
import org.openqa.selenium.WebDriver;

public class PageObjectHandler {

    public WebDriver driver;

    private HeaderPage headerPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SearchResultsPage searchResultsPage;

    public PageObjectHandler(){}

    public HeaderPage headerPage(){
        if(this.headerPage == null)
            headerPage = new HeaderPage(driver);
        return headerPage;
    }
    public LoginPage loginPage(){
        if(this.loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }
    public RegisterPage registerPage(){
        if(this.registerPage == null)
            registerPage = new RegisterPage(driver);
        return registerPage;
    }
    public SearchResultsPage searchResultsPage(){
        if(this.searchResultsPage == null)
            searchResultsPage = new SearchResultsPage(driver);
        return searchResultsPage;
    }
}
