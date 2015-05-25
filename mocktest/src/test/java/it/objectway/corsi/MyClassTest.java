package it.objectway.corsi;

import it.objectway.corsi.mocktest.MyClass;
import it.objectway.corsi.mocktest.impl.SuperCalculatorStub;
import it.objectway.corsi.mocktest.interfaces.SuperCalculatorInterface;
import org.junit.Test;

import java.util.Date;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class MyClassTest {

    private MyClass testMe = new MyClass();

    @Test
    public void testDoSomething() throws Exception {
        /* test a + b concatenation */
        assertEquals("ciao test", testMe.doSomething("ciao ", "test", true));

        /* test b + a concatenation */
        assertEquals("test 123", testMe.doSomething("123", "test ", false));

        /* test null cases */
        assertEquals("OK", testMe.doSomething(null, "test", true));
        assertEquals("OK", testMe.doSomething("ciao ", null, true));
        assertEquals("OK", testMe.doSomething(null, null, true));
    }

    @Test
    public void testCalculate() throws Exception {
        /* test sum */
        assertEquals(15, testMe.calculate("sum", 5, 10));

        /* test with supercalculator stub */
        testMe.setSuperCalculator(new SuperCalculatorStub());
        assertEquals(50, testMe.calculate("supercalculate", 5, 10));
    }

    @Test
    public void testMockCalculate() throws Exception {
        /* test sum */
        assertEquals(15, testMe.calculate("sum", 5, 10));

        /* test with supercalculator stub */
        SuperCalculatorInterface mock = createMock(SuperCalculatorInterface.class);
        String action = "mult";
        expect(mock.calc(action, 5, 10)).andReturn(50);
        replay(mock);
        testMe.setSuperCalculator(mock);
        assertEquals(50, testMe.calculate(action, 5, 10));
        verify(mock);
    }

    @Test
    public void testRetrieveDate() throws Exception {
        /* test date 10s greater than now */
        Date futureDate = new Date(new Date().getTime() + 10000);
        assertEquals(futureDate, testMe.retrieveDate(futureDate));

        /* test older date, should return a date 1s greater than now */
        Date now = new Date();
        Date twoSecsLater = new Date(new Date().getTime() + 2000);
        Date result = testMe.retrieveDate(now);
        assertTrue(result.after(now) && result.before(twoSecsLater));
    }

    @Test
    public void testMockRetrieveDate() throws Exception {
        /* test date 10s greater than now */
        Date now = new Date();

        MyClass mock = createMockBuilder(MyClass.class)
                .addMockedMethod("getNow")
                .createMock();

        expect(mock.getNow()).andReturn(now);

        replay(mock);

        assertEquals(now, mock.retrieveDate(now));

        verify(mock);
    }
}