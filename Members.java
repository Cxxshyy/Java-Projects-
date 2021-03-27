/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author djcat
 */
public class JavaPrac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Members [] mem = new Members[20];
        readFile(mem);
        int position = furthest(mem);
        winners (mem,position);
    }
     
     static void readFile(Members[] mem){
        int i;
        String text;
        String[] fields;
        
        try{
            //Specify the file name and path here
            //will create file if it doesn't exist
            File file = new File("members.txt");
            
           
            //open file for reading
            FileReader fr = new FileReader(file);
            BufferedReader textReader = new BufferedReader (fr);

            
            //get data from file and assign to arrays
            for(i=0; i<20;i++){
                //read line from file 
                text = textReader.readLine();
                
                
                
                fields = text.split(",");
                mem[i] = new Members();
                //assign Strings to the appropriate arrays 
                mem[i].name = fields[0];
                mem[i].surname = fields[1];
                mem[i].distance = Double.parseDouble(fields[2]);
                
            }
        //error handling message
        }catch (IOException ioe) {System.out.println("Cannot read file : " + ioe);}
        
        System.out.println("File Read");
    }
    
 
     static int furthest (Members[]mem){
         double max = mem[0].distance;
         int position = 0;
         
         for (int i = 0; i<mem.length; i++){
             if (mem[i].distance>max){
                 max = mem[i].distance;
                 position = i;
             }
             
         }
         return position;
         
     }
     
     

         
         
    static void winners(Members [] mem,int position){  
     try{   
       FileOutputStream fos = new FileOutputStream ("winners.txt");
         //create parallel arrays to store data here
         
         
         try (PrintWriter pw = new PrintWriter(fos)) {
             pw.println("The furthest distance walked is: " + mem[position].distance );
             pw.println("Names of the winners are: " + "," );
              double am = mem[position].distance *0.7;
                for(int i=0; i <mem.length; i++){
                    if (mem[i].distance> am){
                        pw.println(mem[i].name + " " + mem[i].surname );
                        
                 
                    }
                }
         
             
             
             //create parallel arrays to store data here
             
             }
     } catch (IOException ioe) {System.out.println("Write : " + ioe);}
        
   }

    
}       
class Members{
    String name;
    String surname;
    double distance;
    
}

