package au.infomedia.example.repository;

import au.infomedia.xsd.generated.Login;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {

    public static final Map<String, Login> map = new HashMap<>();

    @PostConstruct
    public void initData() {
        Login login = new Login();
        login.setGroupID(1);
        login.setID(1L);
        login.setSid("a220bcb6-afe5-e911-82b3-a42c8f367b34");

        map.put("ji0110002hobs1", login);

        login = new Login();
        login.setGroupID(2);
        login.setID(2);
        login.setSid("a220bcb6-afe5-e911-82b3-a42c8f367b34a220bcb6-afe5-e911-82b3-a42c8f367b34");

        map.put("ji0110002hobs12", login);
    }

    public Login findUser(String userName) {
        Assert.notNull(userName, "The country's name must not be null");
        return map.get(userName);
    }
}
