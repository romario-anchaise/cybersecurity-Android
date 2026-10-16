// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f2402e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f2404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f2405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f2406d;

    public a(File file, String str, boolean z2) {
        Lock lock;
        this.f2403a = z2;
        File file2 = new File(file, str.concat(".lck"));
        this.f2404b = file2;
        String absolutePath = file2.getAbsolutePath();
        absolutePath.getClass();
        HashMap map = f2402e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(absolutePath);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(absolutePath, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2405c = lock;
    }

    public final void a(boolean z2) {
        File file = this.f2404b;
        this.f2405c.lock();
        if (z2) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f2406d = channel;
            } catch (IOException e3) {
                this.f2406d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e3);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f2406d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f2405c.unlock();
    }
}
