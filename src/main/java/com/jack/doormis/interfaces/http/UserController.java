package com.jack.doormis.interfaces.http;


import com.jack.doormis.common.web.JspKeys;
import com.jack.doormis.common.web.CommonKeys;
import com.jack.doormis.common.web.Json;
import com.jack.doormis.core.user.bo.UserBo;
import com.jack.doormis.core.user.dto.UserMainPageModel;
import com.jack.doormis.core.user.dto.UserMainPageParams;
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
@RequestMapping(value = "/user")
public class UserController {
	protected Logger				log	= Logger.getLogger(this.getClass());
	
	@Autowired
	private UserBo userBo;



    @RequestMapping(value = "/goto_main_page",method = RequestMethod.GET)
    public ModelAndView gotoMainPage(UserMainPageParams pageParams, HttpSession session) {
        User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);

        pageParams.adjustPageParams();

        //search client list
        List<User> userList = userBo.searchMainList(pageParams);

        Integer totalRecordCount = userBo.searchMainCount(pageParams);

        UserMainPageModel model = new UserMainPageModel();
        model.setUserList(userList);
        model.setTotalRecordCount(totalRecordCount);
        model.setCurPage(pageParams.getCurPage());
        model.setPageSize(pageParams.getPageSize());

        ModelAndView modelAndView = new ModelAndView("user/user_main");
        modelAndView.addObject(JspKeys.JspParam_SessionUserInfo, userInfo);
        modelAndView.addObject(JspKeys.JspParam_UserMainPageModel, model);
        return modelAndView;
    }

    @RequestMapping(value = "/goto_add_page",method = RequestMethod.GET)
    public ModelAndView gotoAddPage(HttpSession session) {
        User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);

        ModelAndView modelAndView = new ModelAndView("user/user_add");
        modelAndView.addObject(JspKeys.JspParam_SessionUserInfo, userInfo);
        return modelAndView;
    }


	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Json add(User user, HttpSession session) {
        Json json = new Json();
        try {
            User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);
            user.setAddUserId(userInfo.getId());
            user.setAddTime(new Date());
            userBo.add(user);
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
    public ModelAndView gotoUpdatePage(Integer userId, HttpSession session) {
        User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);

        User user = userBo.getById(userId);

        ModelAndView modelAndView = new ModelAndView("user/user_update");
        modelAndView.addObject(JspKeys.JspParam_SessionUserInfo, userInfo);
        modelAndView.addObject(JspKeys.JspParam_UserInfo, user);
        return modelAndView;
    }

	@ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Json update(User user) {
        Json json = new Json();
        try {
        	userBo.update(user);
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

    @RequestMapping(value = "/goto_update_pwd_page",method = RequestMethod.GET)
    public ModelAndView gotoUpdatePwdPage(HttpSession session) {
        User userInfo = (User) session.getAttribute(CommonKeys.SESSION_USER);

        ModelAndView modelAndView = new ModelAndView("user/user_update_pwd");
        modelAndView.addObject(JspKeys.JspParam_SessionUserInfo, userInfo);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/update_pwd",method = RequestMethod.POST)
    public Json updatePwd(String oldPwd, String newPwd, HttpSession session) {
        Json json = new Json();
        try {
            User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);
            userBo.updatePwd(userInfo.getUserName(), oldPwd, newPwd);
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
    public Json delete(Integer userId) {
        Json json = new Json();
        try {
            userBo.delete(userId);
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
