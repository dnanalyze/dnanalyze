package CS386;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DnaGui extends JFrame
{
    private JButton addClass;
    private JTextField classField;
    private JLabel label;
    private JLabel capLabel;
    private JLabel transcLabel;
    private JTextField transcField;
    private JTextField capField;
    private JRadioButton radioButtonTranslation;
    private JRadioButton radioButtonTranscription;
    private JRadioButton radioButtonBoth;
    private ButtonGroup radioButtonGroup;
    
    public DnaGui()
    {
        createGUI();

        setTitle("DNAnalyzer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(325, 300));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String args[])
    {
       DnaGui DNAGui = new DnaGui();
       DNAGui.setVisible(true);
    }
    
    private void createGUI()
    {
        JPanel pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // create first text box (input)
        label = new JLabel();
        label.setText("DNA Sequence:");
        classField = new JTextField();
        classField.setPreferredSize(new Dimension(200, 30));
        
        //create radio group
        radioButtonGroup = new ButtonGroup();
        
        //create Translation button
        radioButtonTranslation = new JRadioButton();
        radioButtonTranslation.setText("Translation");
        
        //create Transcription button
        radioButtonTranscription = new JRadioButton();
        radioButtonTranscription.setText("Transcription");
        
        //create Both button
        radioButtonBoth = new JRadioButton();
        radioButtonBoth.setText("Both");
        
        // create Translation output text box
        capLabel = new JLabel();
        capLabel.setText("Translation: ");
        capField = new JTextField();
        capField.setPreferredSize(new Dimension(200, 30));
        capField.setEditable(false);
        
        // create Transcription output text box
        transcLabel = new JLabel();
        transcLabel.setText("Transcription: ");
        transcField = new JTextField();
        transcField.setPreferredSize(new Dimension(200, 30));
        transcField.setEditable(false);
        
        // create Sequence DNA button
        addClass = new JButton("Sequence DNA");
        addClass.addActionListener( new addClassListener());
        addClass.setPreferredSize(new Dimension(300, 100));
        
        // group/add first text box
        pane.add(label);
        pane.add(classField);
        
        // group/add first text box
        pane.add(radioButtonTranslation);
        pane.add(radioButtonTranscription);
        pane.add(radioButtonBoth);
        radioButtonGroup.add(radioButtonTranslation);
        radioButtonGroup.add(radioButtonTranscription);
        radioButtonGroup.add(radioButtonBoth);
        
        // group/add second text box
        pane.add(capLabel);
        pane.add(capField);
        
        // group/add third text box
        pane.add(transcLabel);
        pane.add(transcField);
        
        // group/add first button
        pane.add(addClass);
    }

    private class addClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String courseCode = classField.getText();
            
            DnaGui.this.dispose();

        }
    }
}
