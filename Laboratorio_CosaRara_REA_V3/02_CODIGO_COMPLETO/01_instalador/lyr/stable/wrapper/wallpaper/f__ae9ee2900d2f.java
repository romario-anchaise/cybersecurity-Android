// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WallpaperPreviewActivity f3662b;

    public /* synthetic */ f(WallpaperPreviewActivity wallpaperPreviewActivity, int i2) {
        this.f3661a = i2;
        this.f3662b = wallpaperPreviewActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3661a) {
            case 0:
                this.f3662b.lambda$applyWallpaper$4();
                break;
            case 1:
                this.f3662b.lambda$applyWallpaper$2();
                break;
            default:
                this.f3662b.lambda$applyWallpaper$3();
                break;
        }
    }
}
