package com.bashir;

public class Var {
    public String VarName;
    public String VarType;
    public String Value;
    public Var(){
        this.VarName = null;
        this.VarType = null;
        this.Value = null;
    }

    public Var(String VarName,String VarType,String Value ){
        this.VarName = VarName;
        this.VarType = VarType;
        this.Value = Value;
    }
    public void setVarName(String VarNAme){
        this.VarName = VarNAme;
    }
    public void setVarType(String Type){
        this.VarType = Type;
    }
    public void setValue(String value){
        this.Value = value;
    }
    public String toString() {
        return "   " + VarName + "         " + VarType + "\t   " + Value + "\n";
    }
}
