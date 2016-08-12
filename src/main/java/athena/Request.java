package athena;

import com.google.gson.JsonObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by buddyarifin on 8/4/16.
 */
public class Request {
    public String responseString;
    protected HttpURLConnection conn;

    public Request openConnection(String url, String restMethod) {
        try{
            this.conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(restMethod);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Request closeConnection(){
        conn.disconnect();
        return this;
    }

    public Request setHeaders(String key, String value){
        this.conn.setRequestProperty(key, value);
        return this;
    }

    public String readInputStream() {
        StringBuffer response = new StringBuffer();
        try {
            if (conn.getResponseCode() != 200 ){
                throw new RuntimeException("Failed request :" +conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((this.conn.getInputStream())));
            String inputline;
            while ((inputline = br.readLine()) != null) {
//                System.out.println(inputline); // to print json console
                response.append(inputline);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public Request setReqBody(JsonObject json, OutputStream stream){
        try {
            System.out.println("Request body : "+json.getAsString());
            DataOutputStream wr = new DataOutputStream(stream);
            wr.writeBytes(json.getAsString());
            wr.flush();
            wr.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        return this;
    }

    public String build(){
      return responseString = readInputStream();
    }
}
