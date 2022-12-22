package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        App subject = new App();
        int c = subject.add(1, 2);
        assertEquals(c, 3);
    }
}
