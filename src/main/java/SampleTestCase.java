import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class SampleTestCase {
    private RestTemplate restTemplate;
    private final String API_BASE = "https://api.github.com";

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testUserInfoResponse(){
        User remoteUser = restTemplate.getForObject(API_BASE + "/users/dmitriiyashkin", User.class);
        Assert.assertTrue(remoteUser.getHtml_url().contains("https://github.com/dmitriiyashkin"));
    }

    @Test
    public void testFollowers(){
        User[] followers = restTemplate.getForObject(API_BASE + "/users/dmitriiyashkin/followers", User[].class);
        Assert.assertTrue(followers.length == 0);
    }

}
