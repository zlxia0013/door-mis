package com.jack.doormis.core.user.dto;

import com.jack.doormis.core.user.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/3/7.
 */
public class UserMainPageModel {
    private Integer pageCount;
    private Integer curPage;
    private Integer totalRecordCount;
    private Integer pageSize;
    private List<User> userList = new ArrayList<User>();

    public UserMainPageModel() {
    }

    public Integer getPageCount() {
        if (totalRecordCount % pageSize == 0) {
            pageCount = totalRecordCount / pageSize;
        } else {
            pageCount = totalRecordCount / pageSize + 1;
        }
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(Integer totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
