// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w1.c7;
import w1.j7;
import w1.m7;
import w1.o7;
import w1.y6;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Serializable f541e;

    public a(int i3) {
        switch (i3) {
            case 1:
                this.f541e = new LinkedHashMap();
                this.f537a = "";
                break;
            default:
                this.f541e = new StringBuilder();
                this.f540d = -1L;
                this.f537a = "";
                this.f539c = 6;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x014b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0154  */
    /* JADX WARN: Code duplicated, block: B:62:0x0159  */
    /* JADX WARN: Code duplicated, block: B:64:0x015f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0162 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0164  */
    /* JADX WARN: Code duplicated, block: B:69:0x016e  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:94:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c8  */
    public m2.b a(o7 o7Var, y6 y6Var, long j3) {
        boolean z2;
        boolean z3;
        String str;
        c7 c7Var;
        boolean z4;
        o7 o7VarJ;
        long j4;
        boolean z5;
        boolean z6;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f541e;
        m7 m7Var = o7Var.f4734m;
        boolean z7 = o7Var.f4731j;
        List list = o7Var.n;
        j7 j7Var = o7Var.f4733l;
        y6 y6Var2 = y6Var == null ? y6.f5601h : y6Var;
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            long j5 = ((c7) ((Map.Entry) it.next()).getValue()).f3663c;
            if (j3 < j5 || j3 - j5 > 1500) {
                it.remove();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(o7Var.f4725d);
        sb.append("|");
        sb.append(o7Var.f4722a);
        sb.append("|");
        sb.append(o7Var.f4726e);
        sb.append("|");
        sb.append(o7Var.f4727f);
        sb.append("x");
        sb.append(o7Var.f4728g);
        sb.append("|");
        sb.append(o7Var.f4729h);
        sb.append("|");
        sb.append(o7Var.f4730i);
        sb.append("|");
        sb.append(j7Var.f4342b);
        sb.append("|");
        boolean z8 = y6Var2.f5602a;
        long j6 = y6Var2.f5604c;
        boolean z9 = y6Var2.f5607f;
        String str2 = y6Var2.f5603b;
        sb.append(z8 ? str2 : "no-ime");
        String string = sb.toString();
        boolean z10 = z7 == 0 && j7Var.a();
        if (z10 && z8 && !z9) {
            z2 = z9;
            if (string.equals(this.f537a) && this.f538b == j6) {
                this.f539c++;
            } else {
                this.f537a = string;
                this.f538b = j6;
                this.f539c = 1;
                this.f540d = j3;
            }
            if (this.f539c >= 2 && j3 - this.f540d >= 140) {
                z3 = true;
            }
            if (!z10 && (!z8 || z2 || z3)) {
                linkedHashMap.put(string, new c7(o7Var, y6Var2, j3));
                while (linkedHashMap.size() > 8) {
                    Iterator it2 = linkedHashMap.keySet().iterator();
                    if (!it2.hasNext()) {
                        break;
                    }
                    it2.next();
                    it2.remove();
                }
                this.f537a = "";
                this.f538b = 0L;
                this.f539c = 0;
                this.f540d = 0L;
                return new m2.b(o7Var, true, false, list.size());
            }
            if (m7Var != null) {
                str = m7Var.f4541h;
                if (str.isEmpty()) {
                    str = "incomplete";
                    if (!z7) {
                        if (!j7Var.a()) {
                            str = "scene_transition";
                        } else if (z8) {
                            str = "ime_unsettled";
                        }
                    }
                }
            } else {
                str = "incomplete";
                if (!z7) {
                    if (!j7Var.a()) {
                        str = "scene_transition";
                    } else if (z8) {
                        str = "ime_unsettled";
                    }
                }
            }
            c7Var = (c7) linkedHashMap.get(string);
            if (c7Var != null) {
                j4 = c7Var.f3663c;
                if (j3 >= j4 || j3 - j4 > 1500) {
                    z4 = false;
                } else {
                    y6 y6Var3 = c7Var.f3662b;
                    List list2 = y6Var2.f5608g;
                    boolean z11 = y6Var3.f5602a;
                    if (z8) {
                        z5 = true;
                        if (!z11 || !y6Var3.f5603b.equals(str2) || list2.isEmpty()) {
                            z6 = false;
                            break;
                        }
                        Iterator it3 = list2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z6 = true;
                                break;
                            }
                            if (!y6Var3.f5608g.contains((Long) it3.next())) {
                                z6 = false;
                                break;
                            }
                        }
                    } else {
                        z5 = true;
                        z6 = !z11;
                    }
                    if (z6) {
                        z4 = z5;
                    } else {
                        z4 = false;
                    }
                }
            } else {
                z4 = false;
            }
            if (z4) {
                o7 o7Var2 = c7Var.f3661a;
                o7VarJ = o7Var.j(o7Var2.n, o7Var2.f4733l, str);
            } else {
                o7VarJ = o7Var.j(list, j7Var, str);
            }
            return new m2.b(o7VarJ, false, z4, list.size());
        }
        z2 = z9;
        this.f537a = "";
        this.f538b = 0L;
        this.f539c = 0;
        this.f540d = 0L;
        z3 = false;
        if (!z10) {
        }
        if (m7Var != null) {
            str = m7Var.f4541h;
            if (str.isEmpty()) {
                str = "incomplete";
                if (!z7) {
                    if (!j7Var.a()) {
                        str = "scene_transition";
                    } else if (z8) {
                        str = "ime_unsettled";
                    }
                }
            }
        } else {
            str = "incomplete";
            if (!z7) {
                if (!j7Var.a()) {
                    str = "scene_transition";
                } else if (z8) {
                    str = "ime_unsettled";
                }
            }
        }
        c7Var = (c7) linkedHashMap.get(string);
        if (c7Var != null) {
            j4 = c7Var.f3663c;
            if (j3 >= j4) {
                z4 = false;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (z4) {
            o7 o7Var3 = c7Var.f3661a;
            o7VarJ = o7Var.j(o7Var3.n, o7Var3.f4733l, str);
        } else {
            o7VarJ = o7Var.j(list, j7Var, str);
        }
        return new m2.b(o7VarJ, false, z4, list.size());
    }

    public synchronized boolean b(String str, long j3) {
        long j4 = this.f540d;
        if (j4 >= 0 && j3 <= j4) {
            return str == null || str.isEmpty() || this.f537a.isEmpty() || this.f537a.equals(str);
        }
        return false;
    }

    public synchronized String c(int i3, long j3, String str) {
        try {
            this.f540d = j3 + 60000;
            if (str != null && !str.isEmpty()) {
                this.f537a = str;
            }
            if (i3 >= 4 && i3 <= 6) {
                this.f539c = i3;
            }
            if (((StringBuilder) this.f541e).length() < this.f539c) {
                return null;
            }
            StringBuilder sb = (StringBuilder) this.f541e;
            String string = sb.toString();
            sb.setLength(0);
            return string;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(long j3) {
        this.f538b = j3;
        if (((StringBuilder) this.f541e).length() > 0) {
            StringBuilder sb = (StringBuilder) this.f541e;
            sb.setLength(sb.length() - 1);
        }
    }
}
