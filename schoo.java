/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

/**
 *
 * @author djcat
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class School {

    public static void main(String[] args) {
	// write your code here
        String[] name = new String[6];
        String[] phoneNo = new String[6];
        int[] GroupSize = new int[6];
        int[] rating = new int[6];

        readFile(name, phoneNo, GroupSize, rating);
        largestGroupSize(GroupSize);
        ratingCategory(rating);
        CustomerDetails(name, phoneNo, GroupSize, rating);
    }

    static void readFile(String [] name, String[]phoneNo, int[]GroupSize,int[]rating) {

        int i;
        String text;
        String[] fields;
        try {
            //Specify the file name and path here
            File file = new File("Log Data.csv");

            //open file for reading
            FileReader fr = new FileReader(file);
            BufferedReader textReader = new BufferedReader(fr);

            //WRITE CODE to assign data from file to arrays
            for (i = 0; i < 6; i++) {
                text = textReader.readLine();

                fields = text.split(",");


                name[i] = fields[0];
                phoneNo[i] = fields[1];
                GroupSize[i] = Integer.parseInt(fields[2]);
                rating[i] = Integer.parseInt(fields[3]);
            }


            //error handling message
        } catch (IOException ioe) {
            System.out.println("Cannot read file : " + ioe);
        }

        //file read sucessfully
        System.out.println("File Read");
    }

    static void largestGroupSize (int[]GroupSize){
        int max = GroupSize[0];
        for(int i = 0; i < GroupSize.length; i++){
            if(GroupSize[i]> max){
                max = GroupSize[i];
            }
        }
    System.out.println("The largest group size tonight was: " + max);
}

    static void ratingCategory(int[]rating){
        int poorCount = 0;
        int goodCount = 0;
        int Excellentcount = 0;
        for (int i = 0; i < rating.length; i++){
            if(rating[i]>=1 && rating[i]<=3){
                poorCount++;
            }
            else if (rating[i]>=4 && rating[i]<=6){
                goodCount++;


            }
            else if(rating[i]>=7 && rating[i]<=10){
                Excellentcount++;

            }

        }
        System.out.println("The customers rated tonight's meal as: ");
        System.out.println("Poor: " + poorCount);
        System.out.println("Good: " + goodCount);
        System.out.println("Excellent: " + Excellentcount);


    }
    static void CustomerDetails(String [] name, String[]phoneNo, int[]GroupSize,int[]rating){
        int pos = 0;
        for (int i = 0; i < rating.length; i++){
            if(rating[i]<=3){
                pos = i;
                System.out.println("Contact Name: " + name[pos]);
                System.out.println("TelePhone Number: " + phoneNo[pos]);
                System.out.println("Rating: " + rating[pos]);
            }
        }


    }



}

