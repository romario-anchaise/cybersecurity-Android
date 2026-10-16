// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f3512c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f3513d;

    public u(RandomAccessFile randomAccessFile) {
        this.f3513d = randomAccessFile;
    }

    public final long a() {
        long length;
        ReentrantLock reentrantLock = this.f3512c;
        reentrantLock.lock();
        try {
            if (this.f3510a) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            synchronized (this) {
                length = this.f3513d.length();
            }
            return length;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f3512c;
        reentrantLock.lock();
        try {
            if (this.f3510a) {
                reentrantLock.unlock();
                return;
            }
            this.f3510a = true;
            if (this.f3511b != 0) {
                reentrantLock.unlock();
                return;
            }
            reentrantLock.unlock();
            synchronized (this) {
                this.f3513d.close();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final m f(long j2) {
        ReentrantLock reentrantLock = this.f3512c;
        reentrantLock.lock();
        try {
            if (this.f3510a) {
                throw new IllegalStateException("closed");
            }
            this.f3511b++;
            reentrantLock.unlock();
            return new m(this, j2);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
