package com.bashir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class TextManipulate {
    public static void main(String[] args) throws Exception {

        ArrayList<Var> arrayListOfVar = new ArrayList<Var>();

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
                ValidityOfVar v = new ValidityOfVar(arrayListOfVar);
                boolean x = v.validity(var);
                if(x==true){
                    System.out.println("-----Enter var Type----");
                    String type = input.nextLine();
                    boolean y =v.Vartype(type);
                    if(y == true){
                        c.addVar(var, type);

                        Var variable = new Var();
                        variable.setVarName(var);
                        variable.setVarType(type);
                        arrayListOfVar.add(variable);

                    }
                }
            }

            else if(cmd.equals("assignVar"))
            {
                System.out.println("----Enter var name-----");
                String var = input.nextLine();
                Var var1 = new Var();
                boolean mark = false;
                for(int i =0;i<arrayListOfVar.size();i++){
                    var1 = arrayListOfVar.get(i);
                    if(var.equals(var1.VarName)){
                        System.out.println("-----Enter the value----- ");
                        String value = input.nextLine();
                        c.assignVar(var, value);
                        var1.setValue(value);
                        mark = true;
                    }
                }
                if(mark == false) System.out.println("Variable " + var + " is not declared yet!!!");

            }

            else if(cmd.equals("addOp"))
            {
                System.out.println("----Enter Operation----");
                String op = input.nextLine();
                OpCmd operation = new OpCmd(arrayListOfVar);
                boolean x = operation.filter(op);
                if(x==true) c.addOp(op);
            }
            else if(cmd.equals("stop")){

                //this part is for printing an object type arrayList
                /*for(Var v: arrayListOfVar)
                    System.out.println(v);*/

                exit(0);
            }
            else System.out.println("Wrong command!!!");
            System.out.println("----Enter Your command----\n");
        }


    }
}
