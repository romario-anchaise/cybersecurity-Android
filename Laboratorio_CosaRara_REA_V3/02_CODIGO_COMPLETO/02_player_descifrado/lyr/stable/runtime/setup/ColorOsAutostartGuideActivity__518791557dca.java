// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.os9sp.yfwkcq0dwfxaf.R;
import f2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorOsAutostartGuideActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f2661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f2662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f2663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f2664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2666f;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.oppobattery);
        this.f2661a = (ImageView) findViewById(R.id.oppo_bty_image);
        this.f2662b = (Button) findViewById(R.id.oppo_bty_next);
        String language = getResources().getConfiguration().locale.getLanguage();
        if ("ar".equals(language)) {
            str = "ar";
        } else {
            str = "zh".equals(language) ? "zh" : "en";
        }
        if ("ar".equals(str)) {
            this.f2663c = new int[]{R.drawable.oppo_bty_ar_1, R.drawable.oppo_bty_ar_2};
            this.f2664d = new String[]{getString(R.string.oem_figure_next_ar), getString(R.string.oem_figure_enable_ar)};
        } else if ("zh".equals(str)) {
            this.f2663c = new int[]{R.drawable.oppo_bty_cn_1, R.drawable.oppo_bty_cn_2};
            this.f2664d = new String[]{getString(R.string.oem_figure_next_zh), getString(R.string.oem_figure_enable_zh)};
        } else {
            this.f2663c = new int[]{R.drawable.oppo_bty_en_1, R.drawable.oppo_bty_en_2};
            this.f2664d = new String[]{getString(R.string.oem_figure_next), getString(R.string.oem_figure_enable)};
        }
        this.f2661a.setImageResource(this.f2663c[0]);
        this.f2662b.setText(this.f2664d[0]);
        this.f2662b.setOnClickListener(new z(this, 0));
    }
}
