// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends LinkedList {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f3414c;

    public o(s sVar, k kVar) {
        this.f3414c = sVar;
        n nVar = new n(this, 0);
        kVar.c("open", nVar);
        add(new l(kVar, "open", nVar));
        n nVar2 = new n(this, 1);
        kVar.c("packet", nVar2);
        add(new l(kVar, "packet", nVar2));
        n nVar3 = new n(this, 2);
        kVar.c("error", nVar3);
        add(new l(kVar, "error", nVar3));
        n nVar4 = new n(this, 3);
        kVar.c("close", nVar4);
        add(new l(kVar, "close", nVar4));
    }
}
