

import javax..swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{

    JButton button;

    MyFrame(){

        button = new JButton();
        button.setBounds(200,100,100,50);
        button.addActionListener(e->);
        button.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        this.setLayout(null)
        this.setSize(500,500)
        this.setVisible(true);
        this.add(button)

    }

    @Override
}