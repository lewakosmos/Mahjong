import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GamePanel {
    private JPanel finishedPanel;
    private ArrayList<String> finishedButtonNameList;
    private ArrayList<JButton> finishedButtonActionList;
    private int deskFacet;
    private int pairNumber;
    public JPanel gamePanelCreator(){
        finishedPanel = new JPanel();
        finishedPanel.setLayout(new GridLayout(deskFacet, deskFacet));
        buttonTableCreator();
        return finishedPanel;
    }
    public void buttonTableCreator(){
        buttonNamesCreator();
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
    public void buttonNamesCreator(){
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
        for(JButton button : finishedButtonActionList){
            button.addActionListener(e -> {
                button.setBackground(Color.white);
                button.setEnabled(false);
                localCheckButtonList.add(button);
                if(localCheckButtonList.size() ==2 &&
                        !localCheckButtonList.get(0).getText().equals(localCheckButtonList.get(1).getText())){
                    localCheckButtonList.forEach(JButton -> JButton.setBackground(Color.CYAN));
                    localCheckButtonList.forEach(JButton -> JButton.setEnabled(true));
                    localCheckButtonList.clear();
                }
                else if(localCheckButtonList.size() ==2 &&
                        localCheckButtonList.get(0).getText().equals(localCheckButtonList.get(1).getText())){
                    localCheckButtonList.clear();
                }
            });
        }
    }

    public void setDeskFacet(int deskFacet){
        if(deskFacet == 2){
            this.deskFacet = deskFacet;
        }
        else{
            this.deskFacet = ((int) Math.sqrt(deskFacet*2)) + 1;
        }
    }
    public void setPairNumber(int pairNumber){
        this.pairNumber = pairNumber;
    }
}