// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.content.Context;
import android.os.SystemClock;
import android.provider.Settings;
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
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f443a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f444b = new AtomicReference(n.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f445c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f446d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new a2.l(4), new ThreadPoolExecutor.AbortPolicy());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f447e = -1000;

    public static m a(Context context) {
        long j3;
        int i3 = -1;
        try {
            i3 = Settings.Global.getInt(context.getContentResolver(), "boot_count", -1);
        } catch (Throwable unused) {
        }
        try {
            j3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Throwable unused2) {
            j3 = 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        m mVar = new m();
        mVar.f438a = jElapsedRealtime;
        mVar.f440c = i3;
        mVar.f439b = j3;
        return mVar;
    }

    public static n b(RandomAccessFile randomAccessFile, m mVar) {
        int i3 = mVar.f440c;
        try {
            if (randomAccessFile.length() != 36) {
                return n.a();
            }
            randomAccessFile.seek(0L);
            if (randomAccessFile.readInt() == 1195917873) {
                boolean z2 = true;
                if (randomAccessFile.readInt() == 1) {
                    long j3 = randomAccessFile.readLong();
                    long j4 = randomAccessFile.readLong();
                    int i4 = randomAccessFile.readInt();
                    long j5 = randomAccessFile.readLong();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    boolean z3 = (i4 >= 0 || i3 >= 0) && i4 != i3;
                    long j6 = mVar.f439b;
                    if (j6 <= 0 || j5 == j6) {
                        z2 = false;
                    }
                    if (j3 > 0 && j4 >= 0 && j4 <= mVar.f438a && j3 <= jCurrentTimeMillis + 60000 && !z3 && !z2) {
                        return new n(true, j3, j4, i4, j5);
                    }
                    return n.a();
                }
            }
            return n.a();
        } catch (Throwable unused) {
            return n.a();
        }
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        File fileD = d(context);
        if (fileD == null || !fileD.isFile()) {
            return;
        }
        synchronized (f443a) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileD, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            f444b.set(b(randomAccessFile, a(context)));
                            f447e = SystemClock.elapsedRealtime();
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
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
            } catch (Throwable th7) {
                Log.w("GatewayHeartbeatLease", "read failed: " + th7.getMessage());
            }
        }
    }

    public static File d(Context context) {
        if (context == null) {
            return null;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        return new File(new File(filesDir, "keepalive"), "gateway-heartbeat-v1");
    }
}
