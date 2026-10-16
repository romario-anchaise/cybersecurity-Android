// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
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
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3746a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f3747b = new AtomicReference(c0.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f3748c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f3749d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new a2.l(13), new ThreadPoolExecutor.AbortPolicy());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f3750e = -1000;

    public static c0 a(Context context) {
        c0 c0VarA;
        synchronized (f3746a) {
            try {
                File fileC = c(context);
                if (fileC != null && fileC.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileC, "rw");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock fileLockLock = channel.lock();
                            try {
                                if (randomAccessFile.length() < 22) {
                                    c0VarA = c0.a();
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                } else {
                                    randomAccessFile.seek(0L);
                                    if (randomAccessFile.readInt() == 1093751601 && randomAccessFile.readInt() == 1) {
                                        int i3 = randomAccessFile.readInt();
                                        h2.c[] cVarArrValues = h2.c.values();
                                        h2.c cVar = (i3 < 0 || i3 >= cVarArrValues.length) ? h2.c.f1960c : cVarArrValues[i3];
                                        randomAccessFile.readBoolean();
                                        randomAccessFile.readBoolean();
                                        randomAccessFile.readLong();
                                        if (f.a(context, null).b(SystemClock.elapsedRealtime())) {
                                            c0VarA = new c0(cVar);
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                        } else {
                                            c0VarA = c0.a();
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                        }
                                    } else {
                                        c0VarA = c0.a();
                                        if (fileLockLock != null) {
                                            fileLockLock.close();
                                        }
                                        channel.close();
                                    }
                                }
                                randomAccessFile.close();
                                return c0VarA;
                            } catch (Throwable th) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                return c0.a();
            } catch (Throwable th7) {
                Log.w("A11yRuntimeState", "read failed: " + th7.getMessage());
                return c0.a();
            }
        }
    }

    public static c0 b(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = f3750e;
        if ((jElapsedRealtime < j3 || jElapsedRealtime - j3 >= 1000) && context != null && f3748c.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f3750e = jElapsedRealtime;
            try {
                f3749d.execute(new a2.m(context, 6));
            } catch (Throwable th) {
                f3748c.set(false);
                a0.a.p(th, new StringBuilder("cache refresh rejected: "), "A11yRuntimeState");
            }
        }
        return (c0) f3747b.get();
    }

    public static File c(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "a11y"), "runtime-state-v1");
    }
}
