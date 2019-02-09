package com.bashir;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterOpCmd {

    ArrayList<String> arraylistOfVarName = new ArrayList<String>();
    ArrayList<String> arrayListOfOperator = new ArrayList<String>();
    ArrayList<Var> arrayListOfVar = new ArrayList<Var>();
    String msg;

    public FilterOpCmd(){

    }

    public FilterOpCmd(String msg, ArrayList<Var> arrayListOfVar){
        this.msg = msg;
        this.arrayListOfVar = arrayListOfVar;

    }
    public boolean check1(){
        Var var = new Var();
        String type = null;
                String Name = arraylistOfVarName.get(0);
        for(int j = 0;j<arrayListOfVar.size();j++){
            var = arrayListOfVar.get(j);
            if(Name.equals(var.VarName)){
                type = var.VarType;
            }
        }
        boolean mark = false;
        for(int i =0;i<arraylistOfVarName.size();i++){
            String VarName = arraylistOfVarName.get(i);
            for(int j = 0;j<arrayListOfVar.size();j++){
                var = arrayListOfVar.get(j);
                if(VarName.equals(var.VarName) && var.VarType.equals(type)){
                    System.out.println("Variable "+VarName+" Exist");
                    mark = true;
                }
            }
            if(mark == false) System.out.println("Variable "+VarName+" Does Not Exist!!!");
        }
        return mark;
    }

/*
    public void CreateVar(){
        Scanner sc = new Scanner(System.in);
        String VarName,Vartype,Value;
        for(int i =0;i<3;i++){
            System.out.println("--enter Var Name---");
            VarName = sc.nextLine();
            Vartype = sc.nextLine();
            Value = sc.nextLine();
            Var variable = new Var(VarName,Vartype,Value);
            arrayListOfVar.add(variable);
        }
        check();
    }*/
    public  void check(){
        Var var = new Var();
        boolean mark = false;
        for(int i =0;i<arraylistOfVarName.size();i++){
            String VarName = arraylistOfVarName.get(i);
            for(int j = 0;j<arrayListOfVar.size();j++){
                var = arrayListOfVar.get(j);
                if(VarName.equals(var.VarName)){
                    System.out.println("Variable "+VarName+" Exist");
                    mark = true;
                }
            }
            if(mark == false) System.out.println("Variable "+VarName+" Does Not Exist!!!");
        }
    }
    public void filter(){
        //int i = 0;
        String var = "";
        char[] stringToCharArray = msg.toCharArray();
        for(int i =0;i<msg.length();i++){
            if(stringToCharArray[i] == ' ') {
                i++;
            }
            if(stringToCharArray[i]== '=' || stringToCharArray[i]== '+' || stringToCharArray[i]== '-' || stringToCharArray[i]== '*' || stringToCharArray[i]== '/' || stringToCharArray[i]== '>' || stringToCharArray[i]== '<'){
                arraylistOfVarName.add(var);
                var = "";
                String op = Character.toString(stringToCharArray[i]);
                arrayListOfOperator.add(op);
            }
            else{
                var = var + stringToCharArray[i];
            }
            if(i==msg.length()-1){
                arraylistOfVarName.add(var);
            }
        }
        System.out.println(arraylistOfVarName.toString());
        System.out.println(arrayListOfOperator.toString());

        //CreateVar();
    }

}
