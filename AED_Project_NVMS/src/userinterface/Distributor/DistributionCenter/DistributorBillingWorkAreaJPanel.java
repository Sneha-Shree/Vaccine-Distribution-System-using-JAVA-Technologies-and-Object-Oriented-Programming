/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Distributor.DistributionCenter;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DistributorBillingOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DistributorBillingWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bharg
 */
public class DistributorBillingWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DistributorBillingWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account; 
    private DistributorBillingOrganization distributorBillingOrganization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public DistributorBillingWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DistributorBillingOrganization distributorBillingOrganization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.account= account;
        this.distributorBillingOrganization= distributorBillingOrganization;
        this.enterprise = enterprise;
        this.business= business;
        this.network = network;
        populateTbl();
    }

    void populateTbl()
    {
        DefaultTableModel dtm = (DefaultTableModel) distBillingJTbl.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: network.getWorkQueue().getWorkRequestList())
        {
            if(wr instanceof DistributorBillingWorkRequest)
            {
                Object row[] = new Object[5];
                row[0]= wr.getEnterpeise().getName();
                row[1]= wr.getVaccine();
                row[2]= wr.getStatus();
                row[3]=((DistributorBillingWorkRequest) wr).getPrice();
                row[4]= wr.getSender();
                dtm.addRow(row);
            }
        }
    }
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        distBillingJTbl = new javax.swing.JTable();

        distBillingJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Vaccine", "Status", "Price", "Sender"
            }
        ));
        jScrollPane1.setViewportView(distBillingJTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable distBillingJTbl;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}