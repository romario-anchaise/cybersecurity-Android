// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import e2.n1;
import i1.q;
import java.io.File;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends q1.f implements p1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2370d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(p1.a aVar) {
        this.f2369c = 3;
        this.f2370d = (q1.f) aVar;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [p1.a, q1.f] */
    @Override // p1.a
    public Object d() {
        f fVar;
        switch (this.f2369c) {
            case 1:
                c.i iVar = (c.i) this.f2370d;
                String strK = iVar.k();
                WorkDatabase workDatabase = (WorkDatabase) iVar.f386a;
                workDatabase.getClass();
                workDatabase.a();
                workDatabase.b();
                return workDatabase.h().r().y(strK);
            case 2:
                return (List) this.f2370d;
            case 3:
                try {
                    return (List) ((q1.f) this.f2370d).d();
                } catch (SSLPeerUnverifiedException unused) {
                    return q.f2104c;
                }
            default:
                g gVar = (g) this.f2370d;
                Context context = gVar.f2387c;
                String str = gVar.f2388d;
                if (str == null || !gVar.f2390f) {
                    fVar = new f(context, gVar.f2388d, new n1(11), gVar.f2389e, gVar.f2391g);
                } else {
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    noBackupFilesDir.getClass();
                    fVar = new f(context, new File(noBackupFilesDir, str).getAbsolutePath(), new n1(11), gVar.f2389e, gVar.f2391g);
                }
                fVar.setWriteAheadLoggingEnabled(gVar.f2393i);
                return fVar;
        }
    }

    public /* synthetic */ b(int i3, Object obj) {
        this.f2369c = i3;
        this.f2370d = obj;
    }
}
