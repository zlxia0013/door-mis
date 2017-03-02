package com.jack.doormis.core.authority.dao;


import com.jack.doormis.core.authority.pojo.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityDao {
    public Authority getById(@Param("id") int id);

    public List<Authority> search(Authority authority);

    public List<Authority> searchPaged(Authority authority);

    public Long searchCnt(Authority authority);

    public void add(Authority authority);

    public void update(Authority authority);

    public void delete(Authority authority);
}
