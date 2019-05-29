package ui;

import com.bashir.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class editorController implements Initializable {

    @FXML
    Button Start;
    @FXML
    TextArea output;
    @FXML
    ComboBox<String> varType;
    @FXML
    TextField varTypeHolder;
    @FXML
    Label varNameError;
    @FXML
    ImageView showVarNameRight;
    @FXML
    ImageView showvarNameWrong;
    @FXML
    ImageView PrintOpWrong;
    @FXML
    ImageView PrintOpRight;
    @FXML
    Label OpPrintError;
    @FXML
    TextField msgHolder;
    @FXML
    Button print;
    @FXML
    ComboBox<String>assign;
    @FXML
    TextField valueHolder;
    @FXML
    ImageView ShowAssignRight;
    @FXML
    ImageView ShowAssignWrong;
    @FXML
    Label ValueError;
    @FXML
    ComboBox<String> varList;
    @FXML
    TextField opHolder;
    @FXML
    ImageView OpRight;
    @FXML
    ImageView OpWrong;
    @FXML
    Label OpError;
    @FXML
    Button Stop;
    @FXML
    Button MakeLOOPButton;
    @FXML
    Button ExitFromLoop;
    @FXML
    AnchorPane AchorpaneForIeterationPopUp;
    @FXML
    Button OK;
    @FXML
    TextField NoOfIteration;






    GenerateCFile c;
    ArrayList<Var> arrayListOfVar = new ArrayList<Var>();
    public static String mainOutput = "";
    public static String error = "";

    public static Stack s = new Stack();
    public static String f = "";
    //public boolean state = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        varType.getItems().addAll("int", "double", "char");
        varType.setDisable(true);
       // varTypeHolder.setDisable(true);
        showVarNameRight.setVisible(false);
        showvarNameWrong.setVisible(false);
        varNameError.setText("");
        msgHolder.setDisable(true);
        OpPrintError.setVisible(false);
        PrintOpRight.setVisible(false);
        PrintOpWrong.setVisible(false);
        print.setDisable(true);
        ShowAssignRight.setVisible(false);
        ShowAssignWrong.setVisible(false);
        ValueError.setVisible(false);
        OpRight.setVisible(false);
        OpWrong.setVisible(false);
        OpError.setVisible(false);
        MakeLOOPButton.setDisable(true);
        ExitFromLoop.setVisible(false);
        AchorpaneForIeterationPopUp.setVisible(false);
        NoOfIteration.setVisible(false);
        OK.setVisible(false);


    }


    public void start(ActionEvent event) {
        //arrayListOfVar = null;
        mainOutput = "";
        String addit = "";
        try{
            c = new GenerateCFile();
            c.startIt();
        }catch(Exception e){
            System.out.println("throws IO exception!!!");
        }

        mainOutput = mainOutput + "start" + "\n";

        output.setText(mainOutput);


        //state = false;
        varType.setDisable(false);
        print.setDisable(false);
        MakeLOOPButton.setDisable(false);

        //setDisable();
        Start.setDisable(true);

    }
    public void setDisable(){
        showVarNameRight.setVisible(false);
        showvarNameWrong.setVisible(false);
        varNameError.setVisible(false);

        OpPrintError.setVisible(false);
        PrintOpRight.setVisible(false);
        PrintOpWrong.setVisible(false);
    }
    public void setVarType(KeyEvent event)
    {

        /*if(varType.getSelectionModel().getSelectedItem().equals(null)){
            varTypeHolder.setDisable(true);
        }
        else varTypeHolder.setDisable(false);*/


        OpPrintError.setVisible(false);
        PrintOpRight.setVisible(false);
        PrintOpWrong.setVisible(false);


        ShowAssignRight.setVisible(false);
        ShowAssignWrong.setVisible(false);
        ValueError.setVisible(false);

        OpError.setVisible(false);
        OpWrong.setVisible(false);
        OpRight.setVisible(false);


        if(event.getCode() == KeyCode.ENTER) {

            showVarNameRight.setVisible(false);
            showvarNameWrong.setVisible(false);
            varNameError.setVisible(false);

            String varTypeNme = varType.getSelectionModel().getSelectedItem();
            if(varTypeNme==null){
                error = "Var type not declared Yet!!!";
                showVarNameRight.setVisible(false);
                showvarNameWrong.setVisible(true);
                varNameError.setVisible(true);
                varNameError.setText(error);
                error = "";
                return;

            }
            else {
                ValidityOfVar v = new ValidityOfVar(arrayListOfVar);
                try{
                    if (varTypeHolder.getText().equals("")){
                        error = "Give a suitable name!!!";
                        showVarNameRight.setVisible(false);
                        showvarNameWrong.setVisible(true);
                        varNameError.setVisible(true);
                        varNameError.setText(error);
                        error = "";
                        return;
                    }
                    boolean x = v.validity(varTypeHolder.getText());
                    if(x==true){
                        c.addVar(varTypeHolder.getText(),varType.getSelectionModel().getSelectedItem());

                        Var variable = new Var();
                        variable.setVarName(varTypeHolder.getText());
                        variable.setVarType(varType.getSelectionModel().getSelectedItem());
                        arrayListOfVar.add(variable);
                        assign.getItems().add(varTypeHolder.getText());
                        varList.getItems().add(varTypeHolder.getText());
                        mainOutput = mainOutput + varType.getSelectionModel().getSelectedItem() + " " + varTypeHolder.getText() + "\n";
                        output.setText(mainOutput);
                        showVarNameRight.setVisible(true);
                    }
                    else {
                        showVarNameRight.setVisible(false);
                        showvarNameWrong.setVisible(true);
                        varNameError.setVisible(true);
                        varNameError.setText(error);
                        error = "";
                    }
                }catch (Exception e){
                    System.out.println("throws IO exception!!!");
                }
            }

        }
    }

    public void Print(ActionEvent event){

        showVarNameRight.setVisible(false);
        showvarNameWrong.setVisible(false);
        varNameError.setVisible(false);


        ShowAssignRight.setVisible(false);
        ShowAssignWrong.setVisible(false);
        ValueError.setVisible(false);


        OpError.setVisible(false);
        OpWrong.setVisible(false);
        OpRight.setVisible(false);


        varTypeHolder.setDisable(true);
        valueHolder.setDisable(true);
        opHolder.setDisable(true);


        msgHolder.setDisable(false);
        String PreviosMainOutput = mainOutput;
        mainOutput = mainOutput + "Print " ;
        output.setText(mainOutput);
        print.setDisable(true);


        msgHolder.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER)
            {
                print.setDisable(false);
                mainOutput = mainOutput + "\"" + msgHolder.getText() + "\"" + "\n";

                try{
                    Print print = new Print();
                    print.filter(msgHolder.getText());
                    if(error!=""){
                        OpPrintError.setVisible(true);
                        OpPrintError.setText(error);
                        PrintOpWrong.setVisible(true);
                        PrintOpRight.setVisible(false);
                        output.setText(PreviosMainOutput);
                        mainOutput = PreviosMainOutput;
                    }
                    else {
                        output.setText(mainOutput);
                        PrintOpWrong.setVisible(false);
                        PrintOpRight.setVisible(true);


                        varTypeHolder.setDisable(false);
                        valueHolder.setDisable(false);
                        opHolder.setDisable(false);
                    }

                }catch (Exception e1){

                }
                msgHolder.setDisable(true);
                //System.out.println(msgHolder.getText());
            }
        });



    }
    public void assignVar(KeyEvent event) {

        showVarNameRight.setVisible(false);
        showvarNameWrong.setVisible(false);
        varNameError.setVisible(false);


        OpPrintError.setVisible(false);
        PrintOpRight.setVisible(false);
        PrintOpWrong.setVisible(false);


        OpError.setVisible(false);
        OpWrong.setVisible(false);
        OpRight.setVisible(false);


        if (event.getCode() == KeyCode.ENTER) {

            ShowAssignRight.setVisible(false);
            ShowAssignWrong.setVisible(false);
            ValueError.setVisible(false);


            String varName = assign.getSelectionModel().getSelectedItem();
            if (varName == null) {
                error = "Please insert a variable Name first";
                ShowAssignRight.setVisible(false);
                ShowAssignWrong.setVisible(true);
                ValueError.setVisible(true);
                ValueError.setText(error);
                error = "";
                return;

            } else {
                Var var1 = new Var();
                boolean mark = false;
                for (int i = 0; i < arrayListOfVar.size(); i++) {
                    var1 = arrayListOfVar.get(i);
                    if (varName.equals(var1.VarName)) {
                        String value = valueHolder.getText();
                        if(var1.VarType.equals("double")){
                                for(int x =0;x<value.length();x++){
                                   if(value.charAt(x) == '.'){
                                       try {
                                           if(!(value.charAt(x+1)>='0' && value.charAt(x+1)<='9'))
                                               error = "Type mismatch!!!";
                                               ShowAssignRight.setVisible(false);
                                               ShowAssignWrong.setVisible(true);
                                               ValueError.setVisible(true);
                                               ValueError.setText(error);
                                               error = "";
                                               return;
                                       }catch (Exception e){
                                           error = "Invalid value!!!";
                                           ShowAssignRight.setVisible(false);
                                           ShowAssignWrong.setVisible(true);
                                           ValueError.setVisible(true);
                                           ValueError.setText(error);
                                           error = "";
                                           return;
                                       }
                                   }

                                    else if(!((value.charAt(x)>='0' && value.charAt(x)<='9') || (value.charAt(x) == '.' ))){
                                        error = "Type mismatch!!!";
                                        ShowAssignRight.setVisible(false);
                                        ShowAssignWrong.setVisible(true);
                                        ValueError.setVisible(true);
                                        ValueError.setText(error);

                                        error = "";

                                        return;


                                    }
                                    else {
                                       try {
                                           c.assignVar(varName, value);
                                           mainOutput = mainOutput + varName + " = " + value + "\n";
                                           output.setText(mainOutput);
                                           var1.setValue(value);

                                           ShowAssignRight.setVisible(true);
                                           ShowAssignWrong.setVisible(false);
                                           ValueError.setVisible(false);
                                       } catch (Exception e) {

                                       }
                                   }
                                }
                        }
                        else if (var1.VarType.equals("int")){
                            for(int x =0;x<value.length();x++){
                                if(!((value.charAt(x)>='0' && value.charAt(x)<='9'))) {
                                    error = "Type mismatch!!!";
                                    ShowAssignRight.setVisible(false);
                                    ShowAssignWrong.setVisible(true);
                                    ValueError.setVisible(true);
                                    ValueError.setText(error);
                                    error = "";
                                    return;
                                }
                            }
                        }
                        else {
                            if(value.length()>1){
                                error = "Type mismatch!!!";
                                ShowAssignRight.setVisible(false);
                                ShowAssignWrong.setVisible(true);
                                ValueError.setVisible(true);
                                ValueError.setText(error);
                                error = "";
                                return;

                            }
                        }
                        if (valueHolder.getText().equals("")) {
                            error = "Give a suitable value!!!";
                            ShowAssignRight.setVisible(false);
                            ShowAssignWrong.setVisible(true);
                            ValueError.setVisible(true);
                            ValueError.setText(error);
                            error = "";
                            return;
                        }
                        try {
                            c.assignVar(varName, value);
                            mainOutput = mainOutput + varName + " = " + value + "\n";
                            output.setText(mainOutput);

                            ShowAssignRight.setVisible(true);
                            ShowAssignWrong.setVisible(false);
                            ValueError.setVisible(false);
                        } catch (Exception e) {

                        }
                        var1.setValue(value);
                        mark = true;

                    }

                }
                if (mark == false) {
                    error = "Variable " + varName + " is not declared yet!!!";
                    ShowAssignRight.setVisible(false);
                    ShowAssignWrong.setVisible(true);
                    ValueError.setVisible(true);
                    ValueError.setText(error);
                    error = "";
                    return;
                }
            }
        }

    }

    public void OpEvent(KeyEvent event) {

        showVarNameRight.setVisible(false);
        showvarNameWrong.setVisible(false);
        varNameError.setVisible(false);


        OpPrintError.setVisible(false);
        PrintOpRight.setVisible(false);
        PrintOpWrong.setVisible(false);


        ShowAssignRight.setVisible(false);
        ShowAssignWrong.setVisible(false);
        ValueError.setVisible(false);


        if (event.getCode() == KeyCode.ENTER) {
            String op = opHolder.getText();
            OpCmd operation = new OpCmd(arrayListOfVar);
            boolean x = operation.filter(op);
            if(x==true){
                try{
                    c.addOp(op);
                    mainOutput = mainOutput + op + "\n";
                    output.setText(mainOutput);

                    OpError.setVisible(false);
                    OpWrong.setVisible(false);
                    OpRight.setVisible(true);
                }catch (Exception e){

                }

            }
            else {
                OpError.setVisible(true);
                OpError.setText(error);
                error = "";
                OpWrong.setVisible(true);
                OpRight.setVisible(false);
            }

        }
    }
    public void LoopMaker(ActionEvent event) throws Exception {
        /*MakeLoop m = new MakeLoop();
        String addit = m.FileWrite();*/
        //System.out.println("addite: " + addit);

        AchorpaneForIeterationPopUp.setVisible(true);
        NoOfIteration.setVisible(true);
        OK.setVisible(true);
    }
    public void getIterationNo(ActionEvent event) throws Exception {
        String iteration = NoOfIteration.getText();
        mainOutput = mainOutput + "Make repeated statement for " + iteration + " times\n[" + "\n";
        output.setText(mainOutput);
        MakeLoop m = new MakeLoop();
        m.makeLoop("makeLoop",iteration);
        AchorpaneForIeterationPopUp.setVisible(false);
        ExitFromLoop.setVisible(true);

    }
    public void exitButtonAction(ActionEvent event) throws Exception {
        MakeLoop m = new MakeLoop();
        mainOutput = mainOutput + "\n]\n";
        output.setText(mainOutput);
        m.makeLoop("exit","0");
        if(s.isEmpty()) ExitFromLoop.setVisible(false);
    }
    public void stop(ActionEvent event) {
        exit(0);
    }
}
