
package enviar__correo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport; // Add this import
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane; // Add this import


public class Formulario extends javax.swing.JFrame {

    private static String emailFrom = "pruebadecorreodemaricarmen@gmail.com";
    private static String passwordFrom = "qarv dasm ftfh jncv";
    private String emailTo;
    private String subject;
    private String content;
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    
    
    
    
    public Formulario() {
        initComponents();
        mProperties = new Properties();
    }

    private void createEmail(){
        emailTo = txtTo.getText().trim();
        subject = txtSubject.getText().trim();
        content = txtContent.getText().trim();
        
        mProperties.put("mail.smtp.host","smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
       try {
             // Crea un nuevo objeto MimeMessage, que representa el mensaje de correo electrónico
            mCorreo = new MimeMessage(mSession);
             // Configura el remitente del correo
            mCorreo.setFrom(new InternetAddress(emailFrom));
              // Configura el destinatario del correo
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
              // Configura el asunto del correo
            mCorreo.setSubject(subject);
            // Configura el contenido del correo
            // En este caso, se utiliza el método setText para establecer el contenido del correo
            // El contenido está configurado como HTML(Indica que el contenido del correo está en formato HTML)
            //y codificado en ISO-8859-1(Es la forma en que se codifican los caracteres en el contenido del correo).
            mCorreo.setText(content, "ISO-8859-1", "html");
            
        } catch (AddressException ex) {
            // Maneja la excepción en caso de un problema con las direcciones de correo
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            // Maneja la excepción en caso de un problema general con la creación del mensaje
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void sendEmail(){
    try {
        // Se crea un objeto Transport para enviar el correo a través del protocolo SMTP
        Transport mTransport = mSession.getTransport("smtp");
        
        // Se establece la conexión con el servidor SMTP utilizando el remitente y la contraseña
        mTransport.connect(emailFrom, passwordFrom);
        
        // Se envía el mensaje de correo electrónico al destinatario especificado
        mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
        
        // Se cierra la conexión con el servidor SMTP
        mTransport.close();

        // Se muestra un mensaje de confirmación de que el correo ha sido enviado exitosamente
        JOptionPane.showMessageDialog(null, "Correo enviado");
    } catch (NoSuchProviderException ex) {
        // Maneja la excepción si no se encuentra el proveedor de servicios (protocolo SMTP)
        Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        // Maneja la excepción si hay un problema general con el envío del mensaje
        Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
    }
}

        
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        jLabel1.setText("ENVIO DE CORREO");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        jLabel2.setText("Enviar a :");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        jLabel3.setText("Asunto :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        jLabel4.setText("Contenido :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gmail (2).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane2.setViewportView(txtContent);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTo)
                            .addComponent(txtSubject)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                        .addGap(80, 80, 80)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        createEmail();
        sendEmail();
   
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
