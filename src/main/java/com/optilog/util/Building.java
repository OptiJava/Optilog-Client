package com.optilog.util;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Building {

}
