// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WallpaperBrowserActivity f3653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3654c;

    public /* synthetic */ a(WallpaperBrowserActivity wallpaperBrowserActivity, Object obj, int i2) {
        this.f3652a = i2;
        this.f3653b = wallpaperBrowserActivity;
        this.f3654c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3652a) {
            case 0:
                this.f3653b.lambda$load$4((String) this.f3654c);
                break;
            case 1:
                this.f3653b.lambda$load$2((List) this.f3654c);
                break;
            default:
                this.f3653b.lambda$load$3((Exception) this.f3654c);
                break;
        }
    }
}
