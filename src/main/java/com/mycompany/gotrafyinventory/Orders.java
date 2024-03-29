/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.gotrafyinventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author luisa
 */
public class Orders extends javax.swing.JInternalFrame {

    /**
     * Creates new form Product
     */
    public Orders() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        updateProdTable();
        updateCustTable();
        getToday();
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void getToday()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        dateLabel.setText(dtf.format(now));
    }
    public void updateProdTable()
    {
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "hola123";
        try {
            Con = DriverManager.getConnection(url, user, ps);
            St = Con.createStatement();
            Rs = St.executeQuery("select * from products");
            prodTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateCustTable()
    {
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "hola123";
        try {
            Con = DriverManager.getConnection(url, user, ps);
            St = Con.createStatement();
            Rs = St.executeQuery("select * from customer");
            custTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateQty()
    {
        int newQty = oldQty - Integer.valueOf(prodQty.getText());
       
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "hola123";
        try {
            Con = DriverManager.getConnection(url, user, ps);
            Statement Add = Con.createStatement();
            Add.executeUpdate("update products set QUANTITY='"+newQty+"' where ID="+prodId);
            updateProdTable();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodTable = new javax.swing.JTable();
        addToOrderBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        prodPrice = new javax.swing.JTextField();
        jLabelProduct = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        jLabelProduct1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        billId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        custName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        addoOrderBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        prodQty = new javax.swing.JTextField();
        printBtn = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(862, 453));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(121, 172, 131));
        jPanel1.setPreferredSize(new java.awt.Dimension(735, 450));

        jLabel1.setBackground(new java.awt.Color(110, 174, 133));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 174, 133));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEDIDOS");

        jSeparator1.setBackground(new java.awt.Color(110, 174, 133));
        jSeparator1.setForeground(new java.awt.Color(110, 174, 133));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio:");
        jLabel7.setToolTipText("");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cantidad:");
        jLabel8.setToolTipText("");
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        prodTable.setBackground(new java.awt.Color(255, 255, 255));
        prodTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        prodTable.setForeground(new java.awt.Color(51, 51, 51));
        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CANTIDAD", "DESCRIPCIÓN", "CATEGORÍA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        prodTable.setSelectionBackground(new java.awt.Color(110, 174, 133));
        prodTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        prodTable.getTableHeader().setResizingAllowed(false);
        prodTable.getTableHeader().setReorderingAllowed(false);
        prodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(prodTable);

        addToOrderBtn.setBackground(new java.awt.Color(102, 102, 102));
        addToOrderBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        addToOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToOrderBtn.setText("Agregar a la ordén");
        addToOrderBtn.setBorder(null);
        addToOrderBtn.setPreferredSize(new java.awt.Dimension(121, 24));
        addToOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToOrderBtnMouseClicked(evt);
            }
        });
        addToOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToOrderBtnActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(110, 174, 133));

        prodPrice.setBackground(new java.awt.Color(255, 255, 255));
        prodPrice.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        prodPrice.setForeground(new java.awt.Color(51, 51, 51));

        jLabelProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProduct.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabelProduct.setForeground(new java.awt.Color(102, 102, 102));
        jLabelProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProduct.setText("LISTA DE PRODUCTOS");
        jLabelProduct.setIconTextGap(10);
        jLabelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProductMouseClicked(evt);
            }
        });

        custTable.setBackground(new java.awt.Color(255, 255, 255));
        custTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        custTable.setForeground(new java.awt.Color(51, 51, 51));
        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        custTable.setSelectionBackground(new java.awt.Color(110, 174, 133));
        custTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        custTable.getTableHeader().setResizingAllowed(false);
        custTable.getTableHeader().setReorderingAllowed(false);
        custTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(custTable);

        jLabelProduct1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProduct1.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabelProduct1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelProduct1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProduct1.setText("CLIENTES");
        jLabelProduct1.setIconTextGap(10);
        jLabelProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProduct1MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("ID de la orden:");
        jLabel10.setToolTipText("");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        billId.setBackground(new java.awt.Color(255, 255, 255));
        billId.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        billId.setForeground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Nombre del cliente:");
        jLabel11.setToolTipText("");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        custName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        custName.setForeground(new java.awt.Color(51, 51, 51));
        custName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        custName.setText("-");
        custName.setToolTipText("");
        custName.setFocusable(false);
        custName.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Fecha:");
        jLabel13.setToolTipText("");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        dateLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateLabel.setText("-");
        dateLabel.setToolTipText("");
        dateLabel.setFocusable(false);
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        addoOrderBtn.setBackground(new java.awt.Color(204, 204, 204));
        addoOrderBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        addoOrderBtn.setForeground(new java.awt.Color(102, 102, 102));
        addoOrderBtn.setText("Agregar ordén");
        addoOrderBtn.setBorder(null);
        addoOrderBtn.setPreferredSize(new java.awt.Dimension(121, 24));
        addoOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addoOrderBtnMouseClicked(evt);
            }
        });
        addoOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addoOrderBtnActionPerformed(evt);
            }
        });

        billTable.setBackground(new java.awt.Color(255, 255, 255));
        billTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        billTable.setForeground(new java.awt.Color(51, 51, 51));
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "PRODUCTO", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
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
        billTable.setSelectionBackground(new java.awt.Color(110, 174, 133));
        billTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        billTable.getTableHeader().setResizingAllowed(false);
        billTable.getTableHeader().setReorderingAllowed(false);
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(billTable);

        prodQty.setBackground(new java.awt.Color(255, 255, 255));
        prodQty.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        prodQty.setForeground(new java.awt.Color(51, 51, 51));
        prodQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodQtyActionPerformed(evt);
            }
        });

        printBtn.setBackground(new java.awt.Color(134, 187, 152));
        printBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        printBtn.setForeground(new java.awt.Color(102, 102, 102));
        printBtn.setText("IMPRIMIR");
        printBtn.setBorder(null);
        printBtn.setPreferredSize(new java.awt.Dimension(121, 24));
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalLabel.setText("-");
        totalLabel.setToolTipText("");
        totalLabel.setFocusable(false);
        totalLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        totalLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        totalLabel1.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel1.setText("Rs");
        totalLabel1.setToolTipText("");
        totalLabel1.setFocusable(false);
        totalLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelProduct1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(custName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(billId, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(printBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(totalLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addoOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prodQty, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addToOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(prodPrice)
                    .addComponent(jLabel8)
                    .addComponent(prodQty)
                    .addComponent(addToOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(custName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(dateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addoOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int i = 1, unityPrice, qty, subtotal, total=0;
    String prodName;
    private void addToOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToOrderBtnMouseClicked
        
        qty =  Integer.valueOf(prodQty.getText());
        unityPrice = Integer.valueOf(prodPrice.getText());
        subtotal = qty * unityPrice;
        int newQty = oldQty - Integer.valueOf(prodQty.getText());
        
        if(flag == 0 || prodQty.getText().isEmpty() || prodPrice.getText().isEmpty() || prodName.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Selecciona un producto e ingresa la cantidad");
        }
        else if(qty < 1)
        {
            JOptionPane.showMessageDialog(this, "La cantidad mínima es 1");
        }
        else if(oldQty<1)
        {
            JOptionPane.showMessageDialog(this, "El producto selccionado está agotado");
        }
        else if(newQty<0)
        {
            JOptionPane.showMessageDialog(this, "La cantidad seleccionada no se encuentra en stock");
        }
        else
        {
            Vector v = new Vector();
            v.add(i);
            v.add(prodName);
            v.add(qty);
            v.add(Integer.valueOf(prodPrice.getText()));
            v.add(subtotal);
            DefaultTableModel dt = (DefaultTableModel)billTable.getModel();
            dt.addRow(v);
            i++;
            updateQty();
            total+=subtotal;
            totalLabel.setText(""+total);
        }
    }//GEN-LAST:event_addToOrderBtnMouseClicked

    private void jLabelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProductMouseClicked

    }//GEN-LAST:event_jLabelProductMouseClicked

    private void addToOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToOrderBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToOrderBtnActionPerformed

    int flag = 0, prodId, oldQty;
    private void prodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMouseClicked
        DefaultTableModel model =  (DefaultTableModel) prodTable.getModel();
        int row = prodTable.getSelectedRow();
        //billId.setText(model.getValueAt (row, 0).toString());
        prodId = Integer.valueOf(model.getValueAt (row, 0).toString());
        prodName = model.getValueAt (row, 1).toString();
        oldQty = Integer.valueOf(model.getValueAt (row, 2).toString());
        flag = 1;
    }//GEN-LAST:event_prodTableMouseClicked

    private void custTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTableMouseClicked
        DefaultTableModel model =  (DefaultTableModel) custTable.getModel();
        int row = custTable.getSelectedRow();
        custName.setText(model.getValueAt (row, 1).toString());
    }//GEN-LAST:event_custTableMouseClicked

    private void jLabelProduct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProduct1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProduct1MouseClicked

    private void addoOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addoOrderBtnMouseClicked
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "hola123";
        if (billId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ingresa el ID de la factura");
        }else
        {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(url, user, ps);
            System.out.print("Conexion exitosa");
            
            //Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InventoryDB","Luis","Cocoroloco22");
            String sql = "Insert into `order` (id, customer_name, date, amount)" + "values (?, ?, ?, ?)";
            PreparedStatement add = Con.prepareStatement(sql);
            add.setInt(1, Integer.valueOf(billId.getText()));
            add.setString(2,custName.getText());
            add.setString(3, dateLabel.getText());
            add.setInt(4, Integer.valueOf(totalLabel.getText()));
            //int row =add.executeUpdate();
            add.execute();
            Con.close();
            JOptionPane.showMessageDialog(this, "Orden añadida correctamente");
            updateProdTable();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_addoOrderBtnMouseClicked

    private void addoOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addoOrderBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addoOrderBtnActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_billTableMouseClicked

    private void prodQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodQtyActionPerformed

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
        try{
            billTable.print();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }//GEN-LAST:event_printBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToOrderBtn;
    private javax.swing.JButton addoOrderBtn;
    private javax.swing.JTextField billId;
    private javax.swing.JTable billTable;
    private javax.swing.JLabel custName;
    private javax.swing.JTable custTable;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JLabel jLabelProduct1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextField prodPrice;
    private javax.swing.JTextField prodQty;
    private javax.swing.JTable prodTable;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalLabel1;
    // End of variables declaration//GEN-END:variables
}
