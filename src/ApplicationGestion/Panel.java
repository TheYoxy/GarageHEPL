/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationGestion;

import Activites.Entretien;
import Activites.Reparation;
import Activites.Travail;
import Authenticate.Identifiable;
import People.*;
import Tools.FilesOperations;
import Vehicules.MissingTradeMarkException;
import Vehicules.Voiture;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

/**
 *
 * @author floryan
 */
public class Panel extends javax.swing.JFrame {

    /**
     * Constante pour la remise à 0 des emplacements de travail
     */
    private static final String PDEFAUT = "--LIBRE--";
    /**
     * Contante pour la remise à 0 de Divers
     */
    private static final String DDEFAUT = "RAS";
    /**
     * Constante qui retiens le nombre d'emplacements disponibles pour des travaux
     */
    private static final int NB_EMPLACEMENTS = 4;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem _aPrevoirMenuItem;
    private javax.swing.JLabel _atelierLabel;
    private javax.swing.JMenu _atelierMenu;
    private javax.swing.JLabel _bureauCliLabel;
    private javax.swing.JTextField _bureauCliTextField;
    private javax.swing.JLabel _bureauComLabelFixe;
    private javax.swing.JLabel _bureauComptaLabel;
    private javax.swing.JLabel _bureauLabel;
    private javax.swing.JRadioButton _certainAbsentsRadioButton;
    private javax.swing.JMenu _clientMenu;
    private javax.swing.JMenu _commandeItem;
    private javax.swing.JMenuItem _commandeLubrifiantItem;
    private javax.swing.JMenuItem _commandePiecesItem;
    private javax.swing.JMenuItem _commandePneusItem;
    private javax.swing.JLabel _dateHeureLabel;
    private javax.swing.JLabel _diversLabel;
    private javax.swing.JTextField _diversTextField;
    private javax.swing.JMenu _factureMenu;
    private javax.swing.JMenuItem _listeCommandesItem;
    private javax.swing.JMenuItem _listesMenuItem;
    private javax.swing.JMenu _materielMenu;
    private javax.swing.JMenuBar _menuBar;
    private javax.swing.JCheckBox _patronDispoCheckBox;
    private javax.swing.JCheckBox _pauseMidiCheckBox;
    private javax.swing.JLabel _pont1Label;
    private javax.swing.JTextField _pont1TextField;
    private javax.swing.JLabel _pont2Label;
    private javax.swing.JTextField _pont2TextField;
    private javax.swing.JLabel _pont3Label;
    private javax.swing.JTextField _pont3TextField;
    private javax.swing.JMenuItem _priseEnChargeMenuItem;
    private javax.swing.JMenuItem _receptionItem;
    private javax.swing.JLabel _solLabel;
    private javax.swing.JTextField _solTextField;
    private javax.swing.JMenuItem _terminerMenuItem;
    private javax.swing.JRadioButton _toutLeMondeRadioButton;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
    private JMenu Parametres;
    private JMenu Aide;
    private JMenuItem Info;
    private JMenuItem DateMenu;
    private JMenuItem PourDebute;
    private JMenuItem APropos;
    private AboutBox AboutBox;
    private CommandePieces comPieces;
    private int Date;
    private int Time;
    private Locale LocaleDateTime;
    /**
     * Liste chainée qui retiens toutes les personnes identifiables de l'application
     */
    private LinkedList<Personne> ListePersonnes;
    /**
     * Hashtable pour retenir si c'est un entretiens ou une réparation
     */
    private Hashtable<Vector<Object>,Boolean> ListeAttente;
    /**
     * Tableau de taille 4 qui contiens le travail qui se trouve sur le sol où sur un des ponts
     */
    private Travail[] ListeOccupe;
    /**
     * Liste qui contiens tout les travaux qui ont été effectués
     */
    private LinkedList<Travail> ListeFini;
    /**
     * Identifie la personne qui vient de se connecter à l'application
     */
    private Identifiable Logged;
    /**
     * Creates new form Panel
     */
    private Panel() {
        initComponents();
        Time = DateFormat.DEFAULT;
        Date = DateFormat.SHORT;
        LocaleDateTime = Locale.getDefault();
        setTime();
        CustomSetup();
    }
    /**
     * @param list Liste des personnes identifiables
     * @param log Utilisateur reconnu qui s'identifie pour l'application
     */
    public Panel(LinkedList<Personne> list, Identifiable log){
        this();
        //Charger les 3 fichiers de travaux
        //FilesOperations binfile = new FilesOperations();
        //binfile.loadFromBinaryFile("Endedworks");
        //binfile.loadFromBinaryFile("Waitingworks");
        //binfile.loadFromBinaryFile("works") ;
        ListePersonnes= list;
        Logged = log;
        if (Logged instanceof PersonnelGarage) {
            _clientMenu.setEnabled(true);
            _atelierMenu.setEnabled(true);
            _factureMenu.setEnabled(true);
            _materielMenu.setEnabled(true);
            if (Logged instanceof Employe) {
                _priseEnChargeMenuItem.setEnabled(false); //Un employé ne peut pas prendre un travail à charge
            }
        }
        /*Lecture des fichiers*/
        loadAttente();
        loadOccupe();
        loadFini();
    }

    private void CustomSetup(){
        AboutBox = new AboutBox(this,true);
        _menuBar.add(Box.createHorizontalGlue());
        _menuBar.add(Parametres = new JMenu("Paramètres"));
        Parametres.add(Info = new JMenuItem("Infos système"));
        Parametres.add(DateMenu = new JMenuItem("Format de la date"));
        DateMenu.addActionListener(e -> {
            new Date(this,true).setVisible(true);
        });
        _menuBar.add(Aide = new JMenu("Aide"));
        Aide.add(PourDebute = new JMenuItem("Pour débuter"));
        Aide.add(new JSeparator());
        Aide.add(APropos = new JMenuItem("A propos de ..."));
        APropos.addActionListener(evt -> AProposMouseClicked());
        ListeAttente = new Hashtable<>();
        ListeOccupe = new Travail[NB_EMPLACEMENTS];
        ListeFini = new LinkedList<>();
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTime();
            }
        }).start();
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
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    private void AProposMouseClicked()
    {
        AboutBox.setVisible(true);
    }

    /**
     * @param loc
     * @param date
     * @param time
     */
    public void setDate(Locale loc, int date, int time)
    {
        LocaleDateTime = loc;
        Date = date;
        Time = time;
    }

    private void setTime() {
        _dateHeureLabel.setText(DateFormat.getDateTimeInstance(Date,Time).format(Calendar.getInstance(LocaleDateTime).getTime()));
    }

    /**
     * @param vector
     * @param entretien
     */
    public void ajout(Vector <Object> vector,boolean entretien)
    {
        ListeAttente.put(vector,entretien);
        saveAttente();
    }

    /**
     * @param place Correspond à la place dans le garage
     * @param vector Travail sélectioné
     */
    public void miseEnPlace(int place,Vector<Object> vector) throws PlaceUtilisee {
        try{
            if (ListeOccupe[place - 1] == null)
                ListeOccupe[place - 1] = ListeAttente.get(vector)
                        ? new Entretien (new Voiture((String)vector.get(1),4,2,(String)vector.get(0),(Client)vector.get(2)),(Mecanicien) Logged, (String) vector.get(3),(String) vector.get(4))
                        : new Reparation(new Voiture((String)vector.get(1),4,2,(String)vector.get(0),(Client)vector.get(2)),(Mecanicien) Logged, (String) vector.get(3),(String) vector.get(4)); // Si la clef = true -> Entretien
            else
            {
                String[] pos = new String[]{"pont n°1","pont n°2","pont n°3","sol"};
                throw new PlaceUtilisee("Le " + pos[place - 1] + " est déjà occupé.");
            }
            switch (place)
            {
                case 1:
                    _pont1TextField.setText(ListeOccupe[place - 1].getCar().toString() + ". " + ListeOccupe[place-1].getTravailleur() + " fait " + ListeOccupe[place-1].getLibelle());
                    break;
                case 2:
                    _pont2TextField.setText(ListeOccupe[place - 1].getCar().toString() + ". " + ListeOccupe[place-1].getTravailleur() + " fait " + ListeOccupe[place-1].getLibelle());
                    break;
                case 3:
                    _pont3TextField.setText(ListeOccupe[place - 1].getCar().toString() + ". " + ListeOccupe[place-1].getTravailleur() + " fait " + ListeOccupe[place-1].getLibelle());
                    break;
                case 4:
                    _solTextField.setText(ListeOccupe[place - 1].getCar().toString() + ". " + ListeOccupe[place-1].getTravailleur() + " fait " + ListeOccupe[place-1].getLibelle());
                    break;
                default:
                    //Ne peut pas arriver dans ce cas-ci, mais il peut apparaitre si qqn d'autre utilise le code
                    throw new PlaceUtilisee("Il n'y a pas de pont correspondant");
            }
        }
        catch (MissingTradeMarkException e) // Cette exception ne peut arriver
        {
            JOptionPane.showMessageDialog(this,e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
        ListeAttente.remove(vector);

        saveOccupe();
        saveAttente();
    }

    /**
     * Fonction qui charge les travaux en attente
     */
    private void loadAttente()
    {
        try {
            ListeAttente = FilesOperations.loadAttente();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui charge les travaux en cours
     */
    private void loadOccupe()
    {
        try{
            Hashtable<Travail,Integer> tempList;
            tempList = FilesOperations.loadOccupe();
            for (Map.Entry<Travail,Integer> entry : tempList.entrySet())
            {
                ListeOccupe[entry.getValue()] = entry.getKey();
                switch (entry.getValue())
                {
                    case 0:
                        _pont1TextField.setText(ListeOccupe[entry.getValue()].getCar().toString() + ". " + ListeOccupe[entry.getValue()].getTravailleur() + " fait " + ListeOccupe[entry.getValue()].getLibelle());
                        break;
                    case 1:
                        _pont2TextField.setText(ListeOccupe[entry.getValue()].getCar().toString() + ". " + ListeOccupe[entry.getValue()].getTravailleur() + " fait " + ListeOccupe[entry.getValue()].getLibelle());
                        break;
                    case 2:
                        _pont3TextField.setText(ListeOccupe[entry.getValue()].getCar().toString() + ". " + ListeOccupe[entry.getValue()].getTravailleur() + " fait " + ListeOccupe[entry.getValue()].getLibelle());
                        break;
                    case 3:
                        _solTextField.setText(ListeOccupe[entry.getValue()].getCar().toString() + ". " + ListeOccupe[entry.getValue()].getTravailleur() + " fait " + ListeOccupe[entry.getValue()].getLibelle());
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui charge les travaux fini
     */
    private void loadFini()
    {
        try {
            ListeFini = FilesOperations.loadFini();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Fonction qui enregistre les travaux en attente
     */
    private void saveAttente()
    {
        try {
            FilesOperations.saveAttente(ListeAttente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Fonction qui enregistre les travaux en cours
     */
    private void saveOccupe()
    {
        /*Ajout de la liste des travaux occupés au fichier*/
        Hashtable<Travail,Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < 4; i++)
        {
            if (ListeOccupe[i] != null)
                hashtable.put(ListeOccupe[i],i);
        }
        try {
            FilesOperations.saveOccupe(hashtable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui enregistre les travaux finis
     */
    private void saveFini()
    {
        try {
            FilesOperations.saveFini(ListeFini);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param n Endroit où le travail est fini
     * @throws IndexOutOfBoundsException
     */
    public void finTravail(int n) throws IndexOutOfBoundsException {
        JTextField[] temp = new JTextField[] {_pont1TextField,_pont2TextField,_pont3TextField,_solTextField};
        if (n < 0 || n > 3) throw new IndexOutOfBoundsException("Le paramètre n doit être compris entre 0 & 3 compris");
        temp[n].setText(PDEFAUT);
        ListeFini.add(ListeOccupe[n]);
        ListeOccupe[n] = null;
        saveOccupe();
        saveFini();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _diversTextField = new javax.swing.JTextField();
        _patronDispoCheckBox = new javax.swing.JCheckBox();
        _diversLabel = new javax.swing.JLabel();
        _pauseMidiCheckBox = new javax.swing.JCheckBox();
        _bureauLabel = new javax.swing.JLabel();
        _bureauCliLabel = new javax.swing.JLabel();
        _bureauComLabelFixe = new javax.swing.JLabel();
        _toutLeMondeRadioButton = new javax.swing.JRadioButton();
        _certainAbsentsRadioButton = new javax.swing.JRadioButton();
        _bureauCliTextField = new javax.swing.JTextField();
        _bureauComptaLabel = new javax.swing.JLabel();
        _atelierLabel = new javax.swing.JLabel();
        _pont1Label = new javax.swing.JLabel();
        _pont1TextField = new javax.swing.JTextField();
        _pont2Label = new javax.swing.JLabel();
        _pont2TextField = new javax.swing.JTextField();
        _pont3TextField = new javax.swing.JTextField();
        _pont3Label = new javax.swing.JLabel();
        _solLabel = new javax.swing.JLabel();
        _dateHeureLabel = new javax.swing.JLabel();
        _solTextField = new javax.swing.JTextField();
        _menuBar = new javax.swing.JMenuBar();
        _atelierMenu = new javax.swing.JMenu();
        _aPrevoirMenuItem = new javax.swing.JMenuItem();
        _priseEnChargeMenuItem = new javax.swing.JMenuItem();
        _terminerMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        _listesMenuItem = new javax.swing.JMenuItem();
        _materielMenu = new javax.swing.JMenu();
        _commandeItem = new javax.swing.JMenu();
        _commandePneusItem = new javax.swing.JMenuItem();
        _commandePiecesItem = new javax.swing.JMenuItem();
        _commandeLubrifiantItem = new javax.swing.JMenuItem();
        _receptionItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        _listeCommandesItem = new javax.swing.JMenuItem();
        _clientMenu = new javax.swing.JMenu();
        _factureMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Garage HEPL");
        setResizable(false);

        _diversTextField.setEditable(false);
        _diversTextField.setBackground(new java.awt.Color(255, 0, 0));
        _diversTextField.setText(DDEFAUT);

        _patronDispoCheckBox.setText("Patron Disponible");

        _diversLabel.setText("Divers :");

        _pauseMidiCheckBox.setText("Pause-Midi");

        _bureauLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        _bureauLabel.setText("Bureau");

        _bureauCliLabel.setText("Bureau Client:");

        _bureauComLabelFixe.setText("Bureau Comptabilité: ");

        _toutLeMondeRadioButton.setText("Tout le monde est présent");

        _certainAbsentsRadioButton.setText("Certains Absents");

        _bureauCliTextField.setEditable(false);
        _bureauCliTextField.setBackground(new java.awt.Color(255, 0, 0));
        _bureauCliTextField.setText("--Libre--");

        _bureauComptaLabel.setText("jLabel10");

        _atelierLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        _atelierLabel.setText("Atelier");

        _pont1Label.setText("Pont N°1:");

        _pont1TextField.setEditable(false);
        _pont1TextField.setBackground(new java.awt.Color(0, 0, 0));
        _pont1TextField.setForeground(new java.awt.Color(255, 255, 255));
        _pont1TextField.setText(PDEFAUT);

        _pont2Label.setText("Pont N°2:");

        _pont2TextField.setEditable(false);
        _pont2TextField.setBackground(new java.awt.Color(0, 0, 0));
        _pont2TextField.setForeground(new java.awt.Color(255, 255, 255));
        _pont2TextField.setText(PDEFAUT);

        _pont3TextField.setEditable(false);
        _pont3TextField.setBackground(new java.awt.Color(255, 255, 0));
        _pont3TextField.setText(PDEFAUT);

        _pont3Label.setText("Pont N°3:");

        _solLabel.setText("Sol :");

        _dateHeureLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        _dateHeureLabel.setText("Date Heure");

        _solTextField.setEditable(false);
        _solTextField.setBackground(new java.awt.Color(255, 255, 0));
        _solTextField.setText(PDEFAUT);

        _atelierMenu.setText("Atelier");
        _atelierMenu.setEnabled(false);

        _aPrevoirMenuItem.setText("A prévoir ");
        _aPrevoirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _aPrevoirMenuItemActionPerformed(evt);
            }
        });
        _atelierMenu.add(_aPrevoirMenuItem);

        _priseEnChargeMenuItem.setText("Prise en charge");
        _priseEnChargeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _priseEnChargeMenuItemActionPerformed(evt);
            }
        });
        _atelierMenu.add(_priseEnChargeMenuItem);

        _terminerMenuItem.setText("Terminer");
        _terminerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _terminerMenuItemActionPerformed(evt);
            }
        });
        _atelierMenu.add(_terminerMenuItem);
        _atelierMenu.add(jSeparator1);

        _listesMenuItem.setText("Listes");
        _listesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _listesMenuItemActionPerformed(evt);
            }
        });
        _atelierMenu.add(_listesMenuItem);

        _menuBar.add(_atelierMenu);

        _materielMenu.setText("Matériel");
        _materielMenu.setEnabled(false);

        _commandeItem.setText("Commande");

        _commandePneusItem.setText("Commande Pneus");
        _commandePneusItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _commandePneusItemActionPerformed(evt);
            }
        });
        _commandeItem.add(_commandePneusItem);

        _commandePiecesItem.setText("Commande Pièces");
        _commandePiecesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _commandePiecesItemActionPerformed(evt);
            }
        });
        _commandeItem.add(_commandePiecesItem);

        _commandeLubrifiantItem.setText("Commande Lubrifiant");
        _commandeLubrifiantItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _commandeLubrifiantItemActionPerformed(evt);
            }
        });
        _commandeItem.add(_commandeLubrifiantItem);

        _materielMenu.add(_commandeItem);

        _receptionItem.setText("Réception");
        _materielMenu.add(_receptionItem);
        _materielMenu.add(jSeparator2);

        _listeCommandesItem.setText("Liste commandes");
        _materielMenu.add(_listeCommandesItem);

        _menuBar.add(_materielMenu);

        _clientMenu.setText("Clients");
        _clientMenu.setEnabled(false);
        _menuBar.add(_clientMenu);

        _factureMenu.setText("Factures");
        _factureMenu.setEnabled(false);
        _menuBar.add(_factureMenu);

        setJMenuBar(_menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_atelierLabel)
                    .addComponent(_bureauLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_bureauComLabelFixe)
                        .addGap(18, 18, 18)
                        .addComponent(_bureauComptaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_pont1Label)
                            .addComponent(_pont2Label)
                            .addComponent(_pont3Label)
                            .addComponent(_solLabel)
                            .addComponent(_diversLabel)
                            .addComponent(_bureauCliLabel))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_diversTextField)
                            .addComponent(_solTextField)
                            .addComponent(_bureauCliTextField)
                            .addComponent(_pont1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_pont2TextField)
                            .addComponent(_pont3TextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_patronDispoCheckBox)
                            .addComponent(_pauseMidiCheckBox))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_certainAbsentsRadioButton)
                            .addComponent(_toutLeMondeRadioButton))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(_dateHeureLabel)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_dateHeureLabel)
                    .addComponent(_atelierLabel))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_pont1Label)
                    .addComponent(_pont1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_pont2Label)
                    .addComponent(_pont2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(_pont3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_pont3Label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_solLabel)
                    .addComponent(_solTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_diversTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_diversLabel))
                .addGap(80, 80, 80)
                .addComponent(_bureauLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_bureauCliLabel)
                    .addComponent(_toutLeMondeRadioButton)
                    .addComponent(_bureauCliTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_patronDispoCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_bureauComLabelFixe)
                    .addComponent(_certainAbsentsRadioButton)
                    .addComponent(_bureauComptaLabel)
                    .addComponent(_pauseMidiCheckBox))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void _aPrevoirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__aPrevoirMenuItemActionPerformed
        LinkedList<Client> templist = new LinkedList<>();
        for (Personne temp : ListePersonnes)
            if (temp instanceof Client)
                templist.add((Client) temp);
        new NewWork(this,true,templist).setVisible(true);
    }//GEN-LAST:event__aPrevoirMenuItemActionPerformed

    /**
     * @param evt
     */
    private void _priseEnChargeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__priseEnChargeMenuItemActionPerformed
        new PriseCharge(this,true, ListeAttente, ListeOccupe).setVisible(true);
    }//GEN-LAST:event__priseEnChargeMenuItemActionPerformed

    /**
     * @param evt
     */
    private void _terminerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__terminerMenuItemActionPerformed
        new Valider(this,true, ListeOccupe).setVisible(true);
    }//GEN-LAST:event__terminerMenuItemActionPerformed

    /**
     * @param evt
     */
    private void _listesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__listesMenuItemActionPerformed
        new TravauxFini(this,true, ListeFini).setVisible(true);
    }//GEN-LAST:event__listesMenuItemActionPerformed

    /**
     * @param evt
     */
    private void _commandePiecesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__commandePiecesItemActionPerformed
        if(comPieces == null) {
            comPieces = new CommandePieces(this, true, 2);
            comPieces.setVisible(true);
        }
        else
            comPieces.setVisible(true);
    }//GEN-LAST:event__commandePiecesItemActionPerformed

    /**
     ** @param evt
     */
    private void _commandePneusItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__commandePneusItemActionPerformed
        if(comPieces == null) {
            comPieces = new CommandePieces(this, true, 1);
            comPieces.setVisible(true);
        }
        else
            comPieces.setVisible(true);
    }//GEN-LAST:event__commandePneusItemActionPerformed

    /**
     * @param evt
     */
    private void _commandeLubrifiantItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__commandeLubrifiantItemActionPerformed
        if(comPieces == null) {
            comPieces = new CommandePieces(this, true, 3);
            comPieces.setVisible(true);
        }
        else
            comPieces.setVisible(true);
    }//GEN-LAST:event__commandeLubrifiantItemActionPerformed
}
