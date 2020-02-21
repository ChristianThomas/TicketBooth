package frontend;

public class DeleteTransaction extends Transaction{

    DeleteTransaction(String user){
        super(user);
    }

    @Override
    String getTransactionCode() {
        return "delete";
    }

    @Override
    PrivilegeLevel getPrivilege() {
        return PrivilegeLevel.ADMIN;
    }

	@Override
	String getTransactionString() {
		// XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
		// 01 username        AA 000000.00
		//                       9
		String result = "02 ";
		result += User.getPaddedUsername(user);
		result += ' ';
		result += "  ";
		result += ' ';
		result += User.getPaddedBalance(0.0f);
		
		return result;
	}

	@Override
	public TransactionResult accept(Logic l) {
		return l.visitTransaction(this);
	}
}