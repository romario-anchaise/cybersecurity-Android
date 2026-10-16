// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import w1.a4;
import w1.n4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class MirrorBootstrapActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("gateway_url")) {
                stringExtra = intent.getStringExtra("gateway_url");
                if (a4.a(stringExtra) == null) {
                    Log.w("MirrorBootstrap", "Rejected malformed gateway URL extra");
                }
            }
            stringExtra = null;
            Log.i("MirrorBootstrap", "Bootstrap wake");
            n4.m(this, stringExtra);
        } catch (Throwable th) {
            try {
                Log.w("MirrorBootstrap", "Bootstrap extras rejected", th);
            } finally {
                finish();
                overridePendingTransition(0, 0);
            }
        }
    }
}
