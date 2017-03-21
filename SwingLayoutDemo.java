import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingLayoutDemo {
   private JFrame mainFrame;
   private JPanel controlPanel;
   
   
   public SwingLayoutDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
      swingLayoutDemo.show();       
   }

   private void prepareGUI() {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception ex) {
         //
      }
      
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(500, 400);
      mainFrame.setLayout(new GridLayout(3, 1));

      // introduceCodigoLabel = new JLabel("",JLabel.CENTER);        
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });

      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(4, 2));
      controlPanel.setPreferredSize(new Dimension(100, 100));
      mainFrame.add(controlPanel);
      // mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void show(){

      // JPanel panel = new JPanel();
      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
      model.addElement("M\u00e9xico");
      model.addElement("Jap\u00f3n");
      model.addElement("C\u00e1nada");
      model.addElement("China");
      model.addElement("Estados Unidos");
      JComboBox<String> comboBox = new JComboBox<>(model);
      // panel.setBackground(Color.darkGray);
      // panel.setPreferredSize(new Dimension(350, 600));
      GridLayout layout = new GridLayout(5, 2);
      layout.setHgap(10);
      layout.setVgap(5);
      
      controlPanel.setLayout(layout);   
      controlPanel.add(new JLabel(""));
      controlPanel.add(new JLabel(""));
      controlPanel.add(new JLabel("Introduce el c\u00f3digo postal: ", JLabel.RIGHT));
      controlPanel.add(new JTextField());
      controlPanel.add(new JLabel("Elige el pa\u00eds: ", JLabel.RIGHT));
      controlPanel.add(comboBox);
      controlPanel.add(new JLabel(""));
      controlPanel.add(new JButton("Validar"));
      // controlPanel.add(panel);
      // controlPanel.add(new JButton("Validar"));
      
      mainFrame.setVisible(true);  
   }
}