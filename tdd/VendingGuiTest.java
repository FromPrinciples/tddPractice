package tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VendingGuiTest extends TestCase{
    public void testPresentation(){
        VendingMachinePanel vmp;
        vmp = new VendingMachinePanel();

        assertNotNull(vmp.moneyPanel);
        assertNotNull(vmp.takebackPanel);
        assertNotNull(vmp.buttonTakeBack);
        assertNotNull(vmp.buttonInsertMoney);
    }
}
