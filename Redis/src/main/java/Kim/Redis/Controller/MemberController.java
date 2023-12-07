package Kim.Redis.Controller;

import Kim.Redis.Entity.User;
import Kim.Redis.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final UserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user){
        User saveUser = userRepository.save(user);
        log.info("save to DB : " + user);
        return saveUser;
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", cacheNames = "member")
    public User getMember(@PathVariable Long id){
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + "멤버는 존재하지 않습니다"));
        log.info("Member fetching from DB : " + id);
        return findUser;
    }
}
