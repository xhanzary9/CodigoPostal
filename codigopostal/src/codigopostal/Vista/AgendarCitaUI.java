package codigopostal.Vista;

import codigopostal.Contolador.AgendarCitasInternet;
import codigopostal.Excepciones.EstablecimientoCerradoExcepcion;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Servicio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Renoir
 * Clase de interfaz grafica para agendar citas. 
 */
public class AgendarCitaUI extends javax.swing.JFrame {
    
    private Establecimiento establecimiento;
    /**
     * Crea una nueva ventana. 
     * @param establecimiento el establecimiento que se ligió previamente. 
     */
    public AgendarCitaUI(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
        initComponents();
        configuraUI(); 
    }
    
    /**
     * Clase privada para agregar opciones al comboBox. 
     */
    private class ComboItem {
        private Servicio servicio;

        public ComboItem(Servicio servicio) {
            this.servicio = servicio;
        }

        @Override
        public String toString() {
            return servicio.getNombreServicio();
        }

        public Servicio getServicio() {
            return servicio;
        }
    }
    /**
     * Configura la UI y le agrega la información del establecimiento a la UI. 
     */
    private void configuraUI() {
        this.tituloVentana.setText("Agendar Cita en " + establecimiento.getNombre());
        this.horaNoValidaLabel.setVisible(false);
        
        for (Servicio servicio : this.establecimiento.getServiciosOfrece()) {
            ComboItem item = new ComboItem(servicio);
            this.serviciosComboBox.addItem(servicio.getNombreServicio());
        }
        
        //Limita el num de caracteres en los campos de texto hora y minutos. 
        this.horasTextField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) { 
            if (horasTextField.getText().length() >= 2 ) // limit textfield to 3 characters
                e.consume(); 
            }  
        });
        
        this.minutosTextField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) { 
            if (minutosTextField.getText().length() >= 2 ) // limit textfield to 3 characters
                e.consume(); 
            }  
        });
        
    }
    /**
     * NO MODIFICAR
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        serviciosComboBox = new javax.swing.JComboBox<>();
        tituloVentana = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonAgendarCita = new javax.swing.JButton();
        horasTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        minutosTextField = new javax.swing.JTextField();
        meridiemComboBox = new javax.swing.JComboBox<>();
        horaNoValidaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendar Cita\n");

        try {
            datePicker.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2017, 3, 19),
                new java.util.GregorianCalendar(2017, 3, 19))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    datePicker.setMaxDate(new java.util.GregorianCalendar(2017, 11, 31));
    datePicker.setMinDate(new java.util.GregorianCalendar(2017, 3, 19));

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel1.setText("Elegir la Fecha de la Cita:");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel2.setText("Elegir Servicio:");

    serviciosComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            serviciosComboBoxActionPerformed(evt);
        }
    });

    tituloVentana.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    tituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    tituloVentana.setText("Agendar cita en Restaurante Bellini");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel4.setText("Elegir Horario de Cita: ");

    botonAgendarCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    botonAgendarCita.setText("Agendar Cita");
    botonAgendarCita.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonAgendarCitaActionPerformed(evt);
        }
    });

    horasTextField.setText("10");

    jLabel7.setText(":");

    minutosTextField.setText("10");

    meridiemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

    horaNoValidaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    horaNoValidaLabel.setForeground(new java.awt.Color(204, 0, 0));
    horaNoValidaLabel.setText("La hora no es válida");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jLabel2)
                            .addGap(9, 9, 9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(horasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(minutosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(meridiemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(serviciosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(horaNoValidaLabel)))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonAgendarCita)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloVentana)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addContainerGap(121, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(tituloVentana)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(serviciosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(horasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7)
                .addComponent(minutosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(meridiemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(horaNoValidaLabel)
            .addGap(18, 18, 18)
            .addComponent(botonAgendarCita)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serviciosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviciosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviciosComboBoxActionPerformed
    
    /**
     * Se ejecuta al dar click al boton Agendar Cita. 
     * @param evt 
     */
    private void botonAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgendarCitaActionPerformed
        if (!horaValida()) {
            this.horaNoValidaLabel.setVisible(true);
        } else {
            //Obtiene toda la info
            int indiceSeleccionado = this.serviciosComboBox.getSelectedIndex();
            Servicio servicio = this.establecimiento.getServiciosOfrece().get(indiceSeleccionado);
            Date dia = this.datePicker.getSelectedDate().getTime();
            //Calendar cal = this.datePicker.getSelectedDate();
            int hora = 0;
            int minutos = 0;
            String meridium = (String) this.meridiemComboBox.getSelectedItem();
                        
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //System.out.println("Calendar : " + dateFormat.format(cal.getTime()));
            //System.out.println(this.establecimiento.getHorarioServicio());
            try { 
                hora = Integer.parseInt(this.horasTextField.getText()); 
                minutos = Integer.parseInt(this.horasTextField.getText());
            } catch(NumberFormatException e) { /*Can't Happend*/}
            
            //Get Date con hora correcta
            Date date = fechaConHora(dia, hora, minutos, meridium);
            
          
            try {
                AgendarCitasInternet agendar = new AgendarCitasInternet();
                agendar.AgendarCita(establecimiento, servicio, date);
                
                despliegaMensajeExito();
                this.dispose();
            } catch (EstablecimientoCerradoExcepcion e) {
                despliegaMensajeErrorCerrado(establecimiento);
            } 
            
            
            
        } //END ELSE
    }//GEN-LAST:event_botonAgendarCitaActionPerformed
    
    /**
     * Despliega un mensaje de Exio
     */
    private void despliegaMensajeExito() {
        JOptionPane.showMessageDialog(new JFrame(), "Tu cita se agendó exitosamente.", "Dialog",
        JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Desplega un mesaje de error y muestra los horarios disponibles
     * @param est 
     */
    private void despliegaMensajeErrorCerrado(Establecimiento est) {
        String message = "HORARIO NO DISPONIBLE.\n";
        String horariosMsg = "Horarios disponibles: \n";
        String[] horarios = est.getHorarioServicio().split(",");
        
        for (int i = 0; i < horarios.length; i++) {
            horariosMsg += "-" + horarios[i] + ".\n";
        }
        JOptionPane.showMessageDialog(new JFrame(), message + horariosMsg, "Dialog",
        JOptionPane.ERROR_MESSAGE);
    }
    
        /**
         * Obtiene la fecha correcta dado el calendario y los datos introducidos. 
         * @return 
         */
        private Date fechaConHora(Date dia, int hora, int minutos, String meridium) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dia);
            
            //Esto es para que le agregue un 12 a la hora.
            if ("AM".equals(meridium) && hora != 12) {
                //Los suma normal
                cal.add(Calendar.HOUR, hora);
                cal.add(Calendar.MINUTE, minutos);
            } else if ("AM".equals(meridium) && hora == 12){
                //Solo agrega los minutos pues la hora es 00:min
                cal.add(Calendar.MINUTE, minutos);
            } else if ("PM".equals(meridium) && hora != 12){
                //Le suma 12 a la hora
                cal.add(Calendar.HOUR, hora + 12);
                cal.add(Calendar.MINUTE, minutos);
            } else if ("PM".equals(meridium) && hora == 12){
                cal.add(Calendar.HOUR, hora);
                cal.add(Calendar.MINUTE, minutos);
            }
            
            return cal.getTime();
        }
    /**
     * Valida si los datos introducidos como hora son válidos
     * @return 
     */
    private boolean horaValida() {
        String text_hora = this.horasTextField.getText();
        String text_minutos = this.horasTextField.getText();
        int hora = 0;
        int minutos = 0;
        
        try { 
            hora = Integer.parseInt(text_hora); 
            minutos = Integer.parseInt(text_minutos);
        } catch(NumberFormatException e) { 
            return false;
        }
        
        if (hora < 0 || hora > 12 || minutos < 0 || minutos > 60)
            return false;
        
        return true;
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgendarCita;
    private datechooser.beans.DateChooserCombo datePicker;
    private javax.swing.JLabel horaNoValidaLabel;
    private javax.swing.JTextField horasTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> meridiemComboBox;
    private javax.swing.JTextField minutosTextField;
    private javax.swing.JComboBox<String> serviciosComboBox;
    private javax.swing.JLabel tituloVentana;
    // End of variables declaration//GEN-END:variables
}
