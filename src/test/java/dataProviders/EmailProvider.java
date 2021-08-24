package dataProviders;

import PageObjects.Utils;
import org.testng.annotations.DataProvider;
import pojo.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailProvider {
    @DataProvider(name = "getEmailsAndPasswords")
    private Object[] getEmailsAndPasswords(){
        //Llenamos una lista con emails y passwords random
        List<Email> listaemail= new ArrayList<>();

        for (int i=0;i<3;i++){
          Email email= new Email (Utils.generateRandomEmail(),Utils.generateRandomPassword());
          listaemail.add(email);
        }
        Object[] returnlist = new Object[listaemail.size()];
        for (int i =0;i<returnlist.length;i++){
            returnlist[i] = listaemail.get(i);
        }
       return returnlist;
    }
}
