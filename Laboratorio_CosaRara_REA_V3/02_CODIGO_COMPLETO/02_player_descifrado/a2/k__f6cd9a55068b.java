// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import lyr.stable.runtime.engine.CompanionService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f113e;

    public /* synthetic */ k(int i3, Context context, String str) {
        this.f111c = i3;
        this.f112d = context;
        this.f113e = str;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0213  */
    /* JADX WARN: Code duplicated, block: B:132:0x021f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0223  */
    /* JADX WARN: Code duplicated, block: B:135:0x0226  */
    /* JADX WARN: Code duplicated, block: B:137:0x023a  */
    /* JADX WARN: Code duplicated, block: B:139:0x023e  */
    /* JADX WARN: Code duplicated, block: B:142:0x025d  */
    /* JADX WARN: Code duplicated, block: B:144:0x026f  */
    /* JADX WARN: Code duplicated, block: B:167:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:60:0x010c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0139  */
    /* JADX WARN: Code duplicated, block: B:69:0x013c  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b5 A[Catch: all -> 0x01b3, TRY_LEAVE, TryCatch #10 {all -> 0x01b3, blocks: (B:81:0x0184, B:83:0x018e, B:85:0x01ae, B:99:0x01db, B:88:0x01b5, B:98:0x01d8, B:124:0x0206, B:123:0x0203, B:120:0x01fe, B:89:0x01c0, B:97:0x01d5, B:119:0x01fd, B:118:0x01fa, B:90:0x01c4, B:93:0x01ce, B:113:0x01f2, B:112:0x01ef, B:115:0x01f5), top: B:165:0x0184, outer: #16, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01ce A[Catch: all -> 0x01d2, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x01d2, blocks: (B:90:0x01c4, B:93:0x01ce, B:113:0x01f2, B:112:0x01ef, B:91:0x01c8, B:109:0x01ea), top: B:164:0x01c4, outer: #3, inners: #6, #8 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:130:0x0213, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        p pVarN;
        long jCurrentTimeMillis;
        boolean z2;
        long j3;
        long j4;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileLock fileLockLock;
        a1.d dVarE;
        p pVar;
        boolean z3;
        long j5;
        boolean zL;
        String str;
        switch (this.f111c) {
            case 0:
                Context context = this.f112d;
                String str2 = this.f113e;
                synchronized (r.f138b) {
                    try {
                        File fileI = r.i(context);
                        if (fileI.exists()) {
                            randomAccessFile = new RandomAccessFile(r.j(context), "rw");
                            channel = randomAccessFile.getChannel();
                            fileLockLock = channel.lock();
                            pVarN = r.n(fileI);
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
                            r.f139c = pVarN;
                        } else {
                            if (new File(fileI.getPath() + ".bak").exists()) {
                                randomAccessFile = new RandomAccessFile(r.j(context), "rw");
                                try {
                                    channel = randomAccessFile.getChannel();
                                    try {
                                        fileLockLock = channel.lock();
                                        try {
                                            pVarN = r.n(fileI);
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                        } catch (Throwable th) {
                                            if (fileLockLock == null) {
                                                throw th;
                                            }
                                            try {
                                                fileLockLock.close();
                                                throw th;
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                                throw th;
                                            }
                                            try {
                                                randomAccessFile.close();
                                                throw th;
                                            } catch (Throwable th3) {
                                                th.addSuppressed(th3);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        if (channel == null) {
                                            throw th4;
                                        }
                                        try {
                                            channel.close();
                                            throw th4;
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                            throw th4;
                                        }
                                        Log.w("MeshRestartGate", "cross-process gate reconciliation unavailable", th);
                                        pVarN = null;
                                        if (pVarN == null) {
                                            return;
                                        }
                                        jCurrentTimeMillis = System.currentTimeMillis();
                                        z2 = pVarN.f132h;
                                        j3 = pVarN.f129e;
                                        if (z2) {
                                            if (j3 > jCurrentTimeMillis) {
                                                j4 = j3 - jCurrentTimeMillis;
                                            } else {
                                                j4 = 1;
                                            }
                                            c2.p.B(-1, 20003, j4, context, r.g("reconcile-".concat(str2), pVarN.f131g));
                                        } else if (j3 > 0) {
                                            c2.p.B(-1, 20001, Math.max(1L, j3 - jCurrentTimeMillis), context, r.t(pVarN.f131g, "reconcile-".concat(str2), pVarN.f130f));
                                        }
                                        if (r.l(jCurrentTimeMillis, pVarN)) {
                                            String strG = r.g("reconcile-".concat(str2), pVarN.f131g);
                                            long j6 = pVarN.f128d;
                                            c2.p.B(-1, 20003, j6 > jCurrentTimeMillis ? j6 - jCurrentTimeMillis : 1L, context, strG);
                                            CompanionService.e(context);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th6) {
                                    randomAccessFile.close();
                                    throw th6;
                                }
                            } else {
                                pVarN = p.a(0L);
                            }
                            r.f139c = pVarN;
                        }
                    } catch (Throwable th7) {
                        Log.w("MeshRestartGate", "cross-process gate reconciliation unavailable", th7);
                        pVarN = null;
                    }
                }
                if (pVarN == null) {
                    return;
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                z2 = pVarN.f132h;
                j3 = pVarN.f129e;
                if (z2) {
                    if (j3 > jCurrentTimeMillis) {
                        j4 = j3 - jCurrentTimeMillis;
                    } else {
                        j4 = 1;
                    }
                    c2.p.B(-1, 20003, j4, context, r.g("reconcile-".concat(str2), pVarN.f131g));
                } else if (j3 > 0) {
                    c2.p.B(-1, 20001, Math.max(1L, j3 - jCurrentTimeMillis), context, r.t(pVarN.f131g, "reconcile-".concat(str2), pVarN.f130f));
                }
                if (r.l(jCurrentTimeMillis, pVarN)) {
                    String strG2 = r.g("reconcile-".concat(str2), pVarN.f131g);
                    long j7 = pVarN.f128d;
                    c2.p.B(-1, 20003, j7 > jCurrentTimeMillis ? j7 - jCurrentTimeMillis : 1L, context, strG2);
                    CompanionService.e(context);
                    return;
                }
                return;
            default:
                Context context2 = this.f112d;
                String str3 = this.f113e;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long jFloorMod = ((long) Math.floorMod((context2.getPackageName() + ":" + str3).hashCode(), 10001)) + 5000;
                synchronized (r.f138b) {
                    try {
                        File fileI2 = r.i(context2);
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(r.j(context2), "rw");
                        try {
                            FileChannel channel2 = randomAccessFile2.getChannel();
                            try {
                                FileLock fileLockLock2 = channel2.lock();
                                try {
                                    p pVarN2 = r.n(fileI2);
                                    r.f139c = pVarN2;
                                    dVarE = r.e(jCurrentTimeMillis2, jFloorMod, pVarN2);
                                    if (dVarE.f41c) {
                                        r.x(fileI2, (p) dVarE.f42d);
                                    }
                                    r.f139c = (p) dVarE.f42d;
                                    if (fileLockLock2 != null) {
                                        fileLockLock2.close();
                                    }
                                    channel2.close();
                                    randomAccessFile2.close();
                                } catch (Throwable th8) {
                                    if (fileLockLock2 == null) {
                                        throw th8;
                                    }
                                    try {
                                        fileLockLock2.close();
                                        throw th8;
                                    } catch (Throwable th9) {
                                        th8.addSuppressed(th9);
                                        throw th8;
                                    }
                                    try {
                                        randomAccessFile2.close();
                                        throw th;
                                    } catch (Throwable th10) {
                                        th.addSuppressed(th10);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th11) {
                                if (channel2 == null) {
                                    throw th11;
                                }
                                try {
                                    channel2.close();
                                    throw th11;
                                } catch (Throwable th12) {
                                    th11.addSuppressed(th12);
                                    throw th11;
                                }
                                Log.w("MeshRestartGate", "cross-process gate unavailable; using process fallback", th);
                                synchronized (r.f138b) {
                                    dVarE = r.e(jCurrentTimeMillis2, jFloorMod, r.f139c);
                                    r.f139c = (p) dVarE.f42d;
                                    pVar = (p) dVarE.f42d;
                                    z3 = pVar.f132h;
                                    j5 = pVar.f129e;
                                    if (z3) {
                                        c2.p.B(-1, 20003, j5 > jCurrentTimeMillis2 ? j5 - jCurrentTimeMillis2 : 1L, context2, r.g(str3, pVar.f131g));
                                        Log.i("MeshRestartGate", "mesh repair redirected to pending fuse restore source=".concat(str3));
                                        return;
                                    }
                                    long jMax = Math.max(1L, j5 - jCurrentTimeMillis2);
                                    p pVar2 = (p) dVarE.f42d;
                                    c2.p.B(-1, 20001, jMax, context2, r.t(pVar2.f131g, str3, pVar2.f130f));
                                    zL = r.l(jCurrentTimeMillis2, (p) dVarE.f42d);
                                    if (zL) {
                                        String strG3 = r.g(str3, ((p) dVarE.f42d).f131g);
                                        long j8 = ((p) dVarE.f42d).f128d;
                                        c2.p.B(-1, 20003, j8 > jCurrentTimeMillis2 ? j8 - jCurrentTimeMillis2 : 1L, context2, strG3);
                                    }
                                    if (zL) {
                                        CompanionService.e(context2);
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    if (dVarE.f41c) {
                                        str = "mesh repair scheduled";
                                    } else {
                                        str = "mesh repair coalesced";
                                    }
                                    sb.append(str);
                                    sb.append(" source=");
                                    sb.append(str3);
                                    sb.append(" delayMs=");
                                    sb.append(jMax);
                                    sb.append(" repairCount=");
                                    sb.append(((p) dVarE.f42d).f127c);
                                    sb.append(" essentialOnly=");
                                    sb.append(((p) dVarE.f42d).f130f);
                                    Log.i("MeshRestartGate", sb.toString());
                                    return;
                                }
                            }
                        } catch (Throwable th13) {
                            randomAccessFile2.close();
                            throw th13;
                        }
                    } catch (Throwable th14) {
                        Log.w("MeshRestartGate", "cross-process gate unavailable; using process fallback", th14);
                        synchronized (r.f138b) {
                            dVarE = r.e(jCurrentTimeMillis2, jFloorMod, r.f139c);
                            r.f139c = (p) dVarE.f42d;
                            pVar = (p) dVarE.f42d;
                            z3 = pVar.f132h;
                            j5 = pVar.f129e;
                            if (z3) {
                                c2.p.B(-1, 20003, j5 > jCurrentTimeMillis2 ? j5 - jCurrentTimeMillis2 : 1L, context2, r.g(str3, pVar.f131g));
                                Log.i("MeshRestartGate", "mesh repair redirected to pending fuse restore source=".concat(str3));
                                return;
                            }
                            long jMax2 = Math.max(1L, j5 - jCurrentTimeMillis2);
                            p pVar3 = (p) dVarE.f42d;
                            c2.p.B(-1, 20001, jMax2, context2, r.t(pVar3.f131g, str3, pVar3.f130f));
                            zL = r.l(jCurrentTimeMillis2, (p) dVarE.f42d);
                            if (zL) {
                                String strG4 = r.g(str3, ((p) dVarE.f42d).f131g);
                                long j9 = ((p) dVarE.f42d).f128d;
                                c2.p.B(-1, 20003, j9 > jCurrentTimeMillis2 ? j9 - jCurrentTimeMillis2 : 1L, context2, strG4);
                            }
                            if (zL) {
                                CompanionService.e(context2);
                            }
                            StringBuilder sb2 = new StringBuilder();
                            if (dVarE.f41c) {
                                str = "mesh repair scheduled";
                            } else {
                                str = "mesh repair coalesced";
                            }
                            sb2.append(str);
                            sb2.append(" source=");
                            sb2.append(str3);
                            sb2.append(" delayMs=");
                            sb2.append(jMax2);
                            sb2.append(" repairCount=");
                            sb2.append(((p) dVarE.f42d).f127c);
                            sb2.append(" essentialOnly=");
                            sb2.append(((p) dVarE.f42d).f130f);
                            Log.i("MeshRestartGate", sb2.toString());
                            return;
                        }
                    }
                }
                pVar = (p) dVarE.f42d;
                z3 = pVar.f132h;
                j5 = pVar.f129e;
                if (z3) {
                    c2.p.B(-1, 20003, j5 > jCurrentTimeMillis2 ? j5 - jCurrentTimeMillis2 : 1L, context2, r.g(str3, pVar.f131g));
                    Log.i("MeshRestartGate", "mesh repair redirected to pending fuse restore source=".concat(str3));
                    return;
                }
                long jMax3 = Math.max(1L, j5 - jCurrentTimeMillis2);
                p pVar4 = (p) dVarE.f42d;
                c2.p.B(-1, 20001, jMax3, context2, r.t(pVar4.f131g, str3, pVar4.f130f));
                zL = r.l(jCurrentTimeMillis2, (p) dVarE.f42d);
                if (zL) {
                    String strG5 = r.g(str3, ((p) dVarE.f42d).f131g);
                    long j10 = ((p) dVarE.f42d).f128d;
                    c2.p.B(-1, 20003, j10 > jCurrentTimeMillis2 ? j10 - jCurrentTimeMillis2 : 1L, context2, strG5);
                }
                if (zL) {
                    CompanionService.e(context2);
                }
                StringBuilder sb3 = new StringBuilder();
                if (dVarE.f41c) {
                    str = "mesh repair scheduled";
                } else {
                    str = "mesh repair coalesced";
                }
                sb3.append(str);
                sb3.append(" source=");
                sb3.append(str3);
                sb3.append(" delayMs=");
                sb3.append(jMax3);
                sb3.append(" repairCount=");
                sb3.append(((p) dVarE.f42d).f127c);
                sb3.append(" essentialOnly=");
                sb3.append(((p) dVarE.f42d).f130f);
                Log.i("MeshRestartGate", sb3.toString());
                return;
        }
    }
}
