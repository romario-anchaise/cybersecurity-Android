// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t6 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q6 f5156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q6 f5157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5158f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5153a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f5154b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashSet f5155c = new LinkedHashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5159g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5160h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5161i = -1;

    public final synchronized q6 a(q6 q6Var, long j3, long j4) {
        try {
            if (j4 < 0) {
                throw new IllegalArgumentException("requiredStableMs");
            }
            long j5 = this.f5161i;
            if (j5 >= 0 && j3 < j5) {
                e();
            }
            this.f5161i = j3;
            boolean z2 = false;
            if (q6Var == null) {
                List list = Collections.EMPTY_LIST;
                q6Var = new q6("none", 0);
            }
            d(q6Var.f4904b, j3);
            c(q6Var.f4914l, j3);
            if (!"stable".equals(q6Var.f4903a)) {
                this.f5157e = null;
                q6 q6Var2 = this.f5156d;
                if (q6Var2 != null) {
                    if (this.f5159g < 0) {
                        this.f5159g = j3;
                    }
                    long j6 = this.f5159g;
                    if ((j3 >= j6 ? j3 - j6 : 0L) < j4) {
                        return q6Var2.a(q6Var.f4905c).b(q6Var.f4911i, q6Var.f4912j, q6Var.f4913k);
                    }
                }
                this.f5156d = null;
                this.f5159g = -1L;
                this.f5160h = -1L;
                return q6Var.c("ambiguous", q6Var.f4905c);
            }
            this.f5159g = -1L;
            long j7 = this.f5160h;
            if (j7 >= 0) {
                if ((j3 >= j7 ? j3 - j7 : 0L) < j4) {
                    z2 = true;
                }
            }
            if (!z2 && j7 >= 0) {
                this.f5160h = -1L;
            }
            q6 q6Var3 = this.f5156d;
            if (q6Var3 != null && q6Var3.f4904b.equals(q6Var.f4904b)) {
                this.f5156d = q6Var;
                this.f5157e = null;
                if (z2) {
                    return q6Var.a(q6Var.f4905c);
                }
                return q6Var;
            }
            q6 q6Var4 = this.f5157e;
            if (q6Var4 == null || !q6Var4.f4904b.equals(q6Var.f4904b)) {
                this.f5157e = q6Var;
                this.f5158f = j3;
            } else {
                long j8 = this.f5158f;
                if ((j3 >= j8 ? j3 - j8 : 0L) >= j4) {
                    this.f5156d = q6Var;
                    this.f5157e = null;
                    this.f5160h = -1L;
                    return q6Var;
                }
            }
            q6 q6Var5 = this.f5156d;
            return (q6Var5 != null ? q6Var5.a(q6Var.f4905c) : q6Var.c("transition", q6Var.f4905c)).b(q6Var.f4911i, q6Var.f4912j, q6Var.f4913k);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized q6 b(q6 q6Var, long j3) {
        e();
        this.f5161i = j3;
        if (q6Var == null) {
            List list = Collections.EMPTY_LIST;
            return new q6("none", 0);
        }
        if ("stable".equals(q6Var.f4903a)) {
            this.f5156d = q6Var;
        }
        d(q6Var.f4904b, j3);
        c(q6Var.f4914l, j3);
        return q6Var;
    }

    public final void c(List list, long j3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    str = "";
                }
                if (!str.isEmpty()) {
                    linkedHashSet.add(str);
                    LinkedHashMap linkedHashMap = this.f5154b;
                    s6 s6Var = (s6) linkedHashMap.get(str);
                    if (s6Var == null) {
                        if (linkedHashMap.size() >= 32) {
                            linkedHashMap.remove((String) linkedHashMap.keySet().iterator().next());
                        }
                        linkedHashMap.put(str, new s6(j3));
                    } else {
                        if (!this.f5155c.contains(str)) {
                            s6Var.f5053a = j3;
                        }
                        s6Var.f5054b = j3;
                    }
                }
            }
        }
        this.f5155c = linkedHashSet;
    }

    public final void d(String str, long j3) {
        if (str == null) {
            str = "";
        }
        LinkedHashMap linkedHashMap = this.f5153a;
        s6 s6Var = (s6) linkedHashMap.get(str);
        if (s6Var != null) {
            s6Var.f5054b = j3;
            return;
        }
        if (linkedHashMap.size() >= 32) {
            linkedHashMap.remove((String) linkedHashMap.keySet().iterator().next());
        }
        linkedHashMap.put(str, new s6(j3));
    }

    public final void e() {
        this.f5156d = null;
        this.f5157e = null;
        this.f5158f = 0L;
        this.f5159g = -1L;
        this.f5160h = -1L;
        this.f5161i = -1L;
        this.f5153a.clear();
        this.f5154b.clear();
        this.f5155c.clear();
    }

    public final synchronized u6 f() {
        LinkedHashMap linkedHashMap;
        try {
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : this.f5154b.entrySet()) {
                s6 s6Var = (s6) entry.getValue();
                linkedHashMap.put((String) entry.getKey(), new m0(s6Var.f5053a, s6Var.f5054b));
            }
        } catch (Throwable th) {
            throw th;
        }
        return new u6(linkedHashMap, this.f5155c);
    }
}
