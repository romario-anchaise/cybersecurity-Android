// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public interface Q {
    default N b(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default N c(Class cls, M.c cVar) {
        return b(cls);
    }
}
