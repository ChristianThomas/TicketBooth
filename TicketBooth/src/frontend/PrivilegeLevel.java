package frontend;

import java.util.EnumSet;

public enum PrivilegeLevel {
	ADMIN 		(UserType.ADMIN),
	SELL		(UserType.ADMIN, UserType.FULLSTANDARD, UserType.SELLSTANDARD),
	BUY			(UserType.ADMIN, UserType.FULLSTANDARD, UserType.BUYSTANDARD),
	LOGGEDIN	(UserType.ADMIN, UserType.FULLSTANDARD, UserType.SELLSTANDARD, UserType.BUYSTANDARD),
	NOTLOGGEDIN
	;
	
	private EnumSet<UserType> allowedUserType;
	
	PrivilegeLevel(UserType ... a) {
		for(UserType ut : a) {
			allowedUserType.add(ut);
		}
	}
	
	public EnumSet<UserType> getAllowedUserType() {
		return this.allowedUserType;
	}
}
