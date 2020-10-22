package connect;
import connect.Connect;

public class Login {
	private Connect con;
	private String id,pw;
	private String message;
	
	public Login() {
		con=new Connect();
		con.setURL("http://ec2-3-35-43-20.ap-northeast-2.compute.amazonaws.com/account/signin");
		message="{\"Account_ID\":\"zeroman\",\"Account_password\":\"0000\"}";
	}
	
	public boolean access()
	{	
		return con.post(this.message);
	}
	
	public String test()
	{
		return "Login";
	}
}
