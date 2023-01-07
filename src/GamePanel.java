import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GamePanel {
    private JPanel finishedPanel;
    private ArrayList<String> finishedButtonNameList;
    private static ArrayList<JButton> finishedButtonActionList;
    private static int deskFacet;
    private static int pairNumber;
    private static int triesCounter;
    public JPanel gamePanelCreator(){
        finishedPanel = new JPanel();
        finishedPanel.setLayout(new GridLayout(deskFacet, deskFacet));
        buttonTableCreator();
        return finishedPanel;
    }
    public void buttonTableCreator(){
        tileNamesCreator();
        finishedButtonActionList = new ArrayList<>();
        int tileAmount = (int) Math.pow(deskFacet, 2);
        for(int i = 0; i < tileAmount; i++){
            JButton finishPanelButton = new JButton();
            finishPanelButton.setText(finishedButtonNameList.get(i));
            finishPanelButton.setBackground(Color.CYAN);
            finishPanelButton.setForeground(Color.CYAN);
            finishedButtonActionList.add(finishPanelButton);
            finishedPanel.add(finishPanelButton);
        }
        buttonActionCreator();
    }
    public void tileNamesCreator(){
        int tileAmount = (int) Math.pow(deskFacet, 2);
        ArrayList<String> orderedList = new ArrayList<>();
        orderedList.addAll(firstPairListCreator());
        orderedList.addAll(secondPairListCreator());
        orderedList.addAll(emptyTileListCreator());
        finishedButtonNameList = new ArrayList<>();
        for(int i = 0; i < tileAmount; i++){
            String randomTile = orderedList.get((int) (Math.random()*orderedList.size()));
            finishedButtonNameList.add(randomTile);
            orderedList.remove(randomTile);
        }
    }
    public ArrayList<String> firstPairListCreator(){
        ArrayList<String> firstPairList = new ArrayList<>();
        for(int i = 0; i < pairNumber; i++){
            firstPairList.add(Integer.toString(i+1));
        }
        return firstPairList;
    }
    public ArrayList<String> secondPairListCreator(){
        ArrayList<String> secondPairList = new ArrayList<>();
        for(int i = 0; i < pairNumber; i++){
            secondPairList.add(Integer.toString(i+1));
        }
        return secondPairList;
    }
    public ArrayList<String> emptyTileListCreator(){
        int tileAmount = (int) Math.pow(deskFacet, 2);
        ArrayList<String> emptyTileList = new ArrayList<>();
        for(int i = 0; i < (tileAmount- 2*pairNumber); i++){
            emptyTileList.add("X");
        }
        return emptyTileList;
    }
    public void buttonActionCreator(){
        ArrayList<JButton> localCheckButtonList = new ArrayList<>();
        ArrayList<JButton> localButtonList = new ArrayList<>(finishedButtonActionList);
        for(JButton button : localButtonList){
            buttonOptionCreator(button, localCheckButtonList);
        }
    }
    public void buttonOptionCreator(JButton button, ArrayList<JButton> localCheckButtonList){
        button.addActionListener(e -> {
            button.setBackground(Color.white);
            button.setEnabled(false);
            localCheckButtonList.add(button);
            if(localCheckButtonList.size() ==2 &&
                    !localCheckButtonList.get(0).getText().equals(localCheckButtonList.get(1).getText())){
                localCheckButtonList.forEach(JButton -> JButton.setBackground(Color.CYAN));
                localCheckButtonList.forEach(JButton -> JButton.setEnabled(true));
                localCheckButtonList.clear();
                triesCounter++;
            }
            else if(localCheckButtonList.size() ==2 &&
                    localCheckButtonList.get(0).getText().equals(localCheckButtonList.get(1).getText())){
                finishedButtonActionList.removeAll(localCheckButtonList);
                localCheckButtonList.clear();
                triesCounter++;
            }
            listSizeException();
        });
    }
    public void listSizeException(){
        if(finishedButtonActionList.size() == 1){
            finishedButtonActionList.clear();
        }
    }
    public void setDeskFacet(int deskFacet){
        if(deskFacet == 2){
            GamePanel.deskFacet = deskFacet;
        }
        else{
            GamePanel.deskFacet = ((int) Math.sqrt(deskFacet*2)) + 1;
        }
    }
    public void setPairNumber(int pairNumber){
        GamePanel.pairNumber = pairNumber;
    }
    public int getTriesCounter(){
        return triesCounter;
    }
    public ArrayList<JButton> getFinishedButtonActionList(){
        return finishedButtonActionList;
    }
}