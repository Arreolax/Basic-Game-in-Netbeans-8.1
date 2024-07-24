package caballero_mago;

import java.awt.Color;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        this.getContentPane().setBackground(Color.RED);
        eti_text.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_start = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eti_qu = new javax.swing.JLabel();
        eti_text = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_start.setBackground(new java.awt.Color(0, 0, 0));
        btn_start.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_start.setForeground(new java.awt.Color(255, 255, 255));
        btn_start.setText("START");
        btn_start.setFocusable(false);
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        jPanel1.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 160, 50));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.setFocusable(false);
        btn_close.setPreferredSize(new java.awt.Dimension(103, 37));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 160, 50));

        jLabel1.setFont(new java.awt.Font("Impact", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("The Knight and  The Wizard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 440, 64));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("v0.1");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 210, 210, -1));

        eti_qu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eti_qu.setForeground(new java.awt.Color(255, 255, 255));
        eti_qu.setText("?");
        eti_qu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eti_quMouseClicked(evt);
            }
        });
        jPanel1.add(eti_qu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 30, -1));

        eti_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eti_text.setForeground(new java.awt.Color(255, 255, 255));
        eti_text.setText("Days without sleep: 5");
        eti_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eti_textMouseClicked(evt);
            }
        });
        jPanel1.add(eti_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backg5.gif"))); // NOI18N
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 491, 231));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        Game ventana = new Game();
        
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void eti_quMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eti_quMouseClicked
        eti_text.setVisible(true);
        eti_qu.setVisible(false);
    }//GEN-LAST:event_eti_quMouseClicked

    private void eti_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eti_textMouseClicked
        eti_qu.setVisible(true);
        eti_text.setVisible(false);
    }//GEN-LAST:event_eti_textMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel eti_qu;
    private javax.swing.JLabel eti_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
