// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4998h;

    public final void a() {
        this.f4997g = 0;
        this.f4998h = -1L;
    }

    public final p7 b(j7 j7Var, long j3, boolean z2, boolean z3, String str) {
        byte[] bytes;
        String str2 = j7Var.f4342b;
        boolean zEquals = str2.equals(this.f4994d);
        boolean z4 = !zEquals;
        long j4 = this.f4992b;
        long j5 = this.f4993c;
        if (!zEquals) {
            if (j5 == Long.MAX_VALUE) {
                o2.k("revision exhausted");
                return null;
            }
            j5++;
            if (j4 == 0 || !((String) j7Var.f4346f).equals(this.f4995e)) {
                if (j4 == Long.MAX_VALUE) {
                    o2.k("scene epoch exhausted");
                    return null;
                }
                j4++;
            }
        }
        long j6 = j5;
        long j7 = j4;
        boolean z5 = !zEquals || z2 || z3 || this.f4993c == 0;
        long j8 = this.f4991a;
        if (z5) {
            StringBuilder sbL = n4.L("full", j8, j7, j6, j3, str2, str);
            sbL.append(",\"baseRevision\":0");
            String str3 = j7Var.f4341a;
            if (str3.length() < 2 || str3.charAt(0) != '{' || str3.charAt(str3.length() - 1) != '}') {
                j6 = j6;
                j6 = j6;
                j6 = j6;
                o2.i("invalid canonical body");
                return null;
            }
            if (str3.length() > 2) {
                j6 = j6;
                sbL.append(',');
                sbL.append((CharSequence) str3, 1, str3.length() - 1);
            }
            j6 = j6;
            sbL.append('}');
            bytes = sbL.toString().getBytes(StandardCharsets.UTF_8);
        } else {
            long j9 = this.f4992b;
            long j10 = this.f4993c;
            String str4 = this.f4994d;
            String str5 = this.f4996f;
            StringBuilder sbL2 = n4.L("freshness", j8, j9, j10, j3, str4, str);
            j4.d(sbL2, ",\"baseRevision\":", j10, ",\"state\":");
            n4.C0(sbL2, str5);
            sbL2.append('}');
            bytes = sbL2.toString().getBytes(StandardCharsets.UTF_8);
        }
        if (bytes.length <= 61440) {
            return new p7(bytes, z5 ? "full" : "freshness", (String) j7Var.f4345e, str, this.f4991a, j7, j6, j3, false, j7Var.f4343c, j7Var.f4344d, this.f4992b, this.f4993c, j7Var, z4);
        }
        o2.k("v3 JSON exceeds decompression limit");
        return null;
    }
}
