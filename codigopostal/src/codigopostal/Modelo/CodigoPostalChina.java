package codigopostal.Modelo;


public class CodigoPostalChina extends CodigoPostal{
    
    public CodigoPostalChina(String codigoPostal) {
        super(codigoPostal, "######");

    }

    @Override
    public String getCodigoPostal() {
        return super.getCodigoPostal(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodigoPostal(String codigoPostal) {
        super.setCodigoPostal(codigoPostal); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRegExpr() {
        return super.getRegExpr();
    }
}
