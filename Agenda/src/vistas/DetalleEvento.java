/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Animacion.Fade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import servicios.Registros;

/**
 *
 * @author c3rberuss
 */
public class DetalleEvento extends javax.swing.JDialog {

    int x,y;
    
    
    private Registros reg = new Registros();
    private String[] datos;
    private boolean editado;
    private String id;
    private Date date;
    private MostrarEventos event;
    
    public DetalleEvento(java.awt.Frame parent, boolean modal, String id, MostrarEventos evt) {
        super(parent, modal);
        initComponents();
        
        event = evt;
        
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(this.horaS, "HH:mm");
        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(this.horaF, "HH:mm");
        
        this.horaS.setEditor(timeEditor);
        this.horaF.setEditor(timeEditor2);
        
        date = new Date();

        datos = reg.detalle(id);
        
        this.id = id;
        
        if(datos[7].equalsIgnoreCase("NO")){
           this.NoRepetir.setSelected(true);
           this.Repetir.setVisible(false);
        }else{
           this.SiRepetir.setSelected(true);
           this.Repetir.setVisible(true);
           this.Repetir.setSelectedItem(datos[8]);
           this.Repetir.setEnabled(false);
        }
        
        this.fecha.setEnabled(false);
        this.titulo.setText(datos[0]);
        this.descripcion.setText(datos[1]);
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(Integer.valueOf(datos[2]), Integer.valueOf(datos[3]), Integer.valueOf(datos[4]));
        
        this.fecha.setCalendar(cal);
        
        int pos = datos[5].indexOf(":");
       
        String hora = datos[5].substring(0, pos);

        String minuto = datos[5].substring(pos+1);
  
        date.setHours(Integer.valueOf(hora));
        date.setMinutes(Integer.valueOf(minuto));
        
        this.horaS.setValue(date);
        this.categoria.setSelectedItem(datos[6]);
        this.horaF.setValue(date);
        
        this.lugar.setText(datos[9]);
        
        editado = false;
        this.guardar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        titulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editarTitulo = new javax.swing.JToggleButton();
        editarHora = new javax.swing.JToggleButton();
        editarFecha = new javax.swing.JToggleButton();
        editarDescripcion = new javax.swing.JToggleButton();
        editarRepetir = new javax.swing.JToggleButton();
        guardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        NoRepetir = new javax.swing.JRadioButton();
        SiRepetir = new javax.swing.JRadioButton();
        Repetir = new javax.swing.JComboBox<>();
        editarLugar = new javax.swing.JToggleButton();
        categoria = new javax.swing.JComboBox<>();
        horaS = new javax.swing.JSpinner();
        horaF = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        lugar = new javax.swing.JTextField();
        editarCategoria2 = new javax.swing.JToggleButton();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(12, 12, 22));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descripcion.setEditable(false);
        descripcion.setBackground(new java.awt.Color(12, 12, 22));
        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setRows(5);
        descripcion.setToolTipText("Agregue una descripcion del evento");
        jScrollPane1.setViewportView(descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 248, -1));

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(12, 12, 22));
        titulo.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setToolTipText("Nombre del evento");
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        titulo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 250, 20));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TITULO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FECHA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HORA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CATEGORIA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        editarTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarTitulo.setBorderPainted(false);
        editarTitulo.setContentAreaFilled(false);
        editarTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarTitulo.setFocusPainted(false);
        editarTitulo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarTitulo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarTituloStateChanged(evt);
            }
        });
        jPanel1.add(editarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 40, 20));

        editarHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarHora.setBorderPainted(false);
        editarHora.setContentAreaFilled(false);
        editarHora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarHora.setFocusPainted(false);
        editarHora.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarHora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarHoraStateChanged(evt);
            }
        });
        jPanel1.add(editarHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 40, 20));

        editarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarFecha.setBorderPainted(false);
        editarFecha.setContentAreaFilled(false);
        editarFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarFecha.setFocusPainted(false);
        editarFecha.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarFecha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarFechaStateChanged(evt);
            }
        });
        jPanel1.add(editarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 40, 20));

        editarDescripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarDescripcion.setBorderPainted(false);
        editarDescripcion.setContentAreaFilled(false);
        editarDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarDescripcion.setFocusPainted(false);
        editarDescripcion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarDescripcion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarDescripcionStateChanged(evt);
            }
        });
        jPanel1.add(editarDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 40, 20));

        editarRepetir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarRepetir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarRepetir.setBorderPainted(false);
        editarRepetir.setContentAreaFilled(false);
        editarRepetir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarRepetir.setFocusPainted(false);
        editarRepetir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarRepetir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarRepetirStateChanged(evt);
            }
        });
        editarRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarRepetirActionPerformed(evt);
            }
        });
        jPanel1.add(editarRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 40, 20));

        guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/savePq.png"))); // NOI18N
        guardar.setText("GUARDAR CAMBIOS Y CERRAR");
        guardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        guardar.setBorderPainted(false);
        guardar.setContentAreaFilled(false);
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.setFocusPainted(false);
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guardarMouseExited(evt);
            }
        });
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 220, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REPETIR:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 90, 30));

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

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DATOS DE MI EVENTO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 6, 550, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        fecha.setBackground(new java.awt.Color(0, 0, 0));
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setToolTipText("Fecha de realizacion del evento");
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 250, -1));

        NoRepetir.setBackground(new java.awt.Color(12, 12, 22));
        buttonGroup1.add(NoRepetir);
        NoRepetir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        NoRepetir.setForeground(new java.awt.Color(255, 255, 255));
        NoRepetir.setSelected(true);
        NoRepetir.setText("NO");
        NoRepetir.setEnabled(false);
        NoRepetir.setFocusPainted(false);
        NoRepetir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NoRepetirStateChanged(evt);
            }
        });
        jPanel1.add(NoRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        SiRepetir.setBackground(new java.awt.Color(12, 12, 22));
        buttonGroup1.add(SiRepetir);
        SiRepetir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        SiRepetir.setForeground(new java.awt.Color(255, 255, 255));
        SiRepetir.setText("SI");
        SiRepetir.setEnabled(false);
        SiRepetir.setFocusPainted(false);
        SiRepetir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SiRepetirStateChanged(evt);
            }
        });
        jPanel1.add(SiRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, -1));

        Repetir.setBackground(new java.awt.Color(12, 12, 22));
        Repetir.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Repetir.setForeground(new java.awt.Color(255, 255, 255));
        Repetir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diariamente", "Semanalmente", "Mensualmente", "Anualmente" }));
        Repetir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Repetir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Repetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 120, -1));

        editarLugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarLugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarLugar.setBorderPainted(false);
        editarLugar.setContentAreaFilled(false);
        editarLugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarLugar.setFocusPainted(false);
        editarLugar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarLugar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarLugarStateChanged(evt);
            }
        });
        editarLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarLugarActionPerformed(evt);
            }
        });
        jPanel1.add(editarLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 40, 20));

        categoria.setBackground(new java.awt.Color(0, 0, 0));
        categoria.setForeground(new java.awt.Color(255, 255, 255));
        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cumpleaños", "Citas Médicas", "Reuniones", "Bodas", "Otros" }));
        categoria.setToolTipText("Categoria del evento");
        categoria.setEnabled(false);
        jPanel1.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 250, -1));

        horaS.setModel(new SpinnerDateModel());
        horaS.setToolTipText("Hora inicio de evento");
        horaS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        horaS.setEnabled(false);
        jPanel1.add(horaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 110, 30));

        horaF.setModel(new SpinnerDateModel());
        horaF.setToolTipText("Hora fin de evento");
        horaF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        horaF.setEnabled(false);
        jPanel1.add(horaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 110, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("LUGAR:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        lugar.setEditable(false);
        lugar.setBackground(new java.awt.Color(12, 12, 22));
        lugar.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        lugar.setForeground(new java.awt.Color(255, 255, 255));
        lugar.setToolTipText("Nombre del evento");
        lugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lugar.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 250, 20));

        editarCategoria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/edit.png"))); // NOI18N
        editarCategoria2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        editarCategoria2.setBorderPainted(false);
        editarCategoria2.setContentAreaFilled(false);
        editarCategoria2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCategoria2.setFocusPainted(false);
        editarCategoria2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/editPeq.png"))); // NOI18N
        editarCategoria2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarCategoria2StateChanged(evt);
            }
        });
        editarCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCategoria2ActionPerformed(evt);
            }
        });
        jPanel1.add(editarCategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 40, 20));

        eliminar.setText("Eliminar Evento");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void editarTituloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarTituloStateChanged
        if(this.editarTitulo.isSelected()){
            this.titulo.setEditable(true);
            editado = true;
            this.guardar.setVisible(true);
        }else{
            this.titulo.setEditable(false);
        }
    }//GEN-LAST:event_editarTituloStateChanged

    private void editarHoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarHoraStateChanged
        if(this.editarHora.isSelected()){
            this.horaS.setEnabled(true);
            this.horaF.setEnabled(true);
            editado = true;
            this.guardar.setVisible(true);
        }else{
            this.horaS.setEnabled(false);
            this.horaF.setEnabled(false);
        }
    }//GEN-LAST:event_editarHoraStateChanged

    private void editarFechaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarFechaStateChanged
        if(this.editarFecha.isSelected()){
            this.fecha.setEnabled(true);
            editado = true;
            this.guardar.setVisible(true);
        }else{
            this.fecha.setEnabled(false);
        }
    }//GEN-LAST:event_editarFechaStateChanged

    private void editarDescripcionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarDescripcionStateChanged
        if(this.editarDescripcion.isSelected()){
            this.descripcion.setEditable(true);
            editado = true;
            this.guardar.setVisible(true);
        }else{
            this.descripcion.setEditable(false);
        }
    }//GEN-LAST:event_editarDescripcionStateChanged

    private void editarRepetirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarRepetirStateChanged
        if(this.editarRepetir.isSelected()){
            this.NoRepetir.setEnabled(true);
            this.SiRepetir.setEnabled(true);
        }else{
            this.NoRepetir.setEnabled(true);
            this.SiRepetir.setEnabled(true);
        }
    }//GEN-LAST:event_editarRepetirStateChanged

    private void editarRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarRepetirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarRepetirActionPerformed

    private void guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseEntered
        this.guardar.setBorderPainted(true);
    }//GEN-LAST:event_guardarMouseEntered

    private void guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseExited
        this.guardar.setBorderPainted(false);
    }//GEN-LAST:event_guardarMouseExited

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        editado = false;

        datos = new String[12];

        datos[0] = this.titulo.getText();

        datos[1] = String.valueOf(this.fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        datos[2] = String.valueOf(this.fecha.getCalendar().get(Calendar.MONTH));
        datos[3] = String.valueOf(this.fecha.getCalendar().get(Calendar.YEAR));
        datos[4] = String.valueOf(this.fecha.getCalendar().get(Calendar.DAY_OF_WEEK));

        int mes = Integer.valueOf(datos[2])+1;

        datos[5] = datos[1]+"/"+String.valueOf(mes)+"/"+datos[3];

        date = (Date) this.horaS.getValue();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        datos[6] = hourFormat.format(date);

        datos[7] = this.categoria.getSelectedItem().toString();
        datos[8] = this.descripcion.getText();

        if(this.NoRepetir.isSelected()){
            datos[9] = this.NoRepetir.getText();
            datos[10] = "NULL";
        }else{
            datos[9] = this.SiRepetir.getText();
            datos[10] = this.Repetir.getSelectedItem().toString();
        }
        
        datos[11] = this.lugar.getText();

        reg.guardarCambios(this.id, datos, this.fecha.getCalendar(), event);

        Fade.JDialogFadeOut(1f, 0f, 0.1f, 50, this, Fade.DISPOSE);

        event = new MostrarEventos(null, true, "General");
        event.setLocationRelativeTo(null);
        event.setVisible(true);
    }//GEN-LAST:event_guardarActionPerformed

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        this.btnCerrar.setBorderPainted(true);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        this.btnCerrar.setBorderPainted(false);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        if(editado){
            JOptionPane.showMessageDialog(this, "Aún no se han guardado los cambios!");
        }else{

            Fade.JDialogFadeOut(1f, 0f, 0.1f, 50, this, Fade.DISPOSE);

            event = new MostrarEventos(null, true, "General");
            event.setLocationRelativeTo(null);
            event.setVisible(true);
        }

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX()- x , this.getLocation().y + evt.getY() - y );
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void NoRepetirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NoRepetirStateChanged
        if(this.NoRepetir.isSelected()){
            this.Repetir.setEnabled(false);
            this.Repetir.setVisible(false);
            editado = true;
            this.guardar.setVisible(true);
        }
    }//GEN-LAST:event_NoRepetirStateChanged

    private void SiRepetirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SiRepetirStateChanged
        if(this.SiRepetir.isSelected()){
            this.Repetir.setEnabled(true);
            this.Repetir.setVisible(true);
            editado = true;
            this.guardar.setVisible(true);
        }
    }//GEN-LAST:event_SiRepetirStateChanged

    private void editarLugarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarLugarStateChanged
        if(this.editarLugar.isSelected()){
            this.lugar.setEditable(true);
            editado = true;
            this.guardar.setVisible(true);
        }else{
            this.lugar.setEditable(false);
        }
    }//GEN-LAST:event_editarLugarStateChanged

    private void editarLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarLugarActionPerformed

    private void editarCategoria2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarCategoria2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_editarCategoria2StateChanged

    private void editarCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarCategoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarCategoria2ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        reg.eliminarEvento(this.id);
        JOptionPane.showMessageDialog(null, "Evento eliminado exitosamente.");
        this.dispose();
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetalleEvento dialog = new DetalleEvento(new javax.swing.JFrame(), true, "", null);
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
    private javax.swing.JRadioButton NoRepetir;
    private javax.swing.JComboBox<String> Repetir;
    private javax.swing.JRadioButton SiRepetir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JToggleButton editarCategoria2;
    private javax.swing.JToggleButton editarDescripcion;
    private javax.swing.JToggleButton editarFecha;
    private javax.swing.JToggleButton editarHora;
    private javax.swing.JToggleButton editarLugar;
    private javax.swing.JToggleButton editarRepetir;
    private javax.swing.JToggleButton editarTitulo;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JSpinner horaF;
    private javax.swing.JSpinner horaS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lugar;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
