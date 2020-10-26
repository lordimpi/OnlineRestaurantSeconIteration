package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import co.unicauca.onlinerestaurant.client.infra.Messages;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 * Crea un jframe para modificar un plato
 *
 * @author Santiago Acuña
 */
public class GUIModifyDishe extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIModifyDishe
     */
    public GUIModifyDishe() {
        initComponents();
        this.jBtnModificar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnNorte = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTxfId = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jPnSur = new javax.swing.JPanel();
        jBtnModificar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxfPrecio = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar Plato");

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");
        jPnNorte.add(jLabel4);

        jTxfId.setBackground(new java.awt.Color(255, 255, 255));
        jTxfId.setForeground(new java.awt.Color(0, 0, 0));
        jTxfId.setPreferredSize(new java.awt.Dimension(100, 24));
        jPnNorte.add(jTxfId);

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        jPnNorte.add(jBtnBuscar);

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        jBtnModificar.setText("Modificar");
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnModificar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCancelar);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        jPnCentro.setLayout(new java.awt.GridLayout(2, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre:");
        jPnCentro.add(jLabel1);

        jTxfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTxfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPnCentro.add(jTxfNombre);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Precio:");
        jPnCentro.add(jLabel2);

        jTxfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jTxfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jPnCentro.add(jTxfPrecio);

        getContentPane().add(jPnCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana del formulario
     *
     * @param evt evento del boton
     */
    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        this.doDefaultCloseAction();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    /**
     * Modifica un plato con los atributos que tiene el formulario
     *
     * @param evt evento del boton
     */
    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed

        String nombre = jTxfNombre.getText();
        String precio = jTxfPrecio.getText();
        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDishService = new MainDishService(service);
        MainDish dish;
        if (nombre.equals("") || precio.equals("")) {
            jTxfNombre.requestFocus();
            Messages.warningMessage("Campos vacios: Error al modificar", "Warning");
            return;
        }
        try {
            dish = mainDishService.updateMainDish(this.jTxfId.getText().trim(), this.jTxfNombre.getText(), this.jTxfPrecio.getText());
        } catch (Exception ex) {
            clearControls();
            successMessage(ex.getMessage(), "Atención");
            return;
        }
        clearControls();
        this.jTxfId.requestFocus();
        dish = null;
        successMessage("Se modifico el plato con exito.", "EXITO");
        this.jBtnModificar.setVisible(false);
    }//GEN-LAST:event_jBtnModificarActionPerformed

    /**
     * Metodo encargado de buscar en la base de datos un identificador de un
     * plato
     *
     * @param evt Accion evento del formulario, en este caso accion buscar
     */
    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        String id = jTxfId.getText().trim();

        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDishService = new MainDishService(service);

        if (id.equals("")) {
            jTxfId.requestFocus();
            Messages.warningMessage("ERROR: El campo Id esta vacio.", "Warning");
            return;
        }
        MainDish dish;
        try {
            dish = mainDishService.findMainDish(id);
        } catch (Exception ex) {
            clearControls();
            successMessage(ex.getMessage(), "Atención");
            return;
        }
        clearControls();
        showData(dish);
        this.jBtnModificar.setVisible(true);

    }//GEN-LAST:event_jBtnBuscarActionPerformed

    /**
     * Este metodo muestra en el formulario los datos que tiene un objeto
     *
     * @param mainDish Objeto plato principal
     */
    private void showData(MainDish mainDish) {
        jTxfNombre.setText(mainDish.getNameDishe());
        jTxfPrecio.setText(Double.toString(mainDish.getDishPrice()));

    }

    /**
     * Este metodo limpia todos los controles en el formulario
     */
    public void clearControls() {

        jTxfNombre.setText("");
        jTxfPrecio.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JTextField jTxfId;
    private javax.swing.JTextField jTxfNombre;
    private javax.swing.JTextField jTxfPrecio;
    // End of variables declaration//GEN-END:variables
}
