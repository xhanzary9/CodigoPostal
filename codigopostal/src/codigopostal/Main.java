package codigopostal;

import codigopostal.Vista.CodigoPostalUI;
import javax.swing.UIManager;


public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //
        }
        // FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        // CodigoPostal codigo = fabrica.creaCodigoPostal("Canada","R3R 4R4");
        // Validar validar = new CodigoPostalValidador();
        // System.out.println(validar.valida(codigo));
        CodigoPostalUI c = new CodigoPostalUI();
        c.setVisible(true);        
    }
}
