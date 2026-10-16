// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import p.m;
import z.l;
import z.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f3213d;

    public /* synthetic */ h(j jVar, int i3) {
        this.f3212c = i3;
        this.f3213d = jVar;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008e A[Catch: all -> 0x0048, TryCatch #3 {all -> 0x0048, blocks: (B:6:0x001a, B:8:0x001e, B:10:0x0044, B:13:0x004a, B:14:0x0051, B:15:0x0052, B:16:0x005c, B:20:0x0066, B:22:0x006e, B:23:0x0070, B:27:0x007a, B:29:0x0087, B:37:0x0099, B:33:0x008d, B:34:0x008e, B:36:0x0096, B:41:0x009d, B:24:0x0071, B:25:0x0077, B:17:0x005d, B:18:0x0063), top: B:70:0x001a, inners: #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0096 A[Catch: all -> 0x0048, TryCatch #3 {all -> 0x0048, blocks: (B:6:0x001a, B:8:0x001e, B:10:0x0044, B:13:0x004a, B:14:0x0051, B:15:0x0052, B:16:0x005c, B:20:0x0066, B:22:0x006e, B:23:0x0070, B:27:0x007a, B:29:0x0087, B:37:0x0099, B:33:0x008d, B:34:0x008e, B:36:0x0096, B:41:0x009d, B:24:0x0071, B:25:0x0077, B:17:0x005d, B:18:0x0063), top: B:70:0x001a, inners: #4, #5 }] */
    @Override // java.lang.Runnable
    public final void run() {
        b0.a aVar;
        h hVar;
        boolean zIsEmpty;
        boolean zIsEmpty2;
        switch (this.f3212c) {
            case 0:
                synchronized (this.f3213d.f3225g) {
                    j jVar = this.f3213d;
                    jVar.f3226h = (Intent) jVar.f3225g.get(0);
                    break;
                }
                Intent intent = this.f3213d.f3226h;
                if (intent != null) {
                    String action = intent.getAction();
                    int intExtra = this.f3213d.f3226h.getIntExtra("KEY_START_ID", 0);
                    m mVarD = m.d();
                    String str = j.f3218j;
                    mVarD.a(str, "Processing command " + this.f3213d.f3226h + ", " + intExtra);
                    PowerManager.WakeLock wakeLockA = n.a(this.f3213d.f3219a, action + " (" + intExtra + ")");
                    try {
                        m.d().a(str, "Acquiring operation wake lock (" + action + ") " + wakeLockA);
                        wakeLockA.acquire();
                        j jVar2 = this.f3213d;
                        jVar2.f3224f.a(intExtra, jVar2.f3226h, jVar2);
                        m.d().a(str, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                        wakeLockA.release();
                        j jVar3 = this.f3213d;
                        aVar = (b0.a) jVar3.f3220b.f6034c;
                        hVar = new h(jVar3, 1);
                    } catch (Throwable th) {
                        try {
                            m mVarD2 = m.d();
                            String str2 = j.f3218j;
                            mVarD2.c(str2, "Unexpected error in onHandleIntent", th);
                            m.d().a(str2, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                            wakeLockA.release();
                            j jVar4 = this.f3213d;
                            aVar = (b0.a) jVar4.f3220b.f6034c;
                            hVar = new h(jVar4, 1);
                        } catch (Throwable th2) {
                            m.d().a(j.f3218j, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                            wakeLockA.release();
                            j jVar5 = this.f3213d;
                            ((b0.a) jVar5.f3220b.f6034c).execute(new h(jVar5, 1));
                            throw th2;
                        }
                    }
                    aVar.execute(hVar);
                    return;
                }
                return;
            default:
                j jVar6 = this.f3213d;
                m mVarD3 = m.d();
                String str3 = j.f3218j;
                mVarD3.a(str3, "Checking if commands are complete.");
                j.c();
                synchronized (jVar6.f3225g) {
                    try {
                        if (jVar6.f3226h != null) {
                            m.d().a(str3, "Removing command " + jVar6.f3226h);
                            if (!((Intent) jVar6.f3225g.remove(0)).equals(jVar6.f3226h)) {
                                throw new IllegalStateException("Dequeue-d command is not the first.");
                            }
                            jVar6.f3226h = null;
                        }
                        l lVar = (l) jVar6.f3220b.f6032a;
                        c cVar = jVar6.f3224f;
                        synchronized (cVar.f3191c) {
                            zIsEmpty = cVar.f3190b.isEmpty();
                            break;
                        }
                        if (zIsEmpty && jVar6.f3225g.isEmpty()) {
                            synchronized (lVar.f6250f) {
                                zIsEmpty2 = lVar.f6247c.isEmpty();
                                break;
                            }
                            if (zIsEmpty2) {
                                m.d().a(str3, "No more commands & intents.");
                                SystemAlarmService systemAlarmService = jVar6.f3227i;
                                if (systemAlarmService != null) {
                                    systemAlarmService.a();
                                }
                            } else if (!jVar6.f3225g.isEmpty()) {
                                jVar6.d();
                            }
                        } else if (!jVar6.f3225g.isEmpty()) {
                            jVar6.d();
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
        }
    }
}
