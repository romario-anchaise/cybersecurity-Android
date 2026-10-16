// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.AtomicFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile Context f5568o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f5555a = {19321, 19320, 19251, 19311, 19314, 19327, 19307, 19251, 19324, 19315, 19321, 19311, 19314, 19316, 19321, 19251, 19301, 19309, 19314, 19310, 19320, 19321, 19251, 19269, 19309, 19314, 19310, 19320, 19321, 19295, 19311, 19316, 19321, 19322, 19320};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f5556b = {19250, 19309, 19311, 19314, 19326, 19250, 19310, 19320, 19313, 19323, 19250, 19312, 19324, 19309, 19310};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f5557c = {19250, 19309, 19311, 19314, 19326, 19250, 19310, 19320, 19313, 19323, 19250, 19310, 19305, 19324, 19305, 19304, 19310};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f5558d = {19273, 19311, 19324, 19326, 19320, 19311, 19277, 19316, 19321};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f5559e = {19323, 19311, 19316, 19321, 19324};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f5560f = {19322, 19304, 19312, 19248, 19319, 19310, 19248, 19313, 19314, 19314, 19309};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f5561g = {19250, 19321, 19324, 19305, 19324, 19250, 19313, 19314, 19326, 19324, 19313, 19250, 19305, 19312, 19309, 19250, 19323, 19311, 19316, 19321, 19324, 19248, 19310, 19320, 19311, 19307, 19320, 19311};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f5562h = {19250, 19321, 19320, 19307, 19250, 19308, 19320, 19312, 19304, 19266, 19309, 19316, 19309, 19320};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f5563i = {19250, 19321, 19320, 19307, 19250, 19310, 19314, 19326, 19318, 19320, 19305, 19250, 19308, 19320, 19312, 19304, 19321};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f5564j = {19322, 19320, 19315, 19320, 19311, 19316, 19326};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f5565k = {19307, 19327, 19314, 19301};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f5566l = {19322, 19320, 19315, 19300, 19312, 19314, 19305, 19316, 19314, 19315};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicBoolean f5567m = new AtomicBoolean();
    public static final AtomicBoolean n = new AtomicBoolean();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m0 f5569p = new m0(1);

    public static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            return arrayList;
                        }
                        arrayList.add(line);
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return arrayList;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
    }

    public static void b(String str, m0 m0Var, m0 m0Var2) {
        Context context;
        File file;
        if (n.compareAndSet(false, true) && (context = f5568o) != null && x0.f5481a.contains(str) && x0.f5482b.contains("terminate")) {
            try {
                w0 w0Var = new w0(str, "terminate", System.currentTimeMillis(), Process.myPid(), Application.getProcessName(), t9.f5183o, t9.f5181l, t9.f5182m, t9.n, t9.f5179j, t9.f5180k);
                long j3 = w0Var.f5367c;
                FileOutputStream fileOutputStream = null;
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    file = new File(context.createDeviceProtectedStorageContext().getFilesDir(), "anti-analysis-decisions-v1");
                } catch (Throwable unused) {
                    file = null;
                }
                if (file != null && (file.isDirectory() || file.mkdirs() || file.isDirectory())) {
                    StringBuilder sbJ = a0.a.j(j3, "decision-", "-");
                    sbJ.append(w0Var.f5368d);
                    sbJ.append(".json");
                    AtomicFile atomicFile = new AtomicFile(new File(file, sbJ.toString()));
                    try {
                        byte[] bytes = w0Var.b().toString().getBytes(StandardCharsets.UTF_8);
                        if (bytes.length <= 4096) {
                            FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                            try {
                                fileOutputStreamStartWrite.write(bytes);
                                fileOutputStreamStartWrite.flush();
                                atomicFile.finishWrite(fileOutputStreamStartWrite);
                                x0.b(file, j3);
                            } catch (Throwable unused2) {
                                fileOutputStream = fileOutputStreamStartWrite;
                                if (fileOutputStream != null) {
                                    atomicFile.failWrite(fileOutputStream);
                                }
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
            }
        }
        m0Var.getClass();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public static String c(int[] iArr) {
        char[] cArr = new char[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            cArr[i3] = (char) (iArr[i3] ^ 19229);
        }
        return new String(cArr);
    }

    public static boolean d(m0 m0Var) {
        String strC = c(f5559e);
        String strC2 = c(f5560f);
        m0Var.getClass();
        ArrayList arrayListA = a(c(f5556b));
        int size = arrayListA.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListA.get(i3);
            i3++;
            String str = (String) obj;
            if (str.contains(strC) || str.contains(strC2)) {
                return true;
            }
        }
        return false;
    }
}
