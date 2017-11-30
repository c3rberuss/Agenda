/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Animacion.Fade;
import javax.swing.JOptionPane;
import servicios.Registros;

/**
 *
 * @author edwin
 */
public class AgregarNota extends javax.swing.JDialog {

    private int x,y;
    private Registros reg;
    
    
    public AgregarNota(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        reg = new Registros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        Guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(12, 12, 22));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/addPequeño.png"))); // NOI18N
        jLabel2.setText("AGREGAR NOTA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 940, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        btnCerrar.setBackground(new java.awt.Color(102, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR");
        btnCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusPainted(false);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 560, 80, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TITULO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 60, -1));

        titulo.setBackground(new java.awt.Color(12, 12, 22));
        titulo.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setToolTipText("Nombre del evento");
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        titulo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 620, 20));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        descripcion.setBackground(new java.awt.Color(12, 12, 22));
        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setLineWrap(true);
        descripcion.setRows(5);
        descripcion.setToolTipText("Agregue una descripcion del evento");
        descripcion.setWrapStyleWord(true);
        descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        descripcion.setCaretColor(new java.awt.Color(255, 255, 255));
        descripcion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        descripcion.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        descripcion.setSelectionColor(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 620, 240));

        Guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/save.png"))); // NOI18N
        Guardar.setText("GUARDAR");
        Guardar.setToolTipText("Guardar mis datos");
        Guardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        Guardar.setBorderPainted(false);
        Guardar.setContentAreaFilled(false);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.setFocusPainted(false);
        Guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/savePq.png"))); // NOI18N
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GuardarMouseExited(evt);
            }
        });
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 120, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MIS DATOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MIS NUEVA NOTA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 950, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX()- x , this.getLocation().y + evt.getY() - y );
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        this.btnCerrar.setBorderPainted(true);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        this.btnCerrar.setBorderPainted(false);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Fade.JDialogFadeOut(1f, 0f, 0.1f, 50, this,Fade.DISPOSE);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void GuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseEntered
        this.Guardar.setBorderPainted(true);
    }//GEN-LAST:event_GuardarMouseEntered

    private void GuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseExited
        this.Guardar.setBorderPainted(false);
    }//GEN-LAST:event_GuardarMouseExited

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(!this.titulo.getText().isEmpty() && !this.descripcion.getText().isEmpty()){
            reg.agregarApunte(this.titulo.getText(), this.descripcion.getText());
            JOptionPane.showMessageDialog(null, "Se guardó correctamente.");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos.");
        }
    }//GEN-LAST:event_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarNota dialog = new AgregarNota(new javax.swing.JDialog(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
