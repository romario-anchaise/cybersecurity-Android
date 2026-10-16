// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class o extends f1.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f1.l f219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f220d;

    public o(f1.l lVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f219c = lVar;
        this.f220d = threadPoolExecutor;
    }

    @Override // f1.l
    public final void I(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f220d;
        try {
            this.f219c.I(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // f1.l
    public final void J(x xVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f220d;
        try {
            this.f219c.J(xVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
