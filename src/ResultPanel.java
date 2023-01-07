import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ResultPanel {
    private static JButton resultButton;
    public JPanel resultPanelCreator(){
        JPanel resultPanel = new JPanel();
        resultPanel.add(BorderLayout.NORTH, numberOfTries());
        resultPanel.add(BorderLayout.CENTER, resultField());
        resultPanel.add(BorderLayout.SOUTH, resultButton());
        return resultPanel;
    }
    public JLabel numberOfTries(){
        return new JLabel("Number of tries equals");
    }
    public JTextField resultField(){
        GamePanel gp = new GamePanel();
        JTextField resultField = new JTextField();
        resultField.setPreferredSize(new Dimension(200, 20));
        resultField.setText(Integer.toString(gp.getTriesCounter()));
        return resultField;
    }
    public JButton resultButton(){
        resultButton = new JButton("Try again");
        resultButton.addActionListener(new ResultButtonListener());
        return resultButton;
    }
    public static class ResultButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resultButton.setEnabled(false);
        }
    }
    public JButton getResultButton(){
        return resultButton;
    }
}
