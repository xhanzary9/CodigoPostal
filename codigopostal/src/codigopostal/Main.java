package codigopostal;


public class Main {
    public static void main(String[] args) {
        // FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        // CodigoPostal codigo = fabrica.creaCodigoPostal("Canada","R3R 4R4");
        // Validar validar = new CodigoPostalValidador();
        // System.out.println(validar.valida(codigo));
        CodigoPostalUI c = new CodigoPostalUI();
        c.setVisible(true);        
    }
}
