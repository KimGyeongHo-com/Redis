package Kim.Redis.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("Kim.Redis.Entity")
public class JpaConfig {
    // 필요한 경우 추가적인 JPA 구성을 할 수 있습니다.
}