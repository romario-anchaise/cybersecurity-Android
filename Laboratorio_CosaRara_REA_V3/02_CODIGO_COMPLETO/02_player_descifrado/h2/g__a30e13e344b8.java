// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import java.io.EOFException;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final AtomicLong P = new AtomicLong();
    public static final Pattern Q = Pattern.compile("(?i)((?:access[_-]?token|refresh[_-]?token|token|authorization|auth|api[_-]?key|secret|password|signature)\\s*[:=]\\s*)[^&\\s]+");
    public static final Pattern R = Pattern.compile("([?&][A-Za-z0-9_.~-]{1,40}=)[^&#\\s]*");
    public static final Pattern S = Pattern.compile("(?i)(bearer\\s+)[A-Za-z0-9._~+/=-]+");
    public static final Pattern T = Pattern.compile("(?<![A-Za-z0-9])[A-Za-z0-9_+/=-]{48,}(?![A-Za-z0-9])");
    public static final Pattern U = Pattern.compile("\\s+");
    public final String A;
    public final long B;
    public final long C;
    public final String D;
    public final long E;
    public final long F;
    public final String G;
    public final long H;
    public final String I;
    public final long J;
    public final String K;
    public final String L;
    public final String M;
    public final f N;
    public final int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f2011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f2013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f2014m;
    public final int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f2015o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f2016p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f2017q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f2018r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f2019s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f2020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f2021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f2022v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f2023w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f2024x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f2025y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f2026z;

    public g(long j3, int i3, int i4, String str, String str2, int i5, String str3, String str4, String str5, String str6, long j4, long j5, long j6, long j7, int i6, int i7, String str7, String str8, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, String str9, long j17, long j18, String str10, long j19, long j20, String str11, long j21, String str12, long j22, String str13, String str14, String str15, f fVar) {
        f fVar2 = fVar;
        this.f2002a = j3;
        this.O = i3 == 0 ? 9 : i3;
        this.f2003b = i4;
        this.f2004c = j(str, 96);
        this.f2005d = j(str2, 96);
        this.f2006e = i5;
        this.f2007f = j(str3, 96);
        this.f2008g = j(str4, 160);
        this.f2009h = j(str5, 96);
        this.f2010i = j(str6, 160);
        this.f2011j = f(j4);
        this.f2012k = f(j5);
        this.f2013l = f(j6);
        this.f2014m = f(j7);
        this.n = i6;
        this.f2015o = i7;
        this.f2016p = j(str7 == null ? "" : str7.toLowerCase(Locale.ROOT), 24);
        this.f2017q = j(str8 == null ? "" : str8.toLowerCase(Locale.ROOT), 24);
        this.f2018r = f(j8);
        this.f2019s = f(j9);
        this.f2020t = f(j10);
        this.f2021u = f(j11);
        this.f2022v = f(j12);
        this.f2023w = f(j13);
        this.f2024x = f(j14);
        this.f2025y = f(j15);
        this.f2026z = f(j16);
        this.A = j(str9 != null ? str9.toLowerCase(Locale.ROOT) : "", 24);
        this.B = f(j17);
        this.C = f(j18);
        this.D = k(str10);
        this.E = f(j19);
        this.F = f(j20);
        this.G = k(str11);
        this.H = f(j21);
        this.I = k(str12);
        this.J = f(j22);
        this.K = k(str13);
        this.L = k(str14);
        this.M = j(str15, 64);
        if (fVar2 == null || (fVar2.f1987a < 0 && fVar2.f1988b < 0 && fVar2.f1989c < 0 && fVar2.f1990d < 0 && fVar2.f1991e < 0 && fVar2.f1992f == null && fVar2.f1993g == null && fVar2.f1994h < 0 && fVar2.f1995i < 0 && fVar2.f1996j < 0 && fVar2.f1997k < 0 && fVar2.f1998l < 0 && fVar2.f1999m < 0 && fVar2.n < 0 && fVar2.f2000o < 0 && fVar2.f2001p < 0)) {
            fVar2 = null;
        }
        this.N = fVar2;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        sb.append(' ');
        sb.append(str);
        sb.append('=');
        sb.append(str2);
    }

    public static String b(Throwable th) {
        return th == null ? "" : th.getClass().getName();
    }

    public static int c(IOException iOException) {
        if (iOException == null) {
            return 9;
        }
        String lowerCase = iOException.getMessage() == null ? "" : iOException.getMessage().toLowerCase(Locale.ROOT);
        if ((iOException instanceof EOFException) || lowerCase.contains("transport eof")) {
            return 6;
        }
        if (lowerCase.contains("go_away") || lowerCase.contains("go away")) {
            return 7;
        }
        return (lowerCase.contains("ws send rejected") || lowerCase.contains("yamux send fail")) ? 8 : 9;
    }

    public static g d(int i3, long j3) {
        return new g(P.incrementAndGet(), (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 5) ? i3 : 2, "", "", "", "", "", j3, -1L);
    }

    public static long f(long j3) {
        if (j3 < 0) {
            return -1L;
        }
        return j3;
    }

    public static void g(JSONObject jSONObject, String str, int i3) throws JSONException {
        if (i3 >= 0) {
            jSONObject.put(str, i3);
        }
    }

    public static void h(JSONObject jSONObject, String str, long j3) throws JSONException {
        if (j3 >= 0) {
            jSONObject.put(str, j3);
        }
    }

    public static void i(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static String j(String str, int i3) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (Character.isISOControl(iCodePointAt)) {
                sb.append(' ');
            } else {
                sb.appendCodePoint(iCodePointAt);
            }
        }
        String strReplaceAll = T.matcher(R.matcher(Q.matcher(S.matcher(U.matcher(sb.toString()).replaceAll(" ").trim()).replaceAll("$1<redacted>")).replaceAll("$1<redacted>")).replaceAll("$1<redacted>")).replaceAll("<redacted>");
        return strReplaceAll.codePointCount(0, strReplaceAll.length()) <= i3 ? strReplaceAll : strReplaceAll.substring(0, strReplaceAll.offsetByCodePoints(0, i3));
    }

    public static String k(String str) {
        return j(str == null ? "" : str.toLowerCase(Locale.ROOT), 64);
    }

    public static g l(int i3, Throwable th, long j3, long j4) {
        int i4 = i3 != 5 ? 4 : 5;
        Throwable cause = th.getCause() == null ? th : th.getCause();
        return new g(P.incrementAndGet(), i4, b(th), "", "", b(cause), cause == null ? "" : cause.getMessage(), j3, j4);
    }

    public final String e() {
        StringBuilder sb = new StringBuilder("seq=");
        sb.append(this.f2002a);
        sb.append(" initiator=");
        sb.append(a0.a.d(this.O));
        int i3 = this.f2003b;
        if (i3 >= 0) {
            sb.append(" wsCloseCode=");
            sb.append(i3);
        }
        a(sb, "wsCloseReason", this.f2004c);
        a(sb, "failureClass", this.f2005d);
        int i4 = this.f2006e;
        if (i4 >= 0) {
            sb.append(" failureHttpCode=");
            sb.append(i4);
        }
        a(sb, "terminalClass", this.f2007f);
        a(sb, "terminalMessage", this.f2008g);
        a(sb, "causeClass", this.f2009h);
        a(sb, "causeMessage", this.f2010i);
        long j3 = this.f2011j;
        if (j3 >= 0) {
            sb.append(" tunnelLifetimeMs=");
            sb.append(j3);
        }
        long j4 = this.f2012k;
        if (j4 >= 0) {
            sb.append(" lastInAgeMs=");
            sb.append(j4);
        }
        long j5 = this.f2013l;
        if (j5 >= 0) {
            sb.append(" lastOutAgeMs=");
            sb.append(j5);
        }
        long j6 = this.f2014m;
        if (j6 >= 0) {
            sb.append(" queueBytes=");
            sb.append(j6);
        }
        int i5 = this.n;
        if (i5 >= 0) {
            sb.append(" connectionGeneration=");
            sb.append(i5);
        }
        int i6 = this.f2015o;
        if (i6 >= 0) {
            sb.append(" networkEpoch=");
            sb.append(i6);
        }
        a(sb, "networkType", this.f2016p);
        a(sb, "connectionPhase", this.f2017q);
        long j7 = this.f2018r;
        if (j7 >= 0) {
            sb.append(" phaseAgeMs=");
            sb.append(j7);
        }
        long j8 = this.f2019s;
        if (j8 >= 0) {
            sb.append(" ackAgeMs=");
            sb.append(j8);
        }
        long j9 = this.f2020t;
        if (j9 >= 0) {
            sb.append(" registrationAttempt=");
            sb.append(j9);
        }
        long j10 = this.f2021u;
        if (j10 >= 0) {
            sb.append(" invalidAckCount=");
            sb.append(j10);
        }
        long j11 = this.f2022v;
        if (j11 >= 0) {
            sb.append(" heartbeatSentAgeMs=");
            sb.append(j11);
        }
        long j12 = this.f2023w;
        if (j12 >= 0) {
            sb.append(" heartbeatSentSequence=");
            sb.append(j12);
        }
        long j13 = this.f2024x;
        if (j13 >= 0) {
            sb.append(" heartbeatAckSequence=");
            sb.append(j13);
        }
        long j14 = this.f2025y;
        if (j14 >= 0) {
            sb.append(" heartbeatRttMs=");
            sb.append(j14);
        }
        long j15 = this.f2026z;
        if (j15 >= 0) {
            sb.append(" schedulerLagMs=");
            sb.append(j15);
        }
        a(sb, "powerIdleState", this.A);
        long j16 = this.B;
        if (j16 >= 0) {
            sb.append(" pendingLogicalAckCount=");
            sb.append(j16);
        }
        long j17 = this.C;
        if (j17 >= 0) {
            sb.append(" activeLogicalStreamCount=");
            sb.append(j17);
        }
        a(sb, "schedulerActiveTaskType", this.D);
        long j18 = this.E;
        if (j18 >= 0) {
            sb.append(" schedulerActiveTaskAgeMs=");
            sb.append(j18);
        }
        long j19 = this.F;
        if (j19 >= 0) {
            sb.append(" schedulerQueueDelayMs=");
            sb.append(j19);
        }
        a(sb, "schedulerQueueTaskType", this.G);
        long j20 = this.H;
        if (j20 >= 0) {
            sb.append(" emitLockMaxWaitMs=");
            sb.append(j20);
        }
        a(sb, "emitLockMaxWaitOperation", this.I);
        long j21 = this.J;
        if (j21 >= 0) {
            sb.append(" emitLockMaxHoldMs=");
            sb.append(j21);
        }
        a(sb, "emitLockMaxHoldOperation", this.K);
        a(sb, "transportName", this.L);
        a(sb, "transportErrorCode", this.M);
        f fVar = this.N;
        if (fVar != null) {
            long j22 = fVar.f2001p;
            long j23 = fVar.f2000o;
            long j24 = fVar.n;
            long j25 = fVar.f1999m;
            int i7 = fVar.f1998l;
            int i8 = fVar.f1997k;
            int i9 = fVar.f1996j;
            int i10 = fVar.f1995i;
            long j26 = fVar.f1994h;
            Boolean bool = fVar.f1993g;
            Boolean bool2 = fVar.f1992f;
            int i11 = fVar.f1991e;
            long j27 = fVar.f1990d;
            long j28 = fVar.f1989c;
            long j29 = fVar.f1988b;
            long j30 = fVar.f1987a;
            if (j30 >= 0) {
                sb.append(" healthGapProcessCpuMs=");
                sb.append(j30);
            }
            if (j29 >= 0) {
                sb.append(" healthGapThreadCpuMs=");
                sb.append(j29);
            }
            if (j28 >= 0) {
                sb.append(" healthGapBlockingGcCount=");
                sb.append(j28);
            }
            if (j27 >= 0) {
                sb.append(" healthGapBlockingGcTimeMs=");
                sb.append(j27);
            }
            if (i11 >= 0) {
                sb.append(" processImportance=");
                sb.append(i11);
            }
            if (bool2 != null) {
                sb.append(" screenInteractive=");
                sb.append(bool2);
            }
            if (bool != null) {
                sb.append(" powerSaveMode=");
                sb.append(bool);
            }
            if (j26 >= 0) {
                sb.append(" mainLooperMaxDelayMs=");
                sb.append(j26);
            }
            if (i10 >= 0) {
                sb.append(" trimMemoryCount=");
                sb.append(i10);
            }
            if (i9 >= 0) {
                sb.append(" criticalTrimMemoryCount=");
                sb.append(i9);
            }
            if (i8 >= 0) {
                sb.append(" lowMemoryCount=");
                sb.append(i8);
            }
            if (i7 >= 0) {
                sb.append(" lastTrimMemoryLevel=");
                sb.append(i7);
            }
            if (j25 >= 0) {
                sb.append(" pssKb=");
                sb.append(j25);
            }
            if (j24 >= 0) {
                sb.append(" maxPressurePssKb=");
                sb.append(j24);
            }
            if (j23 >= 0) {
                sb.append(" javaHeapKb=");
                sb.append(j23);
            }
            if (j22 >= 0) {
                sb.append(" nativeHeapKb=");
                sb.append(j22);
            }
        }
        return sb.toString();
    }

    public final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("seq", this.f2002a);
            jSONObject.put("initiator", a0.a.d(this.O));
            g(jSONObject, "wsCloseCode", this.f2003b);
            i(jSONObject, "wsCloseReason", this.f2004c);
            i(jSONObject, "failureClass", this.f2005d);
            g(jSONObject, "failureHttpCode", this.f2006e);
            i(jSONObject, "terminalClass", this.f2007f);
            i(jSONObject, "terminalMessage", this.f2008g);
            i(jSONObject, "causeClass", this.f2009h);
            i(jSONObject, "causeMessage", this.f2010i);
            h(jSONObject, "tunnelLifetimeMs", this.f2011j);
            h(jSONObject, "lastInAgeMs", this.f2012k);
            h(jSONObject, "lastOutAgeMs", this.f2013l);
            h(jSONObject, "queueBytes", this.f2014m);
            g(jSONObject, "connectionGeneration", this.n);
            g(jSONObject, "networkEpoch", this.f2015o);
            i(jSONObject, "networkType", this.f2016p);
            i(jSONObject, "connectionPhase", this.f2017q);
            h(jSONObject, "phaseAgeMs", this.f2018r);
            h(jSONObject, "ackAgeMs", this.f2019s);
            h(jSONObject, "registrationAttempt", this.f2020t);
            h(jSONObject, "invalidAckCount", this.f2021u);
            h(jSONObject, "heartbeatSentAgeMs", this.f2022v);
            h(jSONObject, "heartbeatSentSequence", this.f2023w);
            h(jSONObject, "heartbeatAckSequence", this.f2024x);
            h(jSONObject, "heartbeatRttMs", this.f2025y);
            h(jSONObject, "schedulerLagMs", this.f2026z);
            i(jSONObject, "powerIdleState", this.A);
            h(jSONObject, "pendingLogicalAckCount", this.B);
            h(jSONObject, "activeLogicalStreamCount", this.C);
            i(jSONObject, "schedulerActiveTaskType", this.D);
            h(jSONObject, "schedulerActiveTaskAgeMs", this.E);
            h(jSONObject, "schedulerQueueDelayMs", this.F);
            i(jSONObject, "schedulerQueueTaskType", this.G);
            h(jSONObject, "emitLockMaxWaitMs", this.H);
            i(jSONObject, "emitLockMaxWaitOperation", this.I);
            h(jSONObject, "emitLockMaxHoldMs", this.J);
            i(jSONObject, "emitLockMaxHoldOperation", this.K);
            i(jSONObject, "transportName", this.L);
            i(jSONObject, "transportErrorCode", this.M);
            f fVar = this.N;
            if (fVar != null) {
                jSONObject.put("runtimePause", f.a(fVar));
            }
            return jSONObject;
        } catch (JSONException e3) {
            throw new IllegalStateException("Unable to serialize disconnect diagnostic", e3);
        }
    }

    public g(long j3, int i3, String str, String str2, String str3, String str4, String str5, long j4, long j5) {
        this(j3, i3, -1, "", str, -1, str2, str3, str4, str5, j4, j5, -1L, -1L, -1, -1, "", "", -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, "", -1L, -1L, "", -1L, -1L, "", -1L, "", -1L, "", "", "", null);
    }
}
