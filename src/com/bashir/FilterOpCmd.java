package com.bashir;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class FilterOpCmd {

    String msg = "";

    ArrayList<String> arraylistOfVarName = new ArrayList<String>();
    ArrayList<String> arrayListOfOperator = new ArrayList<String>();

    ArrayList<Var> arrayListOfVar = new ArrayList<Var>();


    ArrayList<String> arrayListOfOp = new ArrayList<String>();
    ArrayList<String> arrayListOfConstant = new ArrayList<String>();

    public FilterOpCmd() {

    }
    /*public FilterOp(String msg){

        this.msg = msg;
    }*/

    public void filter() throws ArrayIndexOutOfBoundsException {

        String constant = "";
        String var = "";
        String op = "";
        char[] stringToCharArray = msg.toCharArray();
        for (int i = 0; i < msg.length(); i++) {

            if (i >= msg.length()) break;

            if (stringToCharArray[i] == ' ') {
                if (var != "") {
                    arraylistOfVarName.add(var);
                    arrayListOfOp.add(var);
                    var = "";
                }

                if (op != "") {
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }

                if (constant != "") {
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);

                    constant = "";
                }

                i++;
                if (i >= msg.length()) break;
            }

            if (stringToCharArray[i] == '=' || stringToCharArray[i] == '>' || stringToCharArray[i] == '<' || stringToCharArray[i] == '+' || stringToCharArray[i] == '-' || stringToCharArray[i] == '/' || stringToCharArray[i] == '*') {

                op = op + stringToCharArray[i];
                if (var != "") {
                    arraylistOfVarName.add(var);
                    arrayListOfOp.add(var);
                    var = "";
                }

                if (constant != "") {
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);

                    constant = "";
                }
            } else {
                if (op != "") {
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }
                if (stringToCharArray[i] != ' ' && (int) stringToCharArray[i] >= 48 && (int) stringToCharArray[i] <= 57) {
                    constant = constant + stringToCharArray[i];
                } else if (stringToCharArray[i] != ' ')
                    var = var + stringToCharArray[i];


            }
            if (i == msg.length() - 1) {
                if (var != "") {
                    arraylistOfVarName.add(var);

                    arrayListOfOp.add(var);
                }
                if (constant != "") {
                    arrayListOfConstant.add(constant);
                    arrayListOfOp.add(constant);
                }
                if (op != "") {
                    arrayListOfOperator.add(op);
                    arrayListOfOp.add(op);
                    op = "";
                }

            }
        }
        //print();
    }

    public void print() {
        System.out.println(arraylistOfVarName.toString());
        System.out.println(arrayListOfOperator.toString());
        System.out.println(arrayListOfOp.toString());
        System.out.println(arrayListOfConstant.toString());
        System.out.println(arrayListOfOp.size());

        validityCheck();
    }

    public void validityCheck() throws IndexOutOfBoundsException {
        int j = 0;
        String s1 = "=";
        String s2 = arrayListOfOp.get(1);
        /*System.out.println("arrayListOfOp.get(1)-----> " + arrayListOfOp.get(1));
        System.out.println("arrayListOfOperator.get(1)------>" + arrayListOfOperator.get(1));*/
        if (s1.equals(s2)) {

            for (int i = 1; i <= arrayListOfOperator.size(); i++) {
                j = i * 2;

                //if(j>=arrayListOfOp.size() || i>= arrayListOfOperator.size()) return;

                if (arrayListOfOperator.get(i - 1) != arrayListOfOp.get(j - 1)) {
                    System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso??");
                   /* System.out.println(" i  " + i + "  j  " + j);
                    System.out.println(arrayListOfOperator.get(i - 1));
                    System.out.println(arrayListOfOp.get(j - 1));*/
                    return;
                }
            }

            /*if((arraylistOfVarName.get(0).equals(arrayListOfOp.get(0)) && (arraylistOfVarName.get(arraylistOfVarName.size()-1).equals(arrayListOfOp.get(arrayListOfOp.size()-1)))))
            System.out.println("----valid operation---");*/
            String a1 = arrayListOfOperator.get(0);
            String a2 = arrayListOfOperator.get(arrayListOfOperator.size() - 1);
            if ((arrayListOfOp.get(0) != a1) && (arrayListOfOp.get(arrayListOfOp.size() - 1) != a2)) {
                System.out.println("----valid operation---");
            } else {
                System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso??");
                return;
            }


        } else {
            System.out.println(arrayListOfOp.get(1));
            System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso??");
            return;
        }

        //finalCheck();

    }


    public void brucketMatching(String OpCmd) throws EmptyStackException {

        Stack<String> st = new Stack<String>();
        String br = "";
        String operation = "";
        char[] stringToCharArray = OpCmd.toCharArray();
        for (int i = 0; i < OpCmd.length(); i++) {
            if (stringToCharArray[i] == '(') {
                br = br + stringToCharArray[i];
                st.push(br);
                br = "";
                //i++;
            }
            if (stringToCharArray[i] == ')') {
                if (st.empty()) {
                    System.out.println("vugichugi operation chalaibar aiso?faizlami paiso?!!!");
                    return;
                } else
                    st.pop();
                //i++;
            } else if ((stringToCharArray[i] != '(') && (stringToCharArray[i] != ')'))
                operation = operation + stringToCharArray[i];
            //operation = operation + stringToCharArray[i];
        }
        if (st.empty()) {
            msg = operation;
            filter();
        } else System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso??");

        //System.out.println(st.toString());
        System.out.println("modified op: " + operation);
    }

    public void br(String OpCmd) {
        boolean mark = false;
        char[] stringToCharArray = OpCmd.toCharArray();
        for (int i = 0; i < OpCmd.length(); i++) {
            if (stringToCharArray[i] == '(') {
                if (stringToCharArray[i - 1] == ' ' || stringToCharArray[i - 1] == '=' || stringToCharArray[i - 1] == '+' || stringToCharArray[i - 1] == '-' || stringToCharArray[i - 1] == '/' || stringToCharArray[i - 1] == '*') {
                    for (int j = i; j < OpCmd.length(); j++) {
                        i = j;
                        if (stringToCharArray[j] == ')') {
                            if (j + 1 >= OpCmd.length()) brucketMatching(OpCmd);

                            if (j + 1 < OpCmd.length() && (stringToCharArray[j + 1] == ' ' || stringToCharArray[j + 1] == '=' || stringToCharArray[j + 1] == '+' || stringToCharArray[j + 1] == '-' || stringToCharArray[j + 1] == '/' || stringToCharArray[j + 1] == '*')) {
                                //brucketMatching(OpCmd);
                                //i++;
                                mark = true;
                            } else {
                                System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso?? operator missing before brucket!!! I =  " + i);
                                mark = false;
                                return;
                            }
                        }
                    }
                } else
                    System.out.println("vugichugi operation chalaibar aiso?? faizlami paiso?? operator missing before brucket!!! I =  " + i);
                return;
            }
        }

    }
}
