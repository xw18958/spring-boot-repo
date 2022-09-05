package com.abc.multi_module.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("Verification")
public class Verification implements Serializable {
    String code;
    String username;
}
