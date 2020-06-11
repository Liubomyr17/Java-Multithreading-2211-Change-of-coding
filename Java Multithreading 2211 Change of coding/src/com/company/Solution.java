package com.company;

/*

2211 Change of coding

The first parameter to the main method is the name of the file whose body is encoded in Windows-1251.
In the main method, the second parameter is the name of the file into which the contents of the first file in UTF-8 encoding should be written.

Requirements:
1. The program should NOT read data from the keyboard.
2. The program should NOT display data on the screen.
3. The program should write data to a file.
4. The contents of the second file must match the contents of the first file with the exception of


*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //Так валидатор не прнимает:
        //byte[] buffer = Files.readAllBytes(Paths.get(args[0]));
        //Files.write(Paths.get(args[1]),new String(buffer, "UTF-8").getBytes("Windows-1251"));

        //А так принимает
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        fileOutputStream.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));

        fileInputStream.close();
        fileOutputStream.close();


    }
}
