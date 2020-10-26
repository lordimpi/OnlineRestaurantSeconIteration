package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import co.unicauca.onlinerestaurant.client.infra.Messages;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.common.domain.entity.MainDish;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 * Crear un jInternalFrame para borrar platos
 *
 * @author Santiago Acuña
 */
public class GUIDeleteDishe extends javax.swing.JInternalFrame {

    private List<MainDish> platos = new ArrayList<>();

    ;

    /**
     * Creates new form GUIUpdateDishe
     */
    public GUIDeleteDishe() {
        initComponents();
//        cargarLista();
//        mostrarTabla();
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
        jLblID = new javax.swing.JLabel();
        jTxfID = new javax.swing.JTextField();
        jPnSur = new javax.swing.JPanel();
        jBtnEliminar = new javax.swing.JButton();
        jBtnRecargarTabla = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblPlatos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Plato");
        setPreferredSize(new java.awt.Dimension(495, 329));

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        jLblID.setForeground(new java.awt.Color(255, 255, 255));
        jLblID.setText("ID");
        jPnNorte.add(jLblID);

        jTxfID.setMinimumSize(new java.awt.Dimension(100, 24));
        jTxfID.setPreferredSize(new java.awt.Dimension(200, 24));
        jPnNorte.add(jTxfID);

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        jBtnEliminar.setText("Borrar");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnEliminar);

        jBtnRecargarTabla.setText("Recargar");
        jBtnRecargarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRecargarTablaActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnRecargarTabla);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        jPnCentro.setLayout(new java.awt.BorderLayout());

        jTblPlatos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTblPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblPlatos.setFocusable(false);
        jTblPlatos.setRowHeight(30);
        jTblPlatos.getTableHeader().setReorderingAllowed(false);
        jTblPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblPlatos);

        jPnCentro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPnCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo encargado de actualizar un jtable con nuevos datos
     *
     * @param evt evento del boton
     */
    private void jBtnRecargarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRecargarTablaActionPerformed
        cargarLista();
        mostrarTabla();
    }//GEN-LAST:event_jBtnRecargarTablaActionPerformed

    /**
     * Boton encargado de eliminar platos
     *
     * @param evt evento del boton
     */
    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed

        String id = jTxfID.getText().trim();

        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDishService = new MainDishService(service);
        if (id.equals("")) {
            jTxfID.requestFocus();
            Messages.warningMessage("Debe ingresar un ID para poder borrar un registro", "Warning");
            return;
        }
        try {
            if (Messages.confirmMessage("¿ Desea borrar el registro ?", "Confirm") != 1) {
                boolean a = mainDishService.deleteMainDish(id);
                if (a) {
                    Messages.successMessage("El plato " + id + " fue elimado", "EXITO");
                }

            }
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }
        cargarLista();
        mostrarTabla();
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    /**
     * Metodo encargado de almacenar el identificador de una fila que
     * seleccionada por el mouse del jtable
     *
     * @param evt evento del mouse
     */
    private void jTblPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblPlatosMouseClicked

        int i = jTblPlatos.getSelectedRow();
        TableModel model = jTblPlatos.getModel();
        this.jTxfID.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_jTblPlatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnRecargarTabla;
    private javax.swing.JLabel jLblID;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblPlatos;
    private javax.swing.JTextField jTxfID;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga un lista a traves de un socket
     */
    private void cargarLista() {
        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDish = new MainDishService(service);

        try {
            platos = mainDish.listDishes();
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }
    }

    /**
     * Metodo encargado de mostrar los datos en un jtable
     */
    private void mostrarTabla() {
        String dataTable[][] = new String[platos.size()][3];

        for (int i = 0; i < platos.size(); i++) {
            dataTable[i][0] = platos.get(i).getId_mainDishe();
            dataTable[i][1] = platos.get(i).getNameDishe();
            dataTable[i][2] = Double.toString(platos.get(i).getDishPrice());
        }

        jTblPlatos.setModel(new javax.swing.table.DefaultTableModel(
                dataTable, new String[]{"ID", "Nombre", "Precio"}));

    }

}
