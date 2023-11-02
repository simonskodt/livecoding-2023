import java.util.Set;
import java.util.HashSet;

public class Transaction {
    private String recipient, sender, bank;
    private int amount;
    private boolean isComplete;
    
    public Transaction(String recipient, String sender, int amount) {
        if (recipient == null || sender == null) {
            throw new IllegalArgumentException("*** Afsender eller modtagermangler!");
        }
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
    }
    
    public void completeViaBank(String bank) {
        Set<String> banks = Set.of("Danske bank", "Sydbank", "Nordea");
        
        if (!banks.contains(bank)) {
            throw new IllegalBankException(bank);
        }
        
        this.bank = bank;
        this.isComplete = true;
    }
    
    private void notifyRecipient() throws IncompleteTransactionException {
        if (isComplete) {
            System.out.println("Informerer " + recipient + 
                    " om transaktion fra " + sender + " på " + 
                    amount + "kr (via " + bank + ")");
        } else {
            throw new IncompleteTransactionException();    
        }
    }
    
    public void handleTransaction() {
        System.out.println("Vi håndterer nu din transaktion...");
        try {
            notifyRecipient();
        }
        catch (IncompleteTransactionException e) {
            System.out.println(e.getMessage());
        }
    }
    
}