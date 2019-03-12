package com.bashir;

import ui.editorController;

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
    public boolean checkDeclaration(){
        String s = null;
        Var var ;
        String name = null;
        boolean marker = false;
        if(arrayListOfVarName.isEmpty()){
            //System.out.println("No variable found!!!");
            editorController.error = "No variable found!!!";
            return false;
        }
        if(arrayListOfVariable.isEmpty()){
            //System.out.println("No variable Declared!!!");
            editorController.error = "No variable Declared!!!";
            return false;
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
            //System.out.println("Variable not declared yet!!!");
            editorController.error = "Variable not declared yet!!!";
            return false;
        }
        else {
            boolean x;
            x = checkAssigVar();
            return x;
        }
    }
    public boolean checkAssigVar(){
       for(int i = 1; i<arrayListOfVariableInOP.size();i++){
           if(arrayListOfVariableInOP.get(i).Value == null){
               //System.out.println("Variable is not assigned yet!!!");
               editorController.error = "Variable is not assigned yet!!!";
               return false;
           }
       }
       boolean x = checkType();
       return x;
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
            //System.out.println("everything is okk");
            //print();
            return x;
        }
        else {
            System.out.println("variable type missMatch!!!");
            editorController.error = "variable type missMatch!!!";
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
