package com.optilog.util;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface OnlyInLog {

}
