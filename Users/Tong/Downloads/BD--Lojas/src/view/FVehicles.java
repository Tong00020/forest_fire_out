/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.dao.VehiclesDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Vehicles;

/**
 *
 * @author Tong
 */
public class FVehicles extends javax.swing.JFrame {

    /**
     * Creates new form Vehicles
     */
    public FVehicles() {
        initComponents();
        jButton4.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtKmVehicles = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdVehicles = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarcaVehicles = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPlacaVehicles = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAnoVehicles = new javax.swing.JTextField();
        txtModeloVehicles = new javax.swing.JTextField();
        txtCombusVehicles = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorVehicles = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVehicles = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtBuscaVehicles = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdClienteVehicles = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("PLACA");

        jLabel9.setText("ID");

        jLabel2.setText("MODELO");

        jLabel3.setText("ANO");

        jLabel7.setText("ID DO CLIENTE");

        jLabel11.setText("VELOCIDADE ATUAL");

        jLabel4.setText("COR");

        jLabel1.setText("MARCA");

        jTVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MODELO", "MARCA", "PLACA", "ANO", "COR", "TIPO DE COMBUSTIVEL", "VELOCIDADE ATUAL", "ID DO CLIENTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTVehicles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTVehiclesMouseClicked(evt);
            }
        });
        jTVehicles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTVehiclesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTVehicles);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtBuscaVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaVehiclesActionPerformed(evt);
            }
        });

        jButton4.setText("Busca");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("TIPO DE COMBUSTIVEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtPlacaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtModeloVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtMarcaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(txtCorVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnoVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKmVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(214, 214, 214)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(txtCombusVehicles)
                                        .addGap(42, 42, 42))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addGap(244, 244, 244)
                                .addComponent(txtBuscaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(253, 253, 253)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(506, Short.MAX_VALUE)
                    .addComponent(txtIdClienteVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(375, 375, 375)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlacaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModeloVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnoVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarcaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtKmVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCombusVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscaVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(txtIdClienteVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public void readJTable() throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) jTVehicles.getModel();
        modelo.setNumRows(0);
        VehiclesDAO pdao = new VehiclesDAO();

        for (Vehicles p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getModel(),
                p.getBrand(),
                p.getPlate(),
                p.getYear(),
                p.getColor(),
                p.getType_fuel(),
                p.getKm_current(),
                p.getColor(),
                p.getClientId()
            });

        }

    }
    
    
    public void readJTableForDesc(String desc) throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) jTVehicles.getModel();
        modelo.setNumRows(0);
        VehiclesDAO pdao = new VehiclesDAO();

        for (Vehicles p : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getModel(),
                p.getBrand(),
                p.getPlate(),
                p.getYear(),
                p.getColor(),
                p.getType_fuel(),
                p.getKm_current(),
                p.getColor(),
                p.getClientId()
            });

        }
    }
    
    private void jTVehiclesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVehiclesMouseClicked
        if (jTVehicles.getSelectedRow() != -1) {

            txtIdVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 1).toString());
            txtAnoVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 5).toString());
            txtCorVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 6).toString());
            txtKmVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 8).toString());
            txtModeloVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 2).toString());
            txtPlacaVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 4).toString());
            txtCombusVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 7).toString());
            txtMarcaVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 3).toString());
            txtIdClienteVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 9).toString());
        }
    }//GEN-LAST:event_jTVehiclesMouseClicked

    private void jTVehiclesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTVehiclesKeyReleased
        if (jTVehicles.getSelectedRow() != -1) {

            txtIdVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 1).toString());
            txtAnoVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 5).toString());
            txtCorVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 6).toString());
            txtKmVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 8).toString());
            txtModeloVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 2).toString());
            txtPlacaVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 4).toString());
            txtCombusVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 7).toString());
            txtMarcaVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 3).toString());
            txtIdClienteVehicles.setText(jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 9).toString());
        }
    }//GEN-LAST:event_jTVehiclesKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Vehicles p = new Vehicles();
            VehiclesDAO dao = new VehiclesDAO();

            p.setId(Integer.parseInt(txtIdVehicles.getText()));
            p.setYear(Integer.parseInt(txtAnoVehicles.getText()));
            p.setColor(txtCorVehicles.getText());
            p.setType_fuel(txtCombusVehicles.getText());
            p.setKm_current(Double.parseDouble(txtKmVehicles.getText()));
            p.setModel(txtModeloVehicles.getText());
            p.setPlate(txtPlacaVehicles.getText());
            p.setClientId(Integer.parseInt(txtIdClienteVehicles.getText()));
            p.setBrand(txtMarcaVehicles.getText());
            dao.create(p);

            txtIdVehicles.setText("");
            txtAnoVehicles.setText("");
            txtCorVehicles.setText("");
            txtKmVehicles.setText("");
            txtModeloVehicles.setText("");
            txtPlacaVehicles.setText("");
            txtCombusVehicles.setText("");
            txtMarcaVehicles.setText("");
            txtIdClienteVehicles.setText("");       
            readJTable();

        } catch (SQLException ex) {
            Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTVehicles.getSelectedRow() != -1) {

            try {

                Vehicles p = new Vehicles();
                VehiclesDAO dao = new VehiclesDAO();

                p.setId((int) jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 0));

                dao.delete(p);

                txtIdVehicles.setText("");
                txtAnoVehicles.setText("");
                txtCorVehicles.setText("");
                txtKmVehicles.setText("");
                txtModeloVehicles.setText("");
                txtPlacaVehicles.setText("");
                txtCombusVehicles.setText("");
                txtMarcaVehicles.setText("");
                txtIdClienteVehicles.setText(""); 

                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um veículo para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTVehicles.getSelectedRow() != -1) {

            try {

                Vehicles p = new Vehicles();
                VehiclesDAO dao = new VehiclesDAO();

                p.setId(Integer.parseInt(txtIdVehicles.getText()));
                p.setYear(Integer.parseInt(txtAnoVehicles.getText()));
                p.setColor(txtCorVehicles.getText());
                p.setType_fuel(txtCombusVehicles.getText());
                p.setKm_current(Double.parseDouble(txtKmVehicles.getText()));
                p.setModel(txtModeloVehicles.getText());
                p.setPlate(txtPlacaVehicles.getText());
                p.setClientId(Integer.parseInt(txtIdClienteVehicles.getText()));
                p.setBrand(txtMarcaVehicles.getText());
                p.setId((int) jTVehicles.getValueAt(jTVehicles.getSelectedRow(), 0));

                try {
                    dao.alter(p);
                } catch (SQLException ex) {
                    Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtIdVehicles.setText("");
                txtAnoVehicles.setText("");
                txtCorVehicles.setText("");
                txtKmVehicles.setText("");
                txtModeloVehicles.setText("");
                txtPlacaVehicles.setText("");
                txtCombusVehicles.setText("");
                txtMarcaVehicles.setText("");
                txtIdClienteVehicles.setText("");
                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscaVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaVehiclesActionPerformed
        jButton4.setEnabled(true);
    }//GEN-LAST:event_txtBuscaVehiclesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            readJTableForDesc(txtBuscaVehicles.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FVehicles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVehicles;
    private javax.swing.JTextField txtAnoVehicles;
    private javax.swing.JTextField txtBuscaVehicles;
    private javax.swing.JTextField txtCombusVehicles;
    private javax.swing.JTextField txtCorVehicles;
    private javax.swing.JTextField txtIdClienteVehicles;
    private javax.swing.JTextField txtIdVehicles;
    private javax.swing.JTextField txtKmVehicles;
    private javax.swing.JTextField txtMarcaVehicles;
    private javax.swing.JTextField txtModeloVehicles;
    private javax.swing.JTextField txtPlacaVehicles;
    // End of variables declaration//GEN-END:variables
}