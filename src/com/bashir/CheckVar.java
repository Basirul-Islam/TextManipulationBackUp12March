package com.bashir;

import java.util.ArrayList;

public class CheckVar {
    public ArrayList<Var> arrayListOfVariable = new ArrayList<Var>();
    public ArrayList<String> arrayListOfVarName = new ArrayList<String>();
    public ArrayList<Var> arrayListOfVariableInOP = new ArrayList<Var>();
    public boolean x = false;
    public CheckVar(ArrayList arrayListOfVariable,ArrayList arrayListOfVarName){
        this.arrayListOfVariable = arrayListOfVariable;
        this.arrayListOfVarName = arrayListOfVarName;

    }
    public CheckVar(){

    }
    public void setArrayListOfVariable(ArrayList arrayListOfVariable){
        this.arrayListOfVariable = arrayListOfVariable;
    }
    public void setArrayListOfVarName(ArrayList arrayListOfVarName){

        this.arrayListOfVarName = arrayListOfVarName;
    }
    public void checkDeclaration(){
        String s = null;
        Var var ;
        String name = null;
        boolean marker = false;
        if(arrayListOfVarName.isEmpty()){
            System.out.println("No variable found!!!");
            return;
        }
        if(arrayListOfVariable.isEmpty()){
            System.out.println("No variable Declared!!!");
            return;
        }
        for(int i=0;i<arrayListOfVarName.size();i++){
            s = arrayListOfVarName.get(i);
            for (int  j=0;j<arrayListOfVariable.size();j++){
                var = arrayListOfVariable.get(j);
                name = var.VarName;
                if(s.equals(name)) {
                    marker = true;
                    arrayListOfVariableInOP.add(arrayListOfVariable.get(j));
                    break;
                }
                else marker = false;
            }
        }
        if (marker == false){
            System.out.println("Variable not declared yet!!!");
            return;
        }
        else checkAssigVar();
    }
    public void checkAssigVar(){
       for(int i = 1; i<arrayListOfVariableInOP.size();i++){
           if(arrayListOfVariableInOP.get(i).Value == null){
               System.out.println("Variable is not assigned yet!!!");
               return;
           }
       }
       checkType();
    }
    public boolean checkType(){

        if(arrayListOfVariableInOP.size()==1){
            return true;
        }

        String type = null;

        type = arrayListOfVariableInOP.get(0).VarType;
        for(int i = 1; i<arrayListOfVariableInOP.size();i++){
            if(type.equals(arrayListOfVariableInOP.get(i).VarType)){
                //System.out.println("type: " + type + "  "+arrayListOfVariableInOP.get(i).VarName +"              " + arrayListOfVariableInOP.get(i).VarType);
                x = true;
            }
            else x= false;

        }
        if(x == true){
            System.out.println("everything is okk");
            //print();
            return x;
        }
        else {
            System.out.println("type missMatch!!!");
            //print();
            return x;
        }
    }
    public void print(){
        for(Var v: arrayListOfVariableInOP)
            System.out.println(v);
        for(String s: arrayListOfVarName)
            System.out.println(s);
    }
}
