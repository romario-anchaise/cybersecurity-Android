// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import android.os.StatFs;
import java.io.File;
import k1.v;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T0.c f849f;

    public final j a() {
        long j2 = this.f847d;
        z zVar = this.f844a;
        if (zVar == null) {
            throw new IllegalStateException("directory == null");
        }
        double d2 = this.f846c;
        if (d2 > 0.0d) {
            try {
                File fileE = zVar.e();
                fileE.mkdir();
                StatFs statFs = new StatFs(fileE.getAbsolutePath());
                long blockCountLong = (long) (d2 * statFs.getBlockCountLong() * statFs.getBlockSizeLong());
                long j3 = this.f848e;
                if (j2 > j3) {
                    throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
                }
                if (blockCountLong >= j2) {
                    j2 = blockCountLong > j3 ? j3 : blockCountLong;
                }
            } catch (Exception unused) {
            }
        } else {
            j2 = 0;
        }
        return new j(j2, this.f849f, this.f845b, zVar);
    }
}
