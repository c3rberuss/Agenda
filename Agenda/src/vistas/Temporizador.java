/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Animacion.Fade;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import servicios.SegundoPlano;

/**
 *
 * @author edwin
 */
public class Temporizador extends javax.swing.JDialog {

   int x,y;
    private Timer timer;
    private int Hours;
    private int Minutes;
    private int Seconds;
    private int MiliSeconds;
    private boolean init;
    private boolean running;
    private Clip sonido;
    private long tiempo;
    private AudioInputStream ais;
    private BufferedInputStream bis; 
    
    
    public Temporizador(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        tiempo = 0;
        running = false;
        
       try {
           
           bis = new BufferedInputStream(getClass().getResourceAsStream("/recursos/sonidos/beep.wav"));
           ais = AudioSystem.getAudioInputStream(bis);
           
           sonido = AudioSystem.getClip();
           
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
           Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }

    public Temporizador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Temporizador(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jPanel3 = new javax.swing.JPanel();
        LblHours = new javax.swing.JLabel();
        LblMinutes = new javax.swing.JLabel();
        LblSeconds = new javax.swing.JLabel();
        LblMiliSeconds = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        spinnerHora = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        spinnerMinuto = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spinnerSegundo = new javax.swing.JSpinner();

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/tempoTitulo.png"))); // NOI18N
        jLabel2.setText("MI TEMPORIZADOR");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 940, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        btnCerrar.setBackground(new java.awt.Color(102, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/close.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusPainted(false);
        btnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/closePeque.png"))); // NOI18N
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

        jPanel3.setBackground(new java.awt.Color(12, 12, 22));

        LblHours.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        LblHours.setForeground(new java.awt.Color(255, 255, 255));
        LblHours.setText("00");

        LblMinutes.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        LblMinutes.setForeground(new java.awt.Color(255, 255, 255));
        LblMinutes.setText("00");

        LblSeconds.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        LblSeconds.setForeground(new java.awt.Color(255, 255, 255));
        LblSeconds.setText("00");

        LblMiliSeconds.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        LblMiliSeconds.setForeground(new java.awt.Color(255, 255, 255));
        LblMiliSeconds.setText("000");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3.setText(":");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5.setText(":");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(LblHours)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(LblMinutes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(LblSeconds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(LblMiliSeconds)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblHours)
                    .addComponent(LblMinutes)
                    .addComponent(LblMiliSeconds)
                    .addComponent(LblSeconds)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jPanel4.setBackground(new java.awt.Color(12, 12, 22));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spinnerHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        jPanel4.add(spinnerHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HORAS");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, -1));

        spinnerMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        jPanel4.add(spinnerMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 40, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MINUTOS");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 80, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SEGUNDOS");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 80, -1));

        spinnerSegundo.setModel(new javax.swing.SpinnerNumberModel(1, 0, 60, 1));
        jPanel4.add(spinnerSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 40, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 360, 90));

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

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
         this.btnIniciar.setEnabled(false);
        if(init == false){
             
            setHours((int) this.spinnerHora.getValue());
            setMinutes((int) this.spinnerMinuto.getValue());
            
            if(((int)this.spinnerSegundo.getValue()) > 1){
                setSeconds((int) this.spinnerSegundo.getValue() - 1);
            }else{
                setSeconds((int) this.spinnerSegundo.getValue());
            }
            
            tiempo = (long) ((getHours() * 3600000) + (getMinutes() * 60000) + (getSeconds() * 1000) - 0.5);

            setMiliSeconds(1000);
            timer = new Timer();
            iniciarTemporizador();
            init = true;
            running = true;
                 
        }else{
            getTimer().cancel();
            init = false;
        }
    }//GEN-LAST:event_btnIniciarActionPerformed


    public void iniciarTemporizador(){
             // Clase en la que está el código a ejecutar 
        TimerTask timerTask = new TimerTask() { 
         public void run()  {
             
             
             setMiliSeconds(getMiliSeconds()-1);
             tiempo--;
             
             if(getMiliSeconds() == 0){
                 setMiliSeconds(1000);
                 setSeconds(getSeconds()-1);

                 if(getSeconds() == 0){
                     setSeconds(60);
                     setMinutes(getMinutes()-1);
                     
                     if(getMinutes() == 0){
                         setMinutes(0);
                         setHours(getHours()-1);
                     }
                     if (getHours()==-1){
                         setHours(0);
                     }
                     
                 }
             }
             
             actualizarVentana(String.valueOf(getHours()), String.valueOf(getMinutes()), 
                     String.valueOf(getSeconds()),String.valueOf(getMiliSeconds()));
             
           if(tiempo == 0){
                 timer.cancel();
                 actualizarVentana("00", "00", "00", "000");                 
                 jPanel4.updateUI();
                 sonar();
                 running = false;
                 btnIniciar.setEnabled(true);
             }
             
         } 
     };
     
     
     // Dentro de 0 milisegundos avísame cada 1000 milisegundos 
        getTimer().scheduleAtFixedRate(timerTask, 0, 1);

    }
    public void actualizarVentana(String horas, String minutos, String segundos, String mili){
        
        if(horas.length() == 1){
            horas = "0"+horas;
        }
        
        if(minutos.length() == 1){
            minutos = "0"+minutos;
        }
        
        if(segundos.length() == 1){
            segundos = "0"+segundos;
        }
        
        if(mili.length() == 1){
            mili = "00"+mili;
        }
        
        if(mili.length() == 2){
            mili = "0"+mili;
        }
        

        LblMiliSeconds.setText(mili);
        LblSeconds.setText(segundos);
        LblMinutes.setText(minutos);
        LblHours.setText(horas);
            
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
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Temporizador dialog = new Temporizador(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel LblHours;
    private javax.swing.JLabel LblMiliSeconds;
    private javax.swing.JLabel LblMinutes;
    private javax.swing.JLabel LblSeconds;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JSpinner spinnerMinuto;
    private javax.swing.JSpinner spinnerSegundo;
    // End of variables declaration//GEN-END:variables
    
    public void agregarListener(ActionListener al){
        
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

 public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

        public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int Minutes) {
        this.Minutes = Minutes;
    }

    public int getSeconds() {
        return Seconds;
    }

    public void setSeconds(int Seconds) {
        this.Seconds = Seconds;
    }

    public int getMiliSeconds() {
        return MiliSeconds;
    }

    public void setMiliSeconds(int MiliSeconds) {
        this.MiliSeconds = MiliSeconds;
    }

   
    public void sonar(){
        try {
            
            //Se carga el clip de audio
            bis = new BufferedInputStream(getClass().getResourceAsStream("/recursos/sonidos/beep.wav"));
            ais = AudioSystem.getAudioInputStream(bis);
            sonido = AudioSystem.getClip();
            sonido.open(ais);
            
            //inicia la reproducción
            sonido.start();
             sonido.loop(2);
            //Se pausa el hilo para esperar la reproducción del Sonido
            Thread.sleep(9000);
           
            //se cierra el clip de audio
            sonido.close();
            
        } catch (LineUnavailableException | IOException | InterruptedException | UnsupportedAudioFileException ex) {
            Logger.getLogger(SegundoPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

