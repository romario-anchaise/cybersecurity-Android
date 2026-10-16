// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p020l0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    String[] alternate() default {};

    String value();
}
