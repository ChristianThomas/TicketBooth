package frontend;

import java.io.IOException;
import java.util.ArrayList;

public class DailyTransactionFileHandler extends FileHandler {
	public DailyTransactionFileHandler(String file) throws IOException {
		super(file);
	}

	public void writeTransactions(ArrayList<TransactionResult> transactions) throws IOException {
		ArrayList<String> tmp = new ArrayList<String>();
		for(TransactionResult tr : transactions) {
			if(tr.status) {
				tmp.add(tr.transaction.getTransactionString());
			}
		}
		tmp.add(getEndOfSession());
		write(tmp);
	}
	
	public static String getEndOfSession() {
		return "00";
	}
}
