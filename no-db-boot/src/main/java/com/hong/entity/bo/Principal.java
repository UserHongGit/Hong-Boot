package com.hong.entity.bo;


import lombok.Data;

import java.io.Serializable;
import java.util.Locale;

@Data
public class Principal implements Serializable {
    private static final long serialVersionUID = 6750483124220830600L;
    private String principalNo = null;
    private String userLoginName = null;
    private String userName = null;
    private Object userNo = null;
    private Object topGroupNo = null;
    private Object directGroupNo = null;
    private Object tenantId = null;
    private String ip = null;
    private Locale locale;
    private Boolean authorization;
    private Boolean write;
    private Object extendsData;

    public Principal() {
        this.locale = Locale.SIMPLIFIED_CHINESE;
        this.authorization = false;
        this.write = true;
    }


    public static Principal createSystemPrinciple() {
        Principal principal = new Principal();
        principal.setAuthorization(true);
        principal.setPrincipalNo("system");
        principal.setWrite(true);
        return principal;
    }
}
