package lala.util.mvp.scope;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by miguellemos on 18/10/17.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ViewScope {
}
