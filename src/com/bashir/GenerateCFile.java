package com.bashir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class GenerateCFile {

    FileOutputStream fout=null;
    FileInputStream fin = null;

    public GenerateCFile()throws FileNotFoundException {
        fout = new FileOutputStream(new File("main.c"));
    }



    public void startIt() throws IOException
    {
        fout = new FileOutputStream(new File("main.c"));
        fout.write("".getBytes());
        String start = "#include<stdio.h>\n"
                + "int main()\n"
                + "{\n\n\n"
                + "return 0;\n"
                + "}\n";

        fout.write(start.getBytes());
    }

    public void print(String msg) throws FileNotFoundException, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }




        String print = "printf(" + '"' + msg + '"' + ");\n" ;
        char additara[] = new char[addit.length()+print.length()+10];
        int pos = addit.indexOf("return 0;");


        //System.out.println("Position: "+ pos);


        for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
        for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
        for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);

        String finaladdit = "";
        for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

        char finalfinal[] = finaladdit.toCharArray();

        fout.close();
        fout = new FileOutputStream(new File("main.c"));

        for(int i=0; i<finalfinal.length; i++)
        {
            fout.write(finalfinal[i]);
        }

    }

    public void addVar(String var, String type) throws FileNotFoundException, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        String print = type + " " + var + ";\n";
        char additara[] = new char[addit.length()+print.length()+10];
        int pos = addit.indexOf("return 0;");





        for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
        for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
        for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);

        String finaladdit = "";
        for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

        char finalfinal[] = finaladdit.toCharArray();

        fout.close();
        fout = new FileOutputStream(new File("main.c"));

        for(int i=0; i<finalfinal.length; i++)
        {
            fout.write(finalfinal[i]);
        }

    }


    public void assignVar(String var, String value) throws FileNotFoundException, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        String print = var + " = " + value + ";\n";
        char additara[] = new char[addit.length()+print.length()+10];
        int pos = addit.indexOf("return 0;");

        for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
        for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
        for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);

        String finaladdit = "";
        for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

        char finalfinal[] = finaladdit.toCharArray();

        fout.close();
        fout = new FileOutputStream(new File("main.c"));

        for(int i=0; i<finalfinal.length; i++)
        {
            fout.write(finalfinal[i]);
        }

    }


    public void addOp(String op) throws FileNotFoundException, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        String print = op + ";\n";
        char additara[] = new char[addit.length()+print.length()+10];
        int pos = addit.indexOf("return 0;");

        for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
        for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
        for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);

        String finaladdit = "";
        for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

        char finalfinal[] = finaladdit.toCharArray();

        fout.close();
        fout = new FileOutputStream(new File("main.c"));

        for(int i=0; i<finalfinal.length; i++)
        {
            fout.write(finalfinal[i]);
        }

    }


}
