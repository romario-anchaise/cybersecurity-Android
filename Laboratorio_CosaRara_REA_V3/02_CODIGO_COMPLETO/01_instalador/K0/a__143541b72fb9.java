// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends h {
    public a() {
        super("IDENTITY", 0);
    }

    @Override // p018k0.h
    public final String b(Field field) {
        return field.getName();
    }
}
