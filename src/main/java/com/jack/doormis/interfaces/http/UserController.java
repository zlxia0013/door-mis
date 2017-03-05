package com.jack.doormis.interfaces.http;


import com.jack.doormis.common.web.ClientKeys;
import com.jack.doormis.common.web.CommonKeys;
import com.jack.doormis.common.web.Json;
import com.jack.doormis.core.user.bo.UserBo;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.util.ReturnCodes;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import com.jack.doormis.util.exception.DoorMisSystemException;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	protected Logger				log	= Logger.getLogger(this.getClass());
	
	@Autowired
	private UserBo userBo;



    @RequestMapping(value = "/goto_main_page",method = RequestMethod.GET)
    public ModelAndView gotoMainPage(HttpSession session) {
        User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);

        ModelAndView modelAndView = new ModelAndView("user/user_main");
        modelAndView.addObject(ClientKeys.JspParam_UserInfo, userInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/goto_add_page",method = RequestMethod.GET)
    public ModelAndView gotoAddPage(HttpSession session) {
        User userInfo = (User)session.getAttribute(CommonKeys.SESSION_USER);

        ModelAndView modelAndView = new ModelAndView("user/user_add");
        modelAndView.addObject(ClientKeys.JspParam_UserInfo, userInfo);
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
	
	/**
     * 修改
     * 
     * @param user
     * @return
     */
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

}
