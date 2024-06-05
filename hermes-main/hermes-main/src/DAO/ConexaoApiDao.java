package DAO;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ConexaoApiDao {
    public static String sendGet(String url) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.addHeader("User-Agent", "Mozilla/5.0");
            HttpResponse response = httpClient.execute(request);
            return EntityUtils.toString(response.getEntity());
        }
    }

    public static String sendPost(String url, String jsonPayload) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            post.setHeader("User-Agent", "Mozilla/5.0");
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(jsonPayload));
            HttpResponse response = httpClient.execute(post);
            return EntityUtils.toString(response.getEntity());
        }
    }
}
