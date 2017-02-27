package com.jack.doormis.core.clientquery.bo;


import com.jack.doormis.core.clientquery.dao.ClientQueryDao;
import com.jack.doormis.core.clientquery.pojo.ClientQuery;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientQueryBo  {
	private ClientQueryDao clientQueryDao;


	public ClientQuery getById(Integer id){
		return clientQueryDao.getById(id);
	}

	public List<ClientQuery> search(ClientQuery clientQuery){
		return clientQueryDao.search(clientQuery);
	}

	public List<ClientQuery> searchPaged(ClientQuery clientQuery){
		return clientQueryDao.searchPaged(clientQuery);
	}

	public Long searchCnt(ClientQuery clientQuery){
		return clientQueryDao.searchCnt(clientQuery);
	}

	public void add(ClientQuery clientQuery){
		clientQueryDao.add(clientQuery);
	}

	public void update(ClientQuery clientQuery){
		clientQueryDao.update(clientQuery);
	}

	public void delete(ClientQuery clientQuery){
		clientQueryDao.delete(clientQuery);
	}
}
