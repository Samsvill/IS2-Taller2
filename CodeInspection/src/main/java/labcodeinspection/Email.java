package labcodeinspection;
import java.util.Locale;


public class Email {

	private String m_firstName; //NOPMD se va a modificar
	private String m_lastName; //NOPMD se va a modificar
	private String password;
	private String department;
	private final int defaultpasswordLength = 8;
	private String email;

	/**
     * Constructs a new Email with the specified first name and last name.
     *
     * @param firstName the first name of the email owner
     * @param lastName  the last name of the email owner
     */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

	/**
	 * Displays the user's information, including first name, last name,
	 * department, email, and password. This information is printed to the console.
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * Sets the department based on the provided department choice.
	 * 
	 * @param depChoice an integer representing the department choice:
	 *                  1 for sales,
	 *                  2 for development,
	 *                  3 for accounting.
	 */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
            this.department = "none"; // Handle invalid choices
            break;
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * Generates an email address and a random password for the user.
	 * 
	 * The email address is generated by concatenating the user's first name,
	 * last name, department, and the domain "espol.edu.ec". The email address
	 * format is "firstname.lastname@department.espol.edu.ec".
	 * 
	 * The password is generated using a random password method with the default
	 * password length.
	 */
	public void generateEmail() {
	    this.password = this.randomPassword(this.defaultpasswordLength);
	    this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department.toLowerCase(Locale.ROOT)
	            + ".espol.edu.ec";
	}
}
