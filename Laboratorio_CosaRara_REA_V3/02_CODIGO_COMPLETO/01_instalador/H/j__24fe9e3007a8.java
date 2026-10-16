// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f203b;

    public j(List list, int i2, Throwable th) {
        p028p0.a.a(list, "initCallbacks cannot be null");
        this.f202a = new ArrayList(list);
        this.f203b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f202a;
        int size = arrayList.size();
        int i2 = 0;
        if (this.f203b != 1) {
            while (i2 < size) {
                ((i) arrayList.get(i2)).getClass();
                i2++;
            }
        } else {
            while (i2 < size) {
                ((i) arrayList.get(i2)).a();
                i2++;
            }
        }
    }
}
