package com.dxb.tdd.bdd.phantomjs;

import com.dxb.tdd.bdd.common.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * @Description:crawler
 * @Author: old
 * @CreateTime:2017-11-15 :15:27:27
 */
public class PhantomjsTest {
    public static void main(String[] args) {
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtil.createPhantomjsWebDriver("D:\\ProgramFiles\\IdeaProjects\\tddtest\\Plugin\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");
            webDriver.get("https://www.baidu.com/");
            System.out.println(webDriver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                webDriver.close();
            }
        }
    }
}
