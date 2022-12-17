package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class J02
{
//Yazili not ortalamasının 90dan kucuk oldugunu test edın

    @Test
    public void name() throws SQLException {
        DBUtils.getConnection("localhost","DatabaseTesting","postgres","gof7021470");
        Statement sql=DBUtils.getStatement();
        ResultSet cntrl=sql.executeQuery("select avg(yazili_notu) from ogrenciler");
        cntrl.next();
        double not=cntrl.getInt(1);
        Assert.assertTrue(not<90);
        DBUtils.closeConnection();

    }
}
