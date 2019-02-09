package com.bashir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

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
                System.out.println("----Enter var name----");
                String var = input.nextLine();
                System.out.println("-----Enter var Type----");
                String type = input.nextLine();
                c.addVar(var, type);
            }

            else if(cmd.equals("assignVar"))
            {
                System.out.println("----Enter var name-----");
                String var = input.nextLine();

                SearchVar searchVar = new SearchVar();
                int pos;
                pos = searchVar.getPosition(var);
                if(pos>=0){
                    System.out.println("-----Enter the value----- ");
                    String type = input.nextLine();
                    c.assignVar(var, type);
                }
                else System.out.println("Variable" + var + "is not declared yet!!!");
                /*System.out.println("-----Enter the value----- ");
                String type = input.nextLine();
                c.assignVar(var, type);*/
            }

            else if(cmd.equals("addOp"))
            {
                System.out.println("----Enter Operation----");
                String op = input.nextLine();

                c.addOp(op);
            }
            else if(cmd.equals("stop")) exit(0);
            else System.out.println("Wrong command!!!");
            System.out.println("----Enter Your command----\n");
        }




    }
}
