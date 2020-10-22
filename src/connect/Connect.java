package connect;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Connect {
	private String str_url;
	private HttpURLConnection con;

	public void setURL(String url)
	{
		this.str_url=url;
	}
	
	public boolean connect(String str_url)
	{
		this.str_url=str_url;
		try {
			URL url=new URL(this.str_url);
			con=(HttpURLConnection)url.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String temp;
			int rank=0;
			while((temp=br.readLine())!=null) {
				System.out.println(temp);
			}
			con.disconnect();
			br.close();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean get()
	{
		try {
			URL url=new URL(this.str_url);
			con=(HttpURLConnection)url.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setRequestMethod("GET");
			
			con.setDoOutput(false);
			StringBuilder sb=new StringBuilder();
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
				BufferedReader br=new BufferedReader(
						new InputStreamReader(con.getInputStream()));
				String line;
				while((line=br.readLine())!=null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println(""+sb.toString());
				return true;
			}else {
				System.out.println(con.getResponseMessage());
				return false;
			}
		}catch(Exception e) {
			System.err.println(e.toString());
			return false;
		}
	}
	
	public boolean post(String jsonMessage)
	{
		try {
			URL url=new URL(this.str_url);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);
			
			OutputStreamWriter wr=new OutputStreamWriter(con.getOutputStream());
			wr.write(jsonMessage);
			wr.flush();
			
			StringBuilder sb=new StringBuilder();
			if(con.getResponseCode()==HttpURLConnection.HTTP_ACCEPTED) {
				BufferedReader br=new BufferedReader(
						new InputStreamReader(con.getInputStream(),"utf-8"));
				String line;
				while((line=br.readLine())!=null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println(""+sb.toString());
				return true;
			}else {
				System.out.println(con.getResponseMessage());
				return false;
			}
		}catch(Exception e) {
			System.err.println(e.toString());
			return false;
		}
	}

}
