package trabalho.view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import trabalho.dao.NearEarthObjectDao;
import trabalho.dto.NearEarthObject;
import trabalho.dto.NeoApi;
import trabalho.dto.NeoFeed;
//import trabalho.dto.NeoObject;;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author lucas.wojahn
 */
public class TelaInicial extends javax.swing.JFrame {

    private volatile boolean running = true;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    /**
     * Creates new form Dashboard
     */
    public TelaInicial() {
        initComponents();
        new Thread(this::updateLabel).start();
        jPanel2.setVisible(false);

    }

    private void updateLabel() {
        while (running) {
            SwingUtilities.invokeLater(() -> timeCounter.setText(dtf.format(LocalDateTime.now())));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Erro ao atualizar data");
                System.out.println(e);
                running = false;
            }
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

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        timeCounter = new javax.swing.JLabel();
        detectedObjects = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNearObjects = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        timeCounter.setText("jLabel1");

        detectedObjects.setText("jLabel1");

        label1.setText("Timer:");

        label2.setText("Objetos Detectados:");

        jTableNearObjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Distancia"
            }
        ));
        jScrollPane1.setViewportView(jTableNearObjects);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeCounter))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detectedObjects)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeCounter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detectedObjects))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
        );

        timeCounter.getAccessibleContext().setAccessibleName("TimeCounter");
        label1.getAccessibleContext().setAccessibleName("Timer");
        label2.getAccessibleContext().setAccessibleName("objDetectedLabel");

        jMenu1.setText("Arquivo");

        jMenuItem2.setText("Dashboard");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDashboard(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Sair");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Dados");

        jMenuItem4.setText("Atualizar Dados");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Resultados");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Configurações");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ajuda");

        jMenuItem6.setText("Sobre");
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemDashboard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDashboard
        NeoApi api = new NeoApi();
        NeoFeed data;

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(currentDate);
            //Limite de data da API parece ser 7 Dias senão da erro
            data = api.buscarDados("2024-06-11", currentDate);
            System.out.println(data.toString());
            System.out.println("Objetos detectados: " + data.getCount());
            detectedObjects.setText(String.valueOf(data.getCount()));

            List<NearEarthObject> objects = data.getNearEarthObjects().get(currentDate);
            NearEarthObjectDao daoObjects = new NearEarthObjectDao();
            
            try {
                daoObjects.salvarLista(objects);
            } catch (SQLException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(objects);

            DefaultTableModel tableModel = new DefaultTableModel();
            jTableNearObjects.setModel(tableModel);

            tableModel.addColumn("ID");
            tableModel.addColumn("Nome");
            tableModel.addColumn("Magnitude");
            //TODO Acho que o que ele pede não é a magnitude e sim distancia, tem que ver ainda como extrair isso da API
            for (int x = 0; x < objects.size(); x++) {
                tableModel.insertRow(x, new Object[]{objects.get(x).getId(),
                    objects.get(x).getName(),
                    String.valueOf(objects.get(x).getAbsoluteMagnitudeH())});
            }

        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

        jPanel2.setVisible(true);

    }//GEN-LAST:event_jMenuItemDashboard


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detectedObjects;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNearObjects;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel timeCounter;
    // End of variables declaration//GEN-END:variables
}
