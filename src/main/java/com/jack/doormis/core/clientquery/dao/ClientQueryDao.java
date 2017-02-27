package com.jack.doormis.core.clientquery.dao;


import com.jack.doormis.core.clientquery.pojo.ClientQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientQueryDao   {
	public ClientQuery getById(@Param("id") int id);

	public List<ClientQuery> search(ClientQuery clientQuery);

	public List<ClientQuery> searchPaged(ClientQuery clientQuery);

	public Long searchCnt(ClientQuery clientQuery);

	public void add(ClientQuery clientQuery);

	public void update(ClientQuery clientQuery);

	public void delete(ClientQuery clientQuery);
}
