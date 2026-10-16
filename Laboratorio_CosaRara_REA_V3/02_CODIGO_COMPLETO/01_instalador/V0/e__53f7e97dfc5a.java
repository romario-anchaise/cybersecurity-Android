// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ File f702c;

    public /* synthetic */ e(MainActivity mainActivity, File file, int i2) {
        this.f700a = i2;
        this.f701b = mainActivity;
        this.f702c = file;
    }

    /* JADX WARN: Code duplicated, block: B:122:? A[Catch: all -> 0x0120, Exception -> 0x0124, SYNTHETIC, TryCatch #9 {Exception -> 0x0124, all -> 0x0120, blocks: (B:21:0x00b2, B:34:0x00f3, B:36:0x0105, B:38:0x010b, B:43:0x0128, B:60:0x016f, B:76:0x019a, B:75:0x0197, B:77:0x019b, B:78:0x01b1, B:79:0x01b2, B:81:0x01bd, B:83:0x01c2, B:84:0x01d7, B:85:0x01de, B:44:0x012c, B:59:0x016c, B:69:0x018e, B:68:0x018b, B:64:0x0185, B:46:0x0133, B:47:0x0137, B:49:0x013d, B:51:0x0144, B:53:0x014e, B:58:0x0167, B:71:0x0191), top: B:108:0x00b2, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long j2 = 0;
        final ?? r1 = 0;
        switch (this.f700a) {
            case 0:
                File file = this.f702c;
                String str = MainActivity.f3569m0;
                final MainActivity mainActivity = this.f701b;
                mainActivity.getClass();
                String str2 = MainActivity.f3569m0;
                String string = MainActivity.f3577u0;
                ?? r9 = 0;
                int i2 = 0;
                while (true) {
                    try {
                        try {
                            ?? r11 = (HttpURLConnection) new URL(string).openConnection();
                            try {
                                r11.setInstanceFollowRedirects(r1);
                                r11.setConnectTimeout(20000);
                                r11.setReadTimeout(30000);
                                r11.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 13; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36");
                                r11.setRequestProperty("Accept", "application/vnd.android.package-archive,application/octet-stream,*/*");
                                r11.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
                                int responseCode = r11.getResponseCode();
                                if (responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                                    if (responseCode != 200) {
                                        throw new IOException("HTTP " + responseCode);
                                    }
                                    final int contentLength = r11.getContentLength();
                                    mainActivity.runOnUiThread(new Runnable() { // from class: V0.g
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            switch (r1) {
                                                case 0:
                                                    mainActivity.f3639y.setIndeterminate(contentLength <= 0);
                                                    break;
                                                default:
                                                    MainActivity mainActivity2 = mainActivity;
                                                    mainActivity2.f3639y.setIndeterminate(false);
                                                    ProgressBar progressBar = mainActivity2.f3639y;
                                                    int i3 = contentLength;
                                                    progressBar.setProgress(i3);
                                                    mainActivity2.f3640z.setText(mainActivity2.getString(R.string.update_progress, Integer.valueOf(i3)));
                                                    break;
                                            }
                                        }
                                    });
                                    if (file.exists() && !file.delete()) {
                                        Log.w(str2, "Could not delete stale download " + file);
                                    }
                                    InputStream inputStream = r11.getInputStream();
                                    try {
                                        ?? fileOutputStream = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[8192];
                                            int i3 = -1;
                                            while (true) {
                                                int i4 = inputStream.read(bArr);
                                                if (i4 == -1) {
                                                    File file2 = file;
                                                    fileOutputStream.flush();
                                                    fileOutputStream.close();
                                                    inputStream.close();
                                                    mainActivity.runOnUiThread(new e(mainActivity, file2, 1));
                                                    r11.disconnect();
                                                    return;
                                                }
                                                fileOutputStream.write(bArr, r1, i4);
                                                j2 += (long) i4;
                                                if (contentLength > 0) {
                                                    File file3 = file;
                                                    final int i5 = (int) ((100 * j2) / ((long) contentLength));
                                                    if (i5 != i3) {
                                                        final int i6 = 1;
                                                        mainActivity.runOnUiThread(new Runnable() { // from class: V0.g
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                switch (i6) {
                                                                    case 0:
                                                                        mainActivity.f3639y.setIndeterminate(i5 <= 0);
                                                                        break;
                                                                    default:
                                                                        MainActivity mainActivity2 = mainActivity;
                                                                        mainActivity2.f3639y.setIndeterminate(false);
                                                                        ProgressBar progressBar = mainActivity2.f3639y;
                                                                        int i7 = i5;
                                                                        progressBar.setProgress(i7);
                                                                        mainActivity2.f3640z.setText(mainActivity2.getString(R.string.update_progress, Integer.valueOf(i7)));
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        i3 = i5;
                                                    }
                                                    file = file3;
                                                    r1 = 0;
                                                } else {
                                                    r1 = 0;
                                                }
                                                if (inputStream != null) {
                                                    throw th;
                                                }
                                                try {
                                                    inputStream.close();
                                                    throw th;
                                                } catch (Throwable th) {
                                                    th.addSuppressed(th);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            try {
                                                fileOutputStream.close();
                                                throw th2;
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                                throw th2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        if (inputStream != null) {
                                            throw th4;
                                        }
                                        inputStream.close();
                                        throw th4;
                                    }
                                }
                                File file4 = file;
                                String headerField = r11.getHeaderField("Location");
                                r11.disconnect();
                                if (headerField != null && (i2 = i2 + 1) <= 6) {
                                    string = new URL(new URL(string), headerField).toString();
                                    file = file4;
                                    r9 = r11;
                                    r1 = 0;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                r9 = r11;
                                Log.w(str2, "In-app download failed", e);
                                mainActivity.runOnUiThread(new a(mainActivity, 5));
                                if (r9 != 0) {
                                    r9.disconnect();
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                r9 = r11;
                                if (r9 != 0) {
                                    r9.disconnect();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                throw new IOException("Too many redirects");
            default:
                MainActivity mainActivity2 = this.f701b;
                File file5 = this.f702c;
                mainActivity2.f3579A = false;
                mainActivity2.f3638x.setVisibility(8);
                mainActivity2.f3635u.setVisibility(0);
                mainActivity2.f3636v.setVisibility(0);
                if (!file5.exists() || file5.length() <= 0) {
                    mainActivity2.f3579A = false;
                    mainActivity2.f3638x.setVisibility(8);
                    mainActivity2.f3635u.setVisibility(0);
                    mainActivity2.f3636v.setVisibility(0);
                    Toast.makeText(mainActivity2, R.string.update_download_failed, 1).show();
                    return;
                }
                if (Build.VERSION.SDK_INT < 26 || mainActivity2.getPackageManager().canRequestPackageInstalls()) {
                    mainActivity2.h(file5);
                    return;
                }
                mainActivity2.f3585G = file5;
                Toast.makeText(mainActivity2, R.string.install_unknown_sources_hint, 1).show();
                try {
                    mainActivity2.startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + mainActivity2.getPackageName())));
                    return;
                } catch (Exception unused) {
                    Toast.makeText(mainActivity2, R.string.install_failed, 1).show();
                    return;
                }
        }
    }
}
