package com.abc.multi_module.system.respository;

import com.abc.multi_module.system.model.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class VerificationDao {
    public static final String HASH_KEY = "Verification";
    @Autowired
    private RedisTemplate template;

    public Verification save(Verification verification){
        template.opsForHash().put(HASH_KEY,verification.getUsername(),verification);
//        template.expire(verification.getUsername(),15, TimeUnit.SECONDS);
        return verification;
    }

    public List<Verification> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Verification findCodeByKey(String username){
        return (Verification) (template.opsForHash().get(HASH_KEY,username));
    }


    public String delete(String username){
        template.opsForHash().delete(HASH_KEY,username);
        return "Code removed!";
    }
}
