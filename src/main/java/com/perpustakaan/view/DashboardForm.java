package com.perpustakaan.view;

import com.perpustakaan.model.Pengguna;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class DashboardForm extends javax.swing.JFrame {

    private Pengguna pengguna;

    public DashboardForm() {
        initComponents();
        initDataPengguna();
    }

    public DashboardForm(Pengguna pengguna) {
        this();
        setPengguna(pengguna);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblWelcome = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuMaster = new javax.swing.JMenu();
        menuDataBuku = new javax.swing.JMenuItem();
        menuSession = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Perpustakaan");

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblWelcome.setText("Dashboard Perpustakaan");

        lblStatus.setText("Selamat datang.");

        desktopPane.setLayer(lblWelcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addContainerGap(466, Short.MAX_VALUE))
        );

        menuMaster.setText("Master Data");

        menuDataBuku.setText("Data Buku");
        menuDataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDataBukuActionPerformed(evt);
            }
        });
        menuMaster.add(menuDataBuku);

        menuBar.add(menuMaster);

        menuSession.setText("Session");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuSession.add(menuLogout);

        menuKeluar.setText("Keluar");
        menuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeluarActionPerformed(evt);
            }
        });
        menuSession.add(menuKeluar);

        menuBar.add(menuSession);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuDataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDataBukuActionPerformed
        onOpenBuku(evt);
    }//GEN-LAST:event_menuDataBukuActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        onLogout(evt);
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        onKeluar(evt);
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void initDataPengguna() {
        if (pengguna == null) {
            lblStatus.setText("Selamat datang.");
            return;
        }

        lblStatus.setText("Login sebagai: " + pengguna.getNamaLengkap() + " (" + pengguna.getRole() + ")");
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
        initDataPengguna();
    }

    private void onOpenBuku(ActionEvent event) {
        BukuForm bukuForm = findOpenBukuForm();
        if (bukuForm == null) {
            bukuForm = new BukuForm();
            desktopPane.add(bukuForm);
            bukuForm.setVisible(true);
        }

        try {
            bukuForm.setIcon(false);
            bukuForm.setSelected(true);
            bukuForm.toFront();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Form buku sudah dibuka.");
        }
    }

    private BukuForm findOpenBukuForm() {
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof BukuForm && !frame.isClosed()) {
                return (BukuForm) frame;
            }
        }
        return null;
    }

    private void onLogout(ActionEvent event) {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin logout?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            dispose();
        }
    }

    private void onKeluar(ActionEvent event) {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tutup aplikasi sekarang?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuDataBuku;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuSession;
    // End of variables declaration//GEN-END:variables
}
