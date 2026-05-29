package com.perpustakaan.view;

import com.perpustakaan.dao.MemberDAO;
import com.perpustakaan.model.Member;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MemberForm extends javax.swing.JInternalFrame {

    private final MemberDAO memberDAO = new MemberDAO();

    private DefaultTableModel tableModel;

    public MemberForm() {
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
        lblAlamat = new javax.swing.JLabel();
        lblPostal = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        txtNamaMember = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtPostal = new javax.swing.JTextField();
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
        tableMember = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CRUD Data Member Perpustakaan");

        lblId.setText("ID Member");

        lblJudul.setText("Judul Member");

        lblAlamat.setText("Alamat");

        lblPostal.setText("Postal");

        txtIdMember.setEditable(false);

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdMember)
                    .addComponent(txtNamaMember)
                    .addComponent(txtAlamat)
                    .addComponent(txtPostal))
                .addContainerGap())
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtIdMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJudul)
                    .addComponent(txtNamaMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlamat)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPostal)
                    .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        tableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Member", "Judul Member", "Alamat", "Postal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tableMember);

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
                    .addComponent(scrollPane))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        tableModel = new DefaultTableModel(new String[]{"ID Member", "Judul Member", "Alamat", "Postal"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableMember.setModel(tableModel);
        tableMember.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void initListeners() {
        tableMember.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                showSelectedDataToForm();
            }
        });
    }

    private void onSimpan(ActionEvent event) {
        txtIdMember.setText(txtIdMember.getText().trim());
        Member member = getMemberFromForm();
        if (member == null) {
            return;
        }

        boolean success = memberDAO.insert(member);
        if (success) {
            JOptionPane.showMessageDialog(this, "Data member berhasil disimpan.");
            refreshTableAfterCrud();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data member.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onEdit(ActionEvent event) {
        Member member = getMemberFromForm();
        if (member == null) {
            return;
        }

        boolean success = memberDAO.update(member);
        if (success) {
            JOptionPane.showMessageDialog(this, "Data member berhasil diubah.");
            refreshTableAfterCrud();
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data member.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onHapus(ActionEvent event) {
        String idMember = txtIdMember.getText().trim();
        if (idMember.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data member yang akan dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = memberDAO.delete(idMember);
            if (success) {
                JOptionPane.showMessageDialog(this, "Data member berhasil dihapus.");
                refreshTableAfterCrud();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data member.", "Error", JOptionPane.ERROR_MESSAGE);
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

    private Member getMemberFromForm() {
        String id = txtIdMember.getText().trim();
        String judul = txtNamaMember.getText().trim();
        String alamat = txtAlamat.getText().trim();
        String postalText = txtPostal.getText().trim();

        if (id.isEmpty() || judul.isEmpty() || alamat.isEmpty() || postalText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        int postal;
        try {
            postal = Integer.parseInt(postalText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Postal harus berupa angka.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (postal < 0) {
            JOptionPane.showMessageDialog(this, "Postal tidak boleh negatif.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return new Member(id, judul, alamat, postal);
    }

    private void loadDataTable() {
        List<Member> listMember = memberDAO.getAll();
        setTableRows(listMember);
    }

    private void loadDataTableByKeyword(String keyword) {
        List<Member> listMember = memberDAO.searchByJudul(keyword);
        setTableRows(listMember);
    }

    private void setTableRows(List<Member> listMember) {
        tableModel.setRowCount(0);
        for (Member member : listMember) {
            tableModel.addRow(new Object[]{
                    member.getIdMember(),
                    member.getNamaMember(),
                    member.getAlamat(),
                    member.getPostal()
            });
        }
    }

    private void showSelectedDataToForm() {
        int selectedRow = tableMember.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        txtIdMember.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtNamaMember.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtAlamat.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txtPostal.setText(tableModel.getValueAt(selectedRow, 3).toString());
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
        txtIdMember.setText(memberDAO.getNextId());
        txtNamaMember.setText("");
        txtAlamat.setText("");
        txtPostal.setText("");
        txtNamaMember.requestFocus();
        tableMember.clearSelection();
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
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblPostal;
    private javax.swing.JPanel panelCari;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelTombol;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableMember;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtNamaMember;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtPostal;
    // End of variables declaration//GEN-END:variables
}
