// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.io.IOException;
import java.io.StringWriter;
import p024n0.O;
import p024n0.c0;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            b bVar = new b(stringWriter);
            bVar.f4097h = 1;
            c0.f3918z.getClass();
            O.d(bVar, this);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
