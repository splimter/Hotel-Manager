/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author splimter
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private ArrayList<Emp> emp = new ArrayList<>();
    private ArrayList<Room> room = new ArrayList<>();
    private DefaultTableModel model;
    Object[] rowdata;
    private String idFromUserTab;

    private void fillTableEmp() {
        ((DefaultTableModel) tableEmp.getModel()).setRowCount(0);

        try {
            emp = DBMan.getAllEmp();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        model = (DefaultTableModel) tableEmp.getModel();
        rowdata = new Object[6];
        for (int i = 0; i < emp.size(); i++) {
            rowdata[0] = emp.get(i).id;
            rowdata[1] = emp.get(i).fullname;
            rowdata[2] = emp.get(i).user;
            rowdata[3] = emp.get(i).pwd;
            rowdata[4] = emp.get(i).ciid;
            rowdata[5] = emp.get(i).role;
            model.addRow(rowdata);
        }

    }

    private void fillTableRoom() {
        ((DefaultTableModel) tableRooms.getModel()).setRowCount(0);
        try {
            room = DBMan.getAllRoom();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        model = (DefaultTableModel) tableRooms.getModel();
        rowdata = new Object[3];
        for (int i = 0; i < room.size(); i++) {
            rowdata[0] = room.get(i).id;
            rowdata[1] = room.get(i).type;
            rowdata[2] = room.get(i).clientID;

            model.addRow(rowdata);
        }
    }

    public Main(String[] data) {
        initComponents();
        this.setLocationRelativeTo(null);

        panelAddUser.setVisible(false);
        panelOverview.setVisible(false);
        panelWelcome.setVisible(true);

        lblFName.setText(data[1]);
        System.out.println(data[2]);
        if (data[2].equals("Admin")) {
            btnAdminSection.setVisible(true);
        } else {
            btnAdminSection.setVisible(false);
        }

        fillTableEmp();
        fillTableRoom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblFName = new javax.swing.JLabel();
        btnAdminSection = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelWelcome = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelOverview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRooms = new javax.swing.JTable();
        btnAddC = new javax.swing.JButton();
        btnUpdateC = new javax.swing.JButton();
        btnDelC = new javax.swing.JButton();
        btnRefreshTable = new javax.swing.JButton();
        panelAddUser = new javax.swing.JPanel();
        txtFullName = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPWD = new javax.swing.JTextField();
        cbRole = new javax.swing.JComboBox<>();
        txtCIID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblErr = new javax.swing.JLabel();
        btnAddUpdateUser = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        btnAddUpdateUser1 = new javax.swing.JButton();
        cbUroomId = new javax.swing.JComboBox<>();
        cbUroomType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbAddRoomType = new javax.swing.JComboBox<>();
        btnAddRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jButton1.setText("Room Overview");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExit.setText("Logout");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblFName.setText("$fname");

        btnAdminSection.setText("Admin Section");
        btnAdminSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminSectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(lblFName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(btnAdminSection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addComponent(lblFName))
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdminSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        panelWelcome.setBackground(new java.awt.Color(0, 204, 255));
        panelWelcome.setPreferredSize(new java.awt.Dimension(747, 516));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setText("Welcome");

        javax.swing.GroupLayout panelWelcomeLayout = new javax.swing.GroupLayout(panelWelcome);
        panelWelcome.setLayout(panelWelcomeLayout);
        panelWelcomeLayout.setHorizontalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWelcomeLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel6)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        panelWelcomeLayout.setVerticalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWelcomeLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(224, 224, 224))
        );

        panelOverview.setBackground(new java.awt.Color(0, 102, 255));
        panelOverview.setPreferredSize(new java.awt.Dimension(747, 516));

        tableRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "room id", "type", "client name", "client CIID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRooms.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableRooms);
        if (tableRooms.getColumnModel().getColumnCount() > 0) {
            tableRooms.getColumnModel().getColumn(0).setResizable(false);
            tableRooms.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableRooms.getColumnModel().getColumn(1).setResizable(false);
            tableRooms.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        btnAddC.setText("Add");
        btnAddC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCActionPerformed(evt);
            }
        });

        btnUpdateC.setText("Update");

        btnDelC.setText("Delete");

        btnRefreshTable.setText("Refresh");

        javax.swing.GroupLayout panelOverviewLayout = new javax.swing.GroupLayout(panelOverview);
        panelOverview.setLayout(panelOverviewLayout);
        panelOverviewLayout.setHorizontalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelOverviewLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(btnAddC)
                .addGap(57, 57, 57)
                .addComponent(btnUpdateC)
                .addGap(58, 58, 58)
                .addComponent(btnDelC)
                .addGap(57, 57, 57)
                .addComponent(btnRefreshTable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOverviewLayout.setVerticalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOverviewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAddC)
                    .addComponent(btnUpdateC)
                    .addComponent(btnDelC)
                    .addComponent(btnRefreshTable))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelAddUser.setBackground(new java.awt.Color(51, 153, 255));

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Client Service", "Reception", "Maintainer " }));

        jLabel1.setText("Full Name");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("CIID");

        jLabel5.setText("Role");

        lblErr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAddUpdateUser.setText("Add User");
        btnAddUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUpdateUserActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Full name", "Username", "Password", "CIID", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableEmp);
        if (tableEmp.getColumnModel().getColumnCount() > 0) {
            tableEmp.getColumnModel().getColumn(0).setResizable(false);
            tableEmp.getColumnModel().getColumn(0).setPreferredWidth(1);
            tableEmp.getColumnModel().getColumn(5).setResizable(false);
        }

        btnAddUpdateUser1.setText("Add User");
        btnAddUpdateUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUpdateUser1ActionPerformed(evt);
            }
        });

        cbUroomId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        cbUroomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standart", "Lux", "Bussines", " " }));

        jLabel7.setText("Change Room Type");

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jLabel8.setText("Add Room");

        cbAddRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standart", "Lux", "Bussines" }));

        btnAddRoom.setText("Add a Room");
        btnAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddUserLayout = new javax.swing.GroupLayout(panelAddUser);
        panelAddUser.setLayout(panelAddUserLayout);
        panelAddUserLayout.setHorizontalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddUserLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAddUpdateUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddUserLayout.createSequentialGroup()
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCIID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbRole, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)
                                    .addComponent(txtPWD, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(panelAddUserLayout.createSequentialGroup()
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbAddRoomType, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)
                                    .addComponent(cbUroomId, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbUroomType, 0, 100, Short.MAX_VALUE)
                                    .addComponent(btnAddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelAddUserLayout.setVerticalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddUserLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUroomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUroomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAddRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddRoom))
                .addGap(59, 59, 59)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPWD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCIID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErr, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUpdateUser)
                    .addComponent(btnClear)
                    .addComponent(btnAddUpdateUser1))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(panelAddUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(panelWelcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelOverview, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelAddUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(panelOverview, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(panelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Login.main(new String[1]);
        this.dispose();

    }//GEN-LAST:event_btnExitActionPerformed

    private void clear() {
        txtFullName.setText("");
        txtUser.setText("");
        txtPWD.setText("");
        txtCIID.setText("");
        cbRole.setSelectedIndex(0);
        lblErr.setText("");
        btnAddUpdateUser.setText("Add");
    }

    private boolean chkField() {
        if (txtFullName.getText().equals("")) {
            lblErr.setText("Full Name must not be empty");
        } else if (txtUser.getText().equals("")) {
            lblErr.setText("User Name must not be empty");
        } else if (txtPWD.getText().equals("")) {
            lblErr.setText("Password must not be empty");
        } else if (txtCIID.getText().equals("")) {
            lblErr.setText("CIID must not be empty");
        } else {
            return true;
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        panelAddUser.setVisible(false);
        panelOverview.setVisible(true);
        panelWelcome.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void btnAdminSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminSectionActionPerformed
        // TODO add your handling code here:
        panelOverview.setVisible(false);
        panelAddUser.setVisible(true);
        panelWelcome.setVisible(false);
    }//GEN-LAST:event_btnAdminSectionActionPerformed

    private void btnAddUpdateUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUpdateUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddUpdateUser1ActionPerformed

    private void tableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseClicked
        // TODO add your handling code here:
        idFromUserTab = tableEmp.getModel().getValueAt(tableEmp.getSelectedRow(), 0).toString();
        String[] currentUser = new String[5];
        try {
            currentUser = DBMan.getEmp(Integer.valueOf(idFromUserTab));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtFullName.setText(currentUser[0]);
        txtUser.setText(currentUser[1]);
        txtPWD.setText(currentUser[2]);

        switch (currentUser[3]) {
            case "Admin":
                cbRole.setSelectedIndex(0);
                break;
            case "Client Service":
                cbRole.setSelectedIndex(1);
                break;
            case "Reception":
                cbRole.setSelectedIndex(2);
                break;
            case "Maintainer":
                cbRole.setSelectedIndex(3);
                break;
        }
        txtCIID.setText(currentUser[4]);
        btnAddUpdateUser.setText("Update");
    }//GEN-LAST:event_tableEmpMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUpdateUserActionPerformed
        // TODO add your handling code here:
        if (chkField()) {
            String[] s = new String[]{txtFullName.getText(), txtUser.getText(),
                txtPWD.getText(), String.valueOf(cbRole.getSelectedItem()), txtCIID.getText()};
            try {
                if (DBMan.getEmp(txtUser.getText())) {

                    if (btnAddUpdateUser.getText().equals("Add")) {
                        DBMan.addUser(s);
                    } else {
                        DBMan.updateUser(s, this.idFromUserTab);
                    }
                    fillTableEmp();
                    clear();

                } else {
                    if (btnAddUpdateUser.getText().equals("Update")) {
                        DBMan.updateUser(s, this.idFromUserTab);
                        fillTableEmp();
                        clear();
                    } else {
                        lblErr.setText("User name already existe!");
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnAddUpdateUserActionPerformed

    private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomActionPerformed
        try {
            // TODO add your handling code here:
            DBMan.addRoom(String.valueOf(cbAddRoomType.getSelectedItem()));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddRoomActionPerformed

    private void btnAddCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCActionPerformed
        // TODO add your handling code here:
        Serve.main();
    }//GEN-LAST:event_btnAddCActionPerformed

    /**
     * @param data
     */
    public static void main(String[] data) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main(data).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddC;
    private javax.swing.JButton btnAddRoom;
    private javax.swing.JButton btnAddUpdateUser;
    private javax.swing.JButton btnAddUpdateUser1;
    private javax.swing.JButton btnAdminSection;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelC;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefreshTable;
    private javax.swing.JButton btnUpdateC;
    private javax.swing.JComboBox<String> cbAddRoomType;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JComboBox<String> cbUroomId;
    private javax.swing.JComboBox<String> cbUroomType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErr;
    private javax.swing.JLabel lblFName;
    private javax.swing.JPanel panelAddUser;
    private javax.swing.JPanel panelOverview;
    private javax.swing.JPanel panelWelcome;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTable tableRooms;
    private javax.swing.JTextField txtCIID;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPWD;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
