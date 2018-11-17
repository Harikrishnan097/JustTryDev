/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krishnan.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Krishnan
 */
public class FileCon {

    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException, WriteException {
        // Scanner in = new Scanner(new FileReader(""));
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Krishnan\\Desktop\\eval.txt"));
        String date = "May 6 2019";
        ArrayList<String> lcount = new ArrayList<String>();
        ArrayList<String> lamount = new ArrayList<String>();
        ArrayList<Double> lsamount = new ArrayList<Double>();
        ArrayList<Double> lscount = new ArrayList<Double>();
        Pattern patt = Pattern.compile(date);
        String line;
        while ((line = r.readLine()) != null) {
            // For each match in the line, extract and print it.
            Matcher m = patt.matcher(line);
            while (m.find()) {
                // Simplest method:
                // System.out.println(m.group(0));

                // Get the starting position of the text
                //int start = line.start();
                // Get ending position
                //int end = m.end(0);
                // Print whatever matched.
                // Use CharacterIterator.substring(offset, end);
                lcount.add(line.substring(52, 57));
                lamount.add(line.substring(59, 63) + "." + line.substring(63, 66));
            }
        }
        /*ArrayList<String> l = new ArrayList<String>();
        String b[] = new String[100];
        while(in.hasNext())
        {
         String s =in.nextLine();
         l.add(s);
        }
        System.out.println();
        String date ="May 4 2019";
        int len = l.size();
        for(int i=0;i<len;i++)
                {
                     b[i] = l.get(i);
                }
        
       
       // StringBuilder newone = new StringBuilder(b);
       Matcher m = null;
        Pattern patt = Pattern.compile(date);
        for(int i=0;i<len;i++)
                {
                    m = patt.matcher(b[i]);
                }
        
        while (m.find())
        {
             for(int i=0;i<len;i++)
                {
                   System.out.println(b[i].substring(52,59));
                }
            
        
        }
        //DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.UK);
       // Date date = format.parse(b);
        //System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010  
         */

        System.out.print("old string:" + lcount + "  " + lamount);

        for (int i = 0; i < lcount.size(); i++) {
            lscount.add(Double.parseDouble(lcount.get(i)));
        }
        for (int i = 0; i < lamount.size(); i++) {
            lsamount.add(Double.parseDouble(lamount.get(i)));
        }

        System.out.print(lscount + "  " + lsamount);

       Double totalscount = lscount.stream().mapToDouble(Double::doubleValue).sum();
         System.out.print( "  total count is" + totalscount);
         Double totalamount = lsamount.stream().mapToDouble(Double::doubleValue).sum();
         System.out.print( "  total count is" + totalamount);
         
         
         
         File f = new  File("C:\\Users\\Krishnan\\Desktop\\excel.xls");
         WritableWorkbook wb = Workbook.createWorkbook(f);
         WritableSheet mysheet = wb.createSheet("mine",0);
         Label l= new Label(0,0,"totalscount");
         Label l2 = new Label(0,1,"total amount");
         Label l3= new Label(1,0 ,String.valueOf(totalscount));
         Label l4 = new Label(1,1,String.valueOf(totalamount));
         mysheet.addCell(l);
         mysheet.addCell(l2);
         mysheet.addCell(l3);
         mysheet.addCell(l4);
         wb.write();
         wb.close();
         System.out.print("finished");
         
         
         
         
    }
}
