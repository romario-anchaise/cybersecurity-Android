// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p008e0;

import A.C0005e;
import F0.i;
import H0.b;
import M0.l;
import M0.m;
import V.a;
import X0.C0055b;
import X0.C0056c;
import X0.n;
import X0.p;
import X0.y;
import android.graphics.Bitmap;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p016j0.f;
import p016j0.o;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Date f2261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Date f2263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2264f;
    public final Date g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f2265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f2266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2268k;

    public c(y yVar, b bVar) {
        int i2;
        this.f2259a = yVar;
        this.f2260b = bVar;
        this.f2268k = -1;
        if (bVar != null) {
            this.f2265h = bVar.f2255c;
            this.f2266i = bVar.f2256d;
            n nVar = bVar.f2258f;
            int size = nVar.size();
            for (int i3 = 0; i3 < size; i3++) {
                String strB = nVar.b(i3);
                Date date = null;
                if (m.M(strB, "Date")) {
                    String strA = nVar.a("Date");
                    if (strA != null) {
                        b bVar2 = c1.c.f2181a;
                        if (strA.length() != 0) {
                            ParsePosition parsePosition = new ParsePosition(0);
                            Date date2 = ((DateFormat) c1.c.f2181a.get()).parse(strA, parsePosition);
                            if (parsePosition.getIndex() == strA.length()) {
                                date = date2;
                            } else {
                                String[] strArr = c1.c.f2182b;
                                synchronized (strArr) {
                                    try {
                                        int length = strArr.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length) {
                                                break;
                                            }
                                            DateFormat[] dateFormatArr = c1.c.f2183c;
                                            DateFormat simpleDateFormat = dateFormatArr[i4];
                                            if (simpleDateFormat == null) {
                                                simpleDateFormat = new SimpleDateFormat(c1.c.f2182b[i4], Locale.US);
                                                simpleDateFormat.setTimeZone(Y0.b.f1123e);
                                                dateFormatArr[i4] = simpleDateFormat;
                                            }
                                            parsePosition.setIndex(0);
                                            Date date3 = simpleDateFormat.parse(strA, parsePosition);
                                            if (parsePosition.getIndex() != 0) {
                                                date = date3;
                                                break;
                                            }
                                            i4++;
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                    this.f2261c = date;
                    this.f2262d = nVar.d(i3);
                } else if (m.M(strB, "Expires")) {
                    String strA2 = nVar.a("Expires");
                    if (strA2 != null) {
                        b bVar3 = c1.c.f2181a;
                        if (strA2.length() != 0) {
                            ParsePosition parsePosition2 = new ParsePosition(0);
                            Date date4 = ((DateFormat) c1.c.f2181a.get()).parse(strA2, parsePosition2);
                            if (parsePosition2.getIndex() == strA2.length()) {
                                date = date4;
                            } else {
                                String[] strArr2 = c1.c.f2182b;
                                synchronized (strArr2) {
                                    try {
                                        int length2 = strArr2.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length2) {
                                                break;
                                            }
                                            DateFormat[] dateFormatArr2 = c1.c.f2183c;
                                            DateFormat simpleDateFormat2 = dateFormatArr2[i5];
                                            if (simpleDateFormat2 == null) {
                                                simpleDateFormat2 = new SimpleDateFormat(c1.c.f2182b[i5], Locale.US);
                                                simpleDateFormat2.setTimeZone(Y0.b.f1123e);
                                                dateFormatArr2[i5] = simpleDateFormat2;
                                            }
                                            parsePosition2.setIndex(0);
                                            Date date5 = simpleDateFormat2.parse(strA2, parsePosition2);
                                            if (parsePosition2.getIndex() != 0) {
                                                date = date5;
                                                break;
                                            }
                                            i5++;
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    }
                    this.g = date;
                } else if (m.M(strB, "Last-Modified")) {
                    String strA3 = nVar.a("Last-Modified");
                    if (strA3 != null) {
                        b bVar4 = c1.c.f2181a;
                        if (strA3.length() != 0) {
                            ParsePosition parsePosition3 = new ParsePosition(0);
                            Date date6 = ((DateFormat) c1.c.f2181a.get()).parse(strA3, parsePosition3);
                            if (parsePosition3.getIndex() == strA3.length()) {
                                date = date6;
                            } else {
                                String[] strArr3 = c1.c.f2182b;
                                synchronized (strArr3) {
                                    try {
                                        int length3 = strArr3.length;
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= length3) {
                                                break;
                                            }
                                            DateFormat[] dateFormatArr3 = c1.c.f2183c;
                                            DateFormat simpleDateFormat3 = dateFormatArr3[i6];
                                            if (simpleDateFormat3 == null) {
                                                simpleDateFormat3 = new SimpleDateFormat(c1.c.f2182b[i6], Locale.US);
                                                simpleDateFormat3.setTimeZone(Y0.b.f1123e);
                                                dateFormatArr3[i6] = simpleDateFormat3;
                                            }
                                            parsePosition3.setIndex(0);
                                            Date date7 = simpleDateFormat3.parse(strA3, parsePosition3);
                                            if (parsePosition3.getIndex() != 0) {
                                                date = date7;
                                                break;
                                            }
                                            i6++;
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                            }
                        }
                    }
                    this.f2263e = date;
                    this.f2264f = nVar.d(i3);
                } else if (m.M(strB, "ETag")) {
                    this.f2267j = nVar.d(i3);
                } else if (m.M(strB, "Age")) {
                    String strD = nVar.d(i3);
                    Bitmap.Config config = f.f3375a;
                    Long lK = l.K(strD);
                    if (lK != null) {
                        long jLongValue = lK.longValue();
                        i2 = jLongValue > 2147483647L ? Integer.MAX_VALUE : jLongValue < 0 ? 0 : (int) jLongValue;
                    } else {
                        i2 = -1;
                    }
                    this.f2268k = i2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0112  */
    /* JADX WARN: Code duplicated, block: B:63:0x0121  */
    /* JADX WARN: Code duplicated, block: B:64:0x0129  */
    /* JADX WARN: Code duplicated, block: B:70:0x013d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0159  */
    /* JADX WARN: Code duplicated, block: B:80:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x015e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0168  */
    /* JADX WARN: Code duplicated, block: B:87:0x0183  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, t0.b] */
    public final d a() {
        long j2;
        long jMin;
        String string;
        long time;
        int i2;
        int i3;
        long millis;
        long millis2;
        String str;
        String str2;
        int i4;
        y yVar = this.f2259a;
        b bVar = this.f2260b;
        if (bVar == null) {
            return new d(yVar, null);
        }
        p pVar = (p) yVar.f1099c;
        if (pVar.f1029j && !bVar.f2257e) {
            return new d(yVar, null);
        }
        ?? r5 = bVar.f2253a;
        C0056c c0056c = (C0056c) r5.getValue();
        if (yVar.b().f950b || ((C0056c) r5.getValue()).f950b || i.a(bVar.f2258f.a("Vary"), "*")) {
            return new d(yVar, null);
        }
        C0056c c0056cB = yVar.b();
        if (!c0056cB.f949a) {
            n nVar = (n) yVar.f1100d;
            if (nVar.a("If-Modified-Since") == null && nVar.a("If-None-Match") == null) {
                long time2 = this.f2266i;
                Date date = this.f2261c;
                long jMax = date != null ? Math.max(0L, time2 - date.getTime()) : 0L;
                int i5 = this.f2268k;
                if (i5 != -1) {
                    jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i5));
                }
                long time3 = this.f2265h;
                long jLongValue = jMax + (time2 - time3) + (((Number) o.f3398a.a()).longValue() - time2);
                int i6 = ((C0056c) r5.getValue()).f951c;
                Date date2 = this.f2263e;
                if (i6 == -1) {
                    Date date3 = this.g;
                    if (date3 != null) {
                        if (date != null) {
                            time2 = date.getTime();
                        }
                        time = date3.getTime() - time2;
                        if (time <= 0) {
                            time = 0;
                        }
                    } else if (date2 == null) {
                        j2 = 0;
                        jMin = j2;
                    } else {
                        ArrayList arrayList = pVar.g;
                        if (arrayList == null) {
                            string = null;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            C0055b.g(arrayList, sb);
                            string = sb.toString();
                        }
                        if (string == null) {
                            if (date != null) {
                                time3 = date.getTime();
                            }
                            long time4 = time3 - date2.getTime();
                            j2 = 0;
                            if (time4 > 0) {
                                jMin = time4 / ((long) 10);
                            }
                        } else {
                            j2 = 0;
                        }
                        jMin = j2;
                    }
                    i2 = c0056cB.f951c;
                    if (i2 != -1) {
                        jMin = Math.min(jMin, TimeUnit.SECONDS.toMillis(i2));
                    }
                    i3 = c0056cB.f956i;
                    if (i3 != -1) {
                        millis = TimeUnit.SECONDS.toMillis(i3);
                    } else {
                        millis = 0;
                    }
                    if (!c0056c.g || (i4 = c0056cB.f955h) == -1) {
                        millis2 = 0;
                    } else {
                        millis2 = TimeUnit.SECONDS.toMillis(i4);
                    }
                    if (c0056c.f949a && jLongValue + millis < jMin + millis2) {
                        return new d(null, bVar);
                    }
                    str = this.f2267j;
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else {
                        if (date2 != null) {
                            str = this.f2264f;
                            i.b(str);
                        } else {
                            if (date != null) {
                                return new d(yVar, null);
                            }
                            str = this.f2262d;
                            i.b(str);
                        }
                        str2 = "If-Modified-Since";
                    }
                    a aVarF = yVar.f();
                    ((C0005e) aVarF.f652d).y(str2, str);
                    return new d(aVarF.c(), bVar);
                }
                time = TimeUnit.SECONDS.toMillis(i6);
                jMin = time;
                i2 = c0056cB.f951c;
                if (i2 != -1) {
                    jMin = Math.min(jMin, TimeUnit.SECONDS.toMillis(i2));
                }
                i3 = c0056cB.f956i;
                if (i3 != -1) {
                    millis = TimeUnit.SECONDS.toMillis(i3);
                } else {
                    millis = 0;
                }
                if (c0056c.g) {
                    millis2 = 0;
                } else {
                    millis2 = 0;
                }
                if (c0056c.f949a) {
                }
                str = this.f2267j;
                if (str != null) {
                    str2 = "If-None-Match";
                } else {
                    if (date2 != null) {
                        str = this.f2264f;
                        i.b(str);
                    } else {
                        if (date != null) {
                            return new d(yVar, null);
                        }
                        str = this.f2262d;
                        i.b(str);
                    }
                    str2 = "If-Modified-Since";
                }
                a aVarF2 = yVar.f();
                ((C0005e) aVarF2.f652d).y(str2, str);
                return new d(aVarF2.c(), bVar);
            }
        }
        return new d(yVar, null);
    }
}
