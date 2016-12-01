/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

/**
 *
 * @author tokyo
 */
public class EncryptionSaveOkCancelDialog extends javax.swing.JDialog {

    /**
     * @param fileXML the fileXML to set
     */
    public void setFileXML(File fileXML) {
        this.fileXML = fileXML;
    }

    public void setJTextFieldTagText(String tag) {
        jTextFieldTag.setText(tag);
    }

    /**
     * @param mainTitle the mainTitle to set
     */
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    /**
     * @param subTitle the subTitle to set
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param passCodeA the passCodeA to set
     */
    public void setPassCodeA(String passCodeA) {
        this.passCodeA = passCodeA;
    }

    /**
     * @param passCodeB the passCodeB to set
     */
    public void setPassCodeB(String passCodeB) {
        this.passCodeB = passCodeB;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    private String mainTitle;
    private String subTitle;
    private String url;
    private String userName;
    private String passCodeA;
    private String passCodeB;
    private String comment;

    private File fileXML;

    /**
     * Write to XML file on Encryption.
     */
    private void writeFile() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String strDate = sdf.format(cal.getTime());
        Properties prop = new Properties();
        try {
            prop.setProperty("tg", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), this.jTextFieldTag.getText()));
            prop.setProperty("mt", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), mainTitle));
            prop.setProperty("st", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), subTitle));
            prop.setProperty("up", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), url));
            prop.setProperty("un", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), userName));
            prop.setProperty("pc", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), passCodeA + passCodeB));
            prop.setProperty("ct", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), comment));
            prop.setProperty("tm", CipherAES128.encrypteCipherAES128(this.jTextFieldPreKey.getText(), strDate));

        } catch (Exception ex) {
            Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (OutputStream os = new FileOutputStream(fileXML)) {
            prop.storeToXML(os, "");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form EncryptionSaveOkCancelDialog
     */
    public EncryptionSaveOkCancelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTag = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPreKey = new javax.swing.JTextField();
        jButtonKeyGenerate = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("TAG");

        jTextFieldTag.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldTagCaretUpdate(evt);
            }
        });
        jTextFieldTag.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldTagInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTextFieldTag.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldTagPropertyChange(evt);
            }
        });

        jLabel2.setText("KEY");

        jTextFieldPreKey.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldPreKeyCaretUpdate(evt);
            }
        });

        jButtonKeyGenerate.setText("KEY GENERATE");
        jButtonKeyGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKeyGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 238, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTag)
                            .addComponent(jTextFieldPreKey)
                            .addComponent(jButtonKeyGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPreKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonKeyGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            System.out.println("Writeing");
            writeFile();
        } catch (Exception ex) {
            Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        doClose(RET_CANCEL);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jTextFieldTagInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldTagInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldTagInputMethodTextChanged

    private void jTextFieldTagPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldTagPropertyChange

    }//GEN-LAST:event_jTextFieldTagPropertyChange

    private void jTextFieldTagCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldTagCaretUpdate
        System.out.println("Change");
        if ((jTextFieldTag.getText().length()) > 6) {
            jTextFieldTag.setBackground(Color.yellow);
        } else {
            jTextFieldTag.setBackground(Color.white);
        }
    }//GEN-LAST:event_jTextFieldTagCaretUpdate

    private void jButtonKeyGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKeyGenerateActionPerformed
        jTextFieldPreKey.setText(
                StructSheet.getPassCode("Ascii", null, 16)
        );
    }//GEN-LAST:event_jButtonKeyGenerateActionPerformed

    private void jTextFieldPreKeyCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldPreKeyCaretUpdate
        System.out.println("16check");
        if (jTextFieldPreKey.getText().length() != 16) {
            this.jTextFieldPreKey.setForeground(Color.red);
            this.okButton.setEnabled(false);
        } else {
            this.jTextFieldPreKey.setForeground(Color.black);
            this.okButton.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldPreKeyCaretUpdate

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
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
            java.util.logging.Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptionSaveOkCancelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EncryptionSaveOkCancelDialog dialog = new EncryptionSaveOkCancelDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButtonKeyGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldPreKey;
    private javax.swing.JTextField jTextFieldTag;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
