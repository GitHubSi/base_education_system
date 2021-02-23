package henu.soft.xiaosi.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 生成JwtToken
 */
@Data
public class ShiroToken implements AuthenticationToken {

    private String token;

    public ShiroToken(String jwt){
        this.token = jwt;
    }

    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
