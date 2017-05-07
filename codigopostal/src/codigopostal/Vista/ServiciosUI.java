/*
 * Clase para listar los servicios disponibles deacuerdo a lo
 * Los codigos podtales. 
 */
package codigopostal.Vista;

import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.Establecimiento;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Renoir
 */

public class ServiciosUI extends javax.swing.JFrame {
    
    /*Es el modelo de la tabla, es decir, las columnas y 
    * datos que se van a mostrar*/
    private javax.swing.table.DefaultTableModel modelo;
    private List<Establecimiento> establecimientos;
    /**
     * Contructor de la interfaz. 
     * @param modelo es el modelo previamente contruido a partir de los servicios. 
     * @param establecimientos que es la lista de establecimientos listados en la table.
     */
    public ServiciosUI(DefaultTableModel modelo, List<Establecimiento> establecimientos) {
        this.modelo = modelo;
        this.establecimientos = establecimientos;
        initComponents();
        poneBotones();
        this.tituloTablaLabel.setText("Servicios Disponibles en " + establecimientos.get(0).getColonia().getNombre());
        //Test
        resizeTable();
        
    }

    /**
     * Generado por NeatBeans. NO MODIFICAR. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        tituloTablaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Servicios Disponibles");

        tablaPrincipal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaPrincipal.setModel(this.modelo);
        jScrollPane1.setViewportView(tablaPrincipal);

        tituloTablaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tituloTablaLabel.setText("Servicios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloTablaLabel)
                        .addGap(0, 928, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(tituloTablaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
     * Se encarga de poner los botones en la tabla, ya que, 
    * JTable no soporta Jbuttons como dato. 
    */
    private void poneBotones() {
        
        ButtonColumn button = new ButtonColumn(this.tablaPrincipal, new AbstractAction() {
            //Se ejecuta cuando se da click sobre el boton Reservar.
            //Despliega AgendarCitaUI
             @Override
             public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                String selected = (String) tablaPrincipal.getModel().getValueAt(modelRow, 0);
                Establecimiento est = establecimientos.get(modelRow);
                System.out.println(est.getNombre());
                AgendarCitaUI agendar = new AgendarCitaUI(est);
                agendar.setVisible(true);
            }
        }, 4);
    }
    
    //Modifica los tamaños de las columnas en la tabla para estilos. 
    private void resizeTable() {
       this.tablaPrincipal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       final TableColumnModel columnModel = this.tablaPrincipal.getColumnModel();
       columnModel.getColumn(0).setPreferredWidth(200);
       columnModel.getColumn(1).setPreferredWidth(200);
       columnModel.getColumn(2).setPreferredWidth(150);
       columnModel.getColumn(3).setPreferredWidth(300);
       columnModel.getColumn(4).setPreferredWidth(130);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPrincipal;
    private javax.swing.JLabel tituloTablaLabel;
    // End of variables declaration//GEN-END:variables
}
