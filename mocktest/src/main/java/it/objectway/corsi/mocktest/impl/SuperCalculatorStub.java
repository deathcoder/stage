package it.objectway.corsi.mocktest.impl;

import it.objectway.corsi.mocktest.interfaces.SuperCalculatorInterface;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class SuperCalculatorStub implements SuperCalculatorInterface {

    @Override
    public int calc(String action, int a, int b) {
        return 30;
    }
}
