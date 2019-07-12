
public class BankingService {
	public void transfer(Account fr, Account to, double amt) {
		synchronized(fr) {
			synchronized (to) {
				fr.withdraw("anjali", amt);
				to.deposit("annnnnjali", amt);
			}
		}
	}
}
