package com.servlet.service;

import java.util.HashMap;
import java.util.Map;

public class DependencyManager {
    private static DependencyManager ourInstance = new DependencyManager();

    public static DependencyManager getInstance() {
        return ourInstance;
    }

    private DependencyManager() {
        registerBean(UserService.class, new UserServiceImpl());
    }

    private Map<Class<?>, Object> beanMap = new HashMap<>();

     public <T> T getBean(Class<T> className){
        return (T) beanMap.get(className);
    }

    private void registerBean(Class<?> className, Object o){
         beanMap.put(className, o);
    }
}
