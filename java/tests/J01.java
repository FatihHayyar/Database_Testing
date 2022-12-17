package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class J01 {
//ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void name() throws SQLException {
        DBUtils.getConnection("localhost","DatabaseTesting","postgres","gof7021470");
        Statement sql=DBUtils.getStatement();
        ResultSet cntrl=sql.executeQuery("select isim from ogrenciler where isim='Merve Gul'");
        cntrl.next();
        String name=cntrl.getString("isim");
     Assert.assertEquals("Merve Gul",name);
     DBUtils.closeConnection();
    }
}
