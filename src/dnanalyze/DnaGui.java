package dnanalyze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DnaGui extends JFrame
{
    private JButton sequenceDNAButton;
    private JButton clearButton;
    private JTextField classField;
    private JLabel label;
    private JLabel translLabel;
    private JLabel transcLabel;
    private JTextField transcField;
    private JTextField translField;
    private JRadioButton radioButtonTranslation;
    private JRadioButton radioButtonTranscription;
    private JRadioButton radioButtonBoth;
    private ButtonGroup radioButtonGroup;
    
    public DnaGui()
    {
        createGUI();

        setTitle( "DNAnalyzer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(325, 300));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    ///*
    // * For testing
    public static void main(String args[])
    {
       DnaGui DNAGui = new DnaGui();
       DNAGui.setVisible(true);
    }
    //*/
    
    private void createGUI()
    {
        JPanel pane = new JPanel();
        this.getContentPane().add( pane );
        pane.setLayout( new FlowLayout( FlowLayout.LEFT ) );
        
        // create first text box (input)
        label = new JLabel();
        label.setText( "DNA Sequence:" );
        classField = new JTextField();
        classField.setPreferredSize( new Dimension( 200, 30 ) );
        
        //create radio group
        radioButtonGroup = new ButtonGroup();
        
        //create Translation button
        radioButtonTranslation = new JRadioButton();
        radioButtonTranslation.setText( "Translation" );
        
        //create Transcription button
        radioButtonTranscription = new JRadioButton();
        radioButtonTranscription.setText( "Transcription" );
        
        //create Both button
        radioButtonBoth = new JRadioButton();
        radioButtonBoth.setText( "Both");
        
        // create Translation output text box
        translLabel = new JLabel();
        translLabel.setText( "Translation: ");
        translField = new JTextField();
        translField.setPreferredSize(new Dimension(200, 30));
        translField.setEditable(false);
        
        // create Transcription output text box
        transcLabel = new JLabel();
        transcLabel.setText( "Transcription: ");
        transcField = new JTextField();
        transcField.setPreferredSize(new Dimension(200, 30));
        transcField.setEditable(false);
        
        // create Sequence DNA button
        sequenceDNAButton = new JButton( "Sequence DNA");
        sequenceDNAButton.addActionListener( new sequenceDNAButtonListener());
        sequenceDNAButton.setPreferredSize(new Dimension(300, 100));
        
        // create clear button
        clearButton = new JButton( "Clear");
        clearButton.addActionListener( new clearButtonListener());
        clearButton.setPreferredSize(new Dimension(300, 100));
        
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
        pane.add(translLabel);
        pane.add(translField);
        
        // group/add third text box
        pane.add(transcLabel);
        pane.add(transcField);
        
        // group/add buttons
        pane.add(sequenceDNAButton);
        pane.add(clearButton);
    }
    
    private class clearButtonListener implements ActionListener 
    {
       @Override
       public void actionPerformed(ActionEvent ae) 
       {
          classField.setText( "" );
          transcField.setText( "" );
          translField.setText( "" );
          radioButtonTranslation.setEnabled(false);
          radioButtonTranscription.setEnabled(false);
          radioButtonBoth.setEnabled(false);
       }
    }
       
    private class sequenceDNAButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            DNAInput stringValidate = new DNAInput(); 
            String DNASequence = classField.getText();
            
            // check for empty string
            if( DNASequence.equals( "" ) )
            {
               translField.setText( "DNA Sequence empty, please enter text!" );
               transcField.setText( "DNA Sequence empty, please enter text!" );
            }
            
            // if not empty
            else
            {
               // if valid string
               if( stringValidate.validateDNAString( DNASequence ) )
               {
                  // display translation
                  if( radioButtonTranslation.isSelected() )
                  {
                     // transcribe sequence for translation
                     Transcriber transcribe = new Transcriber( DNASequence );
                     String RNAString = transcribe.Transcribe();
                     
                     //translate sequence
                     Translator translate = new Translator( RNAString );
                     translate.translateSequence();
                     String translation = translate.toString();
                     translField.setText( translation );
                  }
                  
                  // display transcription
                  else if( radioButtonTranscription.isSelected() )
                  {
                     // transcribe sequence
                     Transcriber transcribe = new Transcriber( DNASequence );
                     transcField.setText( transcribe.Transcribe() );
                  }
                  
                  // display translation and transcription
                  else if( radioButtonBoth.isSelected() )
                  {
                     // transcribe sequence
                     Transcriber transcribe = new Transcriber( DNASequence );
                     String RNAString = transcribe.Transcribe();
                     transcField.setText( RNAString );
                     
                     //translate sequence
                     Translator translate = new Translator( RNAString );
                     translate.translateSequence();
                     String translation = translate.toString();
                     translField.setText( translation );
                  }
               }
               
               // if not valid string
               else
               {
                  // display error text
                  if( radioButtonTranslation.isSelected() )
                  {
                     translField.setText( "DNA Sequence invalid!" );
                     transcField.setText( "" );
                  }
                  
                  // display error text
                  else if( radioButtonTranscription.isSelected() )
                  {
                     transcField.setText( "DNA Sequence invalid!" );
                     translField.setText( "" );
                  }
                  
                  // display error text
                  else if( radioButtonBoth.isSelected() )
                  {
                     translField.setText( "DNA Sequence invalid!" );
                     transcField.setText( "DNA Sequence invalid!" );
                  }
               }
            }
            
        }
    }
}
