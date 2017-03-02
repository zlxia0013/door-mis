package com.jack.doormis.core.user;

import com.jack.doormis.util.exception.DoorMisRuntimeException;

/**
 * Created by Jack on 2017/3/2.
 */
public enum UserState {
    ENABLED(1), DISABLED(0);

    private int stateId;

    UserState(int stateId) {
        this.stateId = stateId;
    }

    public static UserState valueOf(int stateId) {
        switch (stateId) {
            case 1:
                return ENABLED;
            case 0:
                return DISABLED;
            default:
                throw new DoorMisRuntimeException("无效的用户状态: " + stateId);
        }
    }

    public static boolean enabled(int stateId) {
        UserState state = valueOf(stateId);
        return state == ENABLED;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
