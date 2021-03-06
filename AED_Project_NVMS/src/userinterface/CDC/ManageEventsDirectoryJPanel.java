/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CDC;

import Business.EcoSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Events.EventManagement;
import Business.Events.Events;
import Business.Inventory.RequestedVaccineQty;
import Business.Network.Network;
import Business.WorkQueue.CDCEventInventoryWorkRequest;
import Business.vaccine.Vaccine;
import java.awt.CardLayout;
import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bharg
 */
public class ManageEventsDirectoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEventsDirectoryJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Network network;
    private Vaccine selectedVaccine;
    private EcoSystem system;
    private HospitalEnterprise selectedHospitalEnterprise;
    private ArrayList<RequestedVaccineQty> vaccineRequestedArrayList;
    private boolean checkVaccineRequested = false;
    int totalVaccineRemains = 0, capacityEvent = 0;

    public ManageEventsDirectoryJPanel(JPanel userProcessContainer, Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.system = system;
        populatetbl();
        selectedVaccine = (Vaccine) jComboBoxVaccine.getSelectedItem();
        vaccineRequestedArrayList = new ArrayList<>();
        populateVaccineCombobox();
        populateEventLocation();
        
        
        jTextFieldVaccineQuantity.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        jTextFieldEventCapacity.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        
    }

    public void populateEventLocation() {
        jComboBoxEventLocation.removeAllItems();
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof HospitalEnterprise) {
                jComboBoxEventLocation.addItem(((HospitalEnterprise) e));
            }
        }
    }

    public void populatetbl() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tblEvents.getModel();
            dtm.setRowCount(0);
            for (Events e : network.getEventsDirectory().getEventList()) {
                Object row[] = new Object[4];
                row[0] = e;
                row[1] = e.getStartDate();
                row[2] = e.getHospitalEnterprise();
                row[3] = e.getCapacity();
                dtm.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There are no events yet");
        }
    }

    public void populateVaccineRequestTable() {
        DefaultTableModel dtm = (DefaultTableModel) jTableEventInventory.getModel();
        dtm.setRowCount(0);
        for (RequestedVaccineQty qty : vaccineRequestedArrayList) {
            Object row[] = new Object[5];
            row[0] = qty.getVaccine();
            row[1] = qty.getVaccine().getDisease();
            row[2] = qty.getRequestedQty();
            row[3] = qty;
            row[4] = qty.getStatus();
            dtm.addRow(row);
        }
    }

    public void populateVaccineCombobox() {
        jComboBoxVaccine.removeAllItems();
        for (Vaccine v : system.getVaccineDirectory().getVaccineList()) {
            jComboBoxVaccine.addItem(v);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtEventName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jButtonCreateEvent = new javax.swing.JButton();
        jComboBoxEventLocation = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEventCapacity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxVaccine = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVaccineQuantity = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEventInventory = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonRequestVaccine = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonShowEventInventory = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblEvents.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Name", "Start Date", "Event Location", "Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEvents.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEvents);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Event Name:");

        txtEventName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEventName.setForeground(new java.awt.Color(255, 153, 0));
        txtEventName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Start Date:");

        txtStartDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStartDate.setForeground(new java.awt.Color(255, 153, 0));

        jButtonCreateEvent.setBackground(new java.awt.Color(255, 153, 0));
        jButtonCreateEvent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCreateEvent.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreateEvent.setText("Create Event");
        jButtonCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateEventActionPerformed(evt);
            }
        });

        jComboBoxEventLocation.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxEventLocation.setForeground(new java.awt.Color(255, 153, 0));
        jComboBoxEventLocation.setMaximumRowCount(200);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Event Location");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Event Capacity");

        jTextFieldEventCapacity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldEventCapacity.setForeground(new java.awt.Color(255, 153, 0));
        jTextFieldEventCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEventCapacityActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Events (Mobile Camps)");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Request Vaccines for the event");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Vaccine");

        jComboBoxVaccine.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxVaccine.setForeground(new java.awt.Color(255, 153, 0));
        jComboBoxVaccine.setMaximumRowCount(200);
        jComboBoxVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVaccineActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Quantity");

        jTextFieldVaccineQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldVaccineQuantity.setForeground(new java.awt.Color(255, 153, 0));

        jTableEventInventory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableEventInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine", "Disease", "Quantity", "Object", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEventInventory.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEventInventory);
        if (jTableEventInventory.getColumnModel().getColumnCount() > 0) {
            jTableEventInventory.getColumnModel().getColumn(3).setMinWidth(0);
            jTableEventInventory.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTableEventInventory.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Event Inventory");

        jButtonRequestVaccine.setBackground(new java.awt.Color(255, 153, 0));
        jButtonRequestVaccine.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRequestVaccine.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRequestVaccine.setText("Request Vaccine");
        jButtonRequestVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRequestVaccineActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("dd/mm/yyyy");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Events");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Create new event");

        jButtonShowEventInventory.setBackground(new java.awt.Color(255, 153, 0));
        jButtonShowEventInventory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonShowEventInventory.setForeground(new java.awt.Color(255, 255, 255));
        jButtonShowEventInventory.setText("Show Event Inventory");
        jButtonShowEventInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowEventInventoryActionPerformed(evt);
            }
        });

        backjButton1.setBackground(new java.awt.Color(255, 153, 0));
        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEventName)
                                        .addComponent(txtStartDate)
                                        .addComponent(jComboBoxEventLocation, 0, 158, Short.MAX_VALUE)
                                        .addComponent(jTextFieldEventCapacity)))
                                .addComponent(jButtonCreateEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxVaccine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldVaccineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButtonRequestVaccine)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonShowEventInventory))))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backjButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jButtonShowEventInventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEventLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldEventCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldVaccineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRequestVaccine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCreateEvent))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEventNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventNameActionPerformed

    private void jButtonCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateEventActionPerformed
        DistributorEnterprise distributorEnterprise;
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof DistributorEnterprise) {
                distributorEnterprise = (DistributorEnterprise) e;
            }
        }
        
          Date date = null;
        if (!txtStartDate.getText().equals("")) {
            String format = "dd/MM/yyyy";
            String createFlightTimeValidate = txtStartDate.getText();

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            //Date date = null;
            try {
                date = sdf.parse(createFlightTimeValidate);
            } catch (ParseException ex) {
               // Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (checkVaccineRequested) {
            try {
                selectedHospitalEnterprise = (HospitalEnterprise) jComboBoxEventLocation.getSelectedItem();
                if (selectedHospitalEnterprise.isHospitalApproved()) {
                    String eventName = null, sd = null;
                    int eventCapacity = 0;
                    boolean checkName = false, checkStartDate = false, checkEventCapacity = false;

                    if (txtEventName.getText().length() > 0) {
                        eventName = txtEventName.getText();
                        checkName = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Event name cannot be empty");
                        checkName = false;
                    }

                    if (txtStartDate.getText().length() > 0) {
                        sd = txtStartDate.getText();
                        checkStartDate = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Event date cannot be empty");
                        checkStartDate = false;
                    }
                    
                    if (date == null) {
                        JOptionPane.showMessageDialog(null, "Please enter valid date");
                        return;
                    }

                    if (Integer.parseInt(jTextFieldEventCapacity.getText()) > 0) {
                        eventCapacity = Integer.parseInt(jTextFieldEventCapacity.getText());
                        checkEventCapacity = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Event capacity cannot be empty");
                        checkEventCapacity = false;
                    }

                    if (checkName && checkStartDate && checkEventCapacity) {
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date startDate = df.parse(sd);
                        System.out.println(network.getName());
                        Events eve = network.getEventsDirectory().addEvents();
                        eve.setName(eventName);
                        eve.setStartDate(startDate);
                        eve.setCapacity(eventCapacity);
                        eve.setEventManagement(new EventManagement());
                        eve.setHospitalEnterprise(selectedHospitalEnterprise);
                        eve.setVaccineInventoryArrayList(vaccineRequestedArrayList);
                        populatetbl();

                        txtEventName.setText("");
                        txtStartDate.setText("");
                        jTextFieldEventCapacity.setText("");

                        for (RequestedVaccineQty qty : vaccineRequestedArrayList) {
                            CDCEventInventoryWorkRequest workRequest = new CDCEventInventoryWorkRequest();
                            workRequest.setEnterpeise(enterprise);
                            //workRequest.setOrganization(enterprise);
                            workRequest.setRequestDate(new Date());
                            workRequest.setStatus("Requested to Distributor");
                            workRequest.setRequestedQty(qty.getRequestedQty());
                            workRequest.setVaccine(qty.getVaccine());
                            workRequest.setEvents(eve);
                            network.getWorkQueue().getWorkRequestList().add(workRequest);
                        }
                        
                          JOptionPane.showMessageDialog(null, "Event added successfully.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Event cannot be created at this hospital, as it is not yet approved by PHD");
                    vaccineRequestedArrayList.clear();
                    populateVaccineRequestTable();
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Input cannot be parsed, kindly enter in dd/MM/yyyy format");
                txtStartDate.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Request some vaccines");
        }
    }//GEN-LAST:event_jButtonCreateEventActionPerformed

    private void jComboBoxVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVaccineActionPerformed
        // TODO add your handling code here:
        selectedVaccine = (Vaccine) jComboBoxVaccine.getSelectedItem();
    }//GEN-LAST:event_jComboBoxVaccineActionPerformed

    private void jButtonRequestVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRequestVaccineActionPerformed
        // TODO add your handling code here:
        int vaccineQty = 0, capacityEvent = 0;
        boolean checkVaccineQty = false;
        if (Integer.parseInt(jTextFieldEventCapacity.getText()) > 0) {
            capacityEvent = Integer.parseInt(jTextFieldEventCapacity.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Event capacity cannot be empty");
        }

        if (Integer.parseInt(jTextFieldVaccineQuantity.getText()) > 0) {
            vaccineQty = Integer.parseInt(jTextFieldVaccineQuantity.getText());
            checkVaccineQty = true;
        } else {
            JOptionPane.showMessageDialog(null, "Vaccine Quantity should be greater than 0");
            checkVaccineQty = false;
        }

        if (checkVaccineQty) {
            for (RequestedVaccineQty qty : vaccineRequestedArrayList) {
                totalVaccineRemains += qty.getRequestedQty();
            }
            boolean vaccineFound = false;
            for (RequestedVaccineQty qty : vaccineRequestedArrayList) {
                if (qty.getVaccine().equals(selectedVaccine)) {
                    qty.setRequestedQty(qty.getRequestedQty() + vaccineQty);
                    vaccineFound = true;
                }
            }
            if (!vaccineFound) {
                System.out.println("totalVaccineRemains " + totalVaccineRemains);
                //System.out.println("totalVaccineRemains " +totalVaccineRemains);
                System.out.println("(capacityEvent - totalVaccineRemains) " + (capacityEvent - totalVaccineRemains));
                if ((capacityEvent - totalVaccineRemains) >= 0) {
                    RequestedVaccineQty requestedVaccineQty = new RequestedVaccineQty();
                    requestedVaccineQty.setVaccine(selectedVaccine);
                    requestedVaccineQty.setRequestedQty(vaccineQty);
                    requestedVaccineQty.setStatus("Requested to Distributor");
                    vaccineRequestedArrayList.add(requestedVaccineQty);
                    populateVaccineRequestTable();
                    checkVaccineRequested = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Vaccine Quantity cannot exceed Event capacity");
                }
            }
            jTextFieldVaccineQuantity.setText("");
        } else {
            checkVaccineRequested = false;
        }
    }//GEN-LAST:event_jButtonRequestVaccineActionPerformed

    private void jTextFieldEventCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEventCapacityActionPerformed
        // TODO add your handling code here:
        //capacityEvent = Integer.parseInt(jTextFieldEventCapacity.getText());
    }//GEN-LAST:event_jTextFieldEventCapacityActionPerformed

    private void jButtonShowEventInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowEventInventoryActionPerformed
        // TODO add your handling code here:
        if (tblEvents.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Kindly select an event");
        } else {
            Events events = (Events) tblEvents.getValueAt(tblEvents.getSelectedRow(), 0);
            DefaultTableModel dtm = (DefaultTableModel) jTableEventInventory.getModel();
            dtm.setRowCount(0);
            for (RequestedVaccineQty qty : events.getVaccineInventoryArrayList()) {
                Object row[] = new Object[5];
                row[0] = qty.getVaccine();
                row[1] = qty.getVaccine().getDisease();
                row[2] = qty.getRequestedQty();
                row[3] = qty;
                row[4] = qty.getStatus();
                dtm.addRow(row);
            }
        }
    }//GEN-LAST:event_jButtonShowEventInventoryActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton jButtonCreateEvent;
    private javax.swing.JButton jButtonRequestVaccine;
    private javax.swing.JButton jButtonShowEventInventory;
    private javax.swing.JComboBox jComboBoxEventLocation;
    private javax.swing.JComboBox jComboBoxVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventInventory;
    private javax.swing.JTextField jTextFieldEventCapacity;
    private javax.swing.JTextField jTextFieldVaccineQuantity;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
