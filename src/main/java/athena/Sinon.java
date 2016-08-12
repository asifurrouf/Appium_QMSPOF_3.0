package athena;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;
import pages.Constants;
import java.io.IOException;

/**
 * Created by buddyarifin on 8/4/16.
 */

public class Sinon {
    protected Request request;
    protected String response;
    public JsonObject data;

    public Sinon() {
        data = createUserWithoutOauthPassword();
    }

    public JsonObject createUserWithoutOauthPassword() {
            request = new Request();
            response = request.openConnection(Constants.base_uri +
                    "trojan/createuserwithoauthcredentials/", Constants.GET).build();
        return new JsonParser().parse(response).getAsJsonObject();
    }

    public JsonObject getCategory() {
        request = new Request();
        response = request.openConnection(Constants.base_uri + "trojan/allcategories/", Constants.GET)
                .setHeaders("authorization", "Bearer "+getAccessToken()).build();
        return new JsonParser().parse(response).getAsJsonObject();
    }

    public JsonObject createAds() {
        request = new Request();
        response = request.openConnection(Constants.base_uri + "trojan/createactivead/", Constants.POST)
                .setHeaders("authorization", "Bearer "+getAccessToken()).build();
        return new JsonParser().parse(response).getAsJsonObject();
    }

    public JsonObject getUser() {
        return data.getAsJsonObject("user");
    }

    public JsonObject getTokensJson() {
        return data.getAsJsonObject("oauth").getAsJsonObject("tokens");
    }

    public String getUsernameAsEmail() {
        return getUser().get("email").getAsString();
    }

    public String getPassword() {
        return getUser().get("password").getAsString();
    }

    public int getUserID() {
        return getUser().get("id").getAsInt();
    }

    public String getAccessToken() {
        return getTokensJson().get("access_token").getAsString();
    }

    /**
     * Needed Operation
     * 1. Create Active Ads √
     * 2. Create User with SMS Password - not available yet
     * 3. Create User with Password √
     * 4. GET Category √
     * 5. Create User with Spesific Data - with GUI
     * 6. Create Active Ads with Params
     * */


    @Test
    public void testUsers() throws IOException{
        Sinon so = new Sinon();
        String text = so.getUser().toString();
        System.out.println(text);
    }

    @Test
    public void testTokens() throws IOException{
        Sinon so = new Sinon();
        String text = so.getAccessToken().toString();
        System.out.println(text);
    }

    @Test
    public void testEmail() throws IOException{
        Sinon so = new Sinon();
        String text = so.getUsernameAsEmail().toString();
        System.out.println(text);
    }

    @Test
    public void testPass() throws IOException{
        Sinon so = new Sinon();
        String text = so.getPassword().toString();
        System.out.println(text);
    }
}
