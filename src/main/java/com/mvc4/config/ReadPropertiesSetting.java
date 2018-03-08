package com.mvc4.config;


/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 * 最后注意在spring Boot入口类加上@EnableConfigurationProperties
 */
@ConfigurationProperties(prefix = "wisely",locations = "classpath:config/wisely.properties")
public class ReadPropertiesSetting {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
