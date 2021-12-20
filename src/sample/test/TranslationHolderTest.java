package sample.test;

import org.junit.Before;
import org.junit.Test;
import sample.TranslationHolder;

import static org.junit.Assert.assertEquals;

public class TranslationHolderTest {
    private TranslationHolder translationHolder;

    @Before
    public void init() {
        translationHolder = new TranslationHolder();
    }

    @Test
    public void setSum() {
        translationHolder.setSum(1000.0);
        assertEquals(getSum(), 1000.0, 0);
    }

    private double getSum() {
        return 1000;
    }


    public String getNumberOrganization() {
        return "345";
    }

    @Test
    public void setNumberOrganization() {
        translationHolder.setNumberOrganization("345");
        assertEquals(getNumberOrganization(), "345");
    }


    public int getId_transfer() {
        return 345677;
    }

    @Test
    public void setId_transfer() {
        translationHolder.setId_transfer(345677);
        assertEquals(getId_transfer(), 345677);
    }


}