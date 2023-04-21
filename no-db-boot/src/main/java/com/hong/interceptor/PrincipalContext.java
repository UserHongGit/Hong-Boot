package com.hong.interceptor;


import com.hong.entity.bo.Principal;

public class PrincipalContext {
    private static final ThreadLocal<Principal> context = new ThreadLocal();

    public PrincipalContext() {
    }

    public static void setContext(Principal ctx) {
        context.set(ctx);
    }

    public static Principal getContext() {
        return (Principal)context.get();
    }

    public static void removeContext() {
        context.remove();
    }
}