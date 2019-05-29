package com.bashir;

import ui.editorController;

import java.io.*;
import java.util.ArrayList;

public class ValidityOfVar {

    FileOutputStream fout=null;
    FileInputStream fin = null;

    ArrayList<String> Keyes = new ArrayList<String>();
    ArrayList<String> vartype = new ArrayList<String>();
    ArrayList<Var>arrayListOfVar = new ArrayList<Var>();

    public ValidityOfVar(ArrayList<Var>arrayListOfVar){
        this.arrayListOfVar = arrayListOfVar;
    }

    /*public ValidityOfVar(String VarName){
        this.VariableName = VarName;
    }*/

    public boolean validity(String variableName) throws IOException {
        int tmp;
        String addit = "";

        fin = new FileInputStream(new File("Key.txt"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }
        char[] stringToCharArray = addit.toCharArray();
        String key = "";
        for (int i =0; i<=addit.length();i++){
            if(i == addit.length()){
                if(key!=null) {
                    Keyes.add(key);
                    key = "";
                    break;
                }
                break;
            }
            if(stringToCharArray[i]==' '){
                if(key!=null) {
                    Keyes.add(key);
                    key = "";
                }
            }
            else key = key + stringToCharArray[i];
        }
        if(variableName.contains(" ")){
            editorController.error = "variable Name cannot contain space!!! Invalid Variable!!!!";
            return false;
        }
        if(Keyes.contains(variableName)){
            editorController.error = "Invalid Variable Name!!! This is a keyWord/operator in c/c++ language!!!";
            return false;
        }
        else {
             Var var1 = new Var();
             for(int i =0;i<arrayListOfVar.size();i++){
                var1 = arrayListOfVar.get(i);
                if(variableName.equals(var1.VarName)){
                    editorController.error = "variable name already exist!!!!";
                    return false;
                }
            }
            return true;
        }
    }

    public boolean Vartype(String VariableType) throws IOException {
        int tmp;
        String addit = "";

        fin = new FileInputStream(new File("type.txt"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }
        char[] stringToCharArray = addit.toCharArray();

        String type = "";
        for (int i =0; i<=addit.length();i++){
            if(i == addit.length()){
                if(type!=null) {
                    vartype.add(type);
                    type = "";
                    break;
                }
                break;
            }
            if(stringToCharArray[i]==' '){
                if(type!=null) {
                    vartype.add(type);
                    type = "";
                }

            }
            else type = type + stringToCharArray[i];
        }
        if(vartype.contains(VariableType)){
            //System.out.println("----valid variable type------");
            return true;
        }
        else {
            System.out.println("Invalid variable type!!!");
            return false;
        }
    }
}


