/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.DoubleLinkedList;
import EDD.Graph;
import EDD.LinkedList;
import EDD.Node;
import Functions.Global;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ernesto
 */
public class VentanaEliminar extends javax.swing.JFrame {

    /**
     * Creates new form VentanaEliminar
     */
    
    
    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public VentanaEliminar() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jButton2.setText("REGRESAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("NOMBRE DE USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 160, 50));

        comboBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 620, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaModificar v = new VentanaModificar();
        v.setLocationRelativeTo(null);
        v.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String user = (String) comboBox.getSelectedItem();
        comboBox.setSelectedIndex(0);
        if (user.equals("Desplegar lista"))
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario");
        }
        else
        {
            int index = Global.getDoubleList().getUserIndex(user);
            //BORRAR EL USUARIO DE LA LISTA DOBLE
            Global.getDoubleList().DeleteUser(user);
            //BORRAR EL ÍNDICE DEL GRAFO
            Global.getGraph().Delete(index);
            //REESCRIBIR EL ARCHIVO DE TEXTO
            String filePath = Global.getFile().getAbsolutePath();
            try
            {
                LinkedList fileList = new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;
                //ALGORITMO QUE GUARDA EL ARCHIVO EN UNA LISTA SIMPLE
                while ((line = br.readLine()) != null)
                {
                  fileList.InsertAtEnd(line);
                }
                br.close();
                
                //ALGORITMO QUE ELIMINA EL USUARIO SELECCIONADO
                //TAMBIÉN ELIMINA LAS LÍNEAS DONDE ESTÁ DICHO USUARIO
                fileList = fileList.CleanList(user);
                
                //ALGORITMO QUE REESCRIBE EL ARCHIVO DE TEXTO
                FileWriter clearFile = new FileWriter(filePath, false);
                clearFile.write("");
                clearFile.close();
                BufferedWriter bw = new BufferedWriter(new FileWriter (filePath, true));
                Node pointer = fileList.getHead();
                while (pointer!=null)
                {
                    bw.write(pointer.getLine());
                    bw.newLine();
                    pointer = pointer.getNext();
                }
                bw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaEliminar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaEliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
            //MOSTRAR JOPTION PANE DE USUARIO ELIMINADO
            getComboBox().removeAllItems();
            //PREPARAMOS LA COMBO BOX
            DoubleLinkedList usersList = Global.getDoubleList();
            int size = usersList.getSize();
            int cont = 0;
            getComboBox().addItem("Desplegar lista");
            while (cont!=size)
            {
                String u = usersList.returnName(cont);
                getComboBox().addItem(u);
                cont++;
            }
            
            JOptionPane.showMessageDialog(null, user+" ha sido eliminado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
