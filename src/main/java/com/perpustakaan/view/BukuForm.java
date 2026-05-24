package com.perpustakaan.view;

import com.perpustakaan.dao.BukuDAO;
import com.perpustakaan.model.Buku;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BukuForm extends javax.swing.JInternalFrame {

    private final BukuDAO bukuDAO = new BukuDAO();

    private DefaultTableModel tableModel;

    public BukuForm() {
        initComponents();

        if (java.beans.Beans.isDesignTime()) {
            return;
        }

        initTableModel();
        initListeners();
        loadDataTable();
        resetForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelUtama = new javax.swing.JPanel();
        panelInput = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblJudul = new javax.swing.JLabel();
        lblPenulis = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        txtIdBuku = new javax.swing.JTextField();
        txtJudulBuku = new javax.swing.JTextField();
        txtPenulis = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        panelTombol = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        panelCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CRUD Data Buku Perpustakaan");

        lblId.setText("ID Buku");
        lblJudul.setText("Judul Buku");
        lblPenulis.setText("Penulis");
        lblStok.setText("Stok");
        txtIdBuku.setEditable(false);

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInputLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPenulis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdBuku)
                        .addComponent(txtJudulBuku)
                        .addComponent(txtPenulis)
                        .addComponent(txtStok))
                    .addContainerGap())
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInputLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId)
                        .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJudul)
                        .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPenulis)
                        .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStok)
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTombolLayout = new javax.swing.GroupLayout(panelTombol);
        panelTombol.setLayout(panelTombolLayout);
        panelTombolLayout.setHorizontalGroup(
            panelTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTombolLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnSimpan)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnEdit)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnHapus)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnReset)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTombolLayout.setVerticalGroup(
            panelTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTombolLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan)
                        .addComponent(btnEdit)
                        .addComponent(btnHapus)
                        .addComponent(btnReset))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCari.setText("Cari Judul");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCariLayout = new javax.swing.GroupLayout(panelCari);
        panelCari.setLayout(panelCariLayout);
        panelCariLayout.setHorizontalGroup(
            panelCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCariLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCari)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnCari)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnRefresh)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCariLayout.setVerticalGroup(
            panelCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCariLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCari)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCari)
                        .addComponent(btnRefresh))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Buku", "Judul Buku", "Penulis", "Stok"
            }
        ));
        scrollPane.setViewportView(tableBuku);

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelUtamaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTombol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
                    .addContainerGap())
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelUtamaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        onSimpan(evt);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        onEdit(evt);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        onHapus(evt);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        onReset(evt);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        onCari(evt);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        onRefresh(evt);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void initTableModel() {
        tableModel = new DefaultTableModel(new String[]{"ID Buku", "Judul Buku", "Penulis", "Stok"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBuku.setModel(tableModel);
        tableBuku.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void initListeners() {
        tableBuku.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                showSelectedDataToForm();
            }
        });
    }

    private void onSimpan(ActionEvent event) {
        txtIdBuku.setText(txtIdBuku.getText().trim());
        Buku buku = getBukuFromForm();
        if (buku == null) {
            return;
        }

        boolean success = bukuDAO.insert(buku);
        if (success) {
            JOptionPane.showMessageDialog(this, "Data buku berhasil disimpan.");
            refreshTableAfterCrud();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data buku.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onEdit(ActionEvent event) {
        Buku buku = getBukuFromForm();
        if (buku == null) {
            return;
        }

        boolean success = bukuDAO.update(buku);
        if (success) {
            JOptionPane.showMessageDialog(this, "Data buku berhasil diubah.");
            refreshTableAfterCrud();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data buku.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onHapus(ActionEvent event) {
        String idBuku = txtIdBuku.getText().trim();
        if (idBuku.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data buku yang akan dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = bukuDAO.delete(idBuku);
            if (success) {
                JOptionPane.showMessageDialog(this, "Data buku berhasil dihapus.");
                refreshTableAfterCrud();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data buku.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onReset(ActionEvent event) {
        resetForm();
        loadDataTable();
    }

    private void onRefresh(ActionEvent event) {
        txtCari.setText("");
        loadDataTable();
        JOptionPane.showMessageDialog(this, "Tabel berhasil direfresh.");
    }

    private void onCari(ActionEvent event) {
        String keyword = txtCari.getText().trim();
        if (keyword.isEmpty()) {
            loadDataTable();
            return;
        }

        loadDataTableByKeyword(keyword);
    }

    private Buku getBukuFromForm() {
        String id = txtIdBuku.getText().trim();
        String judul = txtJudulBuku.getText().trim();
        String penulis = txtPenulis.getText().trim();
        String stokText = txtStok.getText().trim();

        if (id.isEmpty() || judul.isEmpty() || penulis.isEmpty() || stokText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        int stok;
        try {
            stok = Integer.parseInt(stokText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stok harus berupa angka.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (stok < 0) {
            JOptionPane.showMessageDialog(this, "Stok tidak boleh negatif.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return new Buku(id, judul, penulis, stok);
    }

    private void loadDataTable() {
        List<Buku> listBuku = bukuDAO.getAll();
        setTableRows(listBuku);
    }

    private void loadDataTableByKeyword(String keyword) {
        List<Buku> listBuku = bukuDAO.searchByJudul(keyword);
        setTableRows(listBuku);
    }

    private void setTableRows(List<Buku> listBuku) {
        tableModel.setRowCount(0);
        for (Buku buku : listBuku) {
            tableModel.addRow(new Object[]{
                    buku.getIdBuku(),
                    buku.getJudulBuku(),
                    buku.getPenulis(),
                    buku.getStok()
            });
        }
    }

    private void showSelectedDataToForm() {
        int selectedRow = tableBuku.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        txtIdBuku.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtJudulBuku.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtPenulis.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txtStok.setText(tableModel.getValueAt(selectedRow, 3).toString());
    }

    private void refreshTableAfterCrud() {
        String keyword = txtCari.getText().trim();
        if (keyword.isEmpty()) {
            loadDataTable();
        } else {
            loadDataTableByKeyword(keyword);
        }
    }

    private void resetForm() {
        txtIdBuku.setText(bukuDAO.getNextId());
        txtJudulBuku.setText("");
        txtPenulis.setText("");
        txtStok.setText("");
        txtJudulBuku.requestFocus();
        tableBuku.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPenulis;
    private javax.swing.JLabel lblStok;
    private javax.swing.JPanel panelCari;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelTombol;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
