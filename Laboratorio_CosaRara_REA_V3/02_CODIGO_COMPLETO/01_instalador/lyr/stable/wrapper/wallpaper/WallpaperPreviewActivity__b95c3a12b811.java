// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import V.k;
import V0.p;
import android.app.WallpaperManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p009f.AbstractActivityC0121k;
import p010f0.h;

/* JADX INFO: loaded from: classes.dex */
public final class WallpaperPreviewActivity extends AbstractActivityC0121k {
    public static final String EXTRA_ITEM = p.a(new int[]{132, 39, 94, 63, 87, 20, 146, 245, 78, 28, 37, 172, 7, 251});
    private ProgressBar applying;
    private ImageView image;
    private final ExecutorService ioExec = Executors.newSingleThreadExecutor();
    private WallpaperItem item;
    private Button setButton;

    private void applyWallpaper() {
        this.setButton.setEnabled(false);
        this.applying.setVisibility(0);
        this.ioExec.execute(new f(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyWallpaper$2() {
        this.applying.setVisibility(8);
        this.setButton.setEnabled(true);
        Toast.makeText(this, R.string.wallpaper_set_ok, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyWallpaper$3() {
        this.applying.setVisibility(8);
        this.setButton.setEnabled(true);
        Toast.makeText(this, R.string.wallpaper_set_fail, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyWallpaper$4() {
        try {
            WallpaperManager.getInstance(this).setBitmap(WallpaperClient.get(this).downloadBitmap(this.item.imageUrl), null, true, 3);
            runOnUiThread(new f(this, 1));
        } catch (Exception unused) {
            runOnUiThread(new f(this, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        applyWallpaper();
    }

    private WallpaperItem readItem() {
        return Build.VERSION.SDK_INT >= 33 ? (WallpaperItem) getIntent().getParcelableExtra(EXTRA_ITEM, WallpaperItem.class) : (WallpaperItem) getIntent().getParcelableExtra(EXTRA_ITEM);
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, p029q.h, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_wallpaper_preview);
        WallpaperItem item = readItem();
        this.item = item;
        if (item == null || (str = item.imageUrl) == null || str.isEmpty()) {
            finish();
            return;
        }
        this.image = (ImageView) findViewById(R.id.wallpaperPreviewImage);
        this.setButton = (Button) findViewById(R.id.wallpaperSet);
        this.applying = (ProgressBar) findViewById(R.id.wallpaperApplying);
        TextView textView = (TextView) findViewById(R.id.wallpaperPreviewTitle);
        TextView textView2 = (TextView) findViewById(R.id.wallpaperPreviewCredit);
        View viewFindViewById = findViewById(R.id.wallpaperPreviewBack);
        textView.setText(this.item.title);
        textView2.setText(this.item.copyright);
        final int i2 = 0;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: lyr.stable.wrapper.wallpaper.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WallpaperPreviewActivity f3660b;

            {
                this.f3660b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        this.f3660b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.f3660b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.setButton.setOnClickListener(new View.OnClickListener(this) { // from class: lyr.stable.wrapper.wallpaper.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WallpaperPreviewActivity f3660b;

            {
                this.f3660b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        this.f3660b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.f3660b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        V.f fVarImageLoader = WallpaperClient.get(this).imageLoader();
        h hVar = new h(this);
        hVar.f2625c = this.item.imageUrl;
        hVar.f2632k = Integer.valueOf(R.drawable.bg_wallpaper_placeholder);
        hVar.f2633l = Integer.valueOf(R.drawable.bg_wallpaper_placeholder);
        hVar.f2626d = new p012h0.a(this.image);
        hVar.f2634m = null;
        hVar.f2635n = null;
        hVar.f2636o = null;
        ((k) fVarImageLoader).b(hVar.a());
    }

    @Override // p009f.AbstractActivityC0121k, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        this.ioExec.shutdownNow();
        super.onDestroy();
    }
}
