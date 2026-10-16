// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f287b;

    public a(f fVar) {
        this.f287b = fVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (j2 < 0) {
            return -1;
        }
        try {
            long j3 = this.f286a;
            f fVar = this.f287b;
            if (j3 != j2) {
                if (j3 >= 0 && j2 >= j3 + ((long) fVar.f288a.available())) {
                    return -1;
                }
                fVar.f(j2);
                this.f286a = j2;
            }
            if (i3 > fVar.f288a.available()) {
                i3 = fVar.f288a.available();
            }
            int i4 = fVar.read(bArr, i2, i3);
            if (i4 >= 0) {
                this.f286a += (long) i4;
                return i4;
            }
        } catch (IOException unused) {
        }
        this.f286a = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
