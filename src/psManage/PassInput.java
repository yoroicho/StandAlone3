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
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author 00499
 */
public class PassInput extends javax.swing.JFrame {

    String fileDir;
    Action pasteAction = new DefaultEditorKit.PasteAction();
    Action copyAction = new DefaultEditorKit.CopyAction();
    Action cutAction = new DefaultEditorKit.CutAction();

    /**
     * Creates new form NewJFrame
     */
    public PassInput() {
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

        popupUti = new javax.swing.JPopupMenu();
        mainTitle = new javax.swing.JTextField();
        subTitle = new javax.swing.JTextField();
        url = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        commentScrollPane = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        isOnlyOpen = new javax.swing.JCheckBox();

        pasteAction.putValue(Action.NAME,"貼付");
        popupUti.add(pasteAction);
        copyAction.putValue(Action.NAME,"コピー");
        popupUti.add(copyAction);
        cutAction.putValue(Action.NAME,"切取");
        popupUti.add(cutAction);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainTitleMousePressed(evt);
            }
        });

        subTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subTitleMousePressed(evt);
            }
        });

        url.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                urlMousePressed(evt);
            }
        });

        userName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userNameMousePressed(evt);
            }
        });

        comment.setColumns(20);
        comment.setRows(5);
        comment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                commentMousePressed(evt);
            }
        });
        commentScrollPane.setViewportView(comment);

        randomType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascii", "Alphanumeric", "Alphabetic", "Numeric", "Letters" }));
        randomType.setSelectedIndex(1);
        randomType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                randomTypeItemStateChanged(evt);
            }
        });

        passLength.setEditable(true);
        passLength.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        passLength.setSelectedIndex(15);

        randomText.setText("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$+-./:=?@[]^_`|");
        randomText.setEnabled(false);

        passCodeA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                passCodeACaretUpdate(evt);
            }
        });
        passCodeA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passCodeAMousePressed(evt);
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
        passCodeB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passCodeBMousePressed(evt);
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

        jLabel7.setText("文 字 種");

        passCodeALength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passCodeALength.setText("0");

        passCodeBLength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passCodeBLength.setText("0");

        passCodeLengthTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passCodeLengthTotal.setText("0");

        jLabel8.setText("符号合計");

        jLabel9.setText("文 字 組");

        jLabel10.setText("単位自動取得");

        jLabel11.setText("文字");

        jLabel12.setText("文字");

        jLabel13.setText("摘　　要");

        isOnlyOpen.setText("表示のみ");
        isOnlyOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isOnlyOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(randomType, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passLength, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(userName)
                            .addComponent(subTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(url, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainTitle, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isOnlyOpen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commentScrollPane)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(passCodeB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passCodeBLength, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calcPassB))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addComponent(passCodeA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passCodeLengthTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                    .addComponent(passCodeALength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(calcPassA))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(randomText, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(passLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(passCodeLengthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passCodeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passCodeALength)
                    .addComponent(calcPassA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(passCodeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passCodeBLength)
                    .addComponent(calcPassB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(isOnlyOpen))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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
        if (passCodeA.getText().length() >= 17) {
            passCodeA.setForeground(Color.red);
        } else {
            passCodeA.setForeground(Color.black);
        }
    }//GEN-LAST:event_passCodeACaretUpdate

    private void passCodeBCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passCodeBCaretUpdate
        passCodeBLength.setText(Integer.toString(passCodeB.getText().length()));
        passCodeLengthTotal.setText(Integer.toString(passCodeA.getText().length() + passCodeB.getText().length()));
        if (passCodeB.getText().length() >= 17) {
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
        File file = null;
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
                Logger.getLogger(PassInput.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("a");

            } catch (DocumentException ex) {
                Logger.getLogger(PassInput.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("B");
            } catch (RuntimeException ex) {
                Logger.getLogger(PassInput.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("RuntimeException");
                NotCreateFile notCreateFile = new NotCreateFile(null, true);
                notCreateFile.appendJTextArea(ex.toString());
                notCreateFile.setVisible(true);
                if (file.delete()) {
                    System.out.println("ファイルを削除しました");
                } else {
                    System.out.println("ファイルの削除ができません");
                    delTempFile(file);
                };
            }

            file = new File(this.fileDir);
            Desktop desktop = Desktop.getDesktop();
            Thread.sleep(2000);
            if (this.isOnlyOpen.isSelected()) {
                desktop.open(file);
            } else {
                desktop.print(file);
            }
            Thread.sleep(7000);
            System.out.println("これからファイルを削除します");

            if (file.delete()) {
                System.out.println("ファイルを削除しました");
            } else {
                System.out.println("ファイルの削除ができません");
                delTempFile(file);
            };

        } catch (IOException ex) {
            Logger.getLogger(PassInput.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("c");
        } catch (InterruptedException ex) {
            Logger.getLogger(PassInput.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("D");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void mainTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTitleMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.mainTitle, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_mainTitleMousePressed

    private void subTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subTitleMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.subTitle, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_subTitleMousePressed

    private void urlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urlMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.url, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_urlMousePressed

    private void userNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userNameMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.userName, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_userNameMousePressed

    private void passCodeAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passCodeAMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.passCodeA, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_passCodeAMousePressed

    private void passCodeBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passCodeBMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.passCodeB, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_passCodeBMousePressed

    private void commentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentMousePressed
        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            popupUti.show(this.comment, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_commentMousePressed

    private void isOnlyOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isOnlyOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isOnlyOpenActionPerformed

    private static void delTempFile(File file) {
        FileNotDelete fileNotDelete;
        fileNotDelete = new FileNotDelete(null, true);
        fileNotDelete.setVisible(true);
        System.out.println("これからファイルを削除します");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("ファイルを削除しました");
            } else {
                System.out.println("ファイルの削除ができません");
                delTempFile(file);
            }
        }

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
            java.util.logging.Logger.getLogger(PassInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassInput().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcPassA;
    private javax.swing.JButton calcPassB;
    private javax.swing.JTextArea comment;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JCheckBox isOnlyOpen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mainTitle;
    private javax.swing.JTextField passCodeA;
    private javax.swing.JLabel passCodeALength;
    private javax.swing.JTextField passCodeB;
    private javax.swing.JLabel passCodeBLength;
    private javax.swing.JLabel passCodeLengthTotal;
    private javax.swing.JComboBox passLength;
    private javax.swing.JPopupMenu popupUti;
    private javax.swing.JTextField randomText;
    private javax.swing.JComboBox randomType;
    private javax.swing.JTextField subTitle;
    private javax.swing.JTextField url;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}