package coinbank;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	String title = "Coin Bank - Login";
	int main = 0;
	String idCheck = null;
	String passCheck = null;

	String[] arrMain = {"접속하기"};

	String id = "user";
	String pass = "1234";

	ImageIcon i = new ImageIcon("src/image/logo.gif");
	// ImageIcon main_img = new ImageIcon("src/image/main.gif");


	public Login() {}




	public void start() {
		main = JOptionPane.showOptionDialog
				(null, "", title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, i, arrMain,arrMain[0] );



		while(true) {
			switch(main) {
				case 0:
					JTextField username = new JTextField();
					JTextField password = new JPasswordField();
					Object[] message = {
							"아이디", username,
							"\n비밀번호", password
					};

					int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null);
					if (option == JOptionPane.OK_OPTION) {
						if (username.getText().equals("user") && password.getText().equals("1234")) {
							break;
						} else{
							JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀립니다.", title, JOptionPane.ERROR_MESSAGE);
							continue;
						}
					} else {
						System.exit(main);
					}

					break;
				case -1:
					System.exit(main);
					break;
			}
			break;

		}
	}
}









