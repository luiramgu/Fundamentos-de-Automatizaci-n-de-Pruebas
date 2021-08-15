package selenium;
import PageObjects.BaseClass;
import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.apache.commons.io.FileUtils.readFileToByteArray;

public class TestSearch extends BaseClass {
    SearchData testData;

    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        // Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expecting %s results, but got %s", expectedResult, results.size()));

        Assert.assertEquals(getResults(), results,
                "Expecting " + expectedResult + " results, but got " + getResults());
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expecting %s results, but got %s", expectedResult, results.size()));

        Assert.assertEquals(getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + getResults());
    }

    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }

    @Test (dataProvider = "getSearchDataFromPSQLDB", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        this.testData = testData;
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getExpectedResults());
        }
        else{
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
        }
    }

    @AfterMethod
    public void AfterMethod() {
        try {
            PrintTestData();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        super.AfterMethod();
    }

    @Attachment(value = "TestData", type = "text/plain", fileExtension = ".txt")
    public byte[] PrintTestData() throws IOException {
        File file = new File("src/main/resources/results.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Search Criteria: " + testData.getSearchCriteria() + ", Expected Results: " + this.testData.getExpectedResults());
            fileWriter.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return readFileToByteArray(file);
    }

    /**
     * String = "Juan"
     *
     * String[] = ["Juan", "Pablo", "Piedra"]
     *
     *
     * String[][]
     * Nombre Apellido Correo
     * Juaun    Piedra  juan@piedra
     *
     * */
}
