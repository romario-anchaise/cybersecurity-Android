// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f506a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f510e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f517l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f508c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f507b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f509d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f511f = new ArrayList();

    public static CharSequence a(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }
}
