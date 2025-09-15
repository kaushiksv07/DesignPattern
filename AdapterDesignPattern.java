Adapter Design pattern  and Facade Design pattern

These are structure design pattern
That allows two incompatible interfaces to work together by providing a bridge (adapter class) between them. 

class HDFCBank implements{
    public double getBalanceInHDFC(String accountNo){
        return 1000;
    }
    public void amountTransferInHDFC(String fromAccount, String toAccount, double amount){
        System.out.println("Amount transferred in HDFC");
    }
}
class ICICIBank implements Bank{
    public double getBalanceInICICI(String accountNo){
        return 2000;
    }
    public void amountTransferInICICI(String fromAccount, String toAccount, double amount){
        System.out.println("Amount transferred in ICICI");
    }
}

interface Bank{
    public double getBalance(String accountNo);
    public void amountTransfer(String fromAccount, String toAccount, double amount);
}
class HDFCBankAdapter implements Bank{
    private HDFCBank hdfcBank;
    public HDFCBankAdapter(HDFCBank hdfcBank){
        this.hdfcBank = hdfcBank;
    }
    public double getBalance(String accountNo){
        return hdfcBank.getBalanceInHDFC(accountNo);
    }
    public void amountTransfer(String fromAccount, String toAccount, double amount){
        hdfcBank.amountTransferInHDFC(fromAccount, toAccount, amount);
    }
}
class ICICIBankAdapter implements Bank{
    private ICICIBank iciciBank;
    public ICICIBankAdapter(ICICIBank iciciBank){
        this.iciciBank = iciciBank;
    }
    public double getBalance(String accountNo){
        return iciciBank.getBalanceInICICI(accountNo);
    }
    public void amountTransfer(String fromAccount, String toAccount, double amount){
        iciciBank.amountTransferInICICI(fromAccount, toAccount, amount);
    }
}
//PhonePay services
class PhoneRechanrgeINPhonePay{
    private Bank bank;
    public PhoneRechanrgeINPhonePay(Bank bank){
        this.bank = bank;
    }
    public void rechanrge(String accountNo, double amount){
        double balance = bank.getBalance(accountNo);
        if(balance >= amount){
            bank.amountTransfer(accountNo, "PhonePeAccount", amount);
            System.out.println("Recharge successful");
        }else{
            System.out.println("Insufficient balance");
        }
    }
}
class PhonePay{
    private PhoneRechanrgeINPhonePay phoneRechanrgeINPhonePay;
    public PhonePay(Bank bank){
        phoneRechanrgeINPhonePay = new PhoneRechanrgeINPhonePay(bank);
    }
    public void rechanrge(String accountNo, double amount){
        phoneRechanrgeINPhonePay.rechanrge(accountNo, amount);
    }
}
class Client{
    public static void main(String[] args){
        HDFCBank hdfcBank = new HDFCBank();
        Bank hdfcAdapter = new HDFCBankAdapter(hdfcBank);
        PhonePay phonePayHDFC = new PhonePay(hdfcAdapter);
        phonePayHDFC.rechanrge("HDFC123", 500);

        ICICIBank iciciBank = new ICICIBank();
        Bank iciciAdapter = new ICICIBankAdapter(iciciBank);
        PhonePay phonePayICICI = new PhonePay(iciciAdapter);
        phonePayICICI.rechanrge("ICICI123", 1500);
    }
}