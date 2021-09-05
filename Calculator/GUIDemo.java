import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

/**
 * Write a description of class GUIDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUIDemo extends JFrame implements ActionListener, KeyListener {
    JPanel redPanel;
    JPanel greenPanel;
    JPanel bluePanel;
    //
    JButton btnOne;
    JButton btnTwo;
    JButton btnThree;
    //
    JTextField textField;
    //
    String expression = "";
    /**
     * Constructor for objects of class GUIDemo
     */
    public GUIDemo(){
        super("---GUI Demo---");
        setLayout(null);
        //create panels
        redPanel = new JPanel();
        redPanel.setLayout(null);
        redPanel.setBackground(Color.red);
        redPanel.setSize(100,200);
        redPanel.setLocation(10,10);
        
        greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setSize(100,200);
        greenPanel.setLocation(120,10);

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setSize(100,200);
        bluePanel.setLocation(230,10);
        
        add(redPanel);
        add(greenPanel);
        add(bluePanel);
        
        btnOne = new JButton("One");
        btnOne.setSize(60,60);
        btnOne.setLocation(5,5);
        btnOne.setActionCommand("CMD_One");
        btnOne.addActionListener(this);
        
        
        btnTwo = new JButton("Two");
        btnTwo.setActionCommand("CMD_Two");
        btnTwo.addActionListener(this);
        
        btnThree = new JButton("Three");
        btnThree.setActionCommand("CMD_Three");        
        btnThree.addActionListener(this);
        
        redPanel.add(btnOne);
        greenPanel.add(btnTwo);
        bluePanel.add(btnThree);
        
        textField = new JTextField();
        textField.setSize(200, 25);
        textField.setLocation(10,220);
        add(textField);
        
               
        // initialise instance variables
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setCursor(CROSSHAIR_CURSOR);
        setPreferredSize(new Dimension(400, 300));
        pack();
        
        setFocusable(true);
        addKeyListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("CMD_One")) {
           expression = expression + "1";
        } else
        if (cmd.equals("CMD_Two")) {
           expression = expression + "2";
        } else
        if (cmd.equals("CMD_Three")) {
           expression = expression + "3";
        }
        textField.setText(expression);       
    }
    
    public void keyPressed(KeyEvent e) {
       //System.out.println("Backspace was pressed: " + e.getKeyCode());
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_BACK_SPACE)
            System.out.println("Backspace was pressed: " + e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
    
    public static void main (String[] args) {
        GUIDemo frame = new GUIDemo();
        frame.setVisible(true);
    }
}