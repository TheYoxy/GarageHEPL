/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationGestion;

import javax.swing.*;

/**
 *
 * @author flory
 */
public class AboutBox extends javax.swing.JDialog {

  /**
   * Creates new form AboutBox
   */
  public AboutBox(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    Application = new javax.swing.JLabel();
    Réalisée = new javax.swing.JLabel();
    JaimeRadio = new javax.swing.JRadioButton();
    BofRadio = new javax.swing.JRadioButton();
    JeDetesteRadio = new javax.swing.JRadioButton();
    OkButton = new javax.swing.JButton();

    setTitle("A propos ...");
    setResizable(false);
    setSize(new java.awt.Dimension(470, 220));

    Application.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    Application.setText("Application \"GarageHEPL\"");

    Réalisée.setText("Réalisée par Bonemme Nicolas et Simar Floryan 2225");

    JaimeRadio.setSelected(true);
    JaimeRadio.setText("J'aime");
    JaimeRadio.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        JaimeRadioMouseClicked(evt);
      }
    });

    BofRadio.setText("Bof");
    BofRadio.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        BofRadioMouseClicked(evt);
      }
    });

    JeDetesteRadio.setText("Je déteste");
    JeDetesteRadio.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        JeDetesteRadioMouseClicked(evt);
      }
    });

    OkButton.setText("Ok");
    OkButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        OkButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(JaimeRadio)
                                            .addGap(18, 18, 18)
                                            .addComponent(BofRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JeDetesteRadio))
                                    .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Application)
                                    .addComponent(Réalisée))
                            .addContainerGap(54, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(Application)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Réalisée)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JaimeRadio)
                                    .addComponent(BofRadio)
                                    .addComponent(JeDetesteRadio))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(OkButton)
                            .addGap(50, 50, 50))
    );

    pack();
  }// </editor-fold>

  /**
   * @param evt
   */
  private void JaimeRadioMouseClicked(java.awt.event.MouseEvent evt) {
    JaimeRadio.setSelected(true);
    BofRadio.setSelected(false);
    JeDetesteRadio.setSelected(false);
  }

  /**
   * @param evt
   */
  private void BofRadioMouseClicked(java.awt.event.MouseEvent evt) {
    JaimeRadio.setSelected(false);
    BofRadio.setSelected(true);
    JeDetesteRadio.setSelected(false);
  }

  /**
   * @param evt
   */
  private void JeDetesteRadioMouseClicked(java.awt.event.MouseEvent evt) {

    JOptionPane.showMessageDialog(this,"Pour des raisons de sécurité,\nil n'est pas possible de sélectionner cette option","Information",JOptionPane.INFORMATION_MESSAGE);
    JaimeRadio.setSelected(true);
    BofRadio.setSelected(false);
    JeDetesteRadio.setSelected(false);
  }

  /**
   * @param evt
   */
  private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {
    dispose();
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
    } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(AboutBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

        /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        AboutBox dialog = new AboutBox(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify
  private javax.swing.JLabel Application;
  private javax.swing.JRadioButton BofRadio;
  private javax.swing.JRadioButton JaimeRadio;
  private javax.swing.JRadioButton JeDetesteRadio;
  private javax.swing.JButton OkButton;
  private javax.swing.JLabel Réalisée;
  // End of variables declaration
}
