// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m1.O;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class WallpaperBrowserActivity extends AbstractActivityC0121k implements WallpaperGridAdapter.Listener {
    private static final int PAGE_COUNT = 2;
    private static final int PAGE_SIZE = 8;
    private WallpaperGridAdapter adapter;
    private View errorGroup;
    private TextView errorMessage;
    private RecyclerView grid;
    private final ExecutorService ioExec = Executors.newSingleThreadExecutor();
    private ProgressBar loading;

    private List<WallpaperItem> fetchPages(String str) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BingWallpaperApi bingWallpaperApiApi = WallpaperClient.get(this).api();
        for (int i2 = 0; i2 < PAGE_COUNT; i2++) {
            O oJ = bingWallpaperApiApi.archive("js", i2 * PAGE_SIZE, PAGE_SIZE, str).j();
            if (!oJ.f3818a.f()) {
                throw new IllegalStateException("HTTP " + oJ.f3818a.f907d);
            }
            for (WallpaperItem wallpaperItem : WallpaperMapper.fromArchive((BingHpImageArchive) oJ.f3819b)) {
                linkedHashMap.put(wallpaperItem.id, wallpaperItem);
            }
        }
        if (linkedHashMap.isEmpty()) {
            throw new IllegalStateException("empty");
        }
        return new ArrayList(linkedHashMap.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$4(String str) {
        try {
            runOnUiThread(new a(this, fetchPages(str), 1));
        } catch (Exception e2) {
            runOnUiThread(new a(this, e2, PAGE_COUNT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    private void load() {
        this.errorGroup.setVisibility(PAGE_SIZE);
        this.loading.setVisibility(0);
        this.grid.setVisibility(PAGE_SIZE);
        this.ioExec.execute(new a(this, marketTag(), 0));
    }

    private static String marketTag() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language == null || language.isEmpty()) {
            return "en-US";
        }
        if (country == null || country.isEmpty()) {
            return language;
        }
        return language + "-" + country;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showError, reason: merged with bridge method [inline-methods] */
    public void lambda$load$3(Exception exc) {
        this.loading.setVisibility(PAGE_SIZE);
        this.grid.setVisibility(PAGE_SIZE);
        this.errorGroup.setVisibility(0);
        this.errorMessage.setText(((exc instanceof IllegalStateException) && "empty".equals(exc.getMessage())) ? getString(R.string.wallpaper_empty) : getString(R.string.wallpaper_error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showItems, reason: merged with bridge method [inline-methods] */
    public void lambda$load$2(List<WallpaperItem> list) {
        this.loading.setVisibility(PAGE_SIZE);
        this.errorGroup.setVisibility(PAGE_SIZE);
        this.grid.setVisibility(0);
        this.adapter.submit(list);
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, p029q.h, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wallpaper_browser);
        this.grid = (RecyclerView) findViewById(R.id.wallpaperGrid);
        this.loading = (ProgressBar) findViewById(R.id.wallpaperLoading);
        this.errorGroup = findViewById(R.id.wallpaperErrorGroup);
        this.errorMessage = (TextView) findViewById(R.id.wallpaperErrorMessage);
        Button button = (Button) findViewById(R.id.wallpaperRetry);
        View viewFindViewById = findViewById(R.id.wallpaperBack);
        this.adapter = new WallpaperGridAdapter(this);
        this.grid.setLayoutManager(new GridLayoutManager());
        this.grid.setAdapter(this.adapter);
        final int i2 = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: lyr.stable.wrapper.wallpaper.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WallpaperBrowserActivity f3656b;

            {
                this.f3656b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        this.f3656b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.f3656b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        final int i3 = 1;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: lyr.stable.wrapper.wallpaper.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WallpaperBrowserActivity f3656b;

            {
                this.f3656b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        this.f3656b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.f3656b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        load();
    }

    @Override // p009f.AbstractActivityC0121k, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        this.ioExec.shutdownNow();
        super.onDestroy();
    }

    @Override // lyr.stable.wrapper.wallpaper.WallpaperGridAdapter.Listener
    public void onWallpaperClick(WallpaperItem wallpaperItem) {
        Intent intent = new Intent(this, (Class<?>) WallpaperPreviewActivity.class);
        intent.putExtra(WallpaperPreviewActivity.EXTRA_ITEM, wallpaperItem);
        startActivity(intent);
    }
}
