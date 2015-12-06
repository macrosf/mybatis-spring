package com.mybatis3.mybatis_spring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class MyTest {

    @Test
    public void testFileIo(){
    	try {
			BufferedWriter out = new BufferedWriter(new FileWriter("findme.txt"));
			out.write("test\n");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
