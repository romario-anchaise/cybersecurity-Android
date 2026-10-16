// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H0;

import F0.i;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f255c = new b(0);

    @Override // H0.a
    public final Random a() {
        Object obj = this.f255c.get();
        i.d(obj, "get(...)");
        return (Random) obj;
    }
}
