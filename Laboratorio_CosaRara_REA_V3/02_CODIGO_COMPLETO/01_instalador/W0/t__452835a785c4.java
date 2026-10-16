// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t {
    public static int a(String str, String str2, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection2.setRequestProperty("X-Telemetry-Key", str2);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setConnectTimeout(8000);
                httpURLConnection2.setReadTimeout(8000);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    httpURLConnection2.disconnect();
                    return responseCode;
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
