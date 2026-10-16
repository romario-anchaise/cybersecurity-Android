// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import java.io.IOException;
import java.util.ArrayList;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f859f;
    public b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f861i;

    public c(g gVar, String str) {
        this.f861i = gVar;
        this.f854a = str;
        gVar.getClass();
        this.f855b = new long[2];
        this.f856c = new ArrayList(2);
        this.f857d = new ArrayList(2);
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i2 = 0; i2 < 2; i2++) {
            sb.append(i2);
            this.f856c.add(this.f861i.f868a.d(sb.toString()));
            sb.append(".tmp");
            this.f857d.add(this.f861i.f868a.d(sb.toString()));
            sb.setLength(length);
        }
    }

    public final d a() {
        if (!this.f858e || this.g != null || this.f859f) {
            return null;
        }
        ArrayList arrayList = this.f856c;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            g gVar = this.f861i;
            if (i2 >= size) {
                this.f860h++;
                return new d(gVar, this);
            }
            if (!gVar.f882p.c((z) arrayList.get(i2))) {
                try {
                    gVar.x(this);
                } catch (IOException unused) {
                }
                return null;
            }
            i2++;
        }
    }
}
