/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Oscar
 */
public class dlgCerveza extends javax.swing.JDialog {
    String cerveza;
    int cantidadCerveza = 100;
    /**
     * Creates new form dlgCerveza
     */
    public dlgCerveza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        temporizador();
        setLocation(430, 0);
    }
    
    public void temporizador() { 
        int delay = 800; //milliseconds
       
        ActionListener taskPerformer2 = new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (count == 800) {//we did the task 10 times
                    ((Timer) evt.getSource()).stop();
                }

                leePuntuacion();
                
                count++;
             //   System.out.println("He llegado, bitch.");
             
                     
                }
               
            
            
        };
         
        Timer timerLol = new Timer(delay, taskPerformer2);
        timerLol.start();
    }
    
   
    
    public void leePuntuacion() { 
        File file;
        FileReader fr;

        try {
            file = new File("src\\Puntuaciones\\PuntuacionCerveza.txt");
            // Crea una nueva instancia con el archivo.
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            // Lee la primera linea.
            String linea = br.readLine();
            // La almacena en el atributo texto.
            cerveza = linea;

            // Mientras haya líneas.
            while (linea != null) {
                // Lee la siguiente línea.
                linea = br.readLine();
                // Si la línea no es null, la agrega al atributo texto.
                if (linea != null) {
                    cerveza = linea;
                }
            }
            // Cierra el lector de archivos.
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        cantidadCerveza = Integer.parseInt(cerveza);
        
        switch (cantidadCerveza) { 
            case 100: lblCerveza.setIcon(nivelCerveza100);
                break;
            case 80: lblCerveza.setIcon(nivelCerveza80);
                break;
            case 60: lblCerveza.setIcon(nivelCerveza60);
                break;
            case 40: lblCerveza.setIcon(nivelCerveza40);
                break;
            case 20: lblCerveza.setIcon(nivelCerveza20);
                break;
            case 0: lblCerveza.setIcon(nivelCerveza0);
                break;
        }
        
    
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
        lblCerveza = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        lblCerveza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerveza100.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCerveza)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCerveza)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerveza;
    // End of variables declaration//GEN-END:variables
    Icon nivelCerveza100 = new ImageIcon("src\\Iconos\\cerveza100.png");
    Icon nivelCerveza80 = new ImageIcon("src\\Iconos\\cerveza80.png");
    Icon nivelCerveza60 = new ImageIcon("src\\Iconos\\cerveza60.png");
    Icon nivelCerveza40 = new ImageIcon("src\\Iconos\\cerveza40.png");
    Icon nivelCerveza20 = new ImageIcon("src\\Iconos\\cerveza20.png");
    Icon nivelCerveza0 = new ImageIcon("src\\Iconos\\cerveza0.png");

}
