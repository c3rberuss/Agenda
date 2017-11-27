/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Animacion.Fade;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.Clip;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin
 */
public class Crono extends javax.swing.JDialog {

    int x,y;
    private Timer timer;
    private int Hours;
    private int Minutes;
    private int Seconds;
    private int MiliSeconds;
    private boolean init;
    private Clip sonido;
    private Object[] vueltas;
    private int contVueltas;
    private DefaultTableModel modelo;
    private final int HoursInMili = 3600000;
    private final int SecondsInMili = 1000;
    private final int MinutesInMili = 60000;
    
    public Crono(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        vueltas = new Object[3];
        contVueltas = 1;
        vueltas[1] = "00:00:00:000";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTimes = new javax.swing.JTable();
        btnIniciar = new javax.swing.JButton();
        btnPausar = new javax.swing.JButton();
        btnVuelta = new javax.swing.JButton();

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/croTitulo.png"))); // NOI18N
        jLabel2.setText("MI CRONOMETRO");
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        tableTimes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VUELTA", "TIEMPO", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTimes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 890, 200));

        btnIniciar.setBackground(new java.awt.Color(102, 0, 0));
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        btnPausar.setBackground(new java.awt.Color(102, 0, 0));
        btnPausar.setForeground(new java.awt.Color(255, 255, 255));
        btnPausar.setText("Pausar");
        btnPausar.setEnabled(false);
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

        btnVuelta.setText("Vuelta");
        btnVuelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueltaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVuelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        this.btnCerrar.setBorderPainted(true);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        this.btnCerrar.setBorderPainted(false);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Fade.JDialogFadeOut(1f, 0f, 0.1f, 50, this,Fade.DISPOSE);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX()- x , this.getLocation().y + evt.getY() - y );
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(init == false){
            setHours(0);
            setMinutes(0);
            setSeconds(0);
            setMiliSeconds(0);
            timer = new Timer();
            iniciarCronometro();
            this.btnIniciar.setText("Parar");
            this.btnPausar.setText("Pausar");
            init = true;
            this.btnPausar.setEnabled(true);
            
             DefaultTableModel tb = (DefaultTableModel) this.tableTimes.getModel();
            int a = this.tableTimes.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                tb.removeRow(tb.getRowCount()-1);
            }
            
            contVueltas=1;
            
        }else{
            getTimer().cancel();
            init = false;
            this.btnIniciar.setText("Reiniciar");
            this.btnPausar.setText("Continuar");
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        if(init == false){
            timer = new Timer();
            iniciarCronometro();
            this.btnPausar.setText("Pausar");
            this.btnIniciar.setText("Parar");
            init = true;
        }else{
            getTimer().cancel();
            init = false;
            this.btnPausar.setText("Continuar");
            this.btnIniciar.setText("Reiniciar");
        }
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnVueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueltaActionPerformed
        vueltas[0] = contVueltas + " Vuelta";
        
        vueltas[2] = diferencia(vueltas[1].toString());
        
        vueltas[1] = this.LblHours.getText()+":"+this.LblMinutes.getText()+":"
                +this.LblSeconds.getText()+":"+this.LblMiliSeconds.getText();
        
        modelo = (DefaultTableModel) this.tableTimes.getModel();
        modelo.addRow(vueltas);
        this.tableTimes.setModel(modelo);
        
        contVueltas++;
    }//GEN-LAST:event_btnVueltaActionPerformed

    
    public void iniciarCronometro(){
             // Clase en la que está el código a ejecutar 
        TimerTask timerTask = new TimerTask() { 
         public void run()  {
             
             setMiliSeconds(getMiliSeconds()+1);
             if(getMiliSeconds() == 1000){
                 setMiliSeconds(0);
                 setSeconds(getSeconds()+1);

                 if(getSeconds() == 60){
                     setSeconds(0);
                     setMinutes(getMinutes()+1);
                     
                     if(getMinutes() == 60){
                         setMinutes(0);
                         setHours(getHours()+1);
                     }
                     
                 }
             }
             
             actualizarVentana(String.valueOf(getHours()), String.valueOf(getMinutes()), 
                     String.valueOf(getSeconds()),String.valueOf(getMiliSeconds()));
             
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
    
    
    private String diferencia(String tiempoAnte){
        
        float minutes = Integer.valueOf(this.LblMinutes.getText());
        float hours = Integer.valueOf(this.LblHours.getText());
        float seconds = Integer.valueOf(this.LblSeconds.getText());
        float miliseconds = Integer.valueOf(this.LblMiliSeconds.getText());
          
        
        /*System.out.println("Horas: "+hours);
        System.out.println("Minutos: "+minutes);
        System.out.println("Aegundos: "+seconds);
        System.out.println("Milisegundos: "+miliseconds);*/
        
            
        if(hours > 0){
            hours = hours * (HoursInMili / hours);
        }
        
        if(minutes > 0){
           minutes = minutes * (MinutesInMili / minutes); 
        }
        
        if(seconds > 0){
            seconds = seconds * (SecondsInMili / seconds);
        }
        
        
        float antHours = Integer.valueOf(tiempoAnte.substring(0, 2));
        float antMinutes = Integer.valueOf(tiempoAnte.substring(3, 5));
        float antSeconds = Integer.valueOf(tiempoAnte.substring(6, 8));
        float antMili = Integer.valueOf(tiempoAnte.substring(9));
        
        /*System.out.println("Horas Ant: "+antHours);
        System.out.println("Minutos Ant: "+antMinutes);
        System.out.println("Aegundos Ant: "+antSeconds);
        System.out.println("Milisegundos Ant: "+antMili);*/
        
        if(antHours > 0){
            antHours = antHours * (HoursInMili / antHours);
        }
        
        if(antMinutes > 0){
           antMinutes = antMinutes * (MinutesInMili / antMinutes); 
        }
        
        if(antMili > 0){
            antMili = antMili * (SecondsInMili / antMili);
        }
        
        hours = hours - antHours;
        minutes = minutes - antMinutes;
        seconds = seconds - antSeconds;
        miliseconds = miliseconds - antMili ;
        
        if(hours > 0){
            hours = (int)Math.ceil(hours * (1 / hours));
            System.out.println("\n\nHoras Residuales: "+hours);
        }else{
            //hours = hours * (-1);
        }
        
        if(minutes > 0){
           minutes = (int)Math.ceil(minutes * (1 / minutes));
           System.out.println("Minutos Residuales: "+minutes);
        }else{
            //minutes = minutes * (-1);
        }
        
        if(seconds > 0){
            System.out.println("Segundos en Milis Restantes: "+seconds);
            seconds = (int)Math.ceil(seconds * (1 / seconds));
            System.out.println("Segundos Residuales: "+seconds);
        }else{
            //seconds = seconds * (-1);
        }
        
         if(miliseconds < 0){
            miliseconds =  miliseconds * (-1);
             System.out.println("Milisegundos Residuales: "+miliseconds+"\n\n");
        }
         
        return "+"+String.valueOf((int)hours)+":"+String.valueOf((int)minutes)+":"+
                String.valueOf((int)seconds)+":"+String.valueOf((int)miliseconds);
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
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Crono dialog = new Crono(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnVuelta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTimes;
    // End of variables declaration//GEN-END:variables

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


}
