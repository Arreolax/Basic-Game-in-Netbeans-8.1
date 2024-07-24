package caballero_mago;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Game extends javax.swing.JFrame {
    
    //  Set Values
    private Statistics wizard = new Wizard("Wizard ", 1, 50, 100);
    private Statistics knight = new Knight("Knight ", 1, 50, 100);
    
    
    public Game(){
        initComponents();    
        btn_again.setVisible(false);
        eti_att_k.setVisible(false);
        eti_att_w.setVisible(false);
        eti_help.setVisible(false);
        eti_s_w.setVisible(false);
        eti_s_k.setVisible(false);       
    }
    
    //Knight
    
    private void attack() {
        eti_s_w.setVisible(false);
        eti_s_k.setVisible(false);
        
        int dama = 0;
        
        int att = (int)(Math.random() * 3);  // 0 = special | 1-2 = normal
        
        // attacks power
        if(att == 0){
            dama = knight.Special();
            eti_att_k.setVisible(true);
            eti_s_k.setVisible(true);
        }
        else{
            dama = (int) (Math.random()*4+1);
            eti_att_k.setVisible(false);
        }
       
        wizard.lvl_heal = wizard.lvl_heal - dama;
        eti_eti_knight.setText("You decided to attack and did damage " + dama + " →");
        eti_eti_knight.setForeground(Color.red);
        var_h_w.setValue(wizard.lvl_heal);

        
        // Win
        if (wizard.lvl_heal <= 0) {
            eti_result.setText("¡You've won!");
            eti_result.setForeground(Color.green);
            var_h_w.setValue(0);
            eti_eti_knight.setVisible(false);
            eti_eti_wizard.setVisible(false);
            eti_att_k.setVisible(false);
            eti_att_w.setVisible(false);
            eti_inst.setVisible(false);
            btn_attack.setVisible(false);
            btn_defend.setVisible(false);
            eti_wizard.setVisible(false);
            eti_ayu_w.setVisible(false);
            btn_again.setVisible(true);
            eti_heal.setVisible(false);
            eti_s_w.setVisible(false);
            eti_s_k.setVisible(false);
            //eti_d_w.setVisible(true);
            JOptionPane.showMessageDialog(this,"*** Congratulations!! ***"+"\n"+"You have defeated the wizard");
            return;
        }
        turnoEnemigo();
    }

    private void defense_k() {
        eti_att_k.setVisible(false);
        eti_s_w.setVisible(false);
        eti_s_k.setVisible(false);
        
        int dama = 0;
        
        int att = (int)(Math.random() * 3);  // 0 = special | 1-2 = normal
        
        // attacks power
        if(att == 0){
            dama = wizard.Special();
            eti_att_w.setVisible(true);
        }
        else{
            dama = (int) (Math.random()*4+1);
            eti_att_w.setVisible(false);
        } 
        
        if(knight.lvl_defense > 0){
            knight.lvl_defense =  knight.lvl_defense - dama;
            eti_eti_knight.setText("You decided to defend");
            eti_eti_knight.setForeground(Color.blue);
            eti_eti_wizard.setText("← The wizard attacked you and you took " + dama + " damage");
            eti_eti_wizard.setForeground(Color.red);
            var_d_k.setValue(knight.lvl_defense);
        }else{
            btn_defend.setEnabled(false);
        }
        //turnoEnemigo();
    }
    
    // Wizard

    private void heall() {
        if (wizard instanceof Wizard) {
            ((Wizard) wizard).heal();
            eti_heal.setText("+1 Heal");
            var_h_w.setValue(wizard.lvl_heal);
        }
    }

    private void turnoEnemigo() {
        heall();
        
        int dama = 0;
        
        int att = (int)(Math.random() * 3);  // 0 = special | 1-2 = normal
        
        // attacks power
        if(att == 0){
            dama = knight.Special();
            eti_att_w.setVisible(true);
            eti_s_w.setVisible(true);
        }
        else{
            dama = (int) (Math.random()*4+1);
            eti_att_w.setVisible(false);
        }
        
        int def_w = (int)(Math.random() * 5);  // 0 defense | 1-2 attack
        
        if (def_w >= 1) {            
            knight.lvl_heal = knight.lvl_heal - dama;
            eti_eti_wizard.setText("← The wizard attacked you and you took " + dama + " damage");
            eti_eti_wizard.setForeground(Color.red);
            var_h_k.setValue(knight.lvl_heal);

            if (knight.lvl_heal <= 0) {
                eti_result.setText("¡You've lost!\n");
                eti_result.setForeground(Color.red);
                var_h_k.setValue(0);
                eti_att_k.setVisible(false);
                eti_att_w.setVisible(false);
                eti_eti_knight.setVisible(false);
                eti_eti_wizard.setVisible(false);
                eti_inst.setVisible(false);
                btn_attack.setVisible(false);
                btn_defend.setVisible(false);
                eti_knight.setVisible(false);
                btn_again.setVisible(true);
                eti_heal.setVisible(false);
                eti_help.setVisible(true);
                eti_s_w.setVisible(false);
                eti_s_k.setVisible(false);
                JOptionPane.showMessageDialog(this,"*** GAME OVER!! ***"+"\n"+"Apparently the magician was stronger than you:)");
                return;
            }
        } else {
            defense_w();
        }
    }
    
    private void defense_w() {
        eti_att_w.setVisible(false);
        eti_s_w.setVisible(false);
        eti_s_k.setVisible(false);
        
        int dama = 0;
        
        int att = (int)(Math.random() * 3);  // 0 = special | 1-2 = normal
        
        // attacks power
        if(att == 0){
            dama = knight.Special();
            eti_att_k.setVisible(true);
        }
        else{
            dama = (int) (Math.random()*4+1);
            eti_att_k.setVisible(false);
        }
        
        if(wizard.lvl_defense > 0){
            wizard.lvl_defense =  wizard.lvl_defense - dama;
            eti_eti_wizard.setText("The wizard defended ");
            eti_eti_wizard.setForeground(Color.blue);
            var_d_w.setValue(wizard.lvl_defense);
            
        }
        else{
            wizard.lvl_heal = wizard.lvl_heal - dama;
            eti_eti_wizard.setText("← The wizard attacked you and you took " + dama + " damage");
            eti_eti_wizard.setForeground(Color.red);
            var_h_w.setValue(wizard.lvl_heal);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eti_help = new javax.swing.JLabel();
        eti_ayu_w = new javax.swing.JLabel();
        var_h_k = new javax.swing.JProgressBar();
        eti_vida_k = new javax.swing.JLabel();
        var_h_w = new javax.swing.JProgressBar();
        eti_vida_w = new javax.swing.JLabel();
        btn_attack = new javax.swing.JButton();
        btn_defend = new javax.swing.JButton();
        eti_heal = new javax.swing.JLabel();
        eti_att_w = new javax.swing.JLabel();
        eti_eti_knight = new javax.swing.JLabel();
        eti_knight = new javax.swing.JLabel();
        eti_eti_wizard = new javax.swing.JLabel();
        eti_att_k = new javax.swing.JLabel();
        eti_wizard = new javax.swing.JLabel();
        eti_inst = new javax.swing.JLabel();
        eti_result = new javax.swing.JLabel();
        eti_s_k = new javax.swing.JLabel();
        eti_s_w = new javax.swing.JLabel();
        btn_again = new javax.swing.JButton();
        eti_def_w = new javax.swing.JLabel();
        eti_def_k = new javax.swing.JLabel();
        var_d_k = new javax.swing.JProgressBar();
        var_d_w = new javax.swing.JProgressBar();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(777, 341));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eti_help.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        eti_help.setForeground(new java.awt.Color(255, 255, 255));
        eti_help.setText(":D");
        jPanel1.add(eti_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 285, 30, -1));

        eti_ayu_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ayudante.gif"))); // NOI18N
        jPanel1.add(eti_ayu_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 297, 30, 40));

        var_h_k.setForeground(new java.awt.Color(51, 255, 0));
        var_h_k.setValue(100);
        jPanel1.add(var_h_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 270, 20));

        eti_vida_k.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        eti_vida_k.setForeground(new java.awt.Color(255, 255, 255));
        eti_vida_k.setText("Health:");
        jPanel1.add(eti_vida_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 170, 30));

        var_h_w.setForeground(new java.awt.Color(51, 255, 0));
        var_h_w.setValue(100);
        jPanel1.add(var_h_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 10, 270, 20));

        eti_vida_w.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        eti_vida_w.setForeground(new java.awt.Color(255, 255, 255));
        eti_vida_w.setText(" :Health");
        jPanel1.add(eti_vida_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 10, 80, 20));

        btn_attack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_attack.setText("Attack");
        btn_attack.setFocusPainted(false);
        btn_attack.setFocusable(false);
        btn_attack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_attackMouseClicked(evt);
            }
        });
        jPanel1.add(btn_attack, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 100, 30));

        btn_defend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_defend.setText("Defend");
        btn_defend.setFocusPainted(false);
        btn_defend.setFocusable(false);
        btn_defend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_defendMouseClicked(evt);
            }
        });
        jPanel1.add(btn_defend, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 100, 30));

        eti_heal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eti_heal.setForeground(new java.awt.Color(102, 255, 102));
        eti_heal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(eti_heal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 130, 30));

        eti_att_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ataqueM.gif"))); // NOI18N
        eti_att_w.setText("test");
        jPanel1.add(eti_att_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, 100));

        eti_eti_knight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eti_eti_knight.setForeground(new java.awt.Color(255, 255, 255));
        eti_eti_knight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eti_eti_knight.setToolTipText("");
        jPanel1.add(eti_eti_knight, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 420, 30));

        eti_knight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/knight.gif"))); // NOI18N
        eti_knight.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                eti_knightMouseDragged(evt);
            }
        });
        eti_knight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eti_knightKeyPressed(evt);
            }
        });
        jPanel1.add(eti_knight, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 137, 200, 200));

        eti_eti_wizard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eti_eti_wizard.setForeground(new java.awt.Color(255, 255, 255));
        eti_eti_wizard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(eti_eti_wizard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 410, 30));

        eti_att_k.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/light.gif"))); // NOI18N
        eti_att_k.setText("test");
        jPanel1.add(eti_att_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 190, -1));

        eti_wizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wizard3.1.gif"))); // NOI18N
        eti_wizard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eti_wizardKeyPressed(evt);
            }
        });
        jPanel1.add(eti_wizard, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 197, 170, 140));

        eti_inst.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        eti_inst.setForeground(new java.awt.Color(255, 255, 255));
        eti_inst.setText("What do you want to do?");
        jPanel1.add(eti_inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        eti_result.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        eti_result.setForeground(new java.awt.Color(255, 255, 255));
        eti_result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(eti_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 490, 100));

        eti_s_k.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        eti_s_k.setForeground(new java.awt.Color(204, 0, 255));
        eti_s_k.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eti_s_k.setText("¡¡ IMPACTRUENO !!");
        jPanel1.add(eti_s_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, 20));

        eti_s_w.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        eti_s_w.setForeground(new java.awt.Color(204, 0, 255));
        eti_s_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eti_s_w.setText("¡¡ ANCESTRAL FIRE !!");
        jPanel1.add(eti_s_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 170, 20));

        btn_again.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_again.setText("Return");
        btn_again.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_againActionPerformed(evt);
            }
        });
        jPanel1.add(btn_again, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 110, -1));

        eti_def_w.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        eti_def_w.setForeground(new java.awt.Color(255, 255, 255));
        eti_def_w.setText(" :Defense");
        jPanel1.add(eti_def_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 33, 80, 20));

        eti_def_k.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        eti_def_k.setForeground(new java.awt.Color(255, 255, 255));
        eti_def_k.setText("Defense:");
        jPanel1.add(eti_def_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 33, 70, 20));

        var_d_k.setForeground(new java.awt.Color(0, 255, 255));
        var_d_k.setMaximum(50);
        var_d_k.setValue(50);
        jPanel1.add(var_d_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 37, -1, -1));

        var_d_w.setForeground(new java.awt.Color(0, 255, 255));
        var_d_w.setMaximum(50);
        var_d_w.setValue(50);
        jPanel1.add(var_d_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 37, -1, -1));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backg3.gif"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(777, 341));
        background.setMinimumSize(new java.awt.Dimension(776, 340));
        background.setPreferredSize(new java.awt.Dimension(777, 341));
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 777, 341));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eti_wizardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eti_wizardKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eti_wizardKeyPressed

    private void eti_knightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eti_knightKeyPressed
        //System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_eti_knightKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //if (evt.getKeyCode()==39){
        //    txt_knight.setLocation(txt_knight.getX()+5, txt_knight.getY());
        //} else if (evt.getKeyCode()==37){
        //    txt_knight.setLocation(txt_knight.getX()-5, txt_knight.getY());
        //} else if(txt_knight.getX() == txt_wizard.getX()){
            //vida = vida - 5;
        //}
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        //System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_formKeyTyped

    private void eti_knightMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eti_knightMouseDragged
        //txt_knight.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
    }//GEN-LAST:event_eti_knightMouseDragged

    private void btn_attackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attackMouseClicked
        attack();
    }//GEN-LAST:event_btn_attackMouseClicked

    private void btn_defendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_defendMouseClicked
        defense_k();
    }//GEN-LAST:event_btn_defendMouseClicked

    private void btn_againActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_againActionPerformed
        dispose();
    }//GEN-LAST:event_btn_againActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
            
            
            
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_again;
    private javax.swing.JButton btn_attack;
    private javax.swing.JButton btn_defend;
    private javax.swing.JLabel eti_att_k;
    private javax.swing.JLabel eti_att_w;
    private javax.swing.JLabel eti_ayu_w;
    private javax.swing.JLabel eti_def_k;
    private javax.swing.JLabel eti_def_w;
    private javax.swing.JLabel eti_eti_knight;
    private javax.swing.JLabel eti_eti_wizard;
    private javax.swing.JLabel eti_heal;
    private javax.swing.JLabel eti_help;
    private javax.swing.JLabel eti_inst;
    private javax.swing.JLabel eti_knight;
    private javax.swing.JLabel eti_result;
    private javax.swing.JLabel eti_s_k;
    private javax.swing.JLabel eti_s_w;
    private javax.swing.JLabel eti_vida_k;
    private javax.swing.JLabel eti_vida_w;
    private javax.swing.JLabel eti_wizard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar var_d_k;
    private javax.swing.JProgressBar var_d_w;
    private javax.swing.JProgressBar var_h_k;
    private javax.swing.JProgressBar var_h_w;
    // End of variables declaration//GEN-END:variables
}
