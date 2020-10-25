package connect;

import connect.Connect;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public abstract class Base {
	private String str_url;
	private Connect con;
	private Gson gson;
	
	public void setURL(String url)
	{
		this.str_url=url;
	}
}
