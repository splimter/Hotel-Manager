/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm2;

//import BorderLayout;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author splimter
 */
public class Tp1 extends JFrame {

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JPanel color1 = new JPanel();
    JPanel color2 = new JPanel();
    JPanel color3 = new JPanel();
    JPanel zone = new JPanel();
    JComboBox colorSelector = new JComboBox<>();
    JButton colorDefault = new JButton();

    public Tp1() {
        super("TP1 - Couleurs");
       
        setSize(480, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

      
        jLabel1.setText("Choisir une couleur...");

        jLabel2.setText("Couleur 1");
        jLabel3.setText("Couleur 2");
        jLabel4.setText("Couleur 3");

        color1.setBackground(new Color(255, 255, 51));
        color1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                color1MouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
//                color1MouseExited(evt);
            }
        });
        GroupLayout color1Layout = new GroupLayout(color1);
        color1.setLayout(color1Layout);
        color1Layout.setHorizontalGroup(
                color1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        color1Layout.setVerticalGroup(
                color1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        color2.setBackground(new Color(255, 153, 0));
        color2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                color2MouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
//                color2MouseExited(evt);
            }
        });
        GroupLayout color2Layout = new GroupLayout(color2);
        color2.setLayout(color2Layout);
        color2Layout.setHorizontalGroup(
                color2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        color2Layout.setVerticalGroup(
                color2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        color3.setBackground(new Color(153, 0, 102));
        color3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                color3MouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
//                color3MouseExited(evt);
            }
        });
        GroupLayout color3Layout = new GroupLayout(color3);
        color3.setLayout(color3Layout);
        color3Layout.setHorizontalGroup(
                color3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        color3Layout.setVerticalGroup(
                color3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 15, Short.MAX_VALUE)
        );

        zone.setBackground(new Color(255, 255, 255));
        GroupLayout zoneLayout = new GroupLayout(zone);
        zone.setLayout(zoneLayout);
        zoneLayout.setHorizontalGroup(
                zoneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 333, Short.MAX_VALUE)
        );
        zoneLayout.setVerticalGroup(
                zoneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        colorSelector.setModel(new DefaultComboBoxModel<>(new String[]{"Vert", "Blue", "Rouge"}));
        colorSelector.addItemListener((java.awt.event.ItemEvent evt) -> {
//                colorSelectorItemStateChanged(evt);
        });

        colorDefault.setText("Par défaut");
        colorDefault.addActionListener((java.awt.event.ActionEvent evt) -> {
//                colorDefaultActionPerformed(evt);
        });
        
        
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
 
        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(jLabel2, gbc);
 
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(color1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(jLabel2, gbc);
 
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(color1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(jLabel2, gbc);
 
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(color1, gbc);
        
        this.add(panel);
        
   }
}

class ColorLbl extends JPanel {

    public ColorLbl() {
    }
}
