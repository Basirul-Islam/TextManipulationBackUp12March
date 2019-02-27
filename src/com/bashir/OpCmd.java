package com.bashir;

import java.util.ArrayList;
import java.util.Scanner;

public class OpCmd {


    public ArrayList<Var> arrayListOfVariable = new ArrayList<Var>();
    public ArrayList<String> arrayListOfVarName = new ArrayList<String>();

    public OpCmd(ArrayList<Var> arrayListOfVariable){

        this.arrayListOfVariable = arrayListOfVariable;
    }


    public OpCmd(){

    }
    public  boolean opBr(int pos,String OpCmd){
        boolean mark = false;
        char[] stringToCharArray = OpCmd.toCharArray();


        while(pos>=0){
            pos--;
            if(pos<0){
                mark = true;
                break;
            }
            if(stringToCharArray[pos] == ' ') pos--;
            if((stringToCharArray[pos] == '=' || stringToCharArray[pos] == '+' || stringToCharArray[pos] == '-' || stringToCharArray[pos] == '/' || stringToCharArray[pos] == '*')){
                mark = true;
                //System.out.println("---valid op-----");
                break;
            }
            else {
                mark = false;
                //System.out.println("operator missing!!!!");
                break;
            }
        }
        return mark;
    }

    public boolean clBr(int pos,String OpCmd){
        boolean mark = false;
        char[] stringToCharArray = OpCmd.toCharArray();
        pos++;
        while(pos<OpCmd.length()){
            pos++;
            if(pos>=OpCmd.length()){
                mark = true;
                break;
            }
            if(stringToCharArray[pos] == ' ') pos++;
            else if((stringToCharArray[pos] == '=' || stringToCharArray[pos] == '+' || stringToCharArray[pos] == '-' || stringToCharArray[pos] == '/' || stringToCharArray[pos] == '*')){
                mark = true;
                //System.out.println("---valid op-----");
                break;
            }
            else {
                mark = false;
                //System.out.println("operator missing!!!!");
                break;
            }

        }
        return mark;
    }
    public boolean filter(String OpCmd){
        boolean mark1 = true;
        boolean mark2 = true;
        char[] stringToCharArray = OpCmd.toCharArray();
        for(int i =0;i<OpCmd.length();i++){
            if(stringToCharArray[i] == '('){
                mark1 = opBr(i,OpCmd);
                if(mark1 == false){
                    System.out.println("operator missing before bracket!!!");
                    return false;
                };
            }
            else if(stringToCharArray[i] == ')'){
                mark2 = clBr(i,OpCmd);
                if (mark2 == false){
                    System.out.println("operator missing after bracket!!!");
                    return false;
                }
            }
        }
        FilterOp op = new FilterOp();
        boolean x = op.brucketMatching(OpCmd);
        //System.out.println(x);
        //newly added
        arrayListOfVarName = op.getArrayListOfVarName();
       // print();
        CheckVar checkVar = new CheckVar(arrayListOfVariable,arrayListOfVarName);
        checkVar.checkDeclaration();
        return x;
    }
    public void print(){
        for(Var v: arrayListOfVariable)
            System.out.println(v);
        for(String s: arrayListOfVarName)
            System.out.println(s);
    }
}
