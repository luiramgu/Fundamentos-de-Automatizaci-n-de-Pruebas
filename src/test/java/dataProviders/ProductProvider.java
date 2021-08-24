package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.Products;
import pojo.UserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductProvider {
    @DataProvider(name = "geProductsDataFromJson")
    private Object[] geProductsDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/testData/products.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<Products> testData = new Gson().fromJson(dataSet, new TypeToken<List<Products>>() {}.getType());
        Object[] returnValue = new Object[testData.size()];
        int index = 0;
            for (int i = 0; i< testData.size();i++){
                returnValue[i] = testData.get(i);
            }
        return returnValue;
    }
}
