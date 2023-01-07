import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
public class MahjongFrameCreator {
    private static JFrame mahjongFrame;
    private CardLayout mahjongCardLayout;
    private JPanel mainMahjongPanel;
    public void frameHierarchyMethods(){
        frameCreator();
        panelHierarchyMethod();
    }
    public void frameCreator(){
        mahjongFrame = new JFrame();
        mahjongFrame.setTitle("Mahjong");
        mahjongFrame.setSize(300, 300);
        mahjongFrame.setLocation(500, 400);
        mahjongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void panelHierarchyMethod(){
        layoutCreator();
        startPanelAdd();
        startPanelDelay();
        gamePanelAdd();
        gamePanelDelay();
        resultPanelAdd();
        tryAgainDelay();
    }
    public void layoutCreator(){
        mahjongCardLayout = new CardLayout();
        mainMahjongPanel = new JPanel(mahjongCardLayout);
        mahjongFrame.add(mainMahjongPanel);
    }
    public void startPanelAdd(){
        StartPanel sp = new StartPanel();
        mainMahjongPanel.add(sp.startPanelCreator());
        mahjongFrame.setVisible(true);
    }
    public void startPanelDelay(){
        StartPanel sp = new StartPanel();
        do{
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }while(sp.getStartButton().isEnabled());
    }
    public void gamePanelAdd(){
        GamePanel gp = new GamePanel();
        mainMahjongPanel.add(gp.gamePanelCreator());
        mahjongCardLayout.next(mainMahjongPanel);
    }
    public void gamePanelDelay(){
        GamePanel gp = new GamePanel();
        do{
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }while(!gp.getFinishedButtonActionList().isEmpty());
    }
    public void resultPanelAdd(){
        ResultPanel rp = new ResultPanel();
        mainMahjongPanel.add(rp.resultPanelCreator());
        mahjongCardLayout.next(mainMahjongPanel);
    }
    public void tryAgainDelay(){
        ResultPanel rp = new ResultPanel();
        while(rp.getResultButton().isEnabled()){
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        frameRecreation();
    }
    public void frameRecreation(){
        mahjongFrame.setVisible(false);
        mahjongFrame.getContentPane().removeAll();
        panelHierarchyMethod();
    }
}