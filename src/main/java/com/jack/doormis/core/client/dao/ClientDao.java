package com.jack.doormis.core.client.dao;


import com.jack.doormis.core.client.dto.ClientMainPageParams;
import com.jack.doormis.core.client.pojo.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientDao {
    Client getById(@Param("id") int id);

    List<Client> search(Client client);

    List<Client> searchMainList(ClientMainPageParams pageParams);

    Integer searchMainCount(ClientMainPageParams pageParams);

    Long searchCnt(Client client);

    void add(Client client);

    void update(Client client);

    void delete(Client client);

    Client getByRealName(String realName);

}
