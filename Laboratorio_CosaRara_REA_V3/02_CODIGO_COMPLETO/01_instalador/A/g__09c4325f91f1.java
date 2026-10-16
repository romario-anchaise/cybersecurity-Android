// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: renamed from: A.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0007g implements InterfaceC0006f, InterfaceC0008h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ClipData f39b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f40c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f42e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f43f;

    public /* synthetic */ C0007g() {
    }

    @Override // A.InterfaceC0006f
    public void b(Bundle bundle) {
        this.f43f = bundle;
    }

    @Override // A.InterfaceC0006f
    public void d(Uri uri) {
        this.f42e = uri;
    }

    @Override // A.InterfaceC0008h
    public int e() {
        return this.f40c;
    }

    @Override // A.InterfaceC0008h
    public ClipData g() {
        return this.f39b;
    }

    @Override // A.InterfaceC0006f
    public C0009i k() {
        return new C0009i(new C0007g(this));
    }

    @Override // A.InterfaceC0008h
    public int q() {
        return this.f41d;
    }

    @Override // A.InterfaceC0008h
    public ContentInfo t() {
        return null;
    }

    public String toString() {
        String strValueOf;
        String str;
        switch (this.f38a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f39b.getDescription());
                sb.append(", source=");
                int i2 = this.f40c;
                if (i2 == 0) {
                    strValueOf = "SOURCE_APP";
                } else if (i2 == 1) {
                    strValueOf = "SOURCE_CLIPBOARD";
                } else if (i2 == 2) {
                    strValueOf = "SOURCE_INPUT_METHOD";
                } else if (i2 == 3) {
                    strValueOf = "SOURCE_DRAG_AND_DROP";
                } else if (i2 != 4) {
                    strValueOf = i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT";
                } else {
                    strValueOf = "SOURCE_AUTOFILL";
                }
                sb.append(strValueOf);
                sb.append(", flags=");
                int i3 = this.f41d;
                sb.append((i3 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i3));
                Uri uri = this.f42e;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                sb.append(this.f43f != null ? ", hasExtras" : "");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // A.InterfaceC0006f
    public void x(int i2) {
        this.f41d = i2;
    }

    public C0007g(C0007g c0007g) {
        ClipData clipData = c0007g.f39b;
        clipData.getClass();
        this.f39b = clipData;
        int i2 = c0007g.f40c;
        if (i2 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i2 > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.f40c = i2;
        int i3 = c0007g.f41d;
        if ((i3 & 1) == i3) {
            this.f41d = i3;
            this.f42e = c0007g.f42e;
            this.f43f = c0007g.f43f;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
