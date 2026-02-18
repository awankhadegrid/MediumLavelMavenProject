package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppTest extends TestCase
{
    @Test
    void encryptUnicodeTest(){

        String[] args = {
                "-mode", "enc",
                "-key", "2",
                "-in","src/main/java/org/example/in.txt",
                "-out","src/main/java/org/example/out.txt",
                "-data", "abc",
                "-alg", "unicode"
        };
        String actual= App.encryptUnicode("abc",2);

        assertEquals("cde",actual);

        App.main(args);
    }

    @Test
    void decryptUnicodeTest(){

        String[] args = {
                "-mode", "dec",
                "-key", "2",
                "-data", "cde",
                "-alg", "unicode"
        };

        App.main(args);
        String actual=App.decryptUnicode("cde",2);
        assertEquals("abc",actual);


    }

    @Test
    void encryptShiftTest(){

        String[] args = {
                "-mode", "enc",
                "-key", "2",
                "-data", "xyz"
        };
        App.main(args);

        String actual = App.encryptShift("xyz",2);
        assertEquals("zab",actual);
    }

    @Test
    void decryptShiftTest(){
        String[] args = {
                "-mode", "dec",
                "-key", "2",
                "-data", "zab"
        };

        App.main(args);

        String actual = App.decryptShift("zab",2);
        assertEquals("xyz",actual);
    }

    @Test
    public void testShiftWithSymbols() {

        String[] args = {
                "-mode", "enc",
                "-key", "5",
                "-data", "Hello, World!"
        };

        App.main(args);
        String actual =App.encryptShift("Hello, World!",5);

        assertEquals("Mjqqt, Btwqi!", actual);
    }




}
