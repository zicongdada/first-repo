import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        
        // 实际项目中，这里应该去调用 Service 查询数据库
        if ("admin".equals(username) && "123456".equals(password)) {
            result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("token", "mock-jwt-token-12345"); // 实际会生成真实的 JWT Token
        } else {
            result.put("code", 401);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }
}
