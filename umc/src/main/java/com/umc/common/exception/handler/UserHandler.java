package com.umc.common.exception.handler;

import com.umc.common.exception.GeneralException;
import com.umc.common.response.BaseErrorCode;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
