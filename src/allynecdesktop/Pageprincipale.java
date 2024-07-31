package allynecdesktop;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class Pageprincipale extends javax.swing.JFrame {

 
    public Pageprincipale() throws SQLException {
       
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//taille du JFrame
        setLocationRelativeTo(null);
        setResizable(true);
        this.setLayout(new BorderLayout());
     
        //taille des  gros panel
        jPanelMenu.setSize(largeurEcran, jPanelMenu.getHeight());
        jPanelLogin.setSize(largeurEcran, hauteurEcran -95);
        jPanelPrincipale.setSize(largeurEcran,hauteurEcran);
        jPanelEnreg.setSize(largeurEcran, hauteurEcran -  jPanelMenu.getHeight());
        jPanelPresence.setSize(largeurEcran, hauteurEcran - 100);
        jPanelAuto.setSize(largeurEcran, hauteurEcran - 100);
        jPanelValidation.setSize(largeurEcran, hauteurEcran);
        jPanelAdmin.setSize(largeurEcran, hauteurEcran);
        //ajout des gros panel dans le JFrame
        this.add(jPanelMenu,BorderLayout.NORTH);
        this.add(jPanelPrincipale,BorderLayout.CENTER);
        this.add(jPanelEnreg,BorderLayout.CENTER);
        this.add(jPanelLogin,BorderLayout.CENTER);
        this.add(jPanelPresence, BorderLayout.CENTER);
        this.add(jPanelAuto,BorderLayout.CENTER);
        this.add(jPanelValidation,BorderLayout.CENTER);
        this.add(jPanelAdmin,BorderLayout.CENTER);
        jPanelMenu.add(jLabelTitre,BorderLayout.CENTER);
        
        
        //JPanel Enregistrement
        jTableEnreg.setSize(largeurEcran, jPanelEnreg.getHeight()- jPanelTitlesEnreg.getHeight());
        jPanelEnreg.revalidate();
        jPanelEnreg.repaint();
        //JPanel présence
        //Jpanel Auto
        jPanelBarreTitresAuto.setSize(jPanelAuto.getWidth() + 200,100);
        jTableAuto.setSize(largeurEcran, jPanelAuto.getHeight() - 20);
        //Jpanel enregistrement
        //jPanelTitlesEnreg.add(jPanel3,BorderLayout.WEST);
        
        //-----------Affichage des JTables
        afficherEmployerInJtable();
        
        

        
 
        ImageDesIcon();
        barreDeTitre();
       
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/LogoVerte.jpg")));
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }   
    }
    
       //recuperer la taille de l'ecran
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public int largeurEcran = screenSize.width ;
        public int hauteurEcran = screenSize.height ;

     private   void ImageDesIcon()
    {
        //definition de background bar
        //couleur verte
        int red = Integer.parseInt("1a",16);
        int green = Integer.parseInt("37",16);
        int blue = Integer.parseInt("25",16);
        Color color = new Color(red,green,blue);
        //couleur bleu foncée
        int red2 = Integer.parseInt("00",16);
        int green2 = Integer.parseInt("02",16);
        int blue2 = Integer.parseInt("0e",16);
        Color bleuDeNuit = new Color(red2,green2,blue2);
        
        this.setBackground(bleuDeNuit);//Jframe
        jPanelPrincipale.setBackground(bleuDeNuit);
        jPanelLogin.setBackground(bleuDeNuit);
        jPanelEnreg.setBackground(bleuDeNuit);
        jPanelCarre.setBackground(bleuDeNuit);
        jLabelTitre.setBackground(bleuDeNuit);
        jPanelMenu.setBackground(bleuDeNuit);
        jPanelPresence.setBackground(bleuDeNuit);
        //jPanelAuto.setBackground(bleuDeNuit);
        jPanelValidation.setBackground(bleuDeNuit);
        jPanelAdmin.setBackground(bleuDeNuit);
      



        //Jlabel et son image pour chaque page qui a besoin d'une image background 
        ImageIcon imageIcone = new ImageIcon(getClass().getResource("/images/icone_enreg.png"));
        Image img = imageIcone.getImage().getScaledInstance(jLabelEnreg.getWidth(), jLabelEnreg.getHeight(), Image.SCALE_SMOOTH);
        jLabelEnreg.setIcon(new ImageIcon(img));
        
        ImageIcon imageIcone30 = new ImageIcon(getClass().getResource("/images/arc1.png"));
        Image img30 = imageIcone30.getImage().getScaledInstance(jLabelArc1.getWidth(), jLabelArc1.getHeight(), Image.SCALE_SMOOTH);
        jLabelArc1.setIcon(new ImageIcon(img30));
        
        ImageIcon imageIcone31 = new ImageIcon(getClass().getResource("/images/icone_presence.png"));
        Image img31 = imageIcone31.getImage().getScaledInstance(jLabelPresence.getWidth(), jLabelPresence.getHeight(), Image.SCALE_SMOOTH);
        jLabelPresence.setIcon(new ImageIcon(img31));
        
        ImageIcon imageIcone32 = new ImageIcon(getClass().getResource("/images/icone_profilAdmin.png"));
        Image img32 = imageIcone32.getImage().getScaledInstance(jLabelAdmin.getWidth(), jLabelAdmin.getHeight(), Image.SCALE_SMOOTH);
        jLabelAdmin.setIcon(new ImageIcon(img32));
        
        ImageIcon imageIcone33 = new ImageIcon(getClass().getResource("/images/Arc2.png"));
        Image img33 = imageIcone33.getImage().getScaledInstance(jLabelArc2.getWidth(), jLabelArc2.getHeight(), Image.SCALE_SMOOTH);
        jLabelArc2.setIcon(new ImageIcon(img33));
        
        ImageIcon imageIcone34 = new ImageIcon(getClass().getResource("/images/icone_autori.png"));
        Image img34 = imageIcone34.getImage().getScaledInstance(jLabelAutori.getWidth(), jLabelAutori.getHeight(), Image.SCALE_SMOOTH);
        jLabelAutori.setIcon(new ImageIcon(img34));
        
        ImageIcon imageIcone35 = new ImageIcon(getClass().getResource("/images/arc3.png"));
        Image img35 = imageIcone35.getImage().getScaledInstance(jLabelArc3.getWidth(), jLabelArc3.getHeight(), Image.SCALE_SMOOTH);
        jLabelArc3.setIcon(new ImageIcon(img35));
        
        ImageIcon imageIcone36 = new ImageIcon(getClass().getResource("/images/icone_valide.png"));
        Image img36 = imageIcone36.getImage().getScaledInstance(jLabelValide.getWidth(), jLabelValide.getHeight(), Image.SCALE_SMOOTH);
        jLabelValide.setIcon(new ImageIcon(img36));
        
        ImageIcon imageIcone37 = new ImageIcon(getClass().getResource("/images/arc4.png"));
        Image img37 = imageIcone37.getImage().getScaledInstance(jLabelArc4.getWidth(), jLabelArc4.getHeight(), Image.SCALE_SMOOTH);
        jLabelArc4.setIcon(new ImageIcon(img37));
        
        //panelMenu et ces objets
        ImageIcon imageIcone20 = new ImageIcon(getClass().getResource("/images/menu.png"));
        Image img20 = imageIcone20.getImage().getScaledInstance(jLabelMenu.getWidth(), jLabelMenu.getHeight(), Image.SCALE_SMOOTH);
        jLabelMenu.setIcon(new ImageIcon(img20));
        
        ImageIcon imageIcone21 = new ImageIcon(getClass().getResource("/images/retour.png"));
        Image img21 = imageIcone21.getImage().getScaledInstance(jLabelRetourMenu.getWidth(), jLabelRetourMenu.getHeight(), Image.SCALE_SMOOTH);
        jLabelRetourMenu.setIcon(new ImageIcon(img21));
        
        
        
        ImageIcon imageIcone22 = new ImageIcon(getClass().getResource("/images/icone_message.png"));
        Image img22 = imageIcone22.getImage().getScaledInstance(jLabelMessage.getWidth(),jLabelMessage.getHeight(), Image.SCALE_SMOOTH);
        jLabelMessage.setIcon(new ImageIcon(img22));
        
        ImageIcon imageIcone23 = new ImageIcon(getClass().getResource("/images/icone_web.png"));
        Image img23 = imageIcone23.getImage().getScaledInstance(jLabelWeb.getWidth(),jLabelWeb.getHeight(), Image.SCALE_SMOOTH);
        jLabelWeb.setIcon(new ImageIcon(img23));
     
       
    }
     //définition  des titres pour la barre des titres de chaque page
     public void barreDeTitre(){
         
         if(jPanelLogin.isVisible()){
             jLabelTitre.setText("");
         }else if(jPanelPrincipale.isVisible()){
             jLabelTitre.setText("");
         }else if(jPanelEnreg.isVisible()){
             jLabelTitre.setText("Enregistrement");
         }else if(jPanelPresence.isVisible()){
             jLabelTitre.setText("Présence");
         }else if(jPanelAuto.isVisible()){
             jLabelTitre.setText("Autorisation");
         }else if(jPanelValidation.isVisible()){
             jLabelTitre.setText("Validation");
         }else if(jPanelAdmin.isVisible()){
             jLabelTitre.setText("Administrateur");
         }else{
         }
     
     }
     
    
      
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jLabelMenu = new javax.swing.JLabel();
        jTextFieldMenu = new javax.swing.JTextField();
        jLabelRetourMenu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTitre = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        jPanelQuadrantLogin = new javax.swing.JPanel();
        jTextFieldIdLogin = new javax.swing.JTextField();
        jTextFieldPw = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelPrincipale = new javax.swing.JPanel();
        jLabelMessage = new javax.swing.JLabel();
        jLabelWeb = new javax.swing.JLabel();
        jPanelCarre = new javax.swing.JPanel();
        jLabelEnreg = new javax.swing.JLabel();
        jLabelArc1 = new javax.swing.JLabel();
        jLabelPresence = new javax.swing.JLabel();
        jLabelAdmin = new javax.swing.JLabel();
        jLabelArc2 = new javax.swing.JLabel();
        jLabelAutori = new javax.swing.JLabel();
        jLabelArc3 = new javax.swing.JLabel();
        jLabelValide = new javax.swing.JLabel();
        jLabelArc4 = new javax.swing.JLabel();
        jPanelEnreg = new javax.swing.JPanel();
        jPanelTitlesEnreg = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddUser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBoxTrie = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEnreg = new javax.swing.JTable();
        jPanelPresence = new javax.swing.JPanel();
        jPanelTitlesPresence = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelAuto = new javax.swing.JPanel();
        jPanelBarreTitresAuto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAuto = new javax.swing.JTable();
        jPanelValidation = new javax.swing.JPanel();
        jPanelAdmin = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Allynec");
        setBackground(new java.awt.Color(51, 0, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 0, 51));

        jLabelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextFieldMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMenuActionPerformed(evt);
            }
        });

        jLabelRetourMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRetourMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRetourMenuMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");

        jLabelTitre.setBackground(new java.awt.Color(0, 51, 255));
        jLabelTitre.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelTitre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitre.setOpaque(true);

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(779, Short.MAX_VALUE)
                .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRetourMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMenu)
                            .addComponent(jLabel1))
                        .addComponent(jLabelRetourMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1730, -1));

        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelQuadrantLogin.setOpaque(false);
        jPanelQuadrantLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdLogin.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldIdLogin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextFieldIdLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 204, 0)));
        jTextFieldIdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdLoginActionPerformed(evt);
            }
        });
        jPanelQuadrantLogin.add(jTextFieldIdLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 410, -1));

        jTextFieldPw.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldPw.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextFieldPw.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 0)));
        jPanelQuadrantLogin.add(jTextFieldPw, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 410, -1));

        jButtonLogin.setBackground(new java.awt.Color(204, 204, 204));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonLogin.setText("SIN IN");
        jButtonLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 0)));
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelQuadrantLogin.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 274, 410, 53));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");
        jLabel2.setOpaque(true);
        jPanelQuadrantLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 61, 50));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PW");
        jLabel3.setOpaque(true);
        jPanelQuadrantLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 50));

        jPanelLogin.add(jPanelQuadrantLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 490, 340));

        getContentPane().add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        jPanelPrincipale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMessageMouseClicked(evt);
            }
        });
        jPanelPrincipale.add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 660, 100, 100));

        jLabelWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelWebMouseClicked(evt);
            }
        });
        jPanelPrincipale.add(jLabelWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 100, 100));

        jLabelEnreg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEnreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEnregMouseClicked(evt);
            }
        });

        jLabelArc1.setText("jll");

        jLabelPresence.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPresence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPresenceMouseClicked(evt);
            }
        });

        jLabelAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdminMouseClicked(evt);
            }
        });

        jLabelArc2.setText("jLabel4");

        jLabelAutori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAutori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAutoriMouseClicked(evt);
            }
        });

        jLabelArc3.setText("jLabel4");

        jLabelValide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelValide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValideMouseClicked(evt);
            }
        });

        jLabelArc4.setText("jLabel4");

        javax.swing.GroupLayout jPanelCarreLayout = new javax.swing.GroupLayout(jPanelCarre);
        jPanelCarre.setLayout(jPanelCarreLayout);
        jPanelCarreLayout.setHorizontalGroup(
            jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarreLayout.createSequentialGroup()
                .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelValide, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanelCarreLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelArc4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArc3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarreLayout.createSequentialGroup()
                        .addComponent(jLabelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPresence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCarreLayout.createSequentialGroup()
                        .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCarreLayout.createSequentialGroup()
                                .addComponent(jLabelAutori, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelArc2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCarreLayout.createSequentialGroup()
                                .addComponent(jLabelEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelArc1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        jPanelCarreLayout.setVerticalGroup(
            jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarreLayout.createSequentialGroup()
                .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelCarreLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabelArc1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPresence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelCarreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelArc4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValide, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarreLayout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(jLabelAutori, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCarreLayout.createSequentialGroup()
                        .addGroup(jPanelCarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelArc3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArc2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelPrincipale.add(jPanelCarre, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 440, 420));

        getContentPane().add(jPanelPrincipale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        jPanelEnreg.setBackground(new java.awt.Color(102, 153, 0));
        jPanelEnreg.setPreferredSize(new java.awt.Dimension(1730, 830));
        jPanelEnreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitlesEnreg.setBackground(new java.awt.Color(204, 255, 204));
        jPanelTitlesEnreg.setOpaque(false);
        jPanelTitlesEnreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        btnAddUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddUser.setText("Add");
        btnAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUserMouseClicked(evt);
            }
        });
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Modify");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Desactivate");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Back");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAddUser)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanelTitlesEnreg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asc", "Desc" }));
        jPanelTitlesEnreg.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 20, -1, -1));

        jComboBoxTrie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxTrie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelTitlesEnreg.add(jComboBoxTrie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Trier");
        jPanelTitlesEnreg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 20, -1, -1));

        jPanelEnreg.add(jPanelTitlesEnreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 60));

        jPanel4.setOpaque(false);

        jTableEnreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nom", "PostNom", "Prenom", "Sexe", "Naissance", "Domicile", "Contact", "Email", "Titre", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableEnreg);
        if (jTableEnreg.getColumnModel().getColumnCount() > 0) {
            jTableEnreg.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableEnreg.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1895, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelEnreg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 56, 1910, 770));

        getContentPane().add(jPanelEnreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        jPanelTitlesPresence.setOpaque(false);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asc", "Desc" }));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom", "PostNom", "Prenom", "Titre" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trrier par:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelTitlesPresenceLayout = new javax.swing.GroupLayout(jPanelTitlesPresence);
        jPanelTitlesPresence.setLayout(jPanelTitlesPresenceLayout);
        jPanelTitlesPresenceLayout.setHorizontalGroup(
            jPanelTitlesPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitlesPresenceLayout.createSequentialGroup()
                .addGap(1051, 1051, 1051)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTitlesPresenceLayout.setVerticalGroup(
            jPanelTitlesPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelTitlesPresenceLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelTitlesPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTitlesPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nom", "PostNom", "Prenom", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelPresenceLayout = new javax.swing.GroupLayout(jPanelPresence);
        jPanelPresence.setLayout(jPanelPresenceLayout);
        jPanelPresenceLayout.setHorizontalGroup(
            jPanelPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1825, Short.MAX_VALUE)
            .addGroup(jPanelPresenceLayout.createSequentialGroup()
                .addComponent(jPanelTitlesPresence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPresenceLayout.setVerticalGroup(
            jPanelPresenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPresenceLayout.createSequentialGroup()
                .addComponent(jPanelTitlesPresence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelPresence, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        jPanelAuto.setBackground(new java.awt.Color(0, 204, 153));
        jPanelAuto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBarreTitresAuto.setBackground(new java.awt.Color(255, 51, 0));
        jPanelBarreTitresAuto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelAuto.add(jPanelBarreTitresAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1750, 80));

        jTableAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nom", "Prenom", "Telephone", "Autorisation1", "Autorisation2", "Autorisation3", "Autorisation4", "Autorisation5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAuto);

        jPanelAuto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1750, 680));

        getContentPane().add(jPanelAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 840));

        jPanelValidation.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanelValidationLayout = new javax.swing.GroupLayout(jPanelValidation);
        jPanelValidation.setLayout(jPanelValidationLayout);
        jPanelValidationLayout.setHorizontalGroup(
            jPanelValidationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1730, Short.MAX_VALUE)
        );
        jPanelValidationLayout.setVerticalGroup(
            jPanelValidationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1730, Short.MAX_VALUE)
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1730, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        //connexion à la base des données
            AllynecDB s = new AllynecDB();
            Connection con = s.getConnection();
            //verifie si ces infos sont contenues dans la BD
            PreparedStatement statement;
        try {
            statement = con.prepareStatement("SELECT COUNT(*) FROM admin WHERE login =? and passw=?");
            statement.setString(1,jTextFieldIdLogin.getText().toString());
            statement.setString(2,jTextFieldPw.getText().toString());
            ResultSet resultat = statement.executeQuery();

            if(resultat.next())
            {
              int compteur = resultat.getInt(1);
              if( compteur == 1)
              {
                statement.close();
                resultat.close();
                con.close();
                jPanelLogin.setVisible(false);
                jPanelPrincipale.setVisible(true);
                barreDeTitre();
                 
              }else{
                  JOptionPane.showMessageDialog(null, "Login ou Mot de Passe incorrect!");
              }
            }else{
                JOptionPane.showMessageDialog(null, "Une erreur s'est produite!");
            } 
        }catch (SQLException ex) {
            Logger.getLogger(Pageprincipale.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite!");
        }
            
              
//        if( jTextFieldIdLogin.getText().equals("a") && jTextFieldPw.getText().equals("b")){
//            jPanelLogin.setVisible(false);
//            jPanelPrincipale.setVisible(true);
//            barreDeTitre();
//        }else{
//            JOptionPane.showMessageDialog(null, "Mot de Passe incorrect!");
//        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jLabelRetourMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRetourMenuMouseClicked
        // retour/fermeture
        if(jPanelEnreg.isVisible()){
            jPanelEnreg.setVisible(false);
            jPanelPrincipale.setVisible(true);
        }else if(jPanelPresence.isVisible()){
            jPanelPresence.setVisible(false);
            jPanelPrincipale.setVisible(true);
        }else if(jPanelAuto.isVisible()){
            jPanelAuto.setVisible(false);
            jPanelPrincipale.setVisible(true);
        }else if(jPanelValidation.isVisible()){
            jPanelValidation.setVisible(false);
            jPanelPrincipale.setVisible(true);
        }else if(jPanelAdmin.isVisible()){
            jPanelAdmin.setVisible(false);
            jPanelPrincipale.setVisible(true);
        }else{
            System.exit(0);
        }
        barreDeTitre();
    }//GEN-LAST:event_jLabelRetourMenuMouseClicked

    private void jTextFieldIdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdLoginActionPerformed

    private void jLabelEnregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEnregMouseClicked
        // TODO add your handling code here:
        jPanelPrincipale.setVisible(false);
        jPanelEnreg.setVisible(true);
        barreDeTitre();
        
    }//GEN-LAST:event_jLabelEnregMouseClicked

    private void jLabelPresenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPresenceMouseClicked
        // TODO add your handling code here:
        jPanelPrincipale.setVisible(false);
        jPanelPresence.setVisible(true);
        barreDeTitre();
    }//GEN-LAST:event_jLabelPresenceMouseClicked

    private void jLabelAutoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAutoriMouseClicked
        // TODO add your handling code here:
        jPanelPrincipale.setVisible(false);
        jPanelAuto.setVisible(true);
        barreDeTitre();
    }//GEN-LAST:event_jLabelAutoriMouseClicked

    private void jLabelValideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValideMouseClicked
        // bouton
        jPanelPrincipale.setVisible(false);
        jPanelValidation.setVisible(true);
        barreDeTitre();
    }//GEN-LAST:event_jLabelValideMouseClicked

    private void jLabelAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdminMouseClicked
        // bouton admin
        jPanelPrincipale.setVisible(false);
        jPanelAdmin.setVisible(true);
        barreDeTitre();
    }//GEN-LAST:event_jLabelAdminMouseClicked

    private void jTextFieldMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMenuActionPerformed

    private void jLabelMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessageMouseClicked

    }//GEN-LAST:event_jLabelMessageMouseClicked
public void ouvrirLien(){
    
     jLabelWeb.addMouseListener(new MouseAdapter() {
            boolean isLinkClicked = false;
            @Override
            public void mouseClicked(MouseEvent e){
                if(! isLinkClicked){
                    isLinkClicked = true;
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }}
            }
});
}

public static boolean  isJFrameOpen(String title){
    for(Window window :Window.getWindows()){
        if(window instanceof JFrame){
            JFrame frame = (JFrame) window;
            if(frame.getTitle().equals(title) && frame.isVisible()){
                return true;
            }
        }
    }
    return false;
}
    
    private void jLabelWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelWebMouseClicked
                // ecouteur pour lr label WEB
         ouvrirLien();
       
    }//GEN-LAST:event_jLabelWebMouseClicked
public static boolean cle = false;
boolean pageOuverte = false;
    private void btnAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserMouseClicked
        // TODO add your handling code here:
        cle = false;
        if( pageOuverte == false){
            //page Add
        
            new AddUser().setVisible(true);
            pageOuverte = true;
       
        }
        else{
            new AddUser().setVisible(false);
            pageOuverte = false;
            
        }

        
    }//GEN-LAST:event_btnAddUserMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code herecle
        
        cle = true;
        new AddUser().setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddUserActionPerformed

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
            java.util.logging.Logger.getLogger(Pageprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pageprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pageprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pageprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pageprincipale().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pageprincipale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBoxTrie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAdmin;
    private javax.swing.JLabel jLabelArc1;
    private javax.swing.JLabel jLabelArc2;
    private javax.swing.JLabel jLabelArc3;
    private javax.swing.JLabel jLabelArc4;
    private javax.swing.JLabel jLabelAutori;
    private javax.swing.JLabel jLabelEnreg;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelPresence;
    private javax.swing.JLabel jLabelRetourMenu;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelValide;
    private javax.swing.JLabel jLabelWeb;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanelAdmin;
    public static javax.swing.JPanel jPanelAuto;
    public static javax.swing.JPanel jPanelBarreTitresAuto;
    private javax.swing.JPanel jPanelCarre;
    public javax.swing.JPanel jPanelEnreg;
    public javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelMenu;
    public javax.swing.JPanel jPanelPresence;
    public javax.swing.JPanel jPanelPrincipale;
    private javax.swing.JPanel jPanelQuadrantLogin;
    public javax.swing.JPanel jPanelTitlesEnreg;
    private javax.swing.JPanel jPanelTitlesPresence;
    public javax.swing.JPanel jPanelValidation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTableAuto;
    public javax.swing.JTable jTableEnreg;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldIdLogin;
    private javax.swing.JTextField jTextFieldMenu;
    private javax.swing.JTextField jTextFieldPw;
    // End of variables declaration//GEN-END:variables
    
    //------------------------------------page enrg-----------------------------------------------------------------------------
       /// importations des des employés de la BD vers le JFrame Enrg
    
    

//    //importation des  employés de la bd vers le Jtale
     public ArrayList<Class_Enrg> getEmployeList() throws SQLException
     {
         
          AllynecDB s = new AllynecDB();
          Connection con = s.getConnection();
         
         ArrayList<Class_Enrg> ListeEmploye = new ArrayList<Class_Enrg>();
         String query1 = "SELECT  nom,postnom,prenom,sexe,datenaissance,domicile,contact,email, titre ,dateAjout,iduser,situation,motif FROM users ";
         //String query2 = "SELECT  t1.IDproduit,t1.Categorie,t1.Forme,t1.Nom,t1.Format,t1.PrixUnitaire,t1.Quantite,t1.PrixTotal, t2.Firme  FROM produits t1 INNER JOIN fabriquants t2 ON t1.IDfirme = t2.IDfirme group by  ";
         //String query;
         
         
         
         Statement st;
         ResultSet rs;
         
         try {
              st = con.createStatement();
              rs = st.executeQuery(query1);
              Class_Enrg listeEnrg ;
              int j = 1;
              while(rs.next())
              {
                   
                  listeEnrg = new Class_Enrg(j,rs.getString("nom"),rs.getString("postnom"),rs.getString("prenom"),rs.getString("sexe"),rs.getDate("datenaissance"),rs.getString("domicile"),rs.getString("contact"),rs.getString("email"),rs.getString("titre"),rs.getDate("dateAjout"),rs.getInt("iduser"),rs.getString("situation"),rs.getString("motif"));
                  ListeEmploye.add(listeEnrg);
                  j++;
              }
              st.close();
              rs.close();
             con.close();
         } catch (Exception ex) {
             Logger.getLogger(Class_Enrg.class.getName()).log(Level.SEVERE,null,ex);
         }
         
        return ListeEmploye;
         
     }
    
     public void afficherEmployerInJtable() throws SQLException
     {
          ArrayList<Class_Enrg> list2 = getEmployeList();
          DefaultTableModel model = (DefaultTableModel)jTableEnreg.getModel();
          Object[] row = new Object[11];                                
          for( int i = 0 ; i < list2.size(); i++)
          {
             row[0] = list2.get(i).getNumEmploy();
             row[1] = list2.get(i).getNom();
             row[2] = list2.get(i).getPstnom();
             row[3] = list2.get(i).getPnom();
             row[4] = list2.get(i).getSexe();
             row[5] = list2.get(i).getNaissance();
             row[6] = list2.get(i).getDomicile();
             row[7] = list2.get(i).getContact();
             row[8] = list2.get(i).getEmail();
             row[9] = list2.get(i).getTitre();
             row[10] = list2.get(i).getDateAjout();
             
            
              model.addRow(row);
          }
        
     }
}
