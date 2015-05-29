package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class DaoProductTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testGetProductList() {
        LogManager logger = new LogManagerImpl(this.getClass());
        Object printme = logger;
        System.out.println(printme.getClass());
    }
}