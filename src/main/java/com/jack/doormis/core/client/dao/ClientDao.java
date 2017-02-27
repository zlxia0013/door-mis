package com.jack.doormis.core.client.dao;


import com.jack.doormis.core.client.pojo.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientDao  {
	public Client getById(@Param("id") int id);

	public List<Client> search(Client client);

	public List<Client> searchPaged(Client client);

	public Long searchCnt(Client client);

	public void add(Client client);

	public void update(Client client);

	public void delete(Client client);
}
