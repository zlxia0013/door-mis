package com.jack.doormis.core.client.dto;

import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.util.exception.DoorMisRuntimeException;

/**
 * Created by Jack on 2017/3/7.
 */
public class ClientMainPageParams {
    private Integer pageSize;
    private Integer curPage;
    private Integer firstRecord;

    private String code;
    private String realName;
    private String address;
    private String phone;
    private String wechat;

    public ClientMainPageParams() {
    }

    public void adjustPageParams(RoleEnum role) {
        switch (role) {
            case EMPL:
                pageSize = 1;
                curPage = 1;
                firstRecord = 0;
                break;
            case ADMIN:
                if (pageSize == null || pageSize < 1) {
                    pageSize = 20;
                }

                if (curPage == null || curPage < 1) {
                    curPage = 1;
                }

                firstRecord = (curPage - 1) * pageSize;

                break;
            default:
                throw new DoorMisRuntimeException("invalid role: " + role);
//                break;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getFirstRecord() {
        return firstRecord;
    }

    public void setFirstRecord(Integer firstRecord) {
        this.firstRecord = firstRecord;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
