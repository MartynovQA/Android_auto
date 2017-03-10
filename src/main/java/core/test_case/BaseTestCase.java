package core.test_case;

import core.appium.page.MobilePageFactory;
import core.asserts.LightAssert;
import core.logger.AppenderFactory;
import core.logger.LevelLogger;
import core.logger.ThreadLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by zaborovsky on 27.12.2016.
 */

@Component
@Configuration
@PropertySource("classpath:mobile.properties")
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class BaseTestCase extends AbstractTestNGSpringContextTests implements IHookable{
//    TODO: Перенести инициацию сюда


    @Autowired
    public Environment environment;

    private final String TEST_IDENTIFIER = UUID.randomUUID().toString();
    protected ITestContext iTestContext;
    protected Logger logger;

    protected MobilePageFactory mobilePageFactory = new MobilePageFactory();
    protected LightAssert lightAssert;


    private String valueParameters = "";



    @BeforeClass
    public void initContext(ITestContext iTestContext) {
        this.iTestContext = iTestContext;
        HashMap<String, String> mapParams = (HashMap<String, String>)iTestContext.getCurrentXmlTest().getAllParameters();
        if(mapParams.size() > 0) {
            valueParameters = mapParams.values().toString().replaceAll("\\[", "_").replaceAll("\\]", "");
        }
        iTestContext.setAttribute("params", valueParameters);
    }

    @BeforeClass(dependsOnMethods = "initContext")
    public void init() throws Exception {
        ThreadLogger.setThreadLogger(Logger.getLogger(TEST_IDENTIFIER));
        logger = ThreadLogger.getThreadLogger();
        logger.addAppender(AppenderFactory.getInstance().createSimple(LevelLogger.TEST_INFO, (getClass().getName() +
                valueParameters), TEST_IDENTIFIER, true));
        logger.addAppender(AppenderFactory.getInstance().createFull(LevelLogger.TEST_INFO, (getClass().getName() +
                valueParameters), TEST_IDENTIFIER, true));
        lightAssert = new LightAssert();
    }

    @BeforeMethod
    public void clearBufferErrors() {
        lightAssert.clearBufferErrors();
    }

    public void checkBufferErrors() {
        String errorString = lightAssert.getBufferErrors();
        clearBufferErrors();
        if (!"".equals(errorString)) {
            logger.log(LevelLogger.TEST_ERROR, errorString);
            throw new AssertionError(errorString);
        }
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
    }
}
