package com.jack.doormis.core.client.bo;

import com.jack.doormis.core.client.dao.ClientDao;
import com.jack.doormis.core.client.dto.ClientMainPageParams;
import com.jack.doormis.core.client.pojo.Client;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.util.StringUtil;
import com.jack.doormis.util.exception.DoorMisException;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientBo {
    @Autowired
    private ClientDao clientDao;

    public Client getById(Integer id) {
        return clientDao.getById(id);
    }

    public Client getByRealName(String realName) {
        return clientDao.getByRealName(realName);
    }

    public List<Client> search(Client client) {
        return clientDao.search(client);
    }

    public List<Client> searchMainList(ClientMainPageParams pageParams) {
        return clientDao.searchMainList(pageParams);
    }

    public Integer searchMainCount(ClientMainPageParams pageParams) {
        return clientDao.searchMainCount(pageParams);
    }

    public Long searchCnt(Client client) {
        return clientDao.searchCnt(client);
    }

    public void add(Client client) {
        validate(client, true);
        clientDao.add(client);
    }

    public void update(Client client) {
        validate(client, false);
        clientDao.update(client);
    }

    private void validate(Client client, boolean isAdd) {
        if (client == null) {
            throw new DoorMisRuntimeException("客户实体不能为空");
        }

        if (StringUtil.isEmpty(client.getRealName())) {
            throw new DoorMisRuntimeException("姓名不能为空");
        } else if (client.getRealName().length() > 15) {
            throw new DoorMisRuntimeException("姓名不能大于15位");
        }

        if (StringUtil.isEmpty(client.getCode())) {
            throw new DoorMisRuntimeException("编号不能为空");
        } else if (client.getCode().length() > 20) {
            throw new DoorMisRuntimeException("编号不能大于20位");
        }

        if (StringUtil.isEmpty(client.getPhone())) {
            throw new DoorMisRuntimeException("电话不能为空");
        } else if (client.getPhone().length() > 50) {
            throw new DoorMisRuntimeException("电话不能大于50位");
        }

        if (StringUtil.isEmpty(client.getAddress())) {
            throw new DoorMisRuntimeException("地址不能为空");
        } else if (client.getAddress().length() > 120) {
            throw new DoorMisRuntimeException("地址不能大于120位");
        }

        if (!StringUtil.isEmpty(client.getWechat()) && client.getWechat().length() > 50) {
            throw new DoorMisRuntimeException("微信号不能大于50位");
        }

        if (!StringUtil.isEmpty(client.getLogistics()) && client.getLogistics().length() > 50) {
            throw new DoorMisRuntimeException("货运部不能大于50位");
        }

        if (!StringUtil.isEmpty(client.getRemark()) && client.getRemark().length() > 100) {
            throw new DoorMisRuntimeException("备注不能大于100位");
        }

        //////////////////
        if (isAdd) {
            Client client1 = getByRealName(client.getRealName());
            if (client1 != null) {
                throw new DoorMisRuntimeException("客户姓名已存在，请重新输入");
            }
        } else {
            if (client.getId() == null) {
                throw new DoorMisRuntimeException("客户id不能为空");
            }
        }
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }

}
