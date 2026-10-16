// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3944a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f3945b = new AtomicReference(e.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f3946c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f3947d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(8), new a2.l(12), new ThreadPoolExecutor.AbortPolicy());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f3948e = -1000;

    /* JADX WARN: Code duplicated, block: B:155:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:? A[Catch: all -> 0x015b, SYNTHETIC, TRY_LEAVE, TryCatch #12 {all -> 0x015b, blocks: (B:99:0x0157, B:120:0x017c, B:119:0x0179, B:116:0x0174), top: B:172:0x009c, inners: #11 }] */
    /* JADX WARN: Code duplicated, block: B:184:? A[Catch: all -> 0x0169, SYNTHETIC, TRY_LEAVE, TryCatch #4 {all -> 0x0169, blocks: (B:103:0x015e, B:128:0x018a, B:127:0x0187, B:124:0x0182), top: B:158:0x0098, inners: #1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [int] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21, types: [int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static e a(Context context, d dVar) {
        Context applicationContext;
        long j3;
        e eVarA;
        Throwable th;
        Throwable th2;
        Throwable th3;
        e eVar;
        ?? r17;
        e eVar2;
        e eVarA2;
        if (context == null) {
            applicationContext = null;
        } else {
            applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
        }
        if (applicationContext == null) {
            loop0: while (true) {
                AtomicReference atomicReference = f3945b;
                e eVar3 = (e) atomicReference.get();
                eVarA2 = dVar == null ? eVar3 : dVar.a(eVar3);
                if (dVar == null) {
                    break;
                }
                while (!atomicReference.compareAndSet(eVar3, eVarA2)) {
                    if (atomicReference.get() != eVar3) {
                    }
                }
                break loop0;
            }
            return eVarA2;
        }
        synchronized (f3944a) {
            ?? r4 = -1;
            try {
                r4 = Settings.Global.getInt(applicationContext.getContentResolver(), "boot_count", -1);
            } catch (Throwable unused) {
            }
            try {
                j3 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).lastUpdateTime;
            } catch (Throwable unused2) {
                j3 = 0;
            }
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Context contextCreateDeviceProtectedStorageContext = applicationContext.createDeviceProtectedStorageContext();
                if (contextCreateDeviceProtectedStorageContext != null) {
                    applicationContext = contextCreateDeviceProtectedStorageContext;
                }
                File file = new File(applicationContext.getFilesDir(), "a11y");
                if (!file.exists() && !file.mkdirs() && !file.isDirectory()) {
                    throw new IllegalStateException("cannot create lease directory");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, "bind-lease-v1"), "rw");
                try {
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            try {
                                FileLock fileLockLock = channel.lock();
                                try {
                                    e eVarC = c(randomAccessFile);
                                    boolean z2 = eVarC.f3823a;
                                    int i3 = eVarC.f3830h;
                                    boolean z3 = true;
                                    boolean z4 = i3 >= 0 && r4 >= 0 && i3 != r4;
                                    boolean z5 = z2 && i3 < 0 && r4 >= 0;
                                    long j4 = eVarC.f3831i;
                                    boolean z6 = j4 > 0 && j3 > 0 && j4 != j3;
                                    if (eVarC.f3827e <= jElapsedRealtime && eVarC.f3828f <= jElapsedRealtime) {
                                        z3 = false;
                                    }
                                    if (!z2 || z4 || z5 || z6 || z3) {
                                        try {
                                            ?? r18 = r4;
                                            r4 = randomAccessFile;
                                            try {
                                                eVar = new e(true, false, eVarC.f3825c, 0, 0L, jElapsedRealtime, jElapsedRealtime > 9223372036854715807L ? Long.MAX_VALUE : 60000 + jElapsedRealtime, r18 == true ? 1 : 0, j3);
                                                r4 = r4;
                                                r17 = r18;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                th3 = th;
                                                if (fileLockLock != null) {
                                                    throw th3;
                                                }
                                                try {
                                                    fileLockLock.close();
                                                    throw th3;
                                                } catch (Throwable th5) {
                                                    th3.addSuppressed(th5);
                                                    throw th3;
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            r4 = randomAccessFile;
                                            th3 = th;
                                            if (fileLockLock != null) {
                                                throw th3;
                                            }
                                            fileLockLock.close();
                                            throw th3;
                                        }
                                    } else {
                                        eVar = eVarC;
                                        r17 = r4;
                                        r4 = randomAccessFile;
                                    }
                                    if (dVar != null) {
                                        eVar = dVar.a(eVar);
                                    }
                                    eVar2 = new e(eVar.f3823a, eVar.f3824b, eVar.f3825c, eVar.f3826d, eVar.f3827e, eVar.f3828f, eVar.f3829g, r17, j3);
                                    if (!eVar2.equals(eVarC)) {
                                        d(r4, eVar2);
                                    }
                                    f3945b.set(eVar2);
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                    r4.close();
                                } catch (Throwable th7) {
                                    th = th7;
                                    r4 = randomAccessFile;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                th2 = th;
                                if (channel != null) {
                                    throw th2;
                                }
                                try {
                                    channel.close();
                                    throw th2;
                                } catch (Throwable th9) {
                                    th2.addSuppressed(th9);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            r4 = randomAccessFile;
                            th2 = th;
                            if (channel != null) {
                                throw th2;
                            }
                            channel.close();
                            throw th2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        th = th;
                        try {
                            r4.close();
                            throw th;
                        } catch (Throwable th12) {
                            th.addSuppressed(th12);
                            throw th;
                        }
                    }
                } catch (Throwable th13) {
                    th = th13;
                    r4 = randomAccessFile;
                    th = th;
                    r4.close();
                    throw th;
                }
            } catch (Throwable th14) {
                Log.w("A11yBindLease", "lease access failed: " + th14.getMessage());
                loop2: while (true) {
                    AtomicReference atomicReference2 = f3945b;
                    e eVar4 = (e) atomicReference2.get();
                    eVarA = dVar == null ? eVar4 : dVar.a(eVar4);
                    if (dVar == null) {
                        break;
                    }
                    do {
                        if (atomicReference2.compareAndSet(eVar4, eVarA)) {
                            break loop2;
                        }
                    } while (atomicReference2.get() == eVar4);
                }
                return eVarA;
            }
        }
        return eVar2;
    }

    public static e b(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = f3948e;
        if (jElapsedRealtime < j3 || jElapsedRealtime - j3 >= 1000) {
            if (context == null) {
                context = null;
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (context != null && f3946c.compareAndSet(false, true)) {
                f3948e = jElapsedRealtime;
                try {
                    f3947d.execute(new a2.m(context, 3));
                } catch (Throwable th) {
                    f3946c.set(false);
                    a0.a.p(th, new StringBuilder("cache refresh rejected: "), "A11yBindLease");
                }
            }
        }
        return (e) f3945b.get();
    }

    public static e c(RandomAccessFile randomAccessFile) {
        try {
            if (randomAccessFile.length() == 0) {
                return e.a();
            }
            randomAccessFile.seek(0L);
            if (randomAccessFile.readInt() == 1093742937 && randomAccessFile.readInt() == 1) {
                return new e(true, randomAccessFile.readBoolean(), randomAccessFile.readLong(), randomAccessFile.readInt(), randomAccessFile.readLong(), randomAccessFile.readLong(), randomAccessFile.readLong(), randomAccessFile.readInt(), randomAccessFile.readLong());
            }
            return e.a();
        } catch (Throwable unused) {
            return e.a();
        }
    }

    public static void d(RandomAccessFile randomAccessFile, e eVar) throws IOException {
        randomAccessFile.setLength(0L);
        randomAccessFile.seek(0L);
        randomAccessFile.writeInt(1093742937);
        randomAccessFile.writeInt(1);
        randomAccessFile.writeBoolean(eVar.f3824b);
        randomAccessFile.writeLong(eVar.f3825c);
        randomAccessFile.writeInt(eVar.f3826d);
        randomAccessFile.writeLong(eVar.f3827e);
        randomAccessFile.writeLong(eVar.f3828f);
        randomAccessFile.writeLong(eVar.f3829g);
        randomAccessFile.writeInt(eVar.f3830h);
        randomAccessFile.writeLong(eVar.f3831i);
        randomAccessFile.getFD().sync();
    }
}
