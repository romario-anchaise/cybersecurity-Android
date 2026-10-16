// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HashMap f527c;

    public b(a aVar, HashMap map) {
        this.f527c = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        HashMap map = this.f527c;
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        String string = builderBuildUpon.build().toString();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        StringBuilder sb = new StringBuilder(String.valueOf(responseCode).length() + 54 + String.valueOf(string).length());
                        sb.append("Received non-success response code ");
                        sb.append(responseCode);
                        sb.append(" from pinging URL: ");
                        sb.append(string);
                        Log.w("HttpUrlPinger", sb.toString());
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException | RuntimeException e3) {
                String message = e3.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + String.valueOf(string).length() + 27);
                sb2.append("Error while pinging URL: ");
                sb2.append(string);
                sb2.append(". ");
                sb2.append(message);
                Log.w("HttpUrlPinger", sb2.toString(), e3);
            }
        } catch (IndexOutOfBoundsException e4) {
            String message2 = e4.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + String.valueOf(string).length() + 32);
            sb3.append("Error while parsing ping URL: ");
            sb3.append(string);
            sb3.append(". ");
            sb3.append(message2);
            Log.w("HttpUrlPinger", sb3.toString(), e4);
        }
    }
}
