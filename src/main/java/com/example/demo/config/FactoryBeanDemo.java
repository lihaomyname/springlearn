package com.example.demo.config;

import com.example.demo.bean.Hello;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: smart lihao
 * @Date: 2019/5/2 14:07
 */
public class FactoryBeanDemo implements FactoryBean<Hello>,BeanNameAware {

    private String name;

    @Override
    public Hello getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void setBeanName(String name) {
        this.name=name;
    }


    public static void main(String[] args) throws InterruptedException {
        int k=4;
        while (true){
            Integer getcode = getcode(k);

            int hash = hash("aaaa");
            int demo = getcode&hash;

            if(demo!=3){
                Thread.sleep(1000L);
                System.out.println("k= "+k+"   demo="+demo);
            }


            k++;



        }
    }


    public static Integer getcode(Integer n){
        int code=2;
        for (int i=1;i<n;i++){
            code=2*code;
        }
        code=code-1;
        return code;
    }


    static  int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
