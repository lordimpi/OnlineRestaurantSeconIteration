package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.common.domain.entity.Delivery;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IDeliveryAccess;
import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
import co.unicauca.onlinerestaurant.client.domain.services.DeliveryService;
import co.unicauca.onlinerestaurant.client.domain.services.MenuService;
import co.unicauca.onlinerestaurant.client.infra.Messages;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import static java.awt.Frame.NORMAL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Mariat
 */
public class GUIShowPedidos extends javax.swing.JFrame {

    private static String idMenu;

    private Menu miMenu;

    /**
     * Creates new form GUIShowPedidos1
     *
     * @param id Un id menu
     * @throws java.lang.Exception
     */
    public GUIShowPedidos(String id) throws Exception {
        idMenu = id;
        initComponents();
        setLocationRelativeTo(null);
        cargarMenu();
        mostrarTabla();

    }

    /**
     * Nombre del restaurante
     */
    private String restaurantname;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLbRestaurantName = new javax.swing.JLabel();
        jPnSur = new javax.swing.JPanel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnRealizarPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMenus = new javax.swing.JTable();
        JPanelDerecho = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtDescripcion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtDireccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Items:");
        jLabel1.setToolTipText("");

        jLbRestaurantName.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPnNorteLayout = new javax.swing.GroupLayout(jPnNorte);
        jPnNorte.setLayout(jPnNorteLayout);
        jPnNorteLayout.setHorizontalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLbRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPnNorteLayout.setVerticalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLbRestaurantName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        jBtnCancelar.setText("Cancelar Pedido");
        jBtnCancelar.setFocusPainted(false);
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCancelar);

        jBtnRealizarPedido.setText("Realizar Pedido");
        jBtnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRealizarPedidoActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnRealizarPedido);

        jTblMenus = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTblMenus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Plato Principal", "Bebida", "Ensalada", "Entrada", "Postre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblMenus.setFocusable(false);
        jTblMenus.setRowHeight(30);
        jTblMenus.getTableHeader().setReorderingAllowed(false);
        jTblMenus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblMenusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblMenus);

        JPanelDerecho.setMinimumSize(new java.awt.Dimension(500, 100));
        JPanelDerecho.setPreferredSize(new java.awt.Dimension(300, 264));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2);

        jTxtDescripcion.setColumns(20);
        jTxtDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTxtDescripcion);

        jPanel1.add(jScrollPane2);

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cantidad:");
        jPanel2.add(jLabel3);
        jPanel2.add(jTxtCantidad);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Dirección de Envío:");
        jPanel2.add(jLabel4);
        jPanel2.add(jTxtDireccion);

        javax.swing.GroupLayout JPanelDerechoLayout = new javax.swing.GroupLayout(JPanelDerecho);
        JPanelDerecho.setLayout(JPanelDerechoLayout);
        JPanelDerechoLayout.setHorizontalGroup(
            JPanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDerechoLayout.createSequentialGroup()
                .addGroup(JPanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPanelDerechoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelDerechoLayout.setVerticalGroup(
            JPanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(JPanelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPnSur, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPnNorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JPanelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPnSur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        restaurantname = "";
        this.dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTblMenusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblMenusMouseClicked

        int i = jTblMenus.getSelectedRow();
        TableModel model = jTblMenus.getModel();
    }//GEN-LAST:event_jTblMenusMouseClicked

    private void jBtnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRealizarPedidoActionPerformed

        IDeliveryAccess service = Factory.getInstance().getDeliveryService();
        // Inyecta la dependencia

        String descripcion = jTxtDescripcion.getText();
        String cantidad = jTxtCantidad.getText();
        String direccionEnvio = jTxtDireccion.getText();

        if (descripcion.equals("") || cantidad.equals("") || direccionEnvio.equals("")) {
            jTxtDescripcion.requestFocus();
            Messages.warningMessage("ERROR AL REALIZAR EL PEDIDO: \nCampos vacios", "Warning");
            return;
        }

        DeliveryService deliveryService = new DeliveryService(service);
        Delivery delivery = new Delivery();
        delivery.setDescripcion(descripcion);
        delivery.setCantidad(Integer.parseInt(cantidad));
        delivery.setDireccionEnvio(direccionEnvio);
        delivery.setMiMenu(miMenu);

        try {
            if (deliveryService.createDelivery(delivery)) {
                successMessage("Pedido realizado con éxito.", "Atención");
            } else {
                Messages.warningMessage("el pedido no pudo ser realizado", "Warning");
            }
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }

        this.dispose();
    }//GEN-LAST:event_jBtnRealizarPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(GUIShowPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIShowPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIShowPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIShowPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIShowPedidos ins;
                try {
                    ins = new GUIShowPedidos(idMenu);
                    ins.setExtendedState(NORMAL);
                    ins.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIShowPedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelDerecho;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnRealizarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLbRestaurantName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblMenus;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextArea jTxtDescripcion;
    private javax.swing.JTextField jTxtDireccion;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo encargado de mostrar los datos en un jtable
     */
    private void mostrarTabla() {
        String dataTable[][] = new String[5][5];

        dataTable[0][0] = miMenu.getMaindish().getNameDish();
        dataTable[0][1] = miMenu.getDrink().getNameDrink();
        dataTable[0][2] = miMenu.getSalad().getNameSalad();
        dataTable[0][3] = miMenu.getEntry().getNameDishEntry();
        dataTable[0][4] = miMenu.getDessert().getName_Dish_Dessert();

        jTblMenus.setModel(new javax.swing.table.DefaultTableModel(
                dataTable, new String[]{"Plato Principal", "Bebida", "Ensalada", "Entrada", "Postre"}));
    }

    private void cargarMenu() throws Exception {
        IMenuAccess service = Factory.getInstance().getMenuService();

        // Inyecta las dependencias
        MenuService menuService = new MenuService(service);

        miMenu = menuService.findMenu(idMenu);

    }
}
