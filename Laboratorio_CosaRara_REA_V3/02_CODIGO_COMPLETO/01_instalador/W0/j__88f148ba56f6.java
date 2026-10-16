// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p040w0;

import E0.p;
import F0.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class j implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4165a = new j();

    public final int hashCode() {
        return 0;
    }

    @Override // p040w0.i
    public final g j(h hVar) {
        i.e(hVar, "key");
        return null;
    }

    @Override // p040w0.i
    public final i r(h hVar) {
        i.e(hVar, "key");
        return this;
    }

    @Override // p040w0.i
    public final i t(i iVar) {
        i.e(iVar, "context");
        return iVar;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // p040w0.i
    public final Object n(Object obj, p pVar) {
        return obj;
    }
}
