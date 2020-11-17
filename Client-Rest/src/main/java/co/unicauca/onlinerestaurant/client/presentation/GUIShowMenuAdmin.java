package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IDessertAccess;
import co.unicauca.onlinerestaurant.client.access.IDrinkAccess;
import co.unicauca.onlinerestaurant.client.access.IEntryAccess;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
import co.unicauca.onlinerestaurant.client.access.ISaladAccess;
import co.unicauca.onlinerestaurant.client.domain.services.DessertService;
import co.unicauca.onlinerestaurant.client.domain.services.DrinkService;
import co.unicauca.onlinerestaurant.client.domain.services.EntryService;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import co.unicauca.onlinerestaurant.client.domain.services.MenuService;
import co.unicauca.onlinerestaurant.client.domain.services.SaladService;
import co.unicauca.onlinerestaurant.client.infra.Messages;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.common.domain.entity.Drink;
import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.common.domain.entity.Salad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Santiago Acuña
 */
public class GUIShowMenuAdmin extends javax.swing.JInternalFrame {

    /**
     * Nombre del restaurante
     */
    String restaurantname;
    /**
     * Lista de menus del restaurante
     */
    private List<Menu> menus = new ArrayList<>();
    /**
     * Lista de platos del restaurante
     */
    private List<MainDish> mainDishes = new ArrayList<>();
    /**
     * Lista ensaladas del restaurante
     */
    private List<Salad> salads = new ArrayList<>();
    /**
     * Lista de postres del restaurante
     */
    private List<Dessert> desserts = new ArrayList<>();
    /**
     * Lista de entradas del restaurantes
     */
    private List<DishEntry> dishEntries = new ArrayList<>();
    /**
     * Lista de jugos del restaurante
     */
    private List<Drink> drinks = new ArrayList<>();

    /**
     * Creates new form GUIUpdateDishe
     *
     * @param RestaurantN Nombre del restaurante
     * @throws java.lang.Exception
     */
    public GUIShowMenuAdmin(String RestaurantN) throws Exception {
        initComponents();
        restaurantname = RestaurantN;
        cargarListas();
        mostrarTabla();
        loadDataCombo();
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
        jtxtnamerestaurant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPnSur = new javax.swing.JPanel();
        BntAgregar = new javax.swing.JButton();
        BntModificar = new javax.swing.JButton();
        BntEliminar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnRecargarTabla = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMenus = new javax.swing.JTable();
        jPnlCenDer = new javax.swing.JPanel();
        jLbID = new javax.swing.JLabel();
        jTxfID = new javax.swing.JTextField();
        jLbPlatoPrincipal = new javax.swing.JLabel();
        jCbxPlatoPrincipal = new javax.swing.JComboBox<>();
        jLbBebida = new javax.swing.JLabel();
        jCbxBebida = new javax.swing.JComboBox<>();
        jLbEnsalada = new javax.swing.JLabel();
        jCbxEnsalada = new javax.swing.JComboBox<>();
        jLbEntrada = new javax.swing.JLabel();
        jCbxEntrada = new javax.swing.JComboBox<>();
        jLbPostre = new javax.swing.JLabel();
        jCbxPostre = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menus");
        setPreferredSize(new java.awt.Dimension(700, 394));

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu de la semana del Restaurante:");

        javax.swing.GroupLayout jPnNorteLayout = new javax.swing.GroupLayout(jPnNorte);
        jPnNorte.setLayout(jPnNorteLayout);
        jPnNorteLayout.setHorizontalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jtxtnamerestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPnNorteLayout.setVerticalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtnamerestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        BntAgregar.setText("Agregar");
        BntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntAgregarActionPerformed(evt);
            }
        });
        jPnSur.add(BntAgregar);

        BntModificar.setText("Modificar");
        BntModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntModificarActionPerformed(evt);
            }
        });
        jPnSur.add(BntModificar);

        BntEliminar.setText("Eliminar");
        BntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntEliminarActionPerformed(evt);
            }
        });
        jPnSur.add(BntEliminar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCancelar);

        jBtnRecargarTabla.setText("Recargar");
        jBtnRecargarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRecargarTablaActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnRecargarTabla);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        jPnCentro.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPnCentro, java.awt.BorderLayout.LINE_START);

        jTblMenus = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTblMenus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Plato Principal", "Bebida", "Ensalada", "Entrada", "Postre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPnlCenDer.setPreferredSize(new java.awt.Dimension(200, 290));
        jPnlCenDer.setLayout(new java.awt.GridLayout(6, 2));

        jLbID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbID.setText("ID:");
        jPnlCenDer.add(jLbID);
        jPnlCenDer.add(jTxfID);

        jLbPlatoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbPlatoPrincipal.setText("Plato Principal:");
        jPnlCenDer.add(jLbPlatoPrincipal);

        jPnlCenDer.add(jCbxPlatoPrincipal);

        jLbBebida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbBebida.setText("Bebida:");
        jPnlCenDer.add(jLbBebida);

        jPnlCenDer.add(jCbxBebida);

        jLbEnsalada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbEnsalada.setText("Ensalada:");
        jPnlCenDer.add(jLbEnsalada);

        jPnlCenDer.add(jCbxEnsalada);

        jLbEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbEntrada.setText("Entrada:");
        jPnlCenDer.add(jLbEntrada);

        jPnlCenDer.add(jCbxEntrada);

        jLbPostre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbPostre.setText("Postre:");
        jPnlCenDer.add(jLbPostre);

        jPnlCenDer.add(jCbxPostre);

        getContentPane().add(jPnlCenDer, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        this.doDefaultCloseAction();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    /**
     * Modifica un menu de la base de datos mediante un Id
     *
     * @param evt Evento del boton modificar menu
     */
    private void BntModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntModificarActionPerformed
        if (jTxfID.getText().equals("")) {
            Messages.warningMessage("Campos vacios: Error al modificar", "Warning");
            return;
        }
        boolean men;

        IMenuAccess service = Factory.getInstance().getMenuService();
        // Inyecta la dependencia
        MenuService menuService = new MenuService(service);
        Menu myMenu = new Menu();
        myMenu.setId_menu(jTxfID.getText());
        myMenu.setMaindish((MainDish) jCbxPlatoPrincipal.getSelectedItem());
        myMenu.setDessert((Dessert) jCbxPostre.getSelectedItem());
        myMenu.setDrink((Drink) jCbxBebida.getSelectedItem());
        myMenu.setSalad((Salad) jCbxEnsalada.getSelectedItem());
        myMenu.setEntry((DishEntry) jCbxEntrada.getSelectedItem());
        men = false;
        try {
            men = menuService.updateMenu(myMenu.getId_menu(),myMenu);
        } catch (Exception ex) {

            successMessage(ex.getMessage(), "Atención");
            return;
        }
        if (men) {
            eliminarItemMenu(jTxfID.getText());
            menus.add(myMenu);
            mostrarTabla();
            successMessage("Se modifico el plato con exito.", "EXITO");
        } else {
            Messages.warningMessage("Error al modificar", "Warning");
        }
    }//GEN-LAST:event_BntModificarActionPerformed

    /**
     * Almacena el indice fila de la tabla menus
     *
     * @param evt Evento click de la tabla menus
     */
    private void jTblMenusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblMenusMouseClicked

        int i = jTblMenus.getSelectedRow();
        TableModel model = jTblMenus.getModel();
        this.jTxfID.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_jTblMenusMouseClicked

    /**
     * Elimina un menu en especifico mediante un Id
     *
     * @param evt Evento del boton Eliminar menu
     */
    private void BntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntEliminarActionPerformed
        if (jTxfID.getText().equals("")) {
            Messages.warningMessage("El campo Id vacio: Error al agregar", "Warning");
            return;
        }

        IMenuAccess service = Factory.getInstance().getMenuService();
        // Inyecta la dependencia
        MenuService menuService = new MenuService(service);
        try {

            if (Messages.confirmMessage("¿ Desea borrar el registro ?", "Confirm") != 1) {
                boolean aux = menuService.deleteMenu(jTxfID.getText());
                if (aux == false) {
                    Messages.warningMessage("No se pudo borrar el menu", "Warning");
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e) {
            Messages.warningMessage(e.getMessage(), "Warning");
        }
        eliminarItemMenu(jTxfID.getText());
        mostrarTabla();
        successMessage("Se borro el menu con exito.", "EXITO");
    }//GEN-LAST:event_BntEliminarActionPerformed

    /**
     * Crea un menu y lo guarda en la base de datos
     *
     * @param evt Evento del boton agregar menu
     */
    private void BntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntAgregarActionPerformed
        if (jTxfID.getText().equals("")) {
            Messages.warningMessage("El campo Id vacio: Error al agregar", "Warning");
            return;
        }

        IMenuAccess service = Factory.getInstance().getMenuService();
        // Inyecta la dependencia
        MenuService menuService = new MenuService(service);
        Menu myMenu = new Menu();
        myMenu.setId_menu(jTxfID.getText());
        myMenu.setMaindish((MainDish) jCbxPlatoPrincipal.getSelectedItem());
        myMenu.setDessert((Dessert) jCbxPostre.getSelectedItem());
        myMenu.setDrink((Drink) jCbxBebida.getSelectedItem());
        myMenu.setSalad((Salad) jCbxEnsalada.getSelectedItem());
        myMenu.setEntry((DishEntry) jCbxEntrada.getSelectedItem());

        try {
            if (menuService.createMenu(myMenu)) {
                menus.add(myMenu);
                mostrarTabla();
                successMessage("Se creo el menu con exito.", "EXITO");
            } else {
                Messages.warningMessage("Error al crear el menu", "Warning");
            }
        } catch (Exception e) {
            Messages.warningMessage(e.getMessage(), "Warning");
        }

    }//GEN-LAST:event_BntAgregarActionPerformed
    /**
     * Actualiza la tabla y los combo box con informacion nueva de la base de
     * datos
     *
     * @param evt Evento del boton recargar tabla
     */
    private void jBtnRecargarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRecargarTablaActionPerformed
        this.jCbxBebida.removeAllItems();
        this.jCbxEnsalada.removeAllItems();
        this.jCbxEntrada.removeAllItems();
        this.jCbxPlatoPrincipal.removeAllItems();
        this.jCbxPostre.removeAllItems();
        cargarListas();
        mostrarTabla();
        loadDataCombo();
    }//GEN-LAST:event_jBtnRecargarTablaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntAgregar;
    private javax.swing.JButton BntEliminar;
    private javax.swing.JButton BntModificar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnRecargarTabla;
    private javax.swing.JComboBox<String> jCbxBebida;
    private javax.swing.JComboBox<String> jCbxEnsalada;
    private javax.swing.JComboBox<String> jCbxEntrada;
    private javax.swing.JComboBox<String> jCbxPlatoPrincipal;
    private javax.swing.JComboBox<String> jCbxPostre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbBebida;
    private javax.swing.JLabel jLbEnsalada;
    private javax.swing.JLabel jLbEntrada;
    private javax.swing.JLabel jLbID;
    private javax.swing.JLabel jLbPlatoPrincipal;
    private javax.swing.JLabel jLbPostre;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JPanel jPnlCenDer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblMenus;
    private javax.swing.JTextField jTxfID;
    private javax.swing.JTextField jtxtnamerestaurant;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga los tipos de comida en el jComboBox
     */
    private void loadDataCombo() {
        this.jCbxPlatoPrincipal.setModel(new DefaultComboBoxModel(mainDishes.toArray()));
        this.jCbxEntrada.setModel(new DefaultComboBoxModel(dishEntries.toArray()));
        this.jCbxEnsalada.setModel(new DefaultComboBoxModel(salads.toArray()));
        this.jCbxBebida.setModel(new DefaultComboBoxModel(drinks.toArray()));
        this.jCbxPostre.setModel(new DefaultComboBoxModel(desserts.toArray()));
    }

    /**
     * Carga un lista usando la API REST
     */
    private void cargarListas() {
        IMenuAccess service = Factory.getInstance().getMenuService();
        IMainDishAccess mdService = Factory.getInstance().getMainDishService();
        IEntryAccess entService = Factory.getInstance().getEntryService();
        ISaladAccess salService = Factory.getInstance().getSaladService();
        IDrinkAccess drService = Factory.getInstance().getDrinkService();
        IDessertAccess dsService = Factory.getInstance().getDessertService();

        // Inyecta las dependencias
        MenuService menuService = new MenuService(service);
        MainDishService dishService = new MainDishService(mdService);
        EntryService entryService = new EntryService(entService);
        SaladService saladService = new SaladService(salService);
        DrinkService drinkService = new DrinkService(drService);
        DessertService dessertService = new DessertService(dsService);

        try {
            menus = menuService.listMenus();
            mainDishes = dishService.listDishes();
            dishEntries = entryService.listEntrys();
            salads = saladService.listSalads();
            drinks = drinkService.listDrinks();
            desserts = dessertService.listDesserts();
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }
    }

    /**
     * Metodo encargado de mostrar los datos en un jtable
     */
    private void mostrarTabla() {
        String dataTable[][] = new String[menus.size()][6];

        for (int i = 0; i < menus.size(); i++) {
            dataTable[i][0] = menus.get(i).getId_menu();
            dataTable[i][1] = menus.get(i).getMaindish().getNameDish();
            dataTable[i][2] = menus.get(i).getDrink().getNameDrink();
            dataTable[i][3] = menus.get(i).getSalad().getNameSalad();
            dataTable[i][4] = menus.get(i).getEntry().getNameDishEntry();
            dataTable[i][5] = menus.get(i).getDessert().getName_Dish_Dessert();

        }

        jTblMenus.setModel(new javax.swing.table.DefaultTableModel(
                dataTable, new String[]{"ID", "Plato Principal", "Bebida", "Ensalada", "Entrada", "Postre"}));
    }

    /**
     * Elimina de la lista de menus un menu en especifico
     *
     * @param id Identificador del menu a eliminar de la lista
     */
    private void eliminarItemMenu(String id) {
        for (Menu myMenu : menus) {
            if (id.equals(myMenu.getId_menu())) {
                menus.remove(myMenu);
                return;
            }
        }
    }
}
