package connect;

import connect.Connect;
import connect.Base;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Login extends Base{
	private Connect con;
	private String id,pw;
	private Gson gson;
	private JsonObject message;
	private String Account_ID,Account_name;
	private boolean is_login;
	
	public Login() {
		this.con=new Connect();
		this.gson=new Gson();
		this.con.setURL("http://ec2-3-35-43-20.ap-northeast-2.compute.amazonaws.com/account/signin"
				+ "?format=json");
	}
	
	public void input(String id,String pw) {
		this.id=id;
		this.pw=pw;
		this.message=new JsonObject();
		this.message.addProperty("Account_ID", this.id);
		this.message.addProperty("Account_password",this.pw);
	}
	
	public boolean access()
	{	
		this.con.setmessage(gson.toJson(this.message));
		this.is_login=this.con.post();
		JsonParser parser=new JsonParser();
		JsonElement result=parser.parse(this.con.getresult());
		try {
			this.Account_ID=result.getAsJsonObject().get("ID").getAsString();
			this.Account_name=result.getAsJsonObject().get("name").getAsString();
		}catch(Exception e){
			this.Account_ID=null;
			this.Account_name=null;
		}
		return this.is_login;
	}
	
	public boolean get_is_login()
	{
		return this.is_login;
	}
	
	public String get_ID() {
		return this.Account_ID;
	}
	
	public String get_name() {
		return this.Account_name;
	}
	
}
	
	
	
