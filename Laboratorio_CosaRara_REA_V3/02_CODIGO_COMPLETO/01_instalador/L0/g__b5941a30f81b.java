// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f352b;

    public /* synthetic */ g(int i2, Object obj) {
        this.f351a = i2;
        this.f352b = obj;
    }

    @Override // L0.c
    public final Iterator iterator() {
        switch (this.f351a) {
            case 0:
                return (Iterator) this.f352b;
            default:
                return ((List) this.f352b).iterator();
        }
    }
}
