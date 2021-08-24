package PageObjects;

import com.sun.org.apache.xpath.internal.Arg;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Utils {
    private final String[] domains = {"gmail.com","msn.com","yahoo.com","microsoft.com","ucreativa.com",
                                "outlook.com","statefarm.com","riotgames.comdr"};
    private final String validChars ="1234567890abcdefghijklmnopqrstuvwxyz";

    private String generateRandomDomain (){
        Random random = new Random();
        return this.domains[random.nextInt(this.domains.length)];
    }

    private String generateRandomBody(){
        Random random = new Random();
        String body="";

        for (int i = 0; i < 8; i++) {
            body = body + validChars.charAt(random.nextInt(validChars.length()));
        }
        return body;
    }

    private   String generateRandomPasswordInternal (){
        Random random = new Random();
        String password="";

        for (int i = 0; i < 16; i++) {
            password = password + validChars.charAt(random.nextInt(validChars.length()));
        }
        return password;
    }

    public static String generateRandomPassword (){
        Utils pswd = new Utils();
        return pswd.generateRandomPasswordInternal();
    }

    public static String generateRandomEmail() {
        Utils email = new Utils();
        return email.generateRandomBody() + "@" + email.generateRandomDomain();
    }

    public static void waitForElement (WebDriver driver, By elementlocator){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementlocator));
    }
    public static Double limpiaCurrency (String value){
        //Recibe un valor con un currency devuelve unicamente el valor sin el currency
        String precio="";
        precio = value.replace('.',',');
        if (value.contains("$")){
            precio = value.replace("$","");
        }
        if (value.contains("€")){
            precio = value.replace("€","");
        }
        if (value.contains("£")){
            precio = value.replace("£","");
        }

        return Double.parseDouble(precio);
    }
}
