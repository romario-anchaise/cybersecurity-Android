// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayGrantActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            intent.addFlags(1342177280);
            startActivity(intent);
        } catch (Throwable unused) {
        }
        finish();
    }
}
