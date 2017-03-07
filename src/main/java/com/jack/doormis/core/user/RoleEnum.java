package com.jack.doormis.core.user;

/**
 * Created by Jack on 2017/3/4.
 */
public enum RoleEnum {
    ADMIN, EMPL;

    public static boolean isValid(String role) {
        try {
            RoleEnum.valueOf(role);
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    public static boolean isEmpl(String role){
        return RoleEnum.valueOf(role) == EMPL;
    }

    public static boolean isAdmin(String role){
        return RoleEnum.valueOf(role) == ADMIN;
    }
}
