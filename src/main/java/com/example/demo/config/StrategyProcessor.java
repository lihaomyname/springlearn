package com.example.demo.config;

import com.example.demo.annotation.StrategyTypeAnnotation;
import com.example.demo.enums.StrategyTypeEnum;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: smart lihao
 * @Date: 2019/6/13 0:07
 */
@Component
public class StrategyProcessor implements BeanFactoryPostProcessor {

    private static final String STRATEGY_PACKAGE = "com.lujiahao.strategy";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
       /* Map<StrategyTypeEnum, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scan(STRATEGY_PACKAGE, StrategyTypeAnnotation.class).forEach(clazz -> {
            // 获取注解中的类型值
            StrategyTypeEnum type = clazz.getAnnotation(StrategyTypeAnnotation.class).orderType();
            handlerMap.put(type, clazz);
        });

        // 初始化HandlerContext,将其注册到spring容器中
        StrategyContext context = new StrategyContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(StrategyContext.class.getName(), context);*/
    }
}