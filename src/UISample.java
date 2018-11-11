import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UISample {
    private JFrame mainFrame;//Main Frame of everything

    private JLabel headerLabel;//The top thingy that says the name
    private JLabel statusLabel;//This is the thing that shows Query : Something

    private JPanel controlPanel;//A block that holds Labels and stuff
    private JPanel scorePanel;//Another block for TFIDF

    private JLabel msglabel;//Msg that is green
    private JLabel outputlabel;//the thing to show TFIDF

    private JTextField input;//input xD

    public UISample(){
        GUI();//calls GUI
    }
    public static void main(String[] args){
        UISample  Show = new UISample();//Init
        Show.show();//calls show for stuff out of initialization
    }
    private void GUI(){
        mainFrame = new JFrame("Documents Search System for Thai Alternative Education platform Using TFIDF");
        mainFrame.setSize(1200,780);//Size of the popup
        mainFrame.setLayout(new GridLayout(5, 1));//how many blocks
        //Exit program
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        //Exit Program

        headerLabel = new JLabel("Documents Search System for Thai Alternative Education platform Using TFIDF", JLabel.CENTER);
        statusLabel = new JLabel("Prototype",JLabel.CENTER);
        statusLabel.setSize(350,100);//Size of status Labal
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());

        msglabel = new JLabel("temp text not gonna show anyways");
        outputlabel = new JLabel("Nope");//Just to initialize these text

        mainFrame.add(headerLabel);//Head
        mainFrame.add(controlPanel);//1 block
        mainFrame.add(statusLabel);//2 block
        mainFrame.add(scorePanel);
        mainFrame.setVisible(true);
        scorePanel.setVisible(false);//Set false until search is done
    }
    private void show(){

        JPanel panel = new JPanel();
        msglabel.setText("Enter Your Query here");
        panel.setLayout(new FlowLayout());
        panel.add(msglabel);
        controlPanel.add(panel);//1st part which is green
        //////////////////////////// INPUT Field here with size of 12 char (can enter more but shows 12 at a time)
        input = new JTextField(12);
        controlPanel.add(input);//
        ///////////////////////////
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Query : " + input.getText();
                statusLabel.setText(data);

                scorePanel.setVisible(true);//after clicking search and finishing compute score set the visibility to true
            }
        });
        controlPanel.add(searchButton);

        mainFrame.setVisible(true);
    }
}