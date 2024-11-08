import java.io.*;

/**
 * la classe JournalOperations qui est la classe principale produisant les rapports et sorties voulus
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 * 
 * NOTE: ***Vous n avez pas le droit de changer le contenu de cette classe***
 */
public class JournalOperations {
    public static final String COMMA_DELIMITER = ",";
    public static final String SEMICOLON_DELIMITER = ";";
    public static final String COLON_DELIMITER = ":";
    

    public static void resolveAndAddBankAccount(Bank bank, Person owner, String accountAndBalanceAndRate, String separator) {
        //System.out.println(bankAccountAndBalance);
        BankAccount result = null;
        String[] values = accountAndBalanceAndRate.split(separator);

        String longAccountNumber = values[0];
        Double balance = Double.parseDouble(values[1]);
        int accountNumberLength = longAccountNumber.length();
        String transitNumber = longAccountNumber.substring(0, 5);
        char[] bankInstitution = longAccountNumber.substring(5, 8).toCharArray();
        String shortAccountNumber = longAccountNumber.substring (8, accountNumberLength);
        String lastDigit = longAccountNumber.substring(accountNumberLength-1, accountNumberLength);
        Integer checkDigit = Integer.parseInt(lastDigit);

        if (checkDigit.intValue() %2 ==0) { // per hypothesis, checking account number ends with an even number
            result = new ChequingAccount(bankInstitution, transitNumber, owner, shortAccountNumber);
        }
        else {  //per hypothesis, checking account number ends with an odd  number
            Double interestRate = Double.parseDouble(values[2]);
            result = new SavingsAccount(bankInstitution, transitNumber, owner, shortAccountNumber, interestRate);
        }
        result.balance = balance;
        bank.configureBankAccount(result, transitNumber, false);
    }

    /**
     * 
     * @param args les arguments de la ligne de commande
     * args[0] prendra le nom du fichier input contenant la liste des transactions de la banque
     * args[1] prendra le nom du fichier output contenant le rapport des transactions journalieres de la banque
     * @throws Exception
     */
    public static void main (String[] args) throws Exception {
        if (args.length !=2) {
          System.out.print("Utilisation: java JournalOperations <fichierInput:String> <fichierOutput:String>");
          return;
        } 
        String fichierinput = args[0];   //"transactions.txt";
        String fichierOutput = args[1];  //"output.txt";
        Branch[] tdBranches  = {
            new Branch("32486", 4.0, "Bells Corner, Ottawa, K2H 9S1"), 
            new Branch("32506", 5.0, "Billings Bridge, Ottawa, K1H 8K2"),
            new Branch("32356", 7.0, "Downtown, Ottawa, K1P 1A4")
        };
        char[] tdInstitution = {'0','0','1'};
        Bank bank = new Bank("TD", tdInstitution, tdBranches);
        
        FileReader fileReader = new FileReader(fichierinput);    
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String ligne;
            while ((ligne = br.readLine()) != null && ligne.length()!=0) {
                String[] values = ligne.split(COMMA_DELIMITER);
                        
                String operationType = values[1];
                String action = values[2];
                
                if (operationType.equalsIgnoreCase("bank")) {   
                    //LocalDateTime datetime = Utils.convertStringToDateTime(values[0]); //on n en a aps besoin pour le moment
                    int index = 2;
                    String transitNumber = values[index+1];
                    String name = values[index+2];
                    String dob = values[index+3];
                    String nas = values[index+4];
                    Person client = new Person(name, dob);
                    client.setNas(nas);

                    switch (action) {
                        case "client":
                            String[] bankAccountSummaryInfos = values[index+7].split(SEMICOLON_DELIMITER);
                            for (String bankAccountAndBalance : bankAccountSummaryInfos) {
                                resolveAndAddBankAccount(bank, client, bankAccountAndBalance, COLON_DELIMITER);  
                            }
                        break;
                        case "new-client":
                            String chequingInfo = values[index+5];
                            String savingIInfo  = values[index+6];
                            Integer numberCheckingAccount = Integer.valueOf(chequingInfo);
                            Integer numberSavingAccount = Integer.valueOf(savingIInfo);

                            for (int i=0; i<numberCheckingAccount.intValue(); i++) {
                                BankAccount bankAccount = new ChequingAccount(tdInstitution, transitNumber, client);  
                                bank.configureBankAccount(bankAccount, transitNumber, true);  
                            }
                            for (int i=0; i<numberSavingAccount.intValue(); i++) {
                                Double interestRate = bank.getDefaultInterestRate(transitNumber);
                                BankAccount bankAccount = new SavingsAccount(tdInstitution, transitNumber, client, interestRate);  
                                bank.configureBankAccount(bankAccount, transitNumber, true);       
                            }
                        break;
                    }
                }
                else if (operationType.equalsIgnoreCase("transaction")) {
                   ;    // rien a faire ici pour le moment                       
                }  //end if    
            }  //end while  

            FileWriter output = new FileWriter(fichierOutput);
            output.write("*****************************");
            output.write(System.lineSeparator());
            output.write(bank.toString());
            output.write("*****************************");
            output.write(System.lineSeparator());
            output.close();
          }//end try
        catch (Exception e) {
            System.out.println("Probleme dans l execution." + e.getStackTrace().toString());
            System.out.println(e.toString());
        }//end catch
    }//end main                
}