package com.jack.doormis.interfaces.http;


import com.jack.doormis.common.web.Json;
import com.jack.doormis.core.clientquery.bo.ClientQueryBo;
import com.jack.doormis.core.clientquery.pojo.ClientQuery;
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

@Controller
@RequestMapping(value = "/clientquery")
public class ClientQueryController {
	protected Logger				log	= Logger.getLogger(this.getClass());
	
	@Autowired
	private ClientQueryBo clientQueryBo;
	
	/**
	 * 跳转到表格页面
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {
        return "/client_query/client_query_list";
    }
	
	/**
	 * 新增
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Json add(ClientQuery clientQuery) {
        Json json = new Json();
        try {
            clientQueryBo.add(clientQuery);
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
     * @param clientQuery
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Json update(ClientQuery clientQuery) {
        Json json = new Json();
        try {
            clientQueryBo.update(clientQuery);
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
