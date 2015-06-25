package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "/spring/spring-database.xml"
})
@Transactional
public class DaoProductTest {

    @Autowired private ProductDao dao;

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
        logger.trace(dao.getProduct(1));
    }
}