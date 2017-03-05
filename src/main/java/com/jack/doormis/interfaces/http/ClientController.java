package com.jack.doormis.interfaces.http;


import com.jack.doormis.common.web.Json;
import com.jack.doormis.core.client.bo.ClientBo;
import com.jack.doormis.core.client.pojo.Client;
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

@Controller
@RequestMapping(value = "/client")
public class ClientController {
	protected Logger				log	= Logger.getLogger(this.getClass());
	
	@Autowired
	private ClientBo clientBo;
	
	/**
	 * 跳转到表格页面
	 * @return
	 */
	@RequestMapping(value = "/goto_main_page",method = RequestMethod.GET)
    public ModelAndView gotoMainPage() {
        ModelAndView modelAndView = new ModelAndView("client/client_main");
        return modelAndView;
    }
	
	/**
	 * 新增
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Json add(Client client) {
        Json json = new Json();
        try {
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
	
	/**
     * 修改
     * 
     * @param client
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
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

}
