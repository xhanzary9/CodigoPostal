/*
 * Interfaz Gráfica de Codigos postales
 */
package codigopostal;

/**
 *
 * @author Renoir
 */
public class CodigoPostalUI extends javax.swing.JFrame {

    /**
     * Crea la interfaz. 
     */
    public CodigoPostalUI() {
        initComponents();
        cambiaMensajeComboBox("Mexico");//Despliega el mensaje de formato de Mexico.
        this.codigoNoValidoLabel.setVisible(false);
        this.codigoValidoLabel.setVisible(false);
    }

    /**
     * Inicializa la interfaz, el cógigo es generado automáticamente por NetBeans.
     * NO MODIFICAR
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        codigoPostalTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        paisesComboBox = new javax.swing.JComboBox<>();
        codigoNoValidoLabel = new javax.swing.JLabel();
        codigoValidoLabel = new javax.swing.JLabel();
        validarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajesTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Introduzca el código postal: ");

        codigoPostalTextField.setMaximumSize(new java.awt.Dimension(6, 40));
        codigoPostalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoPostalTextFieldActionPerformed(evt);
            }
        });
        codigoPostalTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoPostalTextFieldKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Elija el país: ");

        paisesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "México", "Estados Unidos ", "Cánada", "Japón", "China" }));
        paisesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisesComboBoxOnChange(evt);
            }
        });

        codigoNoValidoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigoNoValidoLabel.setForeground(new java.awt.Color(255, 0, 0));
        codigoNoValidoLabel.setText("EL CÓDIGO POSTAL NO ES VÁLIDO");

        codigoValidoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigoValidoLabel.setForeground(new java.awt.Color(0, 153, 0));
        codigoValidoLabel.setText("EL CÓDIGO POSTAL ES VÁLIDO");

        validarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        validarButton.setText("Validar");
        validarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarOnClick(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mensajesTextArea.setEditable(false);
        mensajesTextArea.setBackground(new java.awt.Color(204, 204, 204));
        mensajesTextArea.setColumns(20);
        mensajesTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensajesTextArea.setLineWrap(true);
        mensajesTextArea.setRows(5);
        mensajesTextArea.setWrapStyleWord(true);
        mensajesTextArea.setAutoscrolls(false);
        jScrollPane2.setViewportView(mensajesTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(validarButton)
                    .addComponent(codigoValidoLabel)
                    .addComponent(codigoNoValidoLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoPostalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paisesComboBox, 0, 140, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codigoPostalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paisesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoNoValidoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoValidoLabel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Se cuando se da ENTER mientras se escribe en campo de texto. 
    private void codigoPostalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoPostalTextFieldActionPerformed
        this.validarButton.doClick();
    }//GEN-LAST:event_codigoPostalTextFieldActionPerformed
    /* Esto se ejecuta cuando se da click en el boton "validar"*/
    private void validarOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarOnClick
        //Vueve a acultar mensajes
        this.codigoNoValidoLabel.setVisible(false);
        this.codigoValidoLabel.setVisible(false);
        String cp = this.codigoPostalTextField.getText();
        String pais = this.paisesComboBox.getSelectedItem().toString();
        pais = java.text.Normalizer.normalize(pais, java.text.Normalizer.Form.NFD); //Quita los acentos
        pais = pais.replaceAll("[^\\p{ASCII}]", ""); //Quitas los caracteres raros producto de quitar los acentos. 
        /******VALIDAR postal*******/
        FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        CodigoPostal codigo = fabrica.creaCodigoPostal(pais, cp);
        Validar validar = new CodigoPostalValidador();

        if (validar.valida(codigo)) {
            this.codigoValidoLabel.setVisible(true);
            //Muestro la colonia: 
            ColoniaCodigoPostalImplementacionArchivos coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
            String colonia = coloniaCp.colonia(codigo);
            this.mensajesTextArea.setText(colonia);
        } else {
            this.codigoNoValidoLabel.setVisible(true);
            cambiaMensajeComboBox(pais);
        }
        System.out.println(validar.valida(codigo));
        System.out.println(cp + " " + pais);           
        //System.out.println(pais);
       // this.mensajesTextArea.setText(this.FORMATO_MEX_MSG);
    }//GEN-LAST:event_validarOnClick
    
    /*Este método se ejecuta cuando se elije otro elemento en el ComboBox*/
    private void paisesComboBoxOnChange(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisesComboBoxOnChange
        //Vueve a acultar mensajes
        this.codigoNoValidoLabel.setVisible(false);
        this.codigoValidoLabel.setVisible(false);
        String pais = this.paisesComboBox.getSelectedItem().toString();
        pais = java.text.Normalizer.normalize(pais, java.text.Normalizer.Form.NFD); //Quita los acentos
        pais = pais.replaceAll("[^\\p{ASCII}]", ""); //Quitas los caracteres raros producto de quitar los acentos. 
        System.out.println(pais);
        cambiaMensajeComboBox(pais);
    }//GEN-LAST:event_paisesComboBoxOnChange
    
    /*
     * Método para limitar el número de caracteres en el campo de texto 
    */
    private void codigoPostalTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoPostalTextFieldKeyTyped
         if (this.codigoPostalTextField.getText().length() >= 10 ) // limit textfield to 3 characters
            evt.consume(); 

    }//GEN-LAST:event_codigoPostalTextFieldKeyTyped
   
    /**
     * Este método se encarga de cambiar el texto del mensaje en la UI segpun el país elegido. 
     * Recibe el pais elegido en el COmboBox @param pais. Que puede ser en este caso 5.
     */
    private void cambiaMensajeComboBox(String pais) {
        if (pais.equals("Mexico")) {
            this.mensajesTextArea.setText(this.FORMATO_MEX_MSG);
        } else if (pais.replaceAll("\\s+","").equalsIgnoreCase("Estados Unidos".replaceAll("\\s+",""))) {
            //Tenia que hacer lo anterior por los espacios en blanco. 
            this.mensajesTextArea.setText(this.FORMATO_US_MSG);
        } else if (pais.equals("Canada")) {
            this.mensajesTextArea.setText(this.FORMATO_CAN_MSG);
        } else if (pais.equals("Japon")) {
            this.mensajesTextArea.setText(this.FORMATO_JAP_MSG);
        } else if (pais.equals("China")) {
            this.mensajesTextArea.setText(this.FORMATO_CHI_MSG);
        }
    }
    /**
     * MAIN. 
     * @param args.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */


        /* Crea y despliega el formulario.  */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodigoPostalUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoNoValidoLabel;
    private javax.swing.JTextField codigoPostalTextField;
    private javax.swing.JLabel codigoValidoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea mensajesTextArea;
    private javax.swing.JComboBox<String> paisesComboBox;
    private javax.swing.JButton validarButton;
    // End of variables declaration//GEN-END:variables
    
    //Variables de mensajes. 
    private final String FORMATO_MEX_MSG = "El formato del código postal en México es 5 dígitos sin espacios: #####";
    private final String FORMATO_US_MSG = "El formato del código postal en los Estados Unidos es 5 dígitos sin espacios: #####";
    private final String FORMATO_CAN_MSG = "El formato del código postal en Cánada es la forma A#A  #A# donde A es una letra y # un número.";
    private final String FORMATO_JAP_MSG = "Los códigos Postales en Japón consisten de 7 dígitos con un guión después del tercer dígito: XXX-XXXX";
    private final String FORMATO_CHI_MSG = "Los códigos postales de China constan de seis dígitos: XXXXX";
}
