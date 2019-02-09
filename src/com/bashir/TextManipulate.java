package com.bashir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TextManipulate {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String cmd;
        GenerateCFile c = new GenerateCFile();

        System.out.println("----Enter Your command----\n");

        while(true)
        {
            cmd = input.nextLine();

            if(cmd.equals("start")){
                c.startIt();
            }

            else if(cmd.equals("print"))
            {
                System.out.println("----Enter message----");
                cmd = input.nextLine();
                Print print = new Print();
                print.filter(cmd);
                /*c.print(cmd);*/
            }

            else if(cmd.equals("addVar"))
            {
                System.out.println("----Enter var name and type----");
                String var = input.nextLine();
                String type = input.nextLine();
                c.addVar(var, type);
            }

            else if(cmd.equals("assignVar"))
            {
                System.out.println("----Enter var name and value----");
                String var = input.nextLine();
                String type = input.nextLine();
                c.assignVar(var, type);
            }

            else if(cmd.equals("addOp"))
            {
                System.out.println("----Enter Operation----");
                String op = input.nextLine();

                c.addOp(op);
            }
            System.out.println("----Enter Your command----\n");
        }




    }
}
