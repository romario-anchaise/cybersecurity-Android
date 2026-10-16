// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import H.C0028c;
import W.n;
import android.webkit.MimeTypeMap;
import java.io.File;
import k1.o;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1135a;

    public h(File file) {
        this.f1135a = file;
    }

    @Override // Z.g
    public final Object a(p040w0.d dVar) {
        String str = z.f3517b;
        File file = this.f1135a;
        n nVar = new n(C0028c.s(file), o.f3497a, null, null);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String name = file.getName();
        F0.i.d(name, "getName(...)");
        return new m(nVar, singleton.getMimeTypeFromExtension(M0.e.g0(name, '.', "")), W.g.f751c);
    }
}
