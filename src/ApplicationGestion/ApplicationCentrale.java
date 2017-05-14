/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationGestion;

import network.NetworkBasicServer;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 *
 * @author Nicolas
 */
public class ApplicationCentrale extends javax.swing.JFrame {

    /**
     * Creates new form ApplicationCentrale
     */
    NetworkBasicServer commandeSer;

    public ApplicationCentrale(int type) {
        switch(type)
        {
            case 1:
                commandeSer = new NetworkBasicServer(4441, _messageEntrantCB);
                break;
            case 2:
                commandeSer = new NetworkBasicServer(5555, _messageEntrantCB);
                break;
            case 3:
                commandeSer = new NetworkBasicServer(6666, _messageEntrantCB);
                break;
        }
        initComponents();
        _commandeCoursCB.removeAllItems();//temporaire
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _messageEntrantCB = new javax.swing.JCheckBox();
        _lireButton = new javax.swing.JButton();
        _commandeCoursLabel = new javax.swing.JLabel();
        _commandeCoursCB = new javax.swing.JComboBox<>();
        _imageLabel = new javax.swing.JLabel();
        _detailCommandeLabel = new javax.swing.JLabel();
        _detailScrollPane = new javax.swing.JScrollPane();
        _detailTable = new javax.swing.JTable();
        _verificationDispoB = new javax.swing.JButton();
        _disponibleRB = new javax.swing.JRadioButton();
        _nonDispoRB = new javax.swing.JRadioButton();
        _envoyerReponseB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _messageEntrantCB.setText("Message Entrant");
        _messageEntrantCB.setActionCommand("MessageEntrant");

        _lireButton.setText("Lire");
        _lireButton.setToolTipText("");
        _lireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _lireButtonActionPerformed(evt);
            }
        });

        _commandeCoursLabel.setText("Commande en cours :");
        _commandeCoursLabel.setToolTipText("");

        _commandeCoursCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        _imageLabel.setText("Image");
        _imageLabel.setToolTipText("");

        _detailCommandeLabel.setText("Détail de la commande :");

        _detailTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Caractéristique", "Valeur"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _detailScrollPane.setViewportView(_detailTable);
        _detailTable.getAccessibleContext().setAccessibleName("detailTable");

        _verificationDispoB.setText("Vérification disponibilité");
        _verificationDispoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _verificationDispoBActionPerformed(evt);
            }
        });

        _disponibleRB.setText("Disponible");
        _disponibleRB.setToolTipText("");
        _disponibleRB.setActionCommand("DisponibleRadioB");

        _nonDispoRB.setText("Non disponible");
        _nonDispoRB.setActionCommand("NonDisponibleRadioB");

        _envoyerReponseB.setText("Envoyer réponse");
        _envoyerReponseB.setActionCommand("EnvoiReponseButton");
        _envoyerReponseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _envoyerReponseBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(_verificationDispoB)
                                                .addGap(85, 85, 85)
                                                .addComponent(_disponibleRB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(_nonDispoRB)
                                                .addGap(67, 67, 67))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(_detailCommandeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                .addComponent(_detailScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(_messageEntrantCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(_lireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(95, 95, 95)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(_commandeCoursLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(_commandeCoursCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(_imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(_envoyerReponseB)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(_messageEntrantCB)
                                                        .addComponent(_commandeCoursLabel))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(_lireButton)
                                                        .addComponent(_commandeCoursCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(_imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(_detailCommandeLabel)
                                        .addComponent(_detailScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(_verificationDispoB)
                                        .addComponent(_disponibleRB)
                                        .addComponent(_nonDispoRB))
                                .addGap(52, 52, 52)
                                .addComponent(_envoyerReponseB)
                                .addGap(23, 23, 23))
        );

        _commandeCoursLabel.getAccessibleContext().setAccessibleName("CommandeLabel");
        _imageLabel.getAccessibleContext().setAccessibleName("ImageLabel");
        _detailCommandeLabel.getAccessibleContext().setAccessibleName("DétailLabel");
        _verificationDispoB.getAccessibleContext().setAccessibleName("VerifButton");
        _disponibleRB.getAccessibleContext().setAccessibleName("DisponibleRadioB");
        _nonDispoRB.getAccessibleContext().setAccessibleName("NonDisponibleRadioB");
        _envoyerReponseB.getAccessibleContext().setAccessibleName("EnvoiReponseButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _verificationDispoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__verificationDispoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__verificationDispoBActionPerformed

    private void _lireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__lireButtonActionPerformed
        String libelle, type, quantite;
        String message = commandeSer.getMessage();

        //Ajout à la comboBox
        _commandeCoursCB.addItem(message);
        String[] parts = message.split(";");
        libelle = parts[0];
        type = parts[1];
        quantite = parts[2];

        DefaultTableModel dtm = new DefaultTableModel(){ @Override public boolean isCellEditable(int row, int column){return false;}};
        dtm.setColumnIdentifiers(new String[]{"Caractéristique","Valeur"});
        Object[] array = new Object[2];
        array[0] = ("libelle :");
        array[1]= (libelle);
        dtm.addRow(array);
        array[0] = ("Type :");
        array[1] = (type);
        dtm.addRow(array);
        array[0] = ("Quantite");
        array[1] = (quantite);
        dtm.addRow(array);
        _detailTable.setModel(dtm);
    }//GEN-LAST:event__lireButtonActionPerformed

    private void _envoyerReponseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__envoyerReponseBActionPerformed
        /*
        *Envoi de la réponse au client
         */
        String reponse;
        if(_disponibleRB.isSelected())
        {
            reponse = "disponible";
        }
        else
        {
            if (_nonDispoRB.isSelected()) {
                reponse = "nonDispo";
            }
        }
        commandeSer.sendMessage("coucou");
    }//GEN-LAST:event__envoyerReponseBActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicationCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationCentrale(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> _commandeCoursCB;
    private javax.swing.JLabel _commandeCoursLabel;
    private javax.swing.JLabel _detailCommandeLabel;
    private javax.swing.JScrollPane _detailScrollPane;
    private javax.swing.JTable _detailTable;
    private javax.swing.JRadioButton _disponibleRB;
    private javax.swing.JButton _envoyerReponseB;
    private javax.swing.JLabel _imageLabel;
    private javax.swing.JButton _lireButton;
    private javax.swing.JCheckBox _messageEntrantCB;
    private javax.swing.JRadioButton _nonDispoRB;
    private javax.swing.JButton _verificationDispoB;
    // End of variables declaration//GEN-END:variables
}
