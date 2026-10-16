// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object[] f3418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f3419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s f3420f;

    public q(s sVar, String str, Object[] objArr, a aVar) {
        this.f3420f = sVar;
        this.f3417c = str;
        this.f3418d = objArr;
        this.f3419e = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f3417c);
        Object[] objArr = this.f3418d;
        if (objArr != null) {
            for (Object obj : objArr) {
                jSONArray.put(obj);
            }
        }
        e1.d dVar = new e1.d(2, jSONArray);
        if (this.f3419e != null) {
            int i3 = this.f3420f.f3426c;
            s.f3424m.fine(String.format("emitting packet with ack id %d", Integer.valueOf(i3)));
            this.f3420f.f3430g.put(Integer.valueOf(i3), this.f3419e);
            s sVar = this.f3420f;
            int i4 = sVar.f3426c;
            sVar.f3426c = i4 + 1;
            dVar.f695b = i4;
        }
        boolean z2 = this.f3420f.f3425b;
        s sVar2 = this.f3420f;
        if (z2) {
            sVar2.l(dVar);
        } else {
            sVar2.f3433j.add(dVar);
        }
    }
}
