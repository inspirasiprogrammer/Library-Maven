package com.perpustakaan;

import com.perpustakaan.view.BukuForm;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BukuForm form = new BukuForm();
            form.setVisible(true);
        });
    }
}
