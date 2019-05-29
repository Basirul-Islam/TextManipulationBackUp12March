package com.bashir;

import ui.editorController;

import java.io.*;

public class MakeLoop {



        FileOutputStream fout=null;
        FileInputStream fin = null;

        public MakeLoop()throws FileNotFoundException {

        }

        public void makeLoop(String command,String iteration) throws Exception {
            String p = "";
            if(command.equals("makeLoop")){
                String i = iteration;
                editorController.s.push("{");
                String marker = String.valueOf(editorController.s.size());
                p = "for(int iteration_" + marker + "=0 ; iteration_" + marker + " <" + i + "; iteration_" + marker + "++ )\n{";
                FileWrite(p);
            }
            else if(command.equals("exit")){
                p = "\n}";
                editorController.s.pop();
                FileWrite(p);
            }
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

        //System.out.println("addit: " + addit);


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

        //return addit;
    }
}
