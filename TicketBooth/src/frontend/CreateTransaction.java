package frontend;

public class CreateTransaction extends Transaction{
	final float balance;
	final UserType usertype;

    CreateTransaction(String user, float balance, UserType usertype){
        super(user);
        this.balance = balance;
        this.usertype = usertype;
    }

    @Override
    String getTransactionCode() {
        return "create";
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
		String result = "01 ";
		result += User.getPaddedUsername(user);
		result += ' ';
		result += UserType.getShortUserType(usertype);
		result += ' ';
		result += User.getPaddedBalance(balance);
		
		return result;
	}

	@Override
	public TransactionResult accept(Logic l) {
		return l.visitTransaction(this);
	}
}