package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.SearchData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchProvider {
    @DataProvider(name = "getSearchData")
    private Object[][] getSearchData(){
        return new Object[][]{
                {new SearchData("macbook", 3)},
                {new SearchData("Star Wars", 0)}
        };
    }
    @DataProvider(name = "getSearchData1")
    private Object[][] getSearchData1(){
        return new Object[][]{
                {new SearchData("macbook", 3)}
        };
    }


    @DataProvider(name = "getSearchDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/testData/search.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<SearchData> testData = new Gson().fromJson(dataSet, new TypeToken<List<SearchData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name = "getSearchDataFromPSQLDB")
    private Object[][] getSearchDataFromPSQLDB(){
        String url = "jdbc:postgresql://10.0.1.172:5432/FundamentosQA";
        String dbUsername = "juan.piedra";
        String dbPassword = "asdf";
        String SQLCommand = "SELECT searchCriteria, expectedResults FROM public.searchCriterias;";
        List<SearchData> testData = new ArrayList<>();
        int i = 0;
        Connection conn;
        try{
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand);
            do {
                resultSet.next();
                SearchData row = new SearchData(resultSet.getObject(1).toString(), resultSet.getInt(2));
                testData.add(row);
                i++;
            } while (!resultSet.isLast());
        }
        catch (Exception e){
            System.out.println("Error al conectarse a la base de datos\n" + e.getMessage());
        }
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;

    }
}
