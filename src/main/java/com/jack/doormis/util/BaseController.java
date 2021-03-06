package com.jack.doormis.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jack.doormis.core.user.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class BaseController {

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	public HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	public User getCurUser() {
		return (User) getSession().getAttribute(JzbKeys.S_KEY_USER);
	}

	public Integer getCurUserId() {
		User curUser = getCurUser();
		return curUser != null ? curUser.getId() : 0;
	}
}
