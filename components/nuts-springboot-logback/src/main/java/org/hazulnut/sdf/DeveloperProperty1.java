package org.hazulnut.sdf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * test class.
 *
 * <p>
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/23 15:05: created.<br>
 */
@ConfigurationProperties(prefix = "developer")
@Component
public class DeveloperProperty1 {
    private String name;
    private String website;
    private String qq;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "DeveloperProperty1{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", qq='" + qq + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}