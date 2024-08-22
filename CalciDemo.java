import java.awt.*;
import java.awt.event.*;

public class CalciDemo 
{
    Frame f;
    Panel p;
    Button[] numberButtons=new Button[10];
    Button addButton,subButton,mulButton,divButton,equalButton,clearButton,modButton,dotButton;
    TextField t;
    double currRes=0;
    int op=-1;
    boolean k=true;

    CalciDemo() 
    {
        f=new Frame("Calculator");
        t=new TextField(10);
        t.setEditable(true);
        t.setFont(new Font("Arial", Font.PLAIN, 24));
        p=new Panel();
        f.setLayout(new FlowLayout());

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) 
            {
                System.exit(0);
            }
        });

        for(int i=0;i<10;i++) 
        {
            numberButtons[i]=new Button(String.valueOf(i));
            int label=i;
            numberButtons[i].setPreferredSize(new Dimension(60, 40));
            numberButtons[i].setBackground(Color.decode("#ADD8E6"));
            numberButtons[i].addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (k) {
                        t.setText("");
                        k=false;
                    }
                    t.setText(t.getText()+label);
                }
            });
        }

        addButton=new Button("+");
        subButton=new Button("-");
        mulButton=new Button("*");
        divButton=new Button("/");
        modButton=new Button("%");
        equalButton=new Button("=");
        dotButton=new Button(".");
        clearButton=new Button("C");

        Button[] opButtons={addButton, subButton, mulButton, divButton, modButton, equalButton, dotButton, clearButton};
        for(Button b:opButtons) 
        {
            b.setPreferredSize(new Dimension(60, 40));
            b.setBackground(Color.decode("#ADD8E6"));
        }

        addButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=1;
                k=true;
            }
        });

        subButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=2;
                k=true;
            }
        });

        mulButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=3;
                k=true;
            }
        });

        divButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=4;
                k=true;
            }
        });

        modButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=5;
                k=true;
            }
        });

        equalButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                performOperation();
                op=-1; 
                k=true;
            }
        });

        clearButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                t.setText("");
                currRes=0;
                op=-1;
                k=true;
            }
        });

        dotButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (k) 
                {
                    t.setText("");
                    k=false;
                }
                t.setText(t.getText()+".");
            }
        });

        p.setLayout(new GridLayout(4, 4, 10, 20));

        for(int i=0;i<=9;i++)
        {
            p.add(numberButtons[i]);
        }

        // p.add(numberButtons[0]);
        p.add(addButton);
        p.add(subButton);
        p.add(mulButton);
        p.add(divButton);
        p.add(modButton);
        p.add(equalButton);
        p.add(clearButton);
        p.add(dotButton);
        f.add(t);
        f.add(p);
        f.setSize(300, 300);
        f.setVisible(true);
    }

    private void performOperation() 
    {
        if(op!=-1) 
        { 
            double newVal=Double.parseDouble(t.getText());
            switch(op) 
            {
                case 1->currRes+=newVal;
                case 2->currRes-=newVal;
                case 3->currRes*=newVal;
                case 4->currRes/=newVal;
                case 5->currRes%=newVal;
            }
        } 
        else 
        { 
            currRes=Double.parseDouble(t.getText());
        }
        t.setText(String.valueOf(currRes));
    }

    public static void main(String[] args) 
    {
        new CalciDemo();
    }
}
