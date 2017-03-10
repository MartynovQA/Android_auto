package core.condition;

import com.google.common.base.Function;
import org.openqa.selenium.SearchContext;

/**
 * Created by zaborovsky on 23.12.2016.
 */
public interface SearchContextCondition<T> extends Function<SearchContext, T>{
}
