// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1180b;

    public e(ArrayList arrayList, int i3) {
        switch (i3) {
            case 2:
                this.f1180b = arrayList;
                break;
            default:
                this.f1180b = new ArrayList(arrayList);
                break;
        }
    }

    public boolean a() {
        return this.f1179a < this.f1180b.size();
    }

    public e(int i3, ArrayList arrayList) {
        this.f1179a = i3;
        this.f1180b = arrayList;
    }
}
