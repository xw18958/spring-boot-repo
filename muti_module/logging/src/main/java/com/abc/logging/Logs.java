package com.abc.logging;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Logs {
    @Id
    int log_id;
    String log_type;
    String description;
    Long time;
    String exception_detail;
    LocalDateTime createTime;
    String method;
    String requestIp;
}
