package black.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import black.process.NumberLabel;

public class StandardCalculator extends BasicWindow implements ActionListener{

    private int windowX = 500;

    private int windowY = 420;

    static int NUMBER_PANEL_Y = 60;

    static int LABEL_HEIGHT = 30;
    static int TEXT_SIZE = 20;

    private JPanel numberPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private GridLayout numberPanelLayout = new GridLayout(0, 1);
    private GridLayout buttonPanelLayout = new GridLayout(6, 3);
    
    private JLabel numberLabel;
    private JLabel operatedNumberLabel = new JLabel("");
    
    NumberLabel myNumberProcess = new NumberLabel();
    
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPoint;
    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonMultiply;
    private JButton buttonEqual;
    private JButton buttonClear;
    
    public StandardCalculator() {
        super();
        getContentPane().setLayout(null);
        setMyFrameSize(windowX, windowY);
        setMyPanel();
        setMyLabel();
        setMyButton();
    }

    private void setMyPanel() {
        numberPanel.setBounds(0, 0, windowX - TEXT_SIZE, NUMBER_PANEL_Y);
        getContentPane().add(numberPanel);
        numberPanel.setLayout(numberPanelLayout);

        buttonPanel.setBounds(0, 0 + NUMBER_PANEL_Y, windowX - TEXT_SIZE,
                windowY - NUMBER_PANEL_Y - 50);
        getContentPane().add(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
    }

    public int getWindowX() {
        return windowX;
    }

    public int getWindowY() {
        return windowY;
    }

    @Override
    protected void setMyLabel() {
        numberLabel = new JLabel("0");
        numberLabel.setName("numberLabel");
        numberLabel.setBackground(UIManager.getColor("window"));
        numberLabel.setForeground(Color.BLACK);
        numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        numberLabel.setFont(new Font("新細明體", Font.PLAIN, TEXT_SIZE));

        operatedNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        operatedNumberLabel.setName("operatedNumberLabel");
        operatedNumberLabel.setForeground(Color.BLACK);
        operatedNumberLabel.setFont(new Font("新細明體", Font.PLAIN, TEXT_SIZE));
        operatedNumberLabel.setBackground(Color.WHITE);

        numberPanel.add(operatedNumberLabel);
        numberPanel.add(numberLabel);

    }

    @Override
    protected void setButtonValue() {
        //TODO ← backspace
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonClear = new JButton("C");        
    }

    @Override
    protected void setButtonLocation() {
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        buttonPanel.add(buttonPoint);
        buttonPanel.add(button0);
        buttonPanel.add(buttonEqual);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonSubtract);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(buttonClear);      
    }

    @Override
    protected void setButtonName() {
        button0.setName("button0");
        button1.setName("button1");
        button2.setName("button2");
        button3.setName("button3");
        button4.setName("button4");
        button5.setName("button5");
        button6.setName("button6");
        button7.setName("button7");
        button8.setName("button8");
        button9.setName("button9");
        buttonAdd.setName("buttonAdd");
        buttonSubtract.setName("buttonSubtract");
        buttonMultiply.setName("buttonMultiply");
        buttonPoint.setName("buttonPoint");
        buttonEqual.setName("buttonEqual");
        buttonClear.setName("buttonClear");        
    }

    @Override
    protected void setButtonListener() {
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        
        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonPoint.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonClear.addActionListener(this);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        try {
            myNumberProcess
                    .receiveInput(Integer.parseInt(e.getActionCommand()));
        } catch (Exception exception) {
            //System.out.println(exception.getMessage());
            myNumberProcess.receiveInput(e.getActionCommand());
        }
        numberLabel.setText(myNumberProcess.getNumberString());
        operatedNumberLabel.setText(myNumberProcess.getOperatedNumberString());
        
    }
}
