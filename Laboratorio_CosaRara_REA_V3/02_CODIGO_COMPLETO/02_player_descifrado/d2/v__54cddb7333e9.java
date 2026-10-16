// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w1.o2;
import w1.se;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f622k = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ThreadPoolExecutor f628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f632j;

    public v(l lVar, g gVar) {
        o oVar = new o(0, lVar);
        s sVar = new s();
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g2.g(atomicInteger, 2));
        threadPoolExecutor.prestartAllCoreThreads();
        this.f629g = new Object();
        this.f630h = ConcurrentHashMap.newKeySet();
        this.f631i = true;
        this.f623a = lVar;
        this.f624b = gVar;
        this.f625c = oVar;
        this.f626d = 3;
        this.f627e = sVar;
        this.f628f = threadPoolExecutor;
    }

    public static m b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("message", str2);
            return new m((byte) 6, jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (JSONException e3) {
            throw new AssertionError("encode error response", e3);
        }
    }

    public static boolean d(d dVar) {
        return (dVar == null || dVar.f548c || (dVar.f547b & 1) != 0) ? false : true;
    }

    public static m g(String str, long j3, t tVar, String str2, long j4) throws IOException {
        byte[] bArr = (byte[]) tVar.f613d;
        long length = ((long) bArr.length) + j3;
        long j5 = tVar.f612c;
        boolean z2 = length >= j5;
        String str3 = (String) tVar.f614e;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONObject.put("offset", j3);
            jSONObject.put("nextOffset", length);
            jSONObject.put("eof", z2);
            jSONObject.put("size", j5);
            if (str2 != null && !str2.isEmpty()) {
                jSONObject.put("sha256", str2);
            }
            if (j4 > 0) {
                jSONObject.put("generation", j4);
            }
            if (!str3.isEmpty()) {
                jSONObject.put("prefixSha256", str3);
            }
            byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            long length2 = ((long) bytes.length) + 4 + ((long) bArr.length);
            if (length2 > 4194304) {
                throw new IOException("pull-day payload too large: " + length2);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) length2);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
            dataOutputStream.write(bArr);
            return new m((byte) 5, byteArrayOutputStream.toByteArray());
        } catch (JSONException e3) {
            throw new IOException("encode pull-day metadata", e3);
        }
    }

    public static t h(File file, long j3, int i3, boolean z2, long j4) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long length = randomAccessFile.length();
            if (j4 >= 0) {
                length = Math.min(j4, length);
            }
            if (j3 < 0 || j3 > length) {
                throw new q("OFFSET_OUT_OF_RANGE", "offset outside keylog day");
            }
            byte[] bArr = new byte[(int) Math.min(i3, length - j3)];
            String strJ = (j3 == 0 || !z2) ? "" : j(randomAccessFile, j3);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(bArr);
            t tVar = new t();
            tVar.f613d = bArr;
            tVar.f612c = length;
            tVar.f614e = strJ;
            randomAccessFile.close();
            return tVar;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String j(RandomAccessFile randomAccessFile, long j3) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            randomAccessFile.seek(0L);
            byte[] bArr = new byte[65536];
            while (true) {
                if (j3 <= 0) {
                    StringBuilder sb = new StringBuilder(messageDigest.getDigestLength() * 2);
                    for (byte b3 : messageDigest.digest()) {
                        sb.append(Character.forDigit((b3 >>> 4) & 15, 16));
                        sb.append(Character.forDigit(b3 & 15, 16));
                    }
                    return sb.toString();
                }
                int i3 = randomAccessFile.read(bArr, 0, (int) Math.min(65536, j3));
                if (i3 < 0) {
                    o2.l("keylog prefix shortened during pull");
                    return null;
                }
                messageDigest.update(bArr, 0, i3);
                j3 -= (long) i3;
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError("SHA-256 unavailable", e3);
        }
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, se seVar) {
        if (inputStream == null || outputStream == null) {
            return false;
        }
        synchronized (this.f629g) {
            if (this.f631i && this.f630h.size() < 8) {
                Set set = this.f630h;
                u uVar = new u(this, inputStream, outputStream, seVar, set);
                set.add(uVar);
                Thread thread = new Thread(new p(uVar, 1), "keylog-pull-reader");
                thread.setDaemon(true);
                thread.start();
                return true;
            }
            return false;
        }
    }

    public final void c(byte b3, byte[] bArr, DataOutputStream dataOutputStream) throws IOException {
        m mVarB;
        try {
            if (b3 == 32) {
                mVarB = e();
            } else {
                if (b3 != 33) {
                    throw new q("IO_ERROR", "unsupported command");
                }
                mVarB = f(bArr);
            }
        } catch (q e3) {
            mVarB = b(e3.f606c, e3.getMessage());
        } catch (IOException e4) {
            mVarB = b("IO_ERROR", e4.getMessage());
        } catch (JSONException unused) {
            mVarB = b("IO_ERROR", "invalid request JSON");
        }
        byte b4 = mVarB.f599a;
        byte[] bArr2 = mVarB.f600b;
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr2.length > 4194304) {
            b2.a.k("KEY1 payload too large: ", bArr2.length);
            return;
        }
        DataOutputStream dataOutputStream2 = new DataOutputStream(dataOutputStream);
        dataOutputStream2.write(n.f601a);
        dataOutputStream2.writeByte(b4 & 255);
        dataOutputStream2.writeInt(bArr2.length);
        dataOutputStream2.write(bArr2);
        dataOutputStream2.flush();
    }

    public final m e() throws JSONException, q {
        y.l lVarI = i();
        d dVar = (d) lVarI.f5992d;
        JSONArray jSONArray = new JSONArray();
        for (k kVar : (List) lVarI.f5991c) {
            JSONObject jSONObject = new JSONObject();
            String str = kVar.f590a;
            boolean z2 = kVar.f595f;
            jSONObject.put("date", str);
            jSONObject.put("count", kVar.f591b);
            jSONObject.put("size", kVar.f592c);
            jSONObject.put("sha256", kVar.f594e);
            jSONObject.put("modifiedAt", kVar.f593d);
            jSONObject.put("open", z2);
            if (z2 && kVar.f590a.equals(dVar.f546a)) {
                jSONObject.put("generation", dVar.f547b);
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("days", jSONArray);
        return new m((byte) 4, jSONObject2.toString().getBytes(StandardCharsets.UTF_8));
    }

    public final m f(byte[] bArr) throws IOException, q {
        d0.d dVar;
        JSONObject jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
        String strOptString = jSONObject.optString("date", "");
        if (!f622k.matcher(strOptString).matches()) {
            throw new q("INVALID_DATE", "date must use YYYY-MM-DD");
        }
        try {
            if (!LocalDate.parse(strOptString).toString().equals(strOptString)) {
                throw new q("INVALID_DATE", "invalid calendar date");
            }
            long jOptLong = jSONObject.optLong("offset", 0L);
            long jOptLong2 = jSONObject.optLong("generation", 0L);
            boolean zOptBoolean = jSONObject.optBoolean("verifyPrefix", false);
            int iMax = (int) Math.max(1L, Math.min(262144L, jSONObject.optLong("maxBytes", 262144L)));
            g gVar = this.f624b;
            gVar.getClass();
            File file = new File(gVar.f562c, strOptString + ".ndjson");
            if (!file.isFile()) {
                throw new q("NOT_FOUND", "keylog day not found");
            }
            d dVar2 = this.f624b.f584z;
            String str = "GENERATION_MISMATCH";
            if (dVar2 != null && Objects.equals(strOptString, dVar2.f546a)) {
                if (!d(dVar2)) {
                    throw new q("BUSY", "active keylog day transition in progress");
                }
                if (jOptLong2 > 0 && jOptLong2 != dVar2.f547b) {
                    throw new q("GENERATION_MISMATCH", "active keylog generation changed");
                }
                t tVarH = h(file, jOptLong, iMax, zOptBoolean, dVar2.f549d);
                d dVar3 = this.f624b.f584z;
                if (d(dVar2) && d(dVar3) && dVar2.f547b == dVar3.f547b && Objects.equals(dVar2.f546a, dVar3.f546a)) {
                    return g(strOptString, jOptLong, tVarH, "", dVar2.f547b);
                }
                throw new q(jOptLong2 <= 0 ? "BUSY" : "GENERATION_MISMATCH", "active keylog generation changed");
            }
            y.l lVarI = i();
            d dVar4 = (d) lVarI.f5992d;
            Iterator it = ((List) lVarI.f5991c).iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = "GENERATION_MISMATCH";
                    dVar = null;
                    break;
                }
                k kVar = (k) it.next();
                if (strOptString.equals(kVar.f590a)) {
                    dVar = new d0.d(kVar, (kVar.f595f && kVar.f590a.equals(dVar4.f546a)) ? dVar4.f547b : 0L);
                    break;
                }
            }
            k kVar2 = dVar == null ? null : (k) dVar.f532b;
            long j3 = dVar == null ? 0L : dVar.f531a;
            if (kVar2 == null || !kVar2.f595f || jOptLong2 <= 0 || jOptLong2 == j3) {
                return g(strOptString, jOptLong, h(file, jOptLong, iMax, zOptBoolean, -1L), kVar2 != null ? kVar2.f594e : "", j3);
            }
            throw new q(str, "active keylog generation changed");
        } catch (DateTimeParseException unused) {
            throw new q("INVALID_DATE", "invalid calendar date");
        }
    }

    public final y.l i() throws q {
        for (int i3 = 0; i3 < this.f626d; i3++) {
            d dVar = this.f624b.f584z;
            if (d(dVar)) {
                o oVar = this.f625c;
                List listB = ((l) oVar.f603d).b(dVar.f546a);
                d dVar2 = this.f624b.f584z;
                if (d(dVar) && d(dVar2) && dVar.f547b == dVar2.f547b && dVar.f549d == dVar2.f549d && Objects.equals(dVar.f546a, dVar2.f546a)) {
                    return new y.l(listB, dVar2);
                }
                l lVar = this.f623a;
                synchronized (lVar) {
                    lVar.f598b.clear();
                }
            } else {
                Thread.yield();
            }
        }
        throw new q("BUSY", "keylog day transition in progress");
    }

    public final void k() {
        synchronized (this.f629g) {
            try {
                if (this.f632j) {
                    return;
                }
                this.f632j = true;
                boolean zA = false;
                this.f631i = false;
                Set set = this.f630h;
                this.f630h = Collections.EMPTY_SET;
                a2.h hVar = new a2.h(this, set, 3);
                try {
                    zA = this.f627e.a(hVar);
                } catch (RuntimeException unused) {
                }
                if (!zA) {
                    try {
                        this.f627e.b(hVar);
                    } finally {
                        this.f627e.c();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
