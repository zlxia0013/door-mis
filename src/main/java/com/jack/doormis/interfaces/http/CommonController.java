package com.jack.doormis.interfaces.http;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	protected Logger				log	= Logger.getLogger(this.getClass());

	public static final String URL_GOTO_LOGIN_PAGE = "/goto_login_page";

	@RequestMapping(value = URL_GOTO_LOGIN_PAGE)
    public String gotoLoginPage(Model model) {
        return "/common/login";
    }

}
