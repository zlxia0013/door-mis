package com.jack.doormis.interfaces.http;

import com.jack.doormis.common.web.Json;
import com.jack.doormis.core.user.bo.UserBo;
import com.jack.doormis.util.ReturnCodes;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import com.jack.doormis.util.exception.DoorMisSystemException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CommonController {
    protected Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserBo userBo;

    public static final String URL_GOTO_LOGIN_PAGE = "/goto_login_page";
    public static final String URL_LOGIN = "/login";

    @RequestMapping(value = URL_GOTO_LOGIN_PAGE)
    public String gotoLoginPage() {
        return "/common/login";
    }

    @RequestMapping(value = URL_LOGIN, method = RequestMethod.POST)
    @ResponseBody
    public Json login(String userName, String password) {
        Json json = new Json(true);
        try {
            userBo.login(userName, password);
        }catch (DoorMisRuntimeException e) {
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
