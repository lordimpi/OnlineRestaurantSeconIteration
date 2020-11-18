package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.common.domain.entity.User;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import static co.unicauca.onlinerestaurant.client.infra.Messages.warningMessage;
import co.unicauca.onlinerestaurant.client.infra.Secutiry;
import co.unicauca.onlinerestaurant.client.infra.Singleton;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Crea un formulario para el login
 *
 * @author Santiago Acuña
 */
public class GUILogin extends javax.swing.JFrame {

    /**
     * Posicion del puntero en eje x
     */
    private int x = 0;
    /**
     * Posicion del puntero en eje y
     */
    private int y = 0;

    /**
     * Creates new form NewJFrame
     */
    public GUILogin() {
        initComponents();
        setLocationRelativeTo(null);
        this.setFocusable(true);
        ImageIcon img = new ImageIcon("src/main/java/resources/bg2.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(
                jLbLogo.getWidth(),
                jLbLogo.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        jLbLogo.setIcon(icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLbLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxbUser = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPswField = new javax.swing.JPasswordField();
        BtnIngresar = new javax.swing.JButton();
        jLblBotonCerrar = new javax.swing.JLabel();
        BtnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbLogo.setMaximumSize(new java.awt.Dimension(46, 40));
        jLbLogo.setMinimumSize(new java.awt.Dimension(46, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        TxbUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TxbUser.setForeground(new java.awt.Color(102, 102, 102));
        TxbUser.setText("user@user.com");
        TxbUser.setToolTipText("Enter your user name");
        TxbUser.setBorder(null);
        TxbUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxbUserFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Password");

        jPswField.setForeground(new java.awt.Color(102, 102, 102));
        jPswField.setText("123456");
        jPswField.setToolTipText("Enter your password");
        jPswField.setBorder(null);
        jPswField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPswFieldFocusGained(evt);
            }
        });
        jPswField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPswFieldKeyPressed(evt);
            }
        });

        BtnIngresar.setBackground(new java.awt.Color(122, 72, 221));
        BtnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        BtnIngresar.setText("Ingresar");
        BtnIngresar.setToolTipText("Click here to login");
        BtnIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BtnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnIngresar.setFocusPainted(false);
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        jLblBotonCerrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLblBotonCerrar.setForeground(new java.awt.Color(102, 102, 102));
        jLblBotonCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblBotonCerrar.setText("X");
        jLblBotonCerrar.setToolTipText("Close the application");
        jLblBotonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblBotonCerrarMouseClicked(evt);
            }
        });

        BtnRegistrarse.setBackground(new java.awt.Color(255, 255, 255));
        BtnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnRegistrarse.setForeground(new java.awt.Color(51, 102, 255));
        BtnRegistrarse.setText("Resgistrarse");
        BtnRegistrarse.setToolTipText("Click here to register");
        BtnRegistrarse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BtnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnRegistrarse.setFocusPainted(false);
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(94, 94, 94))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPswField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxbUser)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addComponent(BtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(53, 53, 53)))
                    .addComponent(jLblBotonCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLblBotonCerrar)
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPswField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRegistrarse)
                .addGap(22, 22, 22)
                .addComponent(BtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo encargado de capturar las coordenadas del raton para poder mover
     * el formulario
     *
     * @param evt Evento del Mouse pressed
     */
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

        x = evt.getX();
        y = evt.getY();

    }//GEN-LAST:event_jPanel2MousePressed

    /**
     * Metodo encargado de insertar las coordenada del formulario para ubicar el
     * formulario luego de mover con el raton
     *
     * @param evt Evento del mouse dragged
     */
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    /**
     * Se encarga de hacer las validaciones para el ingreso de un usuario
     *
     * @param evt
     */
    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed

        String email = TxbUser.getText();
        String password = jPswField.getText();
        Secutiry sc = new Secutiry();
        //Aqui vendria el analizar si el usuario existe en el sistema
        if (sc.validarEmail(TxbUser.getText())) {
            try {
                if (sc.validarUsuario(email, password)) {
                    switch (sc.getUser().getRol()) {
                        case "admin":
                            iniciarModoAdmin(sc.getUser());
                            break;
                        case "user":
                            iniciarModoUser(sc.getUser());
                            break;
                    }
                } else {
                    warningMessage("Usuario o Contraseña incorrectas", "Atención");
                }
            } catch (Exception ex) {
                Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            warningMessage("El email ingresado no es valido", "Atención");
        }
    }//GEN-LAST:event_BtnIngresarActionPerformed

    /**
     * Oculta los caracteres para la contraseña
     *
     * @param evt evento de la caja de texto
     */
    private void jPswFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPswFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnIngresarActionPerformed(null);
        }
    }//GEN-LAST:event_jPswFieldKeyPressed

    /**
     * Boton que cierra el formulario login
     *
     * @param evt
     */
    private void jLblBotonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblBotonCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLblBotonCerrarMouseClicked

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame ins = Singleton.getInstCreateUser();
                ins.setExtendedState(NORMAL);
                ins.setVisible(true);
            }
        });
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    private void TxbUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxbUserFocusGained
        this.TxbUser.setText("");
    }//GEN-LAST:event_TxbUserFocusGained

    private void jPswFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPswFieldFocusGained
        this.jPswField.setText("");
    }//GEN-LAST:event_jPswFieldFocusGained

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JTextField TxbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbLogo;
    private javax.swing.JLabel jLblBotonCerrar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPswField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void iniciarModoAdmin(User user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIMenuAdmin ins = null;
                try {
                    ins = new GUIMenuAdmin(user);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                ins.setExtendedState(NORMAL);
                ins.setVisible(true);
            }
        });
        this.dispose();
    }

    private void iniciarModoUser(User user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIMenuCustomer ins = null;
                try {
                    ins = new GUIMenuCustomer(user);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                ins.setExtendedState(NORMAL);
                ins.setVisible(true);
            }
        });
        this.dispose();
    }
}
