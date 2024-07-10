import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] funcButtons=new JButton[10];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,delButton,clrButton,eqButton,percentageButton,ansButton;
    JPanel panel;

    Font myFont= new Font("Serif",Font.BOLD,25);
    double num1=0,num2=0, result=0;
    String operator;


    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,500);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(25, 25, 375, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        eqButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("CLR");
        percentageButton=new JButton("%");
        ansButton=new JButton("ANS");

        funcButtons[0]=addButton;
        funcButtons[1]=subButton;
        funcButtons[2]=mulButton;
        funcButtons[3]=divButton;
        funcButtons[4]=decButton;
        funcButtons[5]=eqButton;
        funcButtons[6]=delButton;
        funcButtons[7]=clrButton;
        funcButtons[8]=percentageButton;
        funcButtons[9]=ansButton;

        for (int i=0; i<10; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

        panel=new JPanel();
        panel.setBounds(25,120,375,325);
        panel.setLayout(new GridLayout(5,4,7,7));
        panel.setBackground(Color.GRAY);

        panel.add(clrButton);
        panel.add(delButton);
        panel.add(percentageButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);    
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(ansButton);
        panel.add(eqButton);
        
        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main (String [] args){

        Calculator calc = new Calculator();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        
        if (e.getSource() == addButton){
            num1=Double.parseDouble(textField.getText());
            operator="+";
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1=Double.parseDouble(textField.getText());
            operator="-";
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1=Double.parseDouble(textField.getText());
            operator="*";
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1=Double.parseDouble(textField.getText());
            operator="/";
            textField.setText("");
        }
        if (e.getSource() == percentageButton){
            num1=Double.parseDouble(textField.getText());
            operator="%";
            textField.setText("");
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == eqButton){
            num2=Double.parseDouble(textField.getText());
            {
                switch (operator){
                    case"+":
                    result=num1+num2;
                    break;
                    case"-":
                    result=num1-num2;
                    break;
                    case"*":
                    result=num1*num2;
                    break;
                    case"/":
                    result=num1/num2;
                    break;
                    case"%":
                    result=num1%num2;
                    break;

                }
                textField.setText(String.valueOf(result));
            }
            
        }
        if (e.getSource() == ansButton){
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

       
    }
}
