
package Interfaces;

import EDD.DoubleLinkedList;
import EDD.Graph;
import Functions.Global;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ernesto
 */
public class Ventana1 extends javax.swing.JFrame {
    
    public Ventana1() 
    {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        TÍTULO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        TÍTULO.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TÍTULO.setText("ANÁLISIS DE REDES SOCIALES");
        jPanel1.add(TÍTULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("FUERTE CONECTIVIDAD ENTRE USUARIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton2.setText("INICIAR ESTUDIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        jButton3.setText("SELECCIONAR ARCHIVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 620, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //AQUÍ SE COMPRUEBA QUE EL ARCHIVO HAYA SIDO SELECCIONADO
        if (FileIsEmpty())
        {
            //SE MUESTRA UN MENSAJE DE ERROR EN CASO DE QUE NO SE HAYA SELECCIONADO NADA
            JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo primero");
        }
        else
        {
            //SE ABRE LA VENTANA SIGUIENTE
            Ventana2 v = new Ventana2();
            v.setLocationRelativeTo(null);
            v.show();
            this.dispose();
            
            //GUARDAMOS EN FILEPATH EL CONTENIDO DEL ARCHIVO
            String filePath = Global.getFile().getAbsolutePath();
            int vertex = Global.CalculateVertex(filePath);
            Graph graph = new Graph(vertex);
            //LEEMOS EL ARCHIVO CON BUFFERREADER
            try 
            {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;
                boolean readingUsers = false;
                DoubleLinkedList doubleList = new DoubleLinkedList();

                while ((line = br.readLine()) != null)
                {
                    // Si encontramos la palabra "usuarios" empezamos a leer los nombres de usuario
                    if (line.equals("usuarios")) 
                    {
                        readingUsers = true;
                        continue;  // Saltamos esta línea para no imprimir "usuarios"
                    }
                    // Si encontramos la palabra "relaciones" terminamos de leer los nombres de usuario
                    if (line.equals("relaciones")) 
                    {
                        readingUsers = false;
                        continue;
                    }
                    // Si estamos en la sección de usuarios creamos el nuevo objeto y lo añadimos al grafo
                    if (readingUsers) 
                    {
                        //AÑADIMOS EL USUARIO A LA LISTA DOBLE
                        doubleList.InsertUser(line);
                    }
                    if (!readingUsers)
                    {
                        //GUARDAMOS ORIGEN EN V1 Y DESTINO EN V2
                        String[] relation = line.split(",");
                        String v1 = relation[0].trim();
                        String v2 = relation[1].trim();
                        
                        //OBTENEMOS EL ÍNDICE DE CADA UNO EN LA LISTA DOBLE
                        int i = doubleList.getUserIndex(v1);
                        int j = doubleList.getUserIndex(v2);
                        //AÑADIMOS LA ARISTA AL GRAFO
                        graph.AddRelation(i, j);
                    }
                }
                //SETEAMOS NUEVA LISTA DOBLE
                Global.setList(doubleList);
                //SETEAMOS NUEVO GRAFO
                Global.setGraph(graph);
                Global.getGraph().Show();
                br.close();
            } 
            catch (IOException e) 
            {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        jFileChooser1.setFileFilter(filter);        
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        int result = jFileChooser1.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            Global.setFile(jFileChooser1.getSelectedFile());
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private boolean FileIsEmpty()
    {
        return Global.getFile() == null;
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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TÍTULO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}