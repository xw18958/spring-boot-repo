package com.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException{
    private int code;
    private String msg;
    private boolean isProceeded;

    public boolean getIsProceeded(){
        return this.isProceeded;
    }
}
