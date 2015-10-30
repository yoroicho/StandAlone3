/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psManage;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author 00499
 */
public class NewJFrame extends javax.swing.JFrame {

    String fileDir;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        mainTitle = new javax.swing.JTextField();
        subTitle = new javax.swing.JTextField();
        url = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        scanType = new javax.swing.JComboBox();
        commentScrollPane = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        thisPassCode = new javax.swing.JTextField();
        randomType = new javax.swing.JComboBox();
        passLength = new javax.swing.JComboBox();
        randomText = new javax.swing.JTextField();
        passCodeA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        calcPassA = new javax.swing.JButton();
        passCodeB = new javax.swing.JTextField();
        calcPassB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passCodeALength = new javax.swing.JLabel();
        passCodeBLength = new javax.swing.JLabel();
        passCodeLengthTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scanType.setEditable(true);
        scanType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ランダム分割", "順分割", "循環", "使い捨て" }));

        comment.setColumns(20);
        comment.setRows(5);
        commentScrollPane.setViewportView(comment);

        randomType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascii", "Alphanumeric", "Alphabetic", "Numeric", "Letters" }));
        randomType.setSelectedIndex(1);
        randomType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                randomTypeItemStateChanged(evt);
            }
        });

        passLength.setEditable(true);
        passLength.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " " }));
        passLength.setSelectedIndex(9);

        randomText.setText("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$+-./:=?@[]^_`|");
        randomText.setEnabled(false);

        passCodeA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                passCodeACaretUpdate(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        calcPassA.setText("自動取得");
        calcPassA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcPassAActionPerformed(evt);
            }
        });

        passCodeB.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                passCodeBCaretUpdate(evt);
            }
        });

        calcPassB.setText("自動取得");
        calcPassB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcPassBActionPerformed(evt);
            }
        });

        jLabel1.setText("件　　名");

        jLabel2.setText("種　　別");

        jLabel3.setText("位　　置");

        jLabel4.setText("ユーザー");

        jLabel5.setText("符号上位");

        jLabel6.setText("符号下位");

        jLabel7.setText("符号文字");

        passCodeALength.setText("0");

        passCodeBLength.setText("0");

        passCodeLengthTotal.setText("0");

        jLabel8.setText("文字数");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scanType, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(randomType, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(passLength, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(thisPassCode)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(url, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainTitle, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passCodeA, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passCodeALength, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calcPassA))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentScrollPane))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(randomText, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton1))
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(passCodeB, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(passCodeBLength)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(57, 57, 57)
                        .addComponent(passCodeLengthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(calcPassB))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thisPassCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passCodeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcPassA)
                    .addComponent(jLabel5)
                    .addComponent(passCodeALength))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passCodeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcPassB)
                    .addComponent(jLabel6)
                    .addComponent(passCodeBLength))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passCodeLengthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_randomTypeItemStateChanged
        passCodeA.setText(null);
        passCodeB.setText(null);
        if (randomType.getSelectedItem().toString().endsWith("Letters")) {
            randomText.setEnabled(true);
        } else {
            randomText.setEnabled(false);
        }
    }//GEN-LAST:event_randomTypeItemStateChanged

    private void passCodeACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passCodeACaretUpdate
        passCodeALength.setText(Integer.toString(passCodeA.getText().length()));
        passCodeLengthTotal.setText(Integer.toString(passCodeA.getText().length() + passCodeB.getText().length()));
        if (passCodeA.getText().length() >= 16) {
            passCodeA.setForeground(Color.red);
        } else {
            passCodeA.setForeground(Color.black);
        }
    }//GEN-LAST:event_passCodeACaretUpdate

    private void passCodeBCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passCodeBCaretUpdate
        passCodeBLength.setText(Integer.toString(passCodeB.getText().length()));
        passCodeLengthTotal.setText(Integer.toString(passCodeA.getText().length() + passCodeB.getText().length()));
        if (passCodeB.getText().length() >= 16) {
            passCodeB.setForeground(Color.red);
        } else {
            passCodeB.setForeground(Color.black);
        }
    }//GEN-LAST:event_passCodeBCaretUpdate

    private void calcPassAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcPassAActionPerformed
        // パスワード文字列の計算を呼び出し、表示
        this.passCodeA.setText(
                StructSheet.getPassCode(
                        this.randomType.getSelectedItem().toString(),
                        this.randomText.getText(),
                        Integer.parseInt(this.passLength.getSelectedItem().toString()))
        );
    }//GEN-LAST:event_calcPassAActionPerformed

    private void calcPassBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcPassBActionPerformed
               // パスワード文字列の計算を呼び出し、表示
        this.passCodeB.setText(
                StructSheet.getPassCode(
                        this.randomType.getSelectedItem().toString(),
                        this.randomText.getText(),
                        Integer.parseInt(this.passLength.getSelectedItem().toString()))
        );
    }//GEN-LAST:event_calcPassBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        try {
            /*
             // 保存ファイルの選択
            
             JFileChooser filechooser = new JFileChooser();
            
             int selected = filechooser.showSaveDialog(this);
             if (selected == JFileChooser.APPROVE_OPTION){
             File file = filechooser.getSelectedFile();
             fileDir = (file.getPath());
             }else if (selected == JFileChooser.CANCEL_OPTION){
             System.out.println("キャンセルされました");
             }else if (selected == JFileChooser.ERROR_OPTION){
             System.out.println("エラー又は取消しがありました");
             }
            
             */
            fileDir = "temp.pdf"; //残さないことを前提とする場合。

            try {
                // 作成開始:
                StructSheet.createPdf(
                        this.mainTitle.getText(),
                        this.subTitle.getText(),
                        this.url.getText(),
                        this.userName.getText(),
                        this.comment.getText(),
                        this.passCodeA.getText(),
                        this.passCodeB.getText(),
                        this.fileDir);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            File file = new File(this.fileDir);
            Desktop desktop = Desktop.getDesktop();
            Thread.sleep(2000);
            desktop.open(file);
            //desktop.print(file);
            Thread.sleep(7000);
            file.delete();

        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcPassA;
    private javax.swing.JButton calcPassB;
    private javax.swing.JTextArea comment;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField mainTitle;
    private javax.swing.JTextField passCodeA;
    private javax.swing.JLabel passCodeALength;
    private javax.swing.JTextField passCodeB;
    private javax.swing.JLabel passCodeBLength;
    private javax.swing.JLabel passCodeLengthTotal;
    private javax.swing.JComboBox passLength;
    private javax.swing.JTextField randomText;
    private javax.swing.JComboBox randomType;
    private javax.swing.JComboBox scanType;
    private javax.swing.JTextField subTitle;
    private javax.swing.JTextField thisPassCode;
    private javax.swing.JTextField url;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
