import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class main_test_testng_parameters {
    @Parameters({"firstName","lastName"})
    @Test
    public void testConstructor(String firstName, String lastName){
        System.out.println("Mi nombre es: " + firstName);
        Persona persona = new Persona(firstName, lastName);
        Assert.assertEquals(persona.getFullName(), "Ahsoka Tano");
    }
}
