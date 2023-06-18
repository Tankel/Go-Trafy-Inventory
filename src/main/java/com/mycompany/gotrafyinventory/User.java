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
public class User extends javax.swing.JInternalFrame {

    /**
     * Creates new form Useruct
     */
    public User() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        updateUserTable();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        userAddBtn = new javax.swing.JButton();
        userDeleteBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        userEditBtn = new javax.swing.JButton();
        userEmail = new javax.swing.JTextField();
        userPass = new javax.swing.JTextField();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(121, 172, 131));
        jPanel1.setPreferredSize(new java.awt.Dimension(735, 450));

        jLabel1.setBackground(new java.awt.Color(110, 174, 133));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 174, 133));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIÓN DE USUARIOS");

        jSeparator1.setBackground(new java.awt.Color(110, 174, 133));
        jSeparator1.setForeground(new java.awt.Color(110, 174, 133));

        userName.setBackground(new java.awt.Color(255, 255, 255));
        userName.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Usuario");
        jLabel5.setToolTipText("");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Contraseña:");
        jLabel6.setToolTipText("");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Correo:");
        jLabel7.setToolTipText("");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Teléfono:");
        jLabel8.setToolTipText("");
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        userPhone.setBackground(new java.awt.Color(255, 255, 255));
        userPhone.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        userPhone.setForeground(new java.awt.Color(51, 51, 51));

        userTable.setBackground(new java.awt.Color(255, 255, 255));
        userTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        userTable.setForeground(new java.awt.Color(51, 51, 51));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO", "CONTRASEÑA", "TELÉFONO", "CORREO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setSelectionBackground(new java.awt.Color(110, 174, 133));
        userTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        userTable.getTableHeader().setResizingAllowed(false);
        userTable.getTableHeader().setReorderingAllowed(false);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        userAddBtn.setBackground(new java.awt.Color(204, 204, 204));
        userAddBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        userAddBtn.setForeground(new java.awt.Color(102, 102, 102));
        userAddBtn.setText("Agregar");
        userAddBtn.setBorder(null);
        userAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userAddBtnMouseClicked(evt);
            }
        });

        userDeleteBtn.setBackground(new java.awt.Color(255, 153, 153));
        userDeleteBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        userDeleteBtn.setForeground(new java.awt.Color(102, 102, 102));
        userDeleteBtn.setText("Eliminar");
        userDeleteBtn.setBorder(null);
        userDeleteBtn.setMaximumSize(new java.awt.Dimension(51, 26));
        userDeleteBtn.setMinimumSize(new java.awt.Dimension(51, 26));
        userDeleteBtn.setPreferredSize(new java.awt.Dimension(51, 26));
        userDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDeleteBtnActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(110, 174, 133));

        userEditBtn.setBackground(new java.awt.Color(204, 204, 204));
        userEditBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        userEditBtn.setForeground(new java.awt.Color(102, 102, 102));
        userEditBtn.setText("Editar");
        userEditBtn.setBorder(null);
        userEditBtn.setPreferredSize(new java.awt.Dimension(36, 26));
        userEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEditBtnActionPerformed(evt);
            }
        });

        userEmail.setBackground(new java.awt.Color(255, 255, 255));
        userEmail.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        userEmail.setForeground(new java.awt.Color(51, 51, 51));

        userPass.setBackground(new java.awt.Color(255, 255, 255));
        userPass.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        userPass.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userPhone)
                                    .addComponent(userName)
                                    .addComponent(userEmail)
                                    .addComponent(userPass, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(userEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userAddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(userPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(userPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userEditBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(userDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateUserTable()
    {
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "cOCOROLOCO22";
        try {
            Con = DriverManager.getConnection(url, user, ps);
            St = Con.createStatement();
            Rs = St.executeQuery("select * from users");
            userTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void userAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAddBtnMouseClicked
        String url = "jdbc:mysql://localhost:3306/trafy_inventory";
        String user = "root";
        String ps = "cOCOROLOCO22";
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(url, user, ps);
            System.out.print("Conexion exitosa");

            //Con = DriverManager.getConnection("jdbc:derby://localhost:1527/InventoryDB","Luis","Cocoroloco22");
            String sql = "Insert into users (username, password, phone, email)" + "values (?, ?, ?, ?)";
            PreparedStatement add = Con.prepareStatement(sql);
            add.setString(1, userName.getText());
            add.setString(2,userPass.getText());
            add.setString(3, userPhone.getText());
            add.setString(4, userEmail.getText());
            //int row =add.executeUpdate();
            add.execute();
            Con.close();
            JOptionPane.showMessageDialog(this, "Usuario añadido correctamente");
            updateUserTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Useructs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Useructs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userAddBtnMouseClicked

    //ELIMINAR
    private void userDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDeleteBtnActionPerformed
        if(userName.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Seleccione un usuario");
        else
        {
            String url = "jdbc:mysql://localhost:3306/trafy_inventory";
            String user = "root";
            String ps = "cOCOROLOCO22";
            try {
                Con = DriverManager.getConnection(url, user, ps);
                Statement Add = Con.createStatement();
                Rs = Add.executeQuery("select * from users where USERNAME='"+userName.getText()+"'");
                if(Rs.next())
                {
                    Add.executeUpdate("Delete from users where USERNAME='"+userName.getText()+"'");
                    updateUserTable(); 
                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
                }
                else
                    JOptionPane.showMessageDialog(this, "Nombre de usuario no encontrado");
            } catch(SQLException ex) {
                ex.printStackTrace();
            } 
        }
    }//GEN-LAST:event_userDeleteBtnActionPerformed

    //EDITAR
    private void userEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEditBtnActionPerformed
        if(userName.getText().isEmpty() || userPass.getText().isEmpty() || userPhone.getText().isEmpty() || userEmail.getText().isEmpty() )
            JOptionPane.showMessageDialog(this, "Falta Información");
        else
        {
            String url = "jdbc:mysql://localhost:3306/trafy_inventory";
            String user = "root";
            String ps = "cOCOROLOCO22";
            try {
                Con = DriverManager.getConnection(url, user, ps);
                Statement Add = Con.createStatement();
                Rs = Add.executeQuery("select * from users where USERNAME='"+userName.getText()+"'");
                if(Rs.next())
                {
                    Add.executeUpdate("update users set PASSWORD='"+userPass.getText()+"', PHONE='"+userPhone.getText()+"', EMAIL='"+userEmail.getText()+"' where USERNAME='"+userName.getText()+"'");
                    updateUserTable(); 
                    JOptionPane.showMessageDialog(this, "Datos del usuario modificado correctamente");
                }
                else
                    JOptionPane.showMessageDialog(this, "Nombre de usuario no encontrado.\nEl nombre de usuario no puede ser modificado."); 
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_userEditBtnActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        DefaultTableModel model =  (DefaultTableModel) userTable.getModel();
        int row = userTable.getSelectedRow();
        userName.setText(model.getValueAt (row, 0).toString());
        userPass.setText(model.getValueAt (row, 1).toString());
        userPhone.setText(model.getValueAt (row, 2).toString());
        userEmail.setText(model.getValueAt (row, 3).toString());
    }//GEN-LAST:event_userTableMouseClicked
                                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton userAddBtn;
    private javax.swing.JButton userDeleteBtn;
    private javax.swing.JButton userEditBtn;
    private javax.swing.JTextField userEmail;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userPass;
    private javax.swing.JTextField userPhone;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
