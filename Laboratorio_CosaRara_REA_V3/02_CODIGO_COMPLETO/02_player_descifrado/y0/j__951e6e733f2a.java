// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o[] f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f6066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f6068d;

    public j(o[] oVarArr, f fVar, String str, l lVar) {
        this.f6065a = oVarArr;
        this.f6066b = fVar;
        this.f6067c = str;
        this.f6068d = lVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        a aVar;
        Object obj = objArr[0];
        if (obj instanceof Exception) {
            aVar = new a("probe error", (Exception) obj);
        } else {
            aVar = obj instanceof String ? new a("probe error: ".concat((String) obj)) : new a("probe error");
        }
        aVar.f6035c = this.f6065a[0].f6109c;
        this.f6066b.a(new Object[0]);
        Logger logger = l.A;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("probe transport \"%s\" failed because of error: %s", this.f6067c, obj));
        }
        this.f6068d.a("upgradeError", aVar);
    }
}
