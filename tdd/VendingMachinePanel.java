package tdd;

import javax.swing.*;

import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VendingMachinePanel extends JFrame {

    private VendingMachinePanel vmp;

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    private VendingMachine vendingMachine;

    public void setUp() throws Exception{
        super.setUp();
        vmp = new VendingMachinePanel();
        vm = new VendingMachine();
    }

    public void testSetVendingMachine(){
        vmp.testSetVendingMachine(vm);
        assertNotNull(vmp.getVendingMachine());
    }
    public JTextField moneyPanel = new JTextField("0");
    public JTextField takebackPanel = new JTextField("0");
    public JButton buttonTakeBack = new JButton("takeback");
    public JButton buttonInsertMoney = new JButton("insertmoney");

    public void testPresentationText(){
        assertEquals("0", vmp.moneyPanel.getText());
        assertEquals("0", vmp.takebackPanel.getText());
        assertEquals("takeback", vmp.buttonTakeBack.getText());
        assertEquals("insertmoney", vmp.buttonInsertMoney.getText());
    }

    public void testInsertMoney(){
        vmp.setVendingMachine(vendingMachine);
        int money = 500;
        vmp.moneyPanel.setText(new Integer(money).toString());
        vmp.buttonInsertMoney.doClick();
        assertEquals(momey, vm.getCurrentMoney());
    }

    public void VendingMachinePanel(){
        buttonInsertMoney,addActionListener(new ActionListener() {
        }){
            public void actionPerformed(ActionEvent e){
                vendingMachine.insertMoney(
                        Integer.parseInt(moneyPanel.getText()));
            }
        };
    }
    private void insertMoney(int money){
        vmp.moneyPanel.setText(
                new Integer(money).toString());
        vmp.buttonInsertMoney.doClick();
    }
    public void testTakeBackMoney(){
        vmp.setVendingMachine(vendingMachine);
        insertMoney(500);
        vmp.buttonTakeBack.doClick();
        assertEquals(0, vendingMachine.getCurrentMoney());
        assertEquals("500", vmp.takebackPanel.getText());
    }


}
