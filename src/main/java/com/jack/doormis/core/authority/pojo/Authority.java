package com.jack.doormis.core.authority.pojo;

public class Authority {
    private String name;

    private String value;

    private Integer forAll;

    private Integer mustHasLogin;//必须已经登陆， 此字段只有在for_all=1时才有意义

    private String comments;

    // %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_DECLARE%%

    public Authority() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getForAll() {
        return forAll;
    }

    public void setForAll(Integer forAll) {
        this.forAll = forAll;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getMustHasLogin() {
        return mustHasLogin;
    }

    public void setMustHasLogin(Integer mustHasLogin) {
        this.mustHasLogin = mustHasLogin;
    }
// %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_GET_SET%%
}
