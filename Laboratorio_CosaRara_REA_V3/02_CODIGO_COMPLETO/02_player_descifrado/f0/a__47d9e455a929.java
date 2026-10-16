// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f0;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Status f1105c;

    public a(Status status) {
        int i3 = status.f472c;
        String str = status.f473d;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 2 + String.valueOf(str).length());
        sb.append(i3);
        sb.append(": ");
        sb.append(str);
        super(sb.toString());
        this.f1105c = status;
    }
}
