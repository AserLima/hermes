package DAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
public class MensagemApiDao {

    private static final String API_URL = "https://api.exemplo.com/users";
 //   private Gson gson = new Gson();
/*
    public List<User> getAllUsers() throws Exception {
        String jsonResponse = HttpClientUtil.sendGet(API_URL);
        Type userListType = new TypeToken<List<User>>() {}.getType();
        return gson.fromJson(jsonResponse, userListType);
    }

    public User getUserById(int id) throws Exception {
        String jsonResponse = HttpClientUtil.sendGet(API_URL + "/" + id);
        return gson.fromJson(jsonResponse, User.class);
    }

    public User createUser(User user) throws Exception {
        String userJson = gson.toJson(user);
        String jsonResponse = HttpClientUtil.sendPost(API_URL, userJson);
        return gson.fromJson(jsonResponse, User.class);
    }
    */

}
