package black.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import black.process.NumberProcess;

import javax.swing.JMenuBar;

public class CreateWindow extends JFrame implements ActionListener {

    static int windowX = 500;
    static int windowY = 420;

    static int buttonStartX = 10;
    static int buttonStartY = 250;

    private JMenuBar myMenuBar = new JMenuBar();
    private JMenu mainMenu = new JMenu("選單");
    private JMenu helpMenu = new JMenu("說明");

    private JLabel numberLabel;
    private JLabel operatedNumberLabel = new JLabel("");

    private JButton numberButton[] = new JButton[10];
    private JButton numberToZero;
    private JButton number0 = new JButton("0");
    private JButton number1 = new JButton("1");
    private JButton number2 = new JButton("2");
    private JButton number3 = new JButton("3");
    private JButton number4 = new JButton("4");
    private JButton number5 = new JButton("5");
    private JButton number6 = new JButton("6");
    private JButton number7 = new JButton("7");
    private JButton number8 = new JButton("8");
    private JButton number9 = new JButton("9");

    private Container container = getContentPane();

    NumberProcess myNumberProcess = new NumberProcess();

    public CreateWindow() {

        container.setLayout(null);

        numberButton[0] = number0;

        numberToZero = new JButton("C");
        numberToZero.setBounds(buttonStartX, buttonStartY - 3 * 60, 50, 50);

        container.add(numberToZero);

        setLabel();
        setNumberbutton();
        setMenu();
        setFrame();
        // displayWindows();
    }

    private void setLabel() {
        numberLabel = new JLabel("0");
        numberLabel.setBackground(UIManager.getColor("window"));
        numberLabel.setForeground(Color.BLACK);
        numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        numberLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
        numberLabel.setBounds(10, 30, 454, 30);
        container.add(numberLabel);

        operatedNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        operatedNumberLabel.setForeground(Color.BLACK);
        operatedNumberLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
        operatedNumberLabel.setBackground(Color.WHITE);
        operatedNumberLabel.setBounds(10, 10, 454, 30);
        container.add(operatedNumberLabel);
    }

    private void setNumberbutton() {
        for (int i = 1; i <= 9; i++) {
            //numberButton[i] = new JButton(Integer.toString(i));
            numberButton[i].setBounds(buttonStartX + (i - 1) % 3 * 60,
                    buttonStartY - (i - 1) / 3 * 60, 50, 50);
            numberButton[i].addActionListener(this);
            container.add(numberButton[i]);
        }
        numberButton[0] = new JButton("0");
        numberButton[0].setBounds(buttonStartX, buttonStartY + 60, 110, 50);
        numberButton[0].addActionListener(this);
        container.add(numberButton[0]);
    }

    private void setFrame() {
        setTitle("一輩子都在計算的計算機");
        setSize(windowX, windowY);
        setJMenuBar(myMenuBar);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setMenu() {
        myMenuBar.add(mainMenu);
        myMenuBar.add(helpMenu);
    }

    public void displayWindows() {
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        myNumberProcess.receiveInput(e.getActionCommand());
        numberLabel.setText(myNumberProcess.getNumberString());
    }
}
