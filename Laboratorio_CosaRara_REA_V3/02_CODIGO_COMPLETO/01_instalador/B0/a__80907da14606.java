// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p003b0;

import java.io.File;
import p010f0.m;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2097a;

    public a(boolean z2) {
        this.f2097a = z2;
    }

    @Override // p003b0.b
    public final String a(Object obj, m mVar) {
        File file = (File) obj;
        if (!this.f2097a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
