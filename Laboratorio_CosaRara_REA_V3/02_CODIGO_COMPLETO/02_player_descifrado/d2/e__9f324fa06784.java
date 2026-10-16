// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileOutputStream f552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BufferedOutputStream f553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f555f;

    public e(String str, File file, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream, long j3) {
        this.f550a = str;
        this.f551b = file;
        this.f552c = fileOutputStream;
        this.f553d = bufferedOutputStream;
        this.f554e = j3;
    }
}
