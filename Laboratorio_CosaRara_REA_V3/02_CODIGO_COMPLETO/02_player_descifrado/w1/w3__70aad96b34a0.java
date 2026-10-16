// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f5389f = {70, 73, 76, 69};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f5390g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f5392b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f5393c = ConcurrentHashMap.newKeySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue f5394d = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadPoolExecutor f5395e;

    static {
        Object[] objArr = new Object[32];
        for (int i3 = 0; i3 < 32; i3++) {
            objArr[i3] = new Object();
        }
        f5390g = objArr;
    }

    public w3(ScreenMirrorService screenMirrorService) {
        Context applicationContext = screenMirrorService.getApplicationContext();
        this.f5391a = applicationContext != null ? applicationContext : screenMirrorService;
    }

    public static void a(JSONArray jSONArray, String str, String str2) throws JSONException {
        File file = new File(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("path", str2);
        jSONObject.put("exists", file.exists());
        jSONArray.put(jSONObject);
    }

    public static String c(File file) throws IOException {
        int i3;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[32768];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i4 = fileInputStream.read(bArr);
                    if (i4 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i4);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            fileInputStream.close();
            StringBuilder sb = new StringBuilder(64);
            for (byte b3 : messageDigest.digest()) {
                sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b3 & 255)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e3) {
            throw new IOException("SHA-256 unavailable", e3);
        }
    }

    public static byte[] d(String str, String str2) {
        return ("novelaya-gallery-v1\n" + str + "\n" + str2 + "\n").getBytes(StandardCharsets.US_ASCII);
    }

    public static void i(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        String str;
        File[] fileArr;
        boolean z2;
        String str2 = "";
        String strOptString = jSONObject.optString("path", "");
        if (strOptString.isEmpty()) {
            s(dataOutputStream, i3, 3, "missing path");
            return;
        }
        File file = new File(strOptString);
        if (!file.exists()) {
            s(dataOutputStream, i3, 1, "not found: ".concat(strOptString));
            return;
        }
        if (!file.isDirectory()) {
            s(dataOutputStream, i3, 3, "not a directory: ".concat(strOptString));
            return;
        }
        if (!file.canRead()) {
            s(dataOutputStream, i3, 2, "no read permission (是否申请了「所有文件访问权限」?)");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            s(dataOutputStream, i3, 4, "listFiles returned null");
            return;
        }
        Arrays.sort(fileArrListFiles, new v3(0));
        JSONArray jSONArray = new JSONArray();
        int length = fileArrListFiles.length;
        int i4 = 0;
        while (i4 < length) {
            File file2 = fileArrListFiles[i4];
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", file2.getName());
            try {
                str = str2;
                fileArr = fileArrListFiles;
                try {
                    jSONObject2.put("size", file2.isDirectory() ? 0L : file2.length());
                } catch (Throwable unused) {
                    jSONObject2.put("size", 0);
                }
            } catch (Throwable unused2) {
                str = str2;
                fileArr = fileArrListFiles;
            }
            jSONObject2.put("isDir", file2.isDirectory());
            try {
                jSONObject2.put("mtime", file2.lastModified());
                z2 = false;
            } catch (Throwable unused3) {
                z2 = false;
                jSONObject2.put("mtime", 0);
            }
            try {
                jSONObject2.put("readable", file2.canRead());
            } catch (Throwable unused4) {
                jSONObject2.put("readable", z2);
            }
            jSONArray.put(jSONObject2);
            i4++;
            str2 = str;
            fileArrListFiles = fileArr;
        }
        String str3 = str2;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("path", file.getAbsolutePath());
        jSONObject3.put("parent", file.getParent() != null ? file.getParent() : str3);
        jSONObject3.put("entries", jSONArray);
        t(dataOutputStream, i3, 0, jSONObject3, null);
    }

    public static void j(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        String strOptString = jSONObject.optString("path", "");
        long jOptLong = jSONObject.optLong("offset", 0L);
        long jOptLong2 = jSONObject.optLong("length", -1L);
        if (strOptString.isEmpty()) {
            s(dataOutputStream, i3, 3, "missing path");
            return;
        }
        if (jOptLong < 0) {
            s(dataOutputStream, i3, 3, "offset < 0");
            return;
        }
        File file = new File(strOptString);
        if (!file.exists()) {
            s(dataOutputStream, i3, 1, "not found");
            return;
        }
        if (file.isDirectory()) {
            s(dataOutputStream, i3, 3, "is directory");
            return;
        }
        if (!file.canRead()) {
            s(dataOutputStream, i3, 2, "no read permission");
            return;
        }
        long length = file.length();
        if (jOptLong > length) {
            jOptLong = length;
        }
        long j3 = length - jOptLong;
        if (jOptLong2 < 0 || jOptLong2 > j3) {
            jOptLong2 = j3;
        }
        if (jOptLong2 > 8388608) {
            jOptLong2 = 8388608;
        }
        int i4 = (int) jOptLong2;
        byte[] bArr = new byte[i4];
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.seek(jOptLong);
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = randomAccessFile.read(bArr, i5, i4 - i5);
                    if (i6 <= 0) {
                        break;
                    } else {
                        i5 += i6;
                    }
                }
                if (i5 != i4) {
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, 0, bArr2, 0, i5);
                    bArr = bArr2;
                }
                randomAccessFile.close();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("path", file.getAbsolutePath());
                jSONObject2.put("size", length);
                jSONObject2.put("offset", jOptLong);
                jSONObject2.put("read", bArr.length);
                jSONObject2.put("eof", jOptLong + ((long) bArr.length) >= length);
                t(dataOutputStream, i3, 0, jSONObject2, bArr);
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException e3) {
            s(dataOutputStream, i3, 4, e3.getMessage());
        }
    }

    public static void l(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        String strOptString = jSONObject.optString("path", "");
        if (strOptString.isEmpty()) {
            s(dataOutputStream, i3, 3, "missing path");
            return;
        }
        File file = new File(strOptString);
        if (!file.exists()) {
            s(dataOutputStream, i3, 1, "not found");
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", file.getName());
        jSONObject2.put("path", file.getAbsolutePath());
        jSONObject2.put("size", file.isDirectory() ? 0L : file.length());
        jSONObject2.put("isDir", file.isDirectory());
        jSONObject2.put("mtime", file.lastModified());
        jSONObject2.put("readable", file.canRead());
        t(dataOutputStream, i3, 0, jSONObject2, null);
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        switch (lowerCase) {
            case "gif":
            case "jpg":
            case "png":
            case "webp":
                return lowerCase;
            default:
                return null;
        }
    }

    public static String o(String str) {
        if (str == null || !str.equals(str.trim().toLowerCase(Locale.ROOT)) || str.length() != 64) {
            return null;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'a' || cCharAt > 'f')) {
                return null;
            }
        }
        return str;
    }

    public static String p(String str) {
        if (str != null && str.equals(str.trim().toLowerCase(Locale.ROOT))) {
            try {
                if (UUID.fromString(str).toString().equals(str)) {
                    return str;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static void r(File file, String str) throws IOException {
        String str2;
        byte[] allBytes = Files.readAllBytes(file.toPath());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(allBytes, 0, allBytes.length, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        long j3 = ((long) i3) * ((long) i4);
        if (i3 < 1 || i4 < 1 || i3 > 8192 || i4 > 8192 || j3 > 25000000 || (str2 = options.outMimeType) == null || !str.equals(str2.toLowerCase(Locale.ROOT))) {
            o2.l("gallery image content is invalid");
        }
    }

    public static void s(DataOutputStream dataOutputStream, int i3, int i4, String str) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "";
            }
            jSONObject.put("error", str);
            t(dataOutputStream, i3, i4, jSONObject, null);
        } catch (JSONException unused) {
        }
    }

    public static void t(DataOutputStream dataOutputStream, int i3, int i4, JSONObject jSONObject, byte[] bArr) throws IOException {
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        long length = bArr != null ? bArr.length : 0L;
        dataOutputStream.write(f5389f);
        dataOutputStream.writeInt(i4);
        dataOutputStream.writeInt(i3);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        dataOutputStream.writeLong(length);
        if (length > 0) {
            dataOutputStream.write(bArr);
        }
    }

    public final File b(String str, String str2) throws IOException {
        String str3;
        String strP = p(str);
        String strN = n(str2);
        if (strP == null || strN == null) {
            str3 = null;
        } else {
            str3 = "novelaya_" + strP + "." + strN;
        }
        if (str3 == null) {
            o2.l("invalid gallery destination");
            return null;
        }
        File canonicalFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getCanonicalFile();
        File canonicalFile2 = new File(canonicalFile, "Novelaya").getCanonicalFile();
        if (!canonicalFile2.getParentFile().equals(canonicalFile)) {
            o2.l("gallery directory escaped Pictures");
            return null;
        }
        File canonicalFile3 = new File(canonicalFile2, str3).getCanonicalFile();
        if (canonicalFile3.getParentFile().equals(canonicalFile2)) {
            return canonicalFile3;
        }
        o2.l("gallery destination escaped root");
        return null;
    }

    public final File e(String str, String str2) throws IOException {
        File fileB = b(str, str2);
        return new File(fileB.getParentFile(), "." + fileB.getName() + ".owner").getCanonicalFile();
    }

    public final void f(int i3, DataOutputStream dataOutputStream, JSONObject jSONObject) throws JSONException, IOException {
        boolean zIsEqual;
        String str;
        String str2;
        String strP = p(jSONObject.optString("transferId", ""));
        String strN = n(jSONObject.optString("extension", ""));
        String strO = o(jSONObject.optString("sha256", ""));
        if (strP == null || strN == null || strO == null) {
            s(dataOutputStream, i3, 3, "invalid gallery identity or type");
            return;
        }
        if (!n.z(this.f5391a)) {
            s(dataOutputStream, i3, 2, "all files access required");
            return;
        }
        File fileB = b(strP, strN);
        File fileE = e(strP, strN);
        synchronized (f5390g[(strP.hashCode() & Integer.MAX_VALUE) % 32]) {
            try {
                boolean zExists = fileB.exists();
                if (zExists && !fileB.isFile()) {
                    s(dataOutputStream, i3, 2, "gallery destination is not a file");
                    return;
                }
                if (zExists || fileE.exists()) {
                    String strP2 = p(strP);
                    String strO2 = o(strO);
                    if (!fileE.isFile() || fileE.length() > 128 || strP2 == null || strO2 == null) {
                        zIsEqual = false;
                    } else {
                        try {
                            zIsEqual = MessageDigest.isEqual(d(strP2, strO2), Files.readAllBytes(fileE.toPath()));
                        } catch (Throwable unused) {
                            zIsEqual = false;
                        }
                    }
                    if (!zIsEqual) {
                        s(dataOutputStream, i3, 2, "gallery ownership marker missing");
                        return;
                    }
                }
                if (zExists && !strO.equals(c(fileB))) {
                    s(dataOutputStream, i3, 2, "gallery image no longer matches transfer");
                    return;
                }
                String str3 = strP + ":" + strN + ":" + strO;
                ConcurrentLinkedQueue concurrentLinkedQueue = this.f5394d;
                ConcurrentHashMap.KeySetView keySetView = this.f5393c;
                if (keySetView.add(str3)) {
                    concurrentLinkedQueue.add(str3);
                }
                while (keySetView.size() > 2048 && (str2 = (String) concurrentLinkedQueue.poll()) != null) {
                    keySetView.remove(str2);
                }
                if (zExists && !fileB.delete()) {
                    s(dataOutputStream, i3, 4, "cannot delete gallery image");
                    return;
                }
                if (fileE.exists() && !fileE.delete()) {
                    s(dataOutputStream, i3, 4, "cannot delete gallery ownership marker");
                    return;
                }
                switch (strN) {
                    case "gif":
                        str = "image/gif";
                        break;
                    case "jpg":
                        str = "image/jpeg";
                        break;
                    case "png":
                        str = "image/png";
                        break;
                    case "webp":
                        str = "image/webp";
                        break;
                    default:
                        str = "";
                        break;
                }
                q(fileB, str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("path", fileB.getCanonicalPath());
                jSONObject2.put("transferId", strP);
                jSONObject2.put("sha256", strO);
                jSONObject2.put("existed", zExists);
                t(dataOutputStream, i3, 0, jSONObject2, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(JSONObject jSONObject, int i3, DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws JSONException, IOException {
        boolean zEquals;
        String str;
        String strP = p(jSONObject.optString("transferId", ""));
        String strN = n(jSONObject.optString("extension", ""));
        String strTrim = jSONObject.optString("mediaType", "").trim();
        Locale locale = Locale.ROOT;
        String lowerCase = strTrim.toLowerCase(locale);
        String strO = o(jSONObject.optString("sha256", ""));
        if (strP != null && strN != null && strO != null) {
            String strN2 = n(strN);
            if (strN2 == null || lowerCase == null) {
                zEquals = false;
            } else {
                switch (strN2) {
                    case "gif":
                        str = "image/gif";
                        break;
                    case "jpg":
                        str = "image/jpeg";
                        break;
                    case "png":
                        str = "image/png";
                        break;
                    case "webp":
                        str = "image/webp";
                        break;
                    default:
                        str = "";
                        break;
                }
                zEquals = str.equals(lowerCase.trim().toLowerCase(locale));
            }
            if (zEquals) {
                long j3 = dataInputStream.readLong();
                if (j3 <= 0 || j3 > 10485760) {
                    s(dataOutputStream, i3, 5, "invalid gallery size: " + j3);
                    return;
                }
                if (!n.z(this.f5391a)) {
                    byte[] bArr = new byte[32768];
                    long j4 = j3;
                    while (j4 > 0) {
                        int i4 = dataInputStream.read(bArr, 0, (int) Math.min(32768, j4));
                        if (i4 < 0) {
                            o2.l("gallery payload truncated");
                            return;
                        }
                        j4 -= (long) i4;
                    }
                    s(dataOutputStream, i3, 2, "all files access required");
                    return;
                }
                File fileB = b(strP, strN);
                File fileE = e(strP, strN);
                File parentFile = fileB.getParentFile();
                if (parentFile == null || !(parentFile.isDirectory() || parentFile.mkdirs())) {
                    s(dataOutputStream, i3, 4, "cannot create gallery directory");
                    return;
                }
                File file = new File(parentFile, "." + fileB.getName() + ".candidate-" + UUID.randomUUID());
                char c3 = (char) 4;
                try {
                    try {
                        n.i0(dataInputStream, file, j3, 10485760L);
                        r(file, lowerCase);
                        try {
                            if (!strO.equals(c(file))) {
                                throw new IOException("gallery image checksum mismatch");
                            }
                            try {
                                synchronized (f5390g[(strP.hashCode() & Integer.MAX_VALUE) % 32]) {
                                    try {
                                        if (this.f5393c.contains(strP + ":" + strN + ":" + strO)) {
                                            s(dataOutputStream, i3, 2, "gallery transfer was deleted");
                                        } else if (fileB.exists() || fileE.exists()) {
                                            s(dataOutputStream, i3, 2, "gallery destination already exists");
                                        } else {
                                            String strP2 = p(strP);
                                            String strO2 = o(strO);
                                            if (strP2 == null || strO2 == null) {
                                                throw new IOException("invalid gallery ownership");
                                            }
                                            byte[] bArrD = d(strP2, strO2);
                                            n.i0(new ByteArrayInputStream(bArrD), fileE, bArrD.length, 128L);
                                            try {
                                                try {
                                                    Files.move(file.toPath(), fileB.toPath(), new CopyOption[0]);
                                                    try {
                                                        q(fileB, lowerCase);
                                                        JSONObject jSONObject2 = new JSONObject();
                                                        jSONObject2.put("path", fileB.getCanonicalPath());
                                                        jSONObject2.put("transferId", strP);
                                                        jSONObject2.put("sha256", strO);
                                                        jSONObject2.put("bytes", j3);
                                                        t(dataOutputStream, i3, 0, jSONObject2, null);
                                                        return;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        Files.deleteIfExists(fileE.toPath());
                                                    } catch (Throwable unused) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        }
                                        Files.deleteIfExists(file.toPath());
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Throwable unused2) {
                        return;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    c3 = 0;
                }
                char c4 = c3;
                try {
                    s(dataOutputStream, i3, 4, th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                    if (c4 == 0) {
                        Files.deleteIfExists(file.toPath());
                        return;
                    }
                    return;
                } catch (Throwable th8) {
                    if (c4 == 0) {
                        try {
                            Files.deleteIfExists(file.toPath());
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th8;
                }
            }
        }
        s(dataOutputStream, i3, 3, "invalid gallery identity or type");
    }

    public final void h(int i3, DataOutputStream dataOutputStream) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        a(jSONArray, "内部存储", Environment.getExternalStorageDirectory().getAbsolutePath());
        a(jSONArray, "Download", new File(Environment.getExternalStorageDirectory(), "Download").getAbsolutePath());
        a(jSONArray, "DCIM", new File(Environment.getExternalStorageDirectory(), "DCIM").getAbsolutePath());
        a(jSONArray, "Pictures", new File(Environment.getExternalStorageDirectory(), "Pictures").getAbsolutePath());
        a(jSONArray, "Movies", new File(Environment.getExternalStorageDirectory(), "Movies").getAbsolutePath());
        a(jSONArray, "Music", new File(Environment.getExternalStorageDirectory(), "Music").getAbsolutePath());
        a(jSONArray, "Documents", new File(Environment.getExternalStorageDirectory(), "Documents").getAbsolutePath());
        a(jSONArray, "微信文件", new File(Environment.getExternalStorageDirectory(), "Android/data/com.tencent.mm/MicroMsg/Download").getAbsolutePath());
        Context context = this.f5391a;
        a(jSONArray, "APP 私有", context.getExternalFilesDir(null) != null ? context.getExternalFilesDir(null).getAbsolutePath() : context.getFilesDir().getAbsolutePath());
        boolean z2 = n.z(context);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shortcuts", jSONArray);
        jSONObject.put("hasAllFilesAccess", z2);
        jSONObject.put("sdkInt", Build.VERSION.SDK_INT);
        jSONObject.put("model", Build.MANUFACTURER + " " + Build.MODEL);
        t(dataOutputStream, i3, 0, jSONObject, null);
    }

    public final void k(DataInputStream dataInputStream, DataOutputStream dataOutputStream, String str) {
        try {
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            if (bArr[0] == 70 && bArr[1] == 73 && bArr[2] == 76 && bArr[3] == 69) {
                int i3 = dataInputStream.readInt();
                int i4 = dataInputStream.readInt();
                int i5 = dataInputStream.readInt();
                if (i5 >= 0 && i5 <= 1000000) {
                    byte[] bArr2 = new byte[i5];
                    if (i5 > 0) {
                        dataInputStream.readFully(bArr2);
                    }
                    JSONObject jSONObject = i5 > 0 ? new JSONObject(new String(bArr2, StandardCharsets.UTF_8)) : new JSONObject();
                    switch (i3) {
                        case 1:
                            i(i4, dataOutputStream, jSONObject);
                            break;
                        case 2:
                            j(i4, dataOutputStream, jSONObject);
                            break;
                        case 3:
                            l(i4, dataOutputStream, jSONObject);
                            break;
                        case 4:
                            h(i4, dataOutputStream);
                            break;
                        case 5:
                            m(jSONObject, i4, dataInputStream, dataOutputStream);
                            break;
                        case 6:
                            g(jSONObject, i4, dataInputStream, dataOutputStream);
                            break;
                        case 7:
                            f(i4, dataOutputStream, jSONObject);
                            break;
                        default:
                            s(dataOutputStream, i4, 3, "unknown cmd " + i3);
                            break;
                    }
                    dataOutputStream.flush();
                    return;
                }
                s(dataOutputStream, i4, 3, "metaLen out of range: " + i5);
                dataOutputStream.flush();
                return;
            }
            Log.w("MirrorFileSrv", "bad magic from ".concat(str));
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("handleRequest (", str, ") error: "), "MirrorFileSrv");
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003f  */
    public final void m(JSONObject jSONObject, int i3, DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws JSONException, IOException {
        String strSubstring;
        File file;
        boolean zStartsWith;
        String strOptString = jSONObject.optString("path", "");
        if (strOptString.isEmpty()) {
            s(dataOutputStream, i3, 3, "missing path");
            return;
        }
        File file2 = new File(strOptString);
        boolean zIsAbsolute = file2.isAbsolute();
        Context context = this.f5391a;
        if (zIsAbsolute) {
            file = file2;
        } else {
            String strReplace = strOptString.replace('\\', '/');
            if (strReplace.startsWith("incoming/")) {
                strSubstring = strReplace.substring(9);
                if (strSubstring.isEmpty() || strSubstring.equals(".") || strSubstring.equals("..") || strSubstring.contains("/")) {
                    strSubstring = null;
                }
            } else {
                strSubstring = null;
            }
            if (strSubstring == null) {
                file = null;
            } else {
                File canonicalFile = new File(context.getCacheDir(), "incoming").getCanonicalFile();
                if (!canonicalFile.exists() && !canonicalFile.mkdirs()) {
                    o2.l("cannot create incoming directory");
                    return;
                } else {
                    file2 = new File(canonicalFile, strSubstring).getCanonicalFile();
                    file = file2;
                }
            }
        }
        if (file == null) {
            s(dataOutputStream, i3, 2, "path not allowed");
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            try {
                File canonicalFile2 = new File(context.getCacheDir().getCanonicalFile(), "incoming").getCanonicalFile();
                if (!canonicalFile2.exists()) {
                    canonicalFile2.mkdirs();
                }
                File externalCacheDir = context.getExternalCacheDir();
                File canonicalFile3 = parentFile.getCanonicalFile();
                if (canonicalFile3.getPath().startsWith(canonicalFile2.getPath())) {
                    zStartsWith = true;
                } else if (externalCacheDir != null) {
                    File canonicalFile4 = new File(externalCacheDir, "incoming").getCanonicalFile();
                    if (!canonicalFile4.exists()) {
                        canonicalFile4.mkdirs();
                    }
                    zStartsWith = canonicalFile3.getPath().startsWith(canonicalFile4.getPath());
                } else {
                    zStartsWith = false;
                }
            } catch (IOException unused) {
            }
            if (zStartsWith) {
                long j3 = dataInputStream.readLong();
                if (j3 <= 0 || j3 > 157286400) {
                    s(dataOutputStream, i3, 5, "invalid size: " + j3);
                    return;
                } else {
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        s(dataOutputStream, i3, 4, "cannot create parent dir");
                        return;
                    }
                    try {
                        n.i0(dataInputStream, file, j3, 157286400L);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", file.getAbsolutePath());
                        jSONObject2.put("bytes", j3);
                        t(dataOutputStream, i3, 0, jSONObject2, null);
                        return;
                    } catch (Throwable th) {
                        s(dataOutputStream, i3, 4, th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                        return;
                    }
                }
            }
        }
        s(dataOutputStream, i3, 2, "path not allowed");
    }

    public final void q(File file, String str) {
        try {
            MediaScannerConnection.scanFile(this.f5391a, new String[]{file.getAbsolutePath()}, new String[]{str}, null);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("gallery media scan failed: "), "MirrorFileSrv");
        }
    }
}
