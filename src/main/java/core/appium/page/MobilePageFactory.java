package core.appium.page;

import core.ios.IosLocator;
import org.apache.commons.collections4.FactoryUtils;
/**
 * Created by zaborovsky on 21.12.2016.
 */
public class MobilePageFactory {

    public <T extends MobileBasePage> T createPage(Class<T> cl) {
        return FactoryUtils.instantiateFactory(cl).create();
    }

    public <T extends MobileBasePage> T createBlock(Class<T> cl, IosLocator locator) {
        return FactoryUtils.instantiateFactory(cl, new Class[]{IosLocator.class}, new Object[]{locator}).create();
    }

}

