import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartPanel {
    private JPanel startPan;
    private JTextField startField;
    private static JButton startButton;

    public JPanel startPanelCreator(){
        startPan = new JPanel();
        labelCreator();
        textFieldCreator();
        startButtonCreator();
        return startPan;
    }
    public void labelCreator(){
        JLabel startLabel = new JLabel("Text your pair number");
        startPan.add(BorderLayout.NORTH, startLabel);
    }
    public void textFieldCreator(){
        startField = new JTextField();
        startField.setPreferredSize(new Dimension(200, 20));
        startPan.add(BorderLayout.CENTER, startField);
    }
    public void startButtonCreator() {
        startButton = new JButton("Start");
        startButton.setBackground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.ITALIC, 20));
        startPan.add(BorderLayout.SOUTH, startButton);
        startButton.addActionListener(new StartButtonListener());
    }
    public JButton getStartButton(){
        return startButton;
    }
    public void switchPanelOption(int textFieldValue){
        GamePanel fp = new GamePanel();
        fp.setDeskFacet(textFieldValue);
        fp.setPairNumber(textFieldValue);
    }
    public class StartButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int textFieldValue = Integer.parseInt(startField.getText());
                switchPanelOption(textFieldValue);
                startButton.setEnabled(false);

            }catch(NumberFormatException ex){
                startField.setText("");
                startButton.setEnabled(true);
            }
        }
    }
}
