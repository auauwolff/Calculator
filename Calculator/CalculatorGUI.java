import javax.swing.JButton; 
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.lang.Math;
import java.awt.Font;
import java.awt.*;  
import javax.swing.*;
import java.util.stream.LongStream;

import java.util.Stack;
import java.util.Scanner;

public class CalculatorGUI {
    
    JTextField displayBox;
    private String font = "Comic Sans MS"; //Font that I am using
    private String button = "";
    private String input = "";   //Holds the user input
    private boolean NewEntry = false; // Resets the screen after user evaluate the expression
    private double result;
    DecimalFormat formater = new DecimalFormat("0.##########");
    
    //Start GUI logic
    public void displayCalculator() {
        
        //buttons to be created
        JButton one, two, three, four, five, six, seven, 
        eight, nine, dot, zero, addition, subtract, adsub,factorial,
        multiply, divide, equals, clear, backspace,
        close, open, off;
            
        ImageIcon img = new ImageIcon("./icon.png"); //Caculator Icon
        JFrame frame = new JFrame("My PROG5001 - Calculator (v1.1)");
        frame.setIconImage(img.getImage()); //Set Icon image
        JPanel mainPane = new JPanel(new GridBagLayout()); //New instace of GridBagLayout
        mainPane.setBackground(Color.WHITE);//Color background of the application
        
        //Create display box
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=5;
        c.weightx=1;
        c.ipady = 8;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(10,10,10,10);
        displayBox = new JTextField(20);
        displayBox.setFont(new Font(font, Font.PLAIN, 30));
        mainPane.add(displayBox, c);
       
        //Create 1 button
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=1;
        c.weightx=1;
        c.weighty=1;
        c.gridwidth=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,10,5,5);
        one = new JButton("1");
        one.setFont(new Font(font, Font.PLAIN, 20));
        one.setBackground(new Color(204, 204, 204));
        one.addActionListener(new NumberButton());
        one.setActionCommand("1");
        mainPane.add(one,c);
       
        //Create 2 button
        c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=1;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        two = new JButton("2");
        two.setFont(new Font(font, Font.PLAIN, 20));
        two.setBackground(new Color(204, 204, 204));
        two.addActionListener(new NumberButton());
        two.setActionCommand("2");
        mainPane.add(two,c);
        
        //Create 3 button
        c = new GridBagConstraints();
        c.gridx=2;
        c.gridy=1;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        three = new JButton("3");
        three.setFont(new Font(font, Font.PLAIN, 20));
        three.setBackground(new Color(204, 204, 204));
        three.addActionListener(new NumberButton());
        three.setActionCommand("3");
        mainPane.add(three,c);
        
        //Create + button
        c = new GridBagConstraints();
        c.gridx=3;
        c.gridy=1;
        c.weightx=1;
        c.gridwidth=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,15,5,5);
        addition = new JButton(" + ");
        addition.setFont(new Font(font, Font.PLAIN, 20));
        addition.setBackground(new Color(204, 204, 204));
        addition.addActionListener(new OperationButton());
        addition.setActionCommand(" + ");
        mainPane.add(addition,c);
        
        //Create backspace "<<" button
        c = new GridBagConstraints();
        c.gridx=4;
        c.gridy=1;
        c.weightx=10;
        c.weighty=10;
        c.gridwidth=10;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,10);
        backspace = new JButton(" << ");
        backspace.setFont(new Font(font, Font.PLAIN, 20));
        backspace.setBackground(new Color(204, 204, 204));
        backspace.addActionListener(new OperationButton());
        backspace.setActionCommand(" << ");
        mainPane.add(backspace,c);
        
        ////Create 4 button
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=2;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,10,5,5);
        four = new JButton("4");
        four.setFont(new Font(font, Font.PLAIN, 20));
        four.setBackground(new Color(204, 204, 204));
        four.addActionListener(new NumberButton());
        four.setActionCommand("4");
        mainPane.add(four,c);
        
        //Create 5 button
        c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=2;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        five = new JButton("5");
        five.setFont(new Font(font, Font.PLAIN, 20));
        five.setBackground(new Color(204, 204, 204));
        five.addActionListener(new NumberButton());
        five.setActionCommand("5");
        mainPane.add(five,c);
        
        //Create 6 button
        c = new GridBagConstraints();
        c.gridx=2;
        c.gridy=2;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        six = new JButton("6");
        six.setFont(new Font(font, Font.PLAIN, 20));
        six.setBackground(new Color(204, 204, 204));
        six.addActionListener(new NumberButton());
        six.setActionCommand("6");
        mainPane.add(six,c);
        
        //Create - button
        c = new GridBagConstraints();
        c.gridx=3;
        c.gridy=2;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,15,5,5);
        subtract = new JButton(" - ");
        subtract.setFont(new Font(font, Font.PLAIN, 20));
        subtract.setBackground(new Color(204, 204, 204));
        subtract.addActionListener(new OperationButton());
        subtract.setActionCommand(" - ");
        mainPane.add(subtract,c);
        
        //Create C button
        c = new GridBagConstraints();
        c.gridx=4;
        c.gridy=2;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,10);
        clear = new JButton(" C ");
        clear.setFont(new Font(font, Font.PLAIN, 20));
        clear.setBackground(new Color(204, 204, 204));
        clear.addActionListener(new OperationButton());
        clear.setActionCommand(" C ");
        mainPane.add(clear,c);
        
        //Create 7 button
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=3;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,10,5,5);
        seven = new JButton("7");
        seven.setFont(new Font(font, Font.PLAIN, 20));
        seven.setBackground(new Color(204, 204, 204));
        seven.addActionListener(new NumberButton());
        seven.setActionCommand("7");
        mainPane.add(seven,c);
        
        //Create 8 button
        c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=3;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        eight = new JButton("8");
        eight.setFont(new Font(font, Font.PLAIN, 20));
        eight.setBackground(new Color(204, 204, 204));
        eight.addActionListener(new NumberButton());
        eight.setActionCommand("8");
        mainPane.add(eight,c);
        
        //Create 9 button
        c = new GridBagConstraints();
        c.gridx=2;
        c.gridy=3;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        nine = new JButton("9");
        nine.setFont(new Font(font, Font.PLAIN, 20));
        nine.setBackground(new Color(204, 204, 204));
        nine.addActionListener(new NumberButton());
        nine.setActionCommand("9");
        mainPane.add(nine,c);
        
        //Create * button
        c = new GridBagConstraints();
        c.gridx=3;
        c.gridy=3;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,15,5,5);
        multiply = new JButton(" * ");
        multiply.setFont(new Font(font, Font.PLAIN, 20));
        multiply.setBackground(new Color(204, 204, 204));
        multiply.addActionListener(new OperationButton());
        multiply.setActionCommand(" * ");
        mainPane.add(multiply,c);
        
        //Create ( button
        c = new GridBagConstraints();
        c.gridx=4;
        c.gridy=3;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,10);
        open = new JButton("( ");
        open.setFont(new Font(font, Font.PLAIN, 20));
        open.setBackground(new Color(204, 204, 204));
        open.addActionListener(new OperationButton());
        open.setActionCommand(" ( ");
        mainPane.add(open,c);
        
        //Create +- button
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=4;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,10,5,5);
        adsub = new JButton("+/-");
        adsub.setFont(new Font(font, Font.PLAIN, 20));
        adsub.setBackground(new Color(204, 204, 204));
        adsub.addActionListener(new OperationButton());
        adsub.setActionCommand("+/-");
        mainPane.add(adsub,c);
        
        //Create 0 button
        c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=4;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        zero = new JButton("0");
        zero.setFont(new Font(font, Font.PLAIN, 20));
        zero.setBackground(new Color(204, 204, 204));
        zero.addActionListener(new NumberButton());
        zero.setActionCommand("0");
        mainPane.add(zero,c);
        
        //Create . button
        c = new GridBagConstraints();
        c.gridx=2;
        c.gridy=4;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,5);
        dot = new JButton(" . ");
        dot.setFont(new Font(font, Font.PLAIN, 20));
        dot.setBackground(new Color(204, 204, 204));
        dot.addActionListener(new OperationButton());
        dot.setActionCommand(" . ");
        mainPane.add(dot,c);
        
        //Create / button
        c = new GridBagConstraints();
        c.gridx=3;
        c.gridy=4;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,15,5,5);
        divide = new JButton(" / ");
        divide.setFont(new Font(font, Font.PLAIN, 20));
        divide.setBackground(new Color(204, 204, 204));
        divide.addActionListener(new OperationButton());
        divide.setActionCommand(" / ");
        mainPane.add(divide,c);
        
        //Create ) button
        c = new GridBagConstraints();
        c.gridx=4;
        c.gridy=4;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,5,10);
        close = new JButton(" )");
        close.setFont(new Font(font, Font.PLAIN, 20));
        close.setBackground(new Color(204, 204, 204));
        close.addActionListener(new OperationButton());
        close.setActionCommand(" )");
        mainPane.add(close,c);
        
       //Create = button
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=5;
        c.weightx=1;
        c.weighty=1;
        c.gridwidth=3;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,10,20,5);
        equals = new JButton(" = ");
        equals.setFont(new Font(font, Font.PLAIN, 20));
        equals.setBackground(new Color(204, 204, 204));
        equals.addActionListener(new EqualsButton());
        equals.setActionCommand(" = ");
        mainPane.add(equals,c);
       
        //Create ! button
        c = new GridBagConstraints();
        c.gridx=3;
        c.gridy=5;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,15,20,5);
        factorial = new JButton(" ! ");
        factorial.setFont(new Font(font, Font.PLAIN, 20));
        factorial.setBackground(new Color(204, 204, 204));
        factorial.addActionListener(new OperationButton());
        factorial.setActionCommand(" ! ");
        mainPane.add(factorial,c);
        
        //Create OFF button
        c = new GridBagConstraints();
        c.gridx=4;
        c.gridy=5;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(5,5,20,10);
        off = new JButton(" OFF ");
        off.setFont(new Font(font, Font.PLAIN, 20));
        off.setBackground(new Color(255,102,102));
        off.addActionListener(new OperationButton());
        off.setActionCommand(" OFF ");
        mainPane.add(off,c);
    
        //Frame settings
        frame.getContentPane().add(BorderLayout.NORTH, mainPane);
        frame.setSize(450, 370);
        frame.setLocationRelativeTo(null); // Move window to center
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    //Create event listener for number buttons, check if is a new entry or not
    class NumberButton implements ActionListener {        
        public void actionPerformed(ActionEvent event) {
       
            if (NewEntry){
            displayBox.setText("");
            NewEntry = false;
            input = "";
            }
        
            button = event.getActionCommand();
            displayBox.setText(displayBox.getText() + button);
            input = input + button; //attribute the value of the button to the display input
        }
    }
    
     //Create event listener for operations buttons, check if is a new entry or not
    class OperationButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            button = event.getActionCommand();    
            
            if (NewEntry){
                displayBox.setText("");
                NewEntry = false;
                input = "";
            }
            //backspace operation
            if (button == " << "){
                StringBuffer sb = new StringBuffer(displayBox.getText());
                sb = sb.deleteCharAt(displayBox.getText().length()-1);
                displayBox.setText(sb.toString());
                input = displayBox.getText();
            }
            //negative numbers operation
            else if (button == "+/-"){
                displayBox.setText(displayBox.getText() + "-");
                input = input + "-";
               }
            // Clear operation
            else if (button == " C "){
                displayBox.setText("");
                input = "";
            }
            //Exit calculator operation
            else if (button == " OFF "){
                    System.exit(0);

            }else{
                displayBox.setText(displayBox.getText() + button);
                input = input + button;
            }
        }
    }
    
    //Calculator logic Starts
    class Calculator {
        
        private String token = "";
        private String exception = "";
        
        public String getException (){
            return exception;
    }
    
    //Check if the operations input are inserted correctly
    public boolean checkInput (String in){
        
        int open = 0;
        int closed = 0;
        int opCount = 0;
        int numCount = 0;
        boolean valid = true;
        
        Scanner reader = new Scanner(in);
            
        while (reader.hasNext()){
            token = reader.next();
            if (token.equals("("))
                open++;
            if (token.equals(")"))
                closed++;
            if (isNumber(token))
                numCount++;
            if (isOperator(token))
                opCount++;
        }
        //Check if there is only "(" in the input or only ")"
        if (open != closed){
            valid = false;
            exception = "Error: parenthesis must have open and close (expression)";
        }
       
       //More the one operator for example 2+*2
       if (numCount <= opCount){
            valid = false;
            exception = "Error: the use of operators is not valid";
        } 
    
       //No operator input 
       if (opCount == 0){
            valid = false;
            exception = "Error: please input an operator";
       }
       return valid;
    }
    
    //Read the input and in order of parenthesis
    public double readInput (String exp){
        Scanner input = new Scanner(exp);
        Stack<Double> num = new Stack<Double>();
        Stack<String> op = new Stack<String>();
        
        while (input.hasNext()){
            token = input.next();
            if(isNumber(token)){
                num.push(Double.parseDouble(token));
            } else if (token.equals("(")){
                op.push(token);
            } else if (token.equals(")")){
                while(!op.peek().equals("(")){
                  num.push(evaluate(op.pop(), num.pop(), num.pop()));
                }
                op.pop();
            } else {
                while(!op.empty() && hasPrecedence(token, op.peek())){
                  num.push(evaluate(op.pop(), num.pop(), num.pop()));
                } op.push(token);
            } 
        }
    
        while (!op.empty()) {
                num.push(evaluate(op.pop(), num.pop(), num.pop()));
        } return num.pop();
    }
    
    //Verify input if is number or negative expression
    private boolean isNumber (String exp){
        if (exp.startsWith("-") && (exp.length() > 1))
            return true;
        else if (exp.startsWith("0"))
            return true;
        else if (exp.startsWith("1"))
            return true;
        else if (exp.startsWith("2"))
            return true;
        else if (exp.startsWith("3"))
            return true;
        else if (exp.startsWith("4"))
            return true;
        else if (exp.startsWith("5"))
            return true;
        else if (exp.startsWith("6"))
            return true;
        else if (exp.startsWith("7"))
            return true;
        else if (exp.startsWith("8"))
            return true;
        else if (exp.startsWith("9"))
            return true;
        else
            return false;
    }
    
    //Verify input if the operator is valid
    private boolean isOperator (String exp){
        if (exp.equals("+"))
            return true;
        else if (exp.equals("-"))
            return true;
         else if (exp.equals("."))
            return true;
        else if (exp.equals("*"))
            return true;
        else if (exp.equals("/"))
            return true;
        else if (exp.equals("!"))
            return true;
        else
            return false;
    }
    
    //Identify the order of the expressins
    private boolean hasPrecedence(String op1, String op2)
    {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;
    }
 
    //Evalue expressions
     private double evaluate (String operation, double num2, double num1) {
        if(operation.equals("+")) {
            num1 = num1 + num2;
        } else if(operation.equals("-")){
            num1 = num1 - num2;
        } else if(operation.equals("*")){
            num1 = num1 * num2;
        } else if(operation.equals("/")){
            num1 = num1 / num2;
        } else if(operation.equals("!")){
             long num = (long) num1;
             num1 = LongStream.rangeClosed(2, num).reduce(1, Math::multiplyExact);
        }return num1;
    }
}
    //Equal button operation
    class EqualsButton implements ActionListener {
        Calculator evaluate = new Calculator();
        
        public void actionPerformed(ActionEvent event){
            NewEntry = true;

            if (evaluate.checkInput(input)){
                button = event.getActionCommand();
                result = evaluate.readInput(input);
                displayBox.setText(displayBox.getText() + button + formater.format(result));
            } else
                displayBox.setText(evaluate.getException());
        }
    }

    //Main method Start calculator
        public static void main(String[] args) {
        CalculatorGUI gui = new CalculatorGUI();
        gui.displayCalculator();
    }
}