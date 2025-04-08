/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.views;

import co.edu.sena.examplejdbc.bd.controllers.EmployeeController;
import co.edu.sena.examplejdbc.bd.controllers.EmployeeTypeController;
import co.edu.sena.examplejdbc.bd.controllers.IEmployeeController;
import co.edu.sena.examplejdbc.bd.controllers.IEmployeeTypeController;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class JFrameEmployee extends javax.swing.JFrame {
    private IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
    private IEmployeeController employeeController = new EmployeeController();
    /**
     * Creates new form JFrameEmployee
     */
    public JFrameEmployee() {
        initComponents();
        fillComboTypes();
        fillTable();
    }
    
    public void fillComboTypes()
    {
        try {
            List<EmployeeType> types = employeeTypeController.findAll();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            jComboBoxTypes.setModel(model);
            model.addAll(types);
            
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
            
    }
    
    public void fillTable()
    {
        try {
            DefaultTableModel model = new DefaultTableModel();
            jTableEmployee.setModel(model);
            model.addColumn("Documento");
            model.addColumn("NombreCompleto");
            model.addColumn("Tipo de empleado");
            
            String [] rows = new String[3];
            List<Employee> employees = employeeController.findAll();
            for (Employee e : employees) {
                rows[0] = String.valueOf(e.getDocument());
                rows[1] = e.getFullname();
                rows[2] = e.getEmployeeType().getDescript();
                model.addRow(rows);
            }
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }

    /**try {
            Employee employee = new Employee();
            employee.setDocument(Long.parseLong(jTextFieldDocument.getText()));
            employee.setFullname(jTextFieldFullName.getText());
            employee.setAddress(jTextFieldAddress.getText());
            employee.setPhone(jTextFieldPhone.getText());
            
            //FK
            EmployeeType type = (EmployeeType) jComboBoxTypes.getSelectedItem();
            employee.setEmployeeType(type);
            employeeController.insert(employee);
            MessageUtils.ShowInfoMessage("El empleado creado exitosamente");
            fillTable();
            clear();
            
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDocument = new javax.swing.JTextField();
        jLabelEmployee = new javax.swing.JLabel();
        jLabelDocument = new javax.swing.JLabel();
        jLabelFullName = new javax.swing.JLabel();
        jTextFieldFullName = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jComboBoxTypes = new javax.swing.JComboBox<>();
        jScrollPaneEmployees = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jLabelHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmployee.setText("EMPLEADO");

        jLabelDocument.setText("Documento:");

        jLabelFullName.setText("Nombre Completo:");

        jLabelAddress.setText("Direccion:");

        jLabelPhone.setText("Telefono:");

        jLabelType.setText("Tipo:");

        jTableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeeMouseClicked(evt);
            }
        });
        jScrollPaneEmployees.setViewportView(jTableEmployee);

        jButtonInsert.setBackground(new java.awt.Color(0, 204, 0));
        jButtonInsert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInsert.setText("Crear");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(255, 255, 51));
        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonUpdate.setText("Modificar");
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 0, 0));
        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonDelete.setText("Eliminar");
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonClean.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonClean.setText("Limpiar");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/sena/examplejdbc/view/Home.png"))); // NOI18N
        jLabelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneEmployees)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelDocument)
                                            .addComponent(jLabelAddress)
                                            .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldDocument)
                                            .addComponent(jTextFieldAddress)
                                            .addComponent(jComboBoxTypes, 0, 180, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)
                                        .addComponent(jButtonUpdate)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonDelete)
                                        .addGap(88, 88, 88)
                                        .addComponent(jButtonClean))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelFullName)
                                            .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldFullName)
                                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabelEmployee)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmployee)
                    .addComponent(jLabelHome))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocument)
                    .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFullName)
                    .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPhone)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelType)
                    .addComponent(jComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonClean))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        try {
            Employee employee = new Employee();
            employee.setDocument(Long.parseLong(jTextFieldDocument.getText()));
            employee.setFullname(jTextFieldFullName.getText());
            employee.setAddress(jTextFieldAddress.getText());
            employee.setPhone(jTextFieldPhone.getText());
            
            //FK
            EmployeeType type = (EmployeeType) jComboBoxTypes.getSelectedItem();
            employee.setEmployeeType(type);
            employeeController.insert(employee);
            MessageUtils.ShowInfoMessage("El empleado creado exitosamente");
            fillTable();
            clear();
            
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jTableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeeMouseClicked
        int rowSelected = jTableEmployee.getSelectedRow();
        if(rowSelected != -1)
        {
            long documentSelected = Long.parseLong(jTableEmployee.getValueAt(rowSelected, 0).toString());
            try {
                Employee employee = employeeController.findById(documentSelected);
                jTextFieldDocument.setText(String.valueOf(documentSelected));
                jTextFieldFullName.setText(employee.getFullname());
                jTextFieldAddress.setText(employee.getAddress());
                jTextFieldPhone.setText(employee.getPhone());
                jComboBoxTypes.getModel().setSelectedItem(employee.getEmployeeType());
                
                jButtonInsert.setEnabled(false);
                jButtonUpdate.setEnabled(true);
                jButtonDelete.setEnabled(true);
            } catch (Exception e) {
                MessageUtils.ShowInfoMessage(e.getMessage());
            }
            }
                
    }//GEN-LAST:event_jTableEmployeeMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
            Employee employee = new Employee();
            employee.setDocument(Long.parseLong(jTextFieldDocument.getText()));
            employee.setFullname(jTextFieldFullName.getText());
            employee.setAddress(jTextFieldAddress.getText());
            employee.setPhone(jTextFieldPhone.getText());
            
            //FK
            EmployeeType type = (EmployeeType) jComboBoxTypes.getSelectedItem();
            employee.setEmployeeType(type);
            employeeController.update(employee);
            MessageUtils.ShowInfoMessage("El empleado fue modificado exitosamente");
            fillTable();
            clear();
            
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            int option = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el registro?", 
                         "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                employeeController.delete(Long.parseLong(jTextFieldDocument.getText()));
                MessageUtils.ShowInfoMessage("Empleado eliminado exitosamente");
                fillTable();
            }
            clear();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        clear();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
       JFrameHome view = new JFrameHome();
        view.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabelHomeMouseClicked

    
    public void clear()
    {
        jTextFieldAddress.setText("");
        jTextFieldDocument.setText("");
        jTextFieldFullName.setText("");
        jTextFieldPhone.setText("");
        jTableEmployee.clearSelection();
        jComboBoxTypes.setSelectedIndex(0);
        jButtonInsert.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }
    
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
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxTypes;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDocument;
    private javax.swing.JLabel jLabelEmployee;
    private javax.swing.JLabel jLabelFullName;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JScrollPane jScrollPaneEmployees;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldDocument;
    private javax.swing.JTextField jTextFieldFullName;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
