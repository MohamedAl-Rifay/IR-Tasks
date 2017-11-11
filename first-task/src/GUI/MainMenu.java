package GUI;

//<editor-fold defaultstate="collapsed" desc="Imports">
import Task1.Util.*;
import java.io.*;
import java.util.*;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.table.*;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.Keymap;
//</editor-fold>

public class MainMenu extends javax.swing.JFrame {

//<editor-fold defaultstate="collapsed" desc="Variables declaration">
    ArrayList<Document> allDocs;
    DefaultTableModel Table_Program1_model, Table_Program2_model;
    DocumentMatrix Matrix;
    DocumentSet Set;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructor">
    public MainMenu() {

        allDocs = new ArrayList<>();
        Matrix = new DocumentMatrix();
        Set = new DocumentSet();
        initComponents();
        ImageIcon img = new ImageIcon(getClass().getResource("/GUI/icon.png"));
        this.setIconImage(img.getImage());
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            @Override
            public int getSize() {
                return allDocs.size();
            }

            @Override
            public String getElementAt(int i) {
                return allDocs.get(i).getTitle();
            }
        });
        Table_Program1_model = new DefaultTableModel(new Object[][]{}, new String[]{"Term", "Posting list"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        Table_Program2_model = new DefaultTableModel(new Object[][]{}, new String[]{"Term", "Boolean vector"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        Table_Program1.setModel(Table_Program1_model);
        Table_Program2.setModel(Table_Program2_model);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_AddDoc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TA_Doc = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TA_Tokens = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        TF_Program1_Query = new javax.swing.JTextField();
        Btn_Program1_Search = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table_Program1 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TA_Program1_Result = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        TF_Program2_Query = new javax.swing.JTextField();
        Btn_Program2_Search = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Table_Program2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_Bitwise_function = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TA_Program2_Result = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IR - Task 1");
        setLocationByPlatform(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(200, 290));
        jPanel6.setLayout(new java.awt.BorderLayout());

        btn_AddDoc.setText("Add Document");
        btn_AddDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddDocActionPerformed(evt);
            }
        });
        jPanel6.add(btn_AddDoc, java.awt.BorderLayout.NORTH);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 23));
        jPanel4.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel4.setPreferredSize(new java.awt.Dimension(460, 23));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Document");
        jPanel4.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel4);

        TA_Doc.setColumns(20);
        TA_Doc.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TA_Doc.setRows(5);
        TA_Doc.setToolTipText("Document");
        jScrollPane3.setViewportView(TA_Doc);

        jPanel7.add(jScrollPane3);

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 23));
        jPanel5.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel5.setPreferredSize(new java.awt.Dimension(460, 23));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tokens");
        jPanel5.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel5);

        TA_Tokens.setColumns(20);
        TA_Tokens.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TA_Tokens.setLineWrap(true);
        TA_Tokens.setRows(5);
        TA_Tokens.setToolTipText("Tokens");
        TA_Tokens.setWrapStyleWord(true);
        jScrollPane4.setViewportView(TA_Tokens);

        jPanel7.add(jScrollPane4);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Documents", jPanel1);

        TF_Program1_Query.setToolTipText("Query");
        TF_Program1_Query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Program1_QueryActionPerformed(evt);
            }
        });

        Btn_Program1_Search.setText("Search");
        Btn_Program1_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Program1_SearchActionPerformed(evt);
            }
        });

        jPanel10.setLayout(new java.awt.GridLayout(1, 5));

        Table_Program1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(Table_Program1);

        jPanel10.add(jScrollPane7);

        jLabel4.setText("Matched Documents :-");

        TA_Program1_Result.setEditable(false);
        TA_Program1_Result.setColumns(20);
        TA_Program1_Result.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TA_Program1_Result.setRows(5);
        jScrollPane8.setViewportView(TA_Program1_Result);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TF_Program1_Query)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Program1_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Program1_Query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Program1_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Program 1", jPanel2);

        TF_Program2_Query.setToolTipText("Query");
        TF_Program2_Query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Program2_QueryActionPerformed(evt);
            }
        });

        Btn_Program2_Search.setText("Search");
        Btn_Program2_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Program2_SearchActionPerformed(evt);
            }
        });

        jPanel8.setLayout(new java.awt.GridLayout(1, 5));

        Table_Program2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Table_Program2);

        jPanel8.add(jScrollPane5);

        jLabel1.setText("Bitwise function :-");

        TF_Bitwise_function.setEditable(false);

        jLabel2.setText("Matched Documents :-");

        TA_Program2_Result.setEditable(false);
        TA_Program2_Result.setColumns(20);
        TA_Program2_Result.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TA_Program2_Result.setRows(5);
        jScrollPane6.setViewportView(TA_Program2_Result);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(202, Short.MAX_VALUE))
                    .addComponent(TF_Bitwise_function)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(TF_Bitwise_function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TF_Program2_Query)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Program2_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Program2_Query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Program2_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Program 2", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Actions">
    private void btn_AddDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddDocActionPerformed
        JFileChooser open = new JFileChooser();
        open.setDialogTitle("Choose a text file");
        open.setDialogType(JFileChooser.OPEN_DIALOG);
        open.setMultiSelectionEnabled(true);
        open.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getAbsolutePath().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text files only(.txt)";
            }
        });
        open.setAcceptAllFileFilterUsed(false);
        open.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (open.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                for (File selectedFile : open.getSelectedFiles()) {
                    Scanner reader = new Scanner(selectedFile);
                    reader.useDelimiter("\\A");
                    Document d = new Document(selectedFile.getName(), reader.hasNext() ? reader.next() : "");
                    allDocs.add(d);
                    Matrix.addDocument(d);
                    Set.addDocument(d);
                    jList1.updateUI();
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_btn_AddDocActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (evt.getValueIsAdjusting()) {
            Document d = allDocs.get(jList1.getSelectedIndex());
            TA_Doc.setText(d.getDoc());
            TA_Tokens.setText(d.getWords() + "");
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void Btn_Program2_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Program2_SearchActionPerformed
        ArrayList<Document> result = Matrix.ExcuteQuery(TF_Program2_Query.getText());
        Table_Program2_model.setRowCount(0);
        for (Map.Entry<String, ArrayList<Boolean>> entry : Matrix.getMatrix().entrySet()) {
            if (entry.getKey().equals("")) {
                break;
            }
            Table_Program2_model.addRow(new String[]{entry.getKey(), " " + entry.getValue()});
        }
        TF_Bitwise_function.setText(result.isEmpty() ? "" : Matrix.getBooleanResult() + "");
        String data = "";
        if (result.isEmpty()) {
            data = "No matched documents !";
        }
        for (int i = 0; i < result.size(); i++) {
            data += 1 + i + " - " + result.get(i).getTitle() + "\n";
        }
        TA_Program2_Result.setText(data);
    }//GEN-LAST:event_Btn_Program2_SearchActionPerformed

    private void Btn_Program1_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Program1_SearchActionPerformed
        LinkedHashSet<Document> result = Set.ExcuteQuery(TF_Program1_Query.getText());
        Table_Program1_model.setRowCount(0);
        for (Map.Entry<String, LinkedHashSet<Document>> entry : Set.getQueryPostingList().entrySet()) {
            if (entry.getKey().equals("")) {
                break;
            }
            Table_Program1_model.addRow(new String[]{entry.getKey() + "=" + entry.getValue().size(), " " + entry.getValue()});
        }
        String data = "";
        int i = 1;
        if (result.isEmpty()) {
            data = "No matched documents !";
        }
        for (Document document : result) {
            data += i++ + " - " + document.getTitle() + "\n";
        }
        TA_Program1_Result.setText(data);
    }//GEN-LAST:event_Btn_Program1_SearchActionPerformed

    private void TF_Program2_QueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Program2_QueryActionPerformed
        Btn_Program2_Search.doClick();
    }//GEN-LAST:event_TF_Program2_QueryActionPerformed

    private void TF_Program1_QueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Program1_QueryActionPerformed
        Btn_Program1_Search.doClick();
    }//GEN-LAST:event_TF_Program1_QueryActionPerformed
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Program1_Search;
    private javax.swing.JButton Btn_Program2_Search;
    private javax.swing.JTextArea TA_Doc;
    private javax.swing.JTextArea TA_Program1_Result;
    private javax.swing.JTextArea TA_Program2_Result;
    private javax.swing.JTextArea TA_Tokens;
    private javax.swing.JTextField TF_Bitwise_function;
    private javax.swing.JTextField TF_Program1_Query;
    private javax.swing.JTextField TF_Program2_Query;
    private javax.swing.JTable Table_Program1;
    private javax.swing.JTable Table_Program2;
    private javax.swing.JButton btn_AddDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

}
