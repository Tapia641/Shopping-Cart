/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Clases.ListaProducto;
import Clases.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tapia
 */
public class ServidorGUI extends javax.swing.JFrame {

    public ServidorGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableDatos.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jTableDatos.setForeground(java.awt.SystemColor.activeCaption);
        jTableDatos.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Precio", "Imagen", "Cantidad", "Catgoria"
            }
        ));
        jScrollPane1.setViewportView(jTableDatos);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAgregarMouseClicked(evt);
            }
        });

        jButtonEditar.setText("Editar");

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBorrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgregarMouseClicked
        AgregarProducto Agregar = new AgregarProducto();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agregar.RecibeLista(Lista);
                Agregar.setServidorGUI(ServidorGUI.this);
                Agregar.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonAgregarMouseClicked

    private void jButtonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBorrarMouseClicked
        // TODO add your handling code here:
        ListaProducto Aux = new ListaProducto();
        for(Producto i: Lista.getLista()){
            if (!i.getNombreProducto().equals(Lista.getLista().get(jTableDatos.getSelectedRow()).getNombreProducto())){
                Aux.pushProducto(i);
            }
        }
        Lista.LimpiaLista();
        Lista.UneLista(Aux.getLista());
        MostrarDatos(Lista);
    }//GEN-LAST:event_jButtonBorrarMouseClicked

    public void MostrarDatos(ListaProducto Lista) {
        this.Lista = Lista;
        modelo = (DefaultTableModel) jTableDatos.getModel();

        try {
            int filas = jTableDatos.getRowCount();
            for (int i = 0; i < filas; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }

        for (Producto i : Lista.getLista()) {
            modelo.addRow(new Object[]{i.getNombreProducto(), i.getDescripcion(), i.getPrecio(), i.getImagenMuestra(), i.getCantidad(),i.getCategoria()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables
    private ListaProducto Lista;
    private DefaultTableModel modelo;

    public void EscribeLista(ListaProducto Lista) throws FileNotFoundException, IOException {
        /* LOS GUARDAMOS EN UN .OUT */
        ObjectOutputStream GuardarObjeto = new ObjectOutputStream(new FileOutputStream("datos.out"));
        GuardarObjeto.writeObject(Lista);
        GuardarObjeto.flush();
    }
}
