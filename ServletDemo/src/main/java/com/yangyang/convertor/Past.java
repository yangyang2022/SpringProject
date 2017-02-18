package com.yangyang.convertor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastValidator.class)
@Documented
public @interface Past {

    String message() default "日期不能超过今天!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
