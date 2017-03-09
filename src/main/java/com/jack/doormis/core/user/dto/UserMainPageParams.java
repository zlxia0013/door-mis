package com.jack.doormis.core.user.dto;

import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.util.exception.DoorMisRuntimeException;

/**
 * Created by Jack on 2017/3/7.
 */
public class UserMainPageParams {
    private Integer pageSize;
    private Integer curPage;
    private Integer firstRecord;

    public UserMainPageParams() {
    }

    public void adjustPageParams() {
        if (pageSize == null || pageSize < 1) {
            pageSize = 20;
        }

        if (curPage == null || curPage < 1) {
            curPage = 1;
        }

        firstRecord = (curPage - 1) * pageSize;
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

}
