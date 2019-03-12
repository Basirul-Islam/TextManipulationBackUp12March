package com.bashir;

import ui.editorController;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class FilterOp {

    String msg = "";
    boolean x = false;
    ArrayList<String> arraylistOfVarName = new ArrayList<String>();
    ArrayList<String> arrayListOfOperator = new ArrayList<String>();

    ArrayList<Var> arrayListOfVar = new ArrayList<Var>();


    ArrayList<String> arrayListOfOp = new ArrayList<String>();
    ArrayList<String> arrayListOfConstant = new ArrayList<String>();



    public FilterOp(){

    }

    public void filter() throws ArrayIndexOutOfBoundsException {

        String constant = "";
        String var = "";
        String op = "";
        char[] stringToCharArray = msg.toCharArray();
        for(int i =0;i<msg.length();i++){

            if(i>=msg.length()) break;

            if(stringToCharArray[i] == ' '){
                if(var != "") {
                    arraylistOfVarName.add(var);
                    arrayListOfOp.add(var);
                    var = "";
                }

                if(op != ""){
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }

                if(constant!=""){
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);

                    constant = "";
                }

                i++;
                if(i>=msg.length()) break;
            }

            if(stringToCharArray[i] == '=' || stringToCharArray[i] == '>' || stringToCharArray[i] == '<' || stringToCharArray[i] == '+' || stringToCharArray[i] == '-' || stringToCharArray[i] == '/' || stringToCharArray[i] == '*'){
                if(op == "")
                    op = op + stringToCharArray[i];

                if(var != "") {
                    arraylistOfVarName.add(var);
                    arrayListOfOp.add(var);
                    var = "";
                }

                if(constant!=""){
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);

                    constant = "";
                }
                arrayListOfOperator.add(op);
                arrayListOfOp.add(op);
                op = "";
            }
            else {
                if(op != ""){
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }
                if(stringToCharArray[i]!= ' ' && (int)stringToCharArray[i]>=48 && (int)stringToCharArray[i]<=57){
                    constant = constant + stringToCharArray[i];
                }

                else if(stringToCharArray[i]!=' ' )
                    var = var + stringToCharArray[i];



            }
            if(i==msg.length()-1){
                if(var!=""){
                    arraylistOfVarName.add(var);

                    arrayListOfOp.add(var);
                }
                if(constant!=""){
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);
                }
                if(op!=""){
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }

            }
        }
        //print();
        validityCheck();
    }
    /*This Method is for printing all the ArrayList*/
    public void print(){
        System.out.println(arraylistOfVarName.toString());
        System.out.println(arrayListOfOperator.toString());
        System.out.println(arrayListOfOp.toString());
        System.out.println(arrayListOfConstant.toString());
        System.out.println(arrayListOfOp.size());

        validityCheck();
    }
    public void validityCheck() throws IndexOutOfBoundsException {

        String x1 = arrayListOfOp.get(0);
        String x2 = arraylistOfVarName.get(0);
        if(x1!=x2){
            //System.out.println("something went wrong!!!variable mismatch!!!");
            editorController.error = "something went wrong!!!variable mismatch!!!";
            return;
        }
        int j =0;
        String s1 = "=";
        String s2 = null;
        try{
            s2 = arrayListOfOp.get(1);
        }
        catch (Exception e){
           // System.out.println("\" = \" sign missing!!!");
            editorController.error = "Invalid Operation!!!";
            return;
        }

        /*System.out.println("arrayListOfOp.get(1)-----> " + arrayListOfOp.get(1));
        System.out.println("arrayListOfOperator.get(1)------>" + arrayListOfOperator.get(1));*/
        if(s1.equals(s2)){

            for(int  i = 0; i<arrayListOfOperator.size();i++){
                j = 2*i+1;

                //if(j>=arrayListOfOp.size() || i>= arrayListOfOperator.size()) return;

                if(arrayListOfOperator.get(i)!=arrayListOfOp.get(j)){
                    //System.out.println("invalid operation!!!operator missing....");
                    editorController.error = "invalid operation!!!operator missing....";
                    //System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso??Operator Missing!!!");
                    /*System.out.println(" i  " + i + "  j  " + j);
                    System.out.println(arrayListOfOperator.get(i));
                    System.out.println(arrayListOfOp.get(j));*/
                    return;
                }

            }

            /*if((arraylistOfVarName.get(0).equals(arrayListOfOp.get(0)) && (arraylistOfVarName.get(arraylistOfVarName.size()-1).equals(arrayListOfOp.get(arrayListOfOp.size()-1)))))
            System.out.println("----valid operation---");*/
            String a1 = arrayListOfOperator.get(0);
            String a2 = arrayListOfOperator.get(arrayListOfOperator.size()-1);
            if((arrayListOfOp.get(0)!= a1) && (arrayListOfOp.get(arrayListOfOp.size()-1)!=a2)){
                //System.out.println("----valid operation---");
                x = true;
            }
            else{
                //System.out.println("invalid operation!!!");
                editorController.error = "invalid operation!!!";
                return;
            }


        }

        else{
            //System.out.println(arrayListOfOp.get(1));
            //System.out.println("invalid operation!!!\"=\" sign missing!!!");
            editorController.error = "invalid operation!!!\"=\" sign missing!!!";
            return;
        }

        //finalCheck();

    }


    public boolean brucketMatching(String OpCmd)throws EmptyStackException {

        Stack<String> st = new Stack<String>();
        String br = "";
        String operation = "";
        char[] stringToCharArray = OpCmd.toCharArray();
        for(int i=0;i<OpCmd.length();i++){
            if(stringToCharArray[i] == '('){
                br = br + stringToCharArray[i];
                st.push(br);
                br = "";
                //i++;
            }
            if(stringToCharArray[i] == ')'){
                if(st.empty()) {
                    //System.out.println("invalid operation!!! \" opening or closing Bracket missing!! \" ");
                    editorController.error = "invalid operation!!! \" opening or closing Bracket missing!! \" ";
                    return x;
                }
                else
                    st.pop();
                //i++;
            }
            else if((stringToCharArray[i]!= '(') && (stringToCharArray[i]!=')')) operation = operation + stringToCharArray[i];
            //operation = operation + stringToCharArray[i];
        }
        if(st.empty()){
            msg = operation;
            filter();
        }
        else //System.out.println("invalid operation!!!");
        editorController.error = "invalid operation!!!";
        /*System.out.println(st.toString());*/
        //System.out.println("modified op: " + operation);
        return x;
    }
    //newly added
    public ArrayList getArrayListOfVarName(){

        return arraylistOfVarName;
    }

}
