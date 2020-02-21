package frontend;

import java.util.EnumSet;

public enum PrivilegeLevel {
	ADMIN 		(UserType.ADMIN),
	SELL		(UserType.ADMIN, UserType.FULLSTANDARD, UserType.SELLSTANDARD),
	BUY			(UserType.ADMIN, UserType.FULLSTANDARD, UserType.BUYSTANDARD),
	LOGGEDIN	(UserType.ADMIN, UserType.FULLSTANDARD, UserType.SELLSTANDARD, UserType.BUYSTANDARD),
	NOTLOGGEDIN (UserType.NOTLOGGEDIN)
	;
	
	private EnumSet<UserType> allowedUserType;
	
	PrivilegeLevel(UserType ... a) {
		allowedUserType = EnumSet.noneOf(UserType.class);
		for(UserType ut : a) {
			allowedUserType.add(ut);
		}
	}
	
	public EnumSet<UserType> getAllowedUserType() {
		return this.allowedUserType;
	}
}
