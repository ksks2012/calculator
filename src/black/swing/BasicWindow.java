package black.swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public abstract class BasicWindow extends JFrame{
    
    private JMenuBar myMenuBar = new JMenuBar();
    private JMenu viewMenu = new JMenu("檢視");
    private JMenu helpMenu = new JMenu("說明");
    
    protected abstract void setMyLabel();
    
    protected abstract void setButtonValue();
    protected abstract void setButtonLocation();
    protected abstract void setButtonName();  
    protected abstract void setButtonListener();   
    
    public BasicWindow(){
        setMyFame();
        setMyMenu();
    }

    private void setMyFame() {
        setTitle("一輩子都在計算的計算機");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }
    
    protected void setMyFrameSize(int x, int y) {
        setSize(x, y);
    }

    private void setMyMenu() {
        setJMenuBar(myMenuBar);
        myMenuBar.add(viewMenu);
        myMenuBar.add(helpMenu);       
    }
    
    protected void setMyButton() {
        setButtonValue();
        setButtonLocation();
        setButtonName();       
        setButtonListener();
    }
    
    public void displayWindow() {
        setVisible(true);     
    }
}
