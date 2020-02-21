package frontend;

public enum UserType {
	ADMIN,
	FULLSTANDARD,
	BUYSTANDARD,
	SELLSTANDARD,
	NOTLOGGEDIN
	;
	
	public static String getShortUserType(UserType ut) {
		switch(ut) {
		case ADMIN:
			return "AA";
		case FULLSTANDARD:
			return "FS";
		case BUYSTANDARD:
			return "BS";
		case SELLSTANDARD:
			return "SS";
		default:
			return null;
		}
	}
	
	public static UserType getUserTypeFromString(String ut) {
		switch(ut) {
		case "AA":
			return UserType.ADMIN;
		case "FS":
			return UserType.FULLSTANDARD;
		case "BS":
			return UserType.BUYSTANDARD;
		case "SS":
			return UserType.SELLSTANDARD;
		default:
			return null;
		}
	}
}
