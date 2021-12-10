package sample.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TableView;
import sample.classes.Configuration;
import sample.classes.cpu.CPU;
import sample.classes.process.Process;

import java.util.ArrayList;

public class ControllerCore {
    @FXML
    private void initialize()
    {
        Main.controller.genCoreAccordion(coreAccordion);

    }

    @FXML
    Accordion coreAccordion;

    public void updateCoreList(CPU cpu)
    {
        for(int i = Configuration.coreCount-1; i>-1 ; i--)
        {
            ArrayList<Process> arr = new ArrayList<>();
            arr.add(cpu.getCores()[i].getCurrentProcess());
            TableView t = (TableView) coreAccordion.getPanes().get(i).getContent();
            t.setItems(FXCollections.observableArrayList(arr));
        }
    }

    public void clearCoreList() {
        for(int i = Configuration.coreCount-1; i>-1 ; i--)
        {
            TableView t = (TableView) coreAccordion.getPanes().get(i).getContent();
            t.setItems(null);
        }
    }
}
