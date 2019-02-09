package com.bashir;

import java.io.*;
import java.util.ArrayList;

public class Print {
    FileOutputStream fout=null;
    FileInputStream fin = null;
    ArrayList<String> arraylistOfVarName = new ArrayList<String>();
    ArrayList<String> arraylistOfVarType = new ArrayList<String>();

    public void filter(String msg) throws Exception {
        char[] stringToCharArray = msg.toCharArray();

        for(int i =0;i<msg.length();i++){
            if(stringToCharArray[i]=='('){
                String var="";
                while(true){
                    i++;

                    if(stringToCharArray[i]==')'){
                        arraylistOfVarName.add(var);
                        var = "";
                        break;
                    }
                    if(!(stringToCharArray[i]=='(' || stringToCharArray[i]==')'))

                        var = var + stringToCharArray[i];
                }

            }
        }
        for(int i =0;i<arraylistOfVarName.size();i++)
        {
            String s = (String) arraylistOfVarName.get(i);
            //SearchVarTyp(s);
            String VarName = " "+s;
            int pos = getPosition(VarName);
            if(pos<0){
                System.out.println("Variable not Found!!! please dclare the variable first---");
                return;
            }
            // System.out.println("Variable Name:" + s + "  Position: " + pos);
            getVarType(pos);
        }
        //FinalPrint(msg);
        CreateString(msg);
    }
    public void CreateString(String msg) throws Exception {

        String print = "";

        if(msg.contains("(") && msg.contains("(")){
            //System.out.print("printf(\"");
            print = "printf(\"";
            char[] stringToCharArray = msg.toCharArray();
            int indexOfArrayList = 0;
            for(int i =0;i<msg.length();i++){


                if(stringToCharArray[i]=='('){
                    //System.out.print(arraylistOfVarType.get(indexOfArrayList));
                    print = print + arraylistOfVarType.get(indexOfArrayList);
                    indexOfArrayList++;
                    while(true){
                        i++;

                        if(stringToCharArray[i]==')'){
                            i++;
                            break;
                        }

                    }

                }
                if(i<msg.length()){
                    //System.out.print(stringToCharArray[i]);
                    print = print + stringToCharArray[i];
                }


            }
            //System.out.print("\"");
            print = print + "\"";
            for(int j =0; j< arraylistOfVarName.size();j++){
                //System.out.print("," + arraylistOfVarName.get(j) );
                print = print + "," + arraylistOfVarName.get(j);
            }
            //System.out.println(");");
            print = print + ");";
        }
        else
            //System.out.println("printf(\"" + msg + "\");");
            print = "printf(\"" + msg + "\");";
        //System.out.println(print);
        FileWrite(print);

    }
    public void FinalPrint(String msg){
        if(msg.contains("(") && msg.contains("(")){
            System.out.print("printf(\"");
            char[] stringToCharArray = msg.toCharArray();
            int indexOfArrayList = 0;
            for(int i =0;i<msg.length();i++){


                if(stringToCharArray[i]=='('){
                    System.out.print(arraylistOfVarType.get(indexOfArrayList));
                    indexOfArrayList++;
                    while(true){
                        i++;

                        if(stringToCharArray[i]==')'){
                            i++;
                            break;
                        }

                    }

                }
                if(i<msg.length())
                    System.out.print(stringToCharArray[i]);
            }
            System.out.print("\"");
            for(int j =0; j< arraylistOfVarName.size();j++){
                System.out.print("," + arraylistOfVarName.get(j) );
            }
            System.out.println(");");
        }
        else System.out.println("printf(\"" + msg + "\");");

    }

    public void getVarType(int index) throws IOException {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        char varType = addit.charAt(index-1);
        if(varType == 't') arraylistOfVarType.add("%d");
        else if(varType == 'g') arraylistOfVarType.add("%s");
        else if(varType == 'e') arraylistOfVarType.add("%lf");

        //System.out.println("Var Type: " + addit.charAt(index-1));
    }

    public int getPosition(String VarName) throws IOException {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        int pos = addit.indexOf(VarName);


        return pos;
    }

    public void PrintArrayList(){

        System.out.println(arraylistOfVarType.toString());
    }

    public void FileWrite(String msg) throws Exception, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }




        String print = msg + "\n";
        char additara[] = new char[addit.length()+print.length()+10];
        int pos = addit.indexOf("return 0;");


        //System.out.println("Position: "+ pos);


        for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
        for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
        for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);

        String finaladdit = "";
        for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

        char finalfinal[] = finaladdit.toCharArray();

        //fout.close();
        fout = new FileOutputStream(new File("main.c"));

        for(int i=0; i<finalfinal.length; i++)
        {
            fout.write(finalfinal[i]);
        }

    }


}
