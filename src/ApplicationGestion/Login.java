/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationGestion;

import Authenticate.Identifiable;
import People.Client;
import People.TechnicienExterieur;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author floryan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private LinkedList<Identifiable> _tableid;
    private Hashtable<String,String> _table;
    /**
     *
     * @param ptableid
     * @param ptable
     */
    public Login(LinkedList<Identifiable> ptableid, Hashtable<String, String> ptable) {
        initComponents();
        _table = ptable;
        _tableid = ptableid;

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utilisateurLabel = new javax.swing.JLabel();
        utilisateurTextField = new javax.swing.JTextField();
        mdpLabel = new javax.swing.JLabel();
        mdpTextField = new javax.swing.JPasswordField();
        mdpRadioButton = new javax.swing.JRadioButton();
        ehRadioButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        utilisateurLabel.setText("Utilisateur: ");

        utilisateurTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        mdpLabel.setText("Mot de passe:");

        mdpRadioButton.setSelected(true);
        mdpRadioButton.setText("Membre du personnel");
        mdpRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mdpRadioButtonMouseClicked(evt);
            }
        });

        ehRadioButton.setText("Extérieur habilité");
        ehRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ehRadioButtonMouseClicked(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        cancelButton.setText("Annuler");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton))
                    .addComponent(mdpRadioButton)
                    .addComponent(ehRadioButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(utilisateurLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mdpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mdpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(utilisateurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utilisateurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(utilisateurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mdpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdpTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mdpRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ehRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        for(Map.Entry<String,String> entry : _table.entrySet()) {
            if(entry.getKey().equals(utilisateurTextField.getText()))
                if(entry.getValue().equals(String.valueOf(mdpTextField.getPassword()))){
                Identifiable temp = null;
                Iterator<Identifiable> it = _tableid.iterator();
                while (it.hasNext())
                {
                    temp = it.next();
                    if (temp.getId().equals(utilisateurTextField.getText()))
                    {
                        if (temp instanceof Client) {
                            JOptionPane.showMessageDialog(this,"Vous n'êtes pas habilité à rentrer dans cette application.","Erreur",JOptionPane.ERROR_MESSAGE);
                            return;
                        } else if (temp instanceof TechnicienExterieur && !ehRadioButton.isSelected())
                            JOptionPane.showMessageDialog(this, "Vous n'êtes pas un Membre du personnel,\nmais un extérieur habilité.", "Information", JOptionPane.INFORMATION_MESSAGE);
                        else if (!(temp instanceof TechnicienExterieur) && ehRadioButton.isSelected())
                            JOptionPane.showMessageDialog(this, "Vous n'êtes pas un extréieur habilité,\nmais un membre du personnel", "Information", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                new Panel(_tableid, temp).setVisible(true);
                setVisible(false);
                return;
                } else {
                    JOptionPane.showMessageDialog(this,"La combinaison utilisateur|mot de passe est incorrecte","Information",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
        }
        JOptionPane.showMessageDialog(this,"Utilisateur inexistant, fin de l'application","Erreur",JOptionPane.ERROR_MESSAGE);
        dispose();
    }//GEN-LAST:event_okButtonMouseClicked

    private void mdpRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdpRadioButtonMouseClicked
        if (ehRadioButton.isSelected()) {
            mdpRadioButton.setSelected(true);
            ehRadioButton.setSelected(false);
        }
    }//GEN-LAST:event_mdpRadioButtonMouseClicked

    private void ehRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ehRadioButtonMouseClicked
        if (mdpRadioButton.isSelected()) {
            mdpRadioButton.setSelected(false);
            ehRadioButton.setSelected(true);
        }
    }//GEN-LAST:event_ehRadioButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton ehRadioButton;
    private javax.swing.JLabel mdpLabel;
    private javax.swing.JRadioButton mdpRadioButton;
    private javax.swing.JPasswordField mdpTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel utilisateurLabel;
    private javax.swing.JTextField utilisateurTextField;
    // End of variables declaration//GEN-END:variables
}
