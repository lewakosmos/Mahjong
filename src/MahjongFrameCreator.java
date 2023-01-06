import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MahjongFrameCreator {
    private JFrame mahjongFrame;
    public void gameHierarchyMethods(){
        StartPanel sp = new StartPanel();
        frameCreator();
        startPanelAdd();
        do{
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                System.out.println("Take your turn");
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }while(sp.getStartButton().isEnabled());
        gamePanelAdd();
    }
    public void frameCreator(){
        mahjongFrame = new JFrame();
        mahjongFrame.setTitle("Mahjong");
        mahjongFrame.setSize(300, 300);
        mahjongFrame.setLocation(500, 400);
        mahjongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void startPanelAdd(){
        StartPanel sp = new StartPanel();
        mahjongFrame.getContentPane().add(sp.startPanelCreator());
        mahjongFrame.setVisible(true);
    }
    public void gamePanelAdd(){
        GamePanel gp = new GamePanel();
        mahjongFrame.setVisible(false);
        mahjongFrame.getContentPane().removeAll();
        mahjongFrame.getContentPane().add(gp.gamePanelCreator());
        mahjongFrame.repaint();
        mahjongFrame.setVisible(true);
    }
}