package com.bashir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SearchVar {

    FileOutputStream fout=null;
    FileInputStream fin = null;
    ArrayList<String> arraylistOfVarName = new ArrayList<String>();
    ArrayList<String> arraylistOfVarType = new ArrayList<String>();

    public int getPosition(String VarName) throws IOException {
        int tmp;
        String addit = "";
        VarName = " " + VarName;
        fin = new FileInputStream(new File("main.c"));

        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }

        int pos = addit.indexOf(VarName);


        return pos;
    }
}
