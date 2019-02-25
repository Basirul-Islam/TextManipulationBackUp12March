package com.bashir;

import java.io.*;


public class ValidityOfVar {

        FileOutputStream fout=null;
        FileInputStream fin = null;

        String VariableName ;
        public ValidityOfVar(){

        }

        public ValidityOfVar(String VarName){
            this.VariableName = VarName;
        }

        public boolean validity() throws IOException {
            int tmp;
            String addit = "";
            String VarName = " " + VariableName;

            boolean mark = false;

            if(VariableName.contains(" ")){
                System.out.println("variable Name cannot contain space!!! Invalid Variable!!!!");
                mark = false;
                return false;
            }

            fin = new FileInputStream(new File("Key.txt"));

            while(fin.available()!=0)
            {
                tmp = fin.read();
                addit = addit+(char)tmp;
            }

            int pos = addit.indexOf(VarName);
            if(addit.contains(VarName)){
                System.out.println("invalid Variable Name!!!This is a keyWord/Operator in c/c++ language!!!");
                mark = false;
                return false;
            }
            else {
                System.out.println("-----valid Variable name---");
                mark = true;
                return true;
            }

        }
        public boolean Vartype(String type) throws IOException {
            int tmp;
            String addit = "";
            String VarType = " " + type;

            boolean mark = false;
            fin = new FileInputStream(new File("VarType.txt"));

            while(fin.available()!=0)
            {
                tmp = fin.read();
                addit = addit+(char)tmp;
            }
            if(addit.contains(VarType)){
                return true;

            }
            else {
                System.out.println("Invalid variable Type!!!!");
                return false;
            }
        }
}


