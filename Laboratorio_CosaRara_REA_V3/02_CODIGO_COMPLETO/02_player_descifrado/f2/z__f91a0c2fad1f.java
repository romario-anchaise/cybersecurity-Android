// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import lyr.stable.runtime.setup.ColorOsAutostartGuideActivity;
import w1.y5;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f1379b;

    public /* synthetic */ z(KeyEvent.Callback callback, int i3) {
        this.f1378a = i3;
        this.f1379b = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3 = this.f1378a;
        KeyEvent.Callback callback = this.f1379b;
        switch (i3) {
            case 0:
                ColorOsAutostartGuideActivity colorOsAutostartGuideActivity = (ColorOsAutostartGuideActivity) callback;
                int i4 = colorOsAutostartGuideActivity.f2665e + 1;
                colorOsAutostartGuideActivity.f2665e = i4;
                int[] iArr = colorOsAutostartGuideActivity.f2663c;
                if (i4 >= iArr.length) {
                    int length = iArr.length;
                    int i5 = colorOsAutostartGuideActivity.f2666f;
                    if (i4 >= length && i5 == 1) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.addFlags(268435456);
                        intent.setData(Uri.parse("package:" + colorOsAutostartGuideActivity.getPackageName()));
                        try {
                            colorOsAutostartGuideActivity.getApplicationContext().startActivity(intent);
                            break;
                        } catch (Exception unused) {
                            Intent intent2 = new Intent("android.settings.SETTINGS");
                            intent2.addFlags(268435456);
                            try {
                                colorOsAutostartGuideActivity.getApplicationContext().startActivity(intent2);
                                break;
                            } catch (Exception unused2) {
                            }
                        }
                        colorOsAutostartGuideActivity.f2666f++;
                        colorOsAutostartGuideActivity.f2661a.setImageDrawable(null);
                        break;
                    }
                } else {
                    colorOsAutostartGuideActivity.f2661a.setImageResource(iArr[i4]);
                    colorOsAutostartGuideActivity.f2662b.setText(colorOsAutostartGuideActivity.f2664d[colorOsAutostartGuideActivity.f2665e]);
                    colorOsAutostartGuideActivity.f2666f++;
                    break;
                }
                break;
            default:
                ((y5) callback).b();
                break;
        }
    }
}
