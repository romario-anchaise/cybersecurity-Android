// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class F extends y {
    @Override // p018k0.y
    public final Object a(a aVar) {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) {
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
    }
}
