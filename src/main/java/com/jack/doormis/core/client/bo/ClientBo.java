package com.jack.doormis.core.client.bo;

import com.jack.doormis.core.client.dao.ClientDao;
import com.jack.doormis.core.client.pojo.Client;
import com.jack.doormis.core.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientBo  {
	@Autowired
	private ClientDao clientDao;

	public Client getById(Integer id){
		return clientDao.getById(id);
	}

	public List<Client> search(Client client){
		return clientDao.search(client);
	}

	public List<Client> searchPaged(Client client){
		return clientDao.searchPaged(client);
	}

	public Long searchCnt(Client client){
		return clientDao.searchCnt(client);
	}

	public void add(Client client){
		clientDao.add(client);
	}

	public void update(Client client){
		clientDao.update(client);
	}

	public void delete(Client client){
		clientDao.delete(client);
	}
}
