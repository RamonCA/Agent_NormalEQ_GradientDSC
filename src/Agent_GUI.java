import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Agent_GUI extends JFrame{

    private Agent_MLR myAgent;
    private JTextField x_value;
    private JTextField factor1_value;
    private JTextField factor2_value;

    public Agent_GUI(Agent_MLR a) {
        super(a.getLocalName());
        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(10, 1));
        p.add(new JLabel(" Normal Equation for MLR and Gradient Descent"));
        p.add(new JLabel(""));
        x_value = new JTextField(5);
        factor1_value = new JTextField(5);
        factor2_value = new JTextField(5);

        p.add(new JLabel(" Factor X1"));
        p.add(factor1_value);

        p.add(new JLabel(" Factor X2"));
        p.add(factor2_value);

        p.add(new JLabel(" Gradient value"));
        p.add(x_value);

        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Calculate");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    double y = Double.parseDouble(x_value.getText());
                    double f1 = Double.parseDouble(factor1_value.getText());
                    double f2 = Double.parseDouble(factor2_value.getText());
                    myAgent.actionAgent(f1,f2,y);
                    x_value.setText("");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(Agent_GUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );
        p = new JPanel();
        p.add(addButton);
        getContentPane().add(p, BorderLayout.SOUTH);

        addWindowListener(new    WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

        addWindowListener(new	WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int)screenSize.getWidth() / 2;
        int centerY = (int)screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
}
