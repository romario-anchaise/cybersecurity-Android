// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import java.util.ArrayList;
import java.util.Iterator;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4015a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractActivityC0121k f4016b;

    public o(AbstractActivityC0121k abstractActivityC0121k) {
        this.f4016b = abstractActivityC0121k;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f4015a.iterator();
    }
}
