package com.jack.doormis.core.client.dto;

import com.jack.doormis.core.client.pojo.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/3/7.
 */
public class ClientMainPageModel {
    private Integer pageCount;
    private Integer curPage;
    private Integer totalRecordCount;
    private Integer pageSize;
    private List<Client> clientList = new ArrayList<Client>();

    public ClientMainPageModel() {
    }

    public Integer getPageCount() {
        if(totalRecordCount % pageSize==0)
        {
            pageCount = totalRecordCount / pageSize;
        }else
        {
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
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
