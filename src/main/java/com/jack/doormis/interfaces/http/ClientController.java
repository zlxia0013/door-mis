package com.jack.doormis.interfaces.http;


import com.jack.doormis.common.web.ClientKeys;
import com.jack.doormis.common.web.Json;
import com.jack.doormis.common.web.CommonKeys;
import com.jack.doormis.core.client.bo.ClientBo;
import com.jack.doormis.core.client.dto.ClientMainPageParams;
import com.jack.doormis.core.client.dto.ClientMainPageModel;
import com.jack.doormis.core.client.pojo.Client;
import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.util.ReturnCodes;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import com.jack.doormis.util.exception.DoorMisSystemException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
    protected Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private ClientBo clientBo;

    @RequestMapping(value = "/goto_main_page", method = RequestMethod.GET)
    public ModelAndView gotoMainPage(ClientMainPageParams pageParams, HttpSession session) {
        User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);

        //adjust params
        pageParams.adjustPageParams(RoleEnum.valueOf(userInfo.getRole()));

        //search client list
        List<Client> clientList = clientBo.searchMainList(pageParams);

        Integer totalRecordCount;
        if (RoleEnum.isEmpl(userInfo.getRole())) {
            totalRecordCount = clientList.size();
        } else {
            totalRecordCount = clientBo.searchMainCount(pageParams);
        }

        ClientMainPageModel model = new ClientMainPageModel();
        model.setClientList(clientList);
        model.setTotalRecordCount(totalRecordCount);
        model.setCurPage(pageParams.getCurPage());
        model.setPageSize(pageParams.getPageSize());

        ModelAndView modelAndView = new ModelAndView("client/client_main");
        modelAndView.addObject(ClientKeys.JspParam_UserInfo, userInfo);
        modelAndView.addObject(ClientKeys.JspParam_ClientMainPageModel, model);
        modelAndView.addObject(ClientKeys.JspParam_ClientMainPageParams, pageParams);
        return modelAndView;
    }

    @RequestMapping(value = "/goto_add_page", method = RequestMethod.GET)
    public ModelAndView gotoAddPage(HttpSession session) {
        User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);

        ModelAndView modelAndView = new ModelAndView("client/client_add");
        modelAndView.addObject(ClientKeys.JspParam_UserInfo, userInfo);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Json add(Client client, HttpSession session) {
        Json json = new Json();
        try {
            User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);
            client.setAddUserId(userInfo.getId());
            client.setAddTime(new Date());
            clientBo.add(client);
            json.setSuccess(true);
        } catch (DoorMisRuntimeException e) {
            json = new Json(e.getErrorCode(), e.getMessage());
        } catch (DoorMisSystemException e) {
            log.error("error", e);
            json = new Json(e.getErrorCode(), "系统忙... " + e.getMessage());
        } catch (Throwable e) {
            log.error("error", e);
            json = new Json(ReturnCodes.SYSTEM_EXCEPTION, "系统忙... " + e.getMessage());
        }
        return json;
    }

    @RequestMapping(value = "/goto_update_page", method = RequestMethod.GET)
    public ModelAndView gotoUpdatePage(Integer clientId, HttpSession session) {
        User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);

        Client client = clientBo.getById(clientId);

        ModelAndView modelAndView = new ModelAndView("client/client_update");
        modelAndView.addObject(ClientKeys.JspParam_UserInfo, userInfo);
        modelAndView.addObject(ClientKeys.JspParam_ClientInfo, client);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Json update(Client client) {
        Json json = new Json();
        try {
            clientBo.update(client);
            json.setSuccess(true);
        } catch (DoorMisRuntimeException e) {
            json = new Json(e.getErrorCode(), e.getMessage());
        } catch (DoorMisSystemException e) {
            log.error("error", e);
            json = new Json(e.getErrorCode(), "系统忙... " + e.getMessage());
        } catch (Throwable e) {
            log.error("error", e);
            json = new Json(ReturnCodes.SYSTEM_EXCEPTION, "系统忙... " + e.getMessage());
        }
        return json;
    }


    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Json delete(Integer clientId) {
        Json json = new Json();
        try {
            clientBo.delete(clientId);
            json.setSuccess(true);
        } catch (DoorMisRuntimeException e) {
            json = new Json(e.getErrorCode(), e.getMessage());
        } catch (DoorMisSystemException e) {
            log.error("error", e);
            json = new Json(e.getErrorCode(), "系统忙... " + e.getMessage());
        } catch (Throwable e) {
            log.error("error", e);
            json = new Json(ReturnCodes.SYSTEM_EXCEPTION, "系统忙... " + e.getMessage());
        }
        return json;
    }

}
