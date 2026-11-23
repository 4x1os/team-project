package view;

import interface_adapter.create_prediction.CreatePredictionController;
import interface_adapter.create_prediction.CreatePredictionState;
import interface_adapter.create_prediction.CreatePredictionViewModel;
import interface_adapter.create_prediction.CreatePredictionViewModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CreatePredictionView extends JPanel implements ActionListener, CreatePredictionViewModelListener {

    private final CreatePredictionViewModel createPredictionViewModel;
    private final JPanel field = new JPanel();
    private final JTextField titleField;
    private final JTextArea descriptionArea;
    private final JTextField option1Field;
    private final JTextField option2Field;
    private final JButton confirm;
    private CreatePredictionController controller = null;

    public CreatePredictionView(CreatePredictionViewModel createPredictionViewModel){
        this.createPredictionViewModel = createPredictionViewModel;
        field.setLayout(new BoxLayout(field, BoxLayout.Y_AXIS));
        titleField = new JTextField(25);
        descriptionArea = new JTextArea(5,25);
        option1Field = new JTextField(25);
        option2Field = new JTextField(25);
        confirm = new JButton("Confirm");

        confirm.addActionListener(e ->{
            List<String> optionList = new ArrayList<>();
            optionList.add(option1Field.getText());
            optionList.add(option2Field.getText());
            controller.execute(
                    titleField.getText(),
                    descriptionArea.getText(),
                    optionList

            );
        });

        field.add(new JLabel("Title"));
        field.add(titleField);

        field.add(new JLabel("Description"));
        field.add(descriptionArea);

        field.add(new JLabel("Option 1"));
        field.add(option1Field);

        field.add(new JLabel("Option 2"));
        field.add(option2Field);

        field.add(confirm);

        this.add(field);


    }



    @Override
    public void stateChanged(){
        setFields(createPredictionViewModel.getState());
    }

    private void setFields(CreatePredictionState state){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click: " + e);
    }

    public void setCreatePredictionController(CreatePredictionController controller){
        this.controller = controller;
    }
}
