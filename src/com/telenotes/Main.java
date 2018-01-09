package com.telenotes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.out.print("Hello!");
        int count = 0;

        // Continue process
        while (count < 10) {


//        FileWriter fWriter = null;
//        BufferedWriter writer = null;
//        try {
//            fWriter = new FileWriter("tele.html");
//            writer = new BufferedWriter(fWriter);
//            writer.write(html);
//            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
//            writer.close(); //make sure you close the writer object
//        } catch (Exception e) {
//            //catch any exceptions here
//            System.out.println("Failed");
//        }

            // get data
            try {
                DarDao darDao = DarDao.getInstance();
            } catch (Exception e) {
                System.out.println("Couldn't connect to the db. Try again");
            }

            System.out.println("done");

            Thread.sleep(10000);
            count++;
        }
    }


}
