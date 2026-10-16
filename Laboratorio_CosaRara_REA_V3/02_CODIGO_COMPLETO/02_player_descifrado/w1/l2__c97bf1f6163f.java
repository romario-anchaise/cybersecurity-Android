// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4436c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f4437d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OutputStream f4438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Consumer f4439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4440g;

    public l2(OutputStream outputStream, String str, kb kbVar) {
        if (outputStream == null) {
            o2.i("output required");
            throw null;
        }
        this.f4438e = outputStream;
        this.f4439f = kbVar;
        Thread thread = new Thread(new a2.b(16, this), str);
        thread.setDaemon(true);
        thread.start();
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        w();
    }

    public final boolean d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        synchronized (this.f4436c) {
            try {
                if (!this.f4440g && this.f4437d.size() < 512) {
                    this.f4437d.addLast((byte[]) bArr.clone());
                    this.f4436c.notifyAll();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w() {
        synchronized (this.f4436c) {
            this.f4440g = true;
            this.f4437d.clear();
            this.f4436c.notifyAll();
        }
    }

    public final byte[] y() {
        synchronized (this.f4436c) {
            while (this.f4437d.isEmpty() && !this.f4440g) {
                try {
                    this.f4436c.wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f4437d.isEmpty()) {
                return null;
            }
            if (!this.f4440g && this.f4437d.size() < 64) {
                this.f4436c.wait(16L);
            }
            int iMin = Math.min(64, this.f4437d.size());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iMin * 16);
            for (int i3 = 0; i3 < iMin; i3++) {
                byte[] bArr = (byte[]) this.f4437d.removeFirst();
                byteArrayOutputStream.write(bArr, 0, bArr.length);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}
