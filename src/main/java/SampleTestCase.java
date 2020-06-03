import models.User;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class SampleTestCase {
    @Test
    public void testUserInfoResponse(){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("https://api.github.com/users/dmitriiyashkin", User.class);
        System.out.println(user);
    }

}
