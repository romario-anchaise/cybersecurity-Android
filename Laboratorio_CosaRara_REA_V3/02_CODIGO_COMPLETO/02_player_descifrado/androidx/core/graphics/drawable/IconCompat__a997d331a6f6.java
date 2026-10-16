// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import b2.a;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f161k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f163b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f171j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f162a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f164c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f165d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f166e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f167f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f168g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f169h = f161k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f170i = null;

    public static IconCompat a(int i3) {
        if (i3 == 0) {
            o2.i("Drawable resource ID must not be 0");
            return null;
        }
        IconCompat iconCompat = new IconCompat();
        iconCompat.f164c = null;
        iconCompat.f165d = null;
        iconCompat.f167f = 0;
        iconCompat.f168g = null;
        iconCompat.f169h = f161k;
        iconCompat.f170i = null;
        iconCompat.f162a = 2;
        iconCompat.f166e = i3;
        iconCompat.f163b = "";
        iconCompat.f171j = "";
        return iconCompat;
    }

    public final int b() {
        int i3 = this.f162a;
        if (i3 == -1) {
            return ((Icon) this.f163b).getResId();
        }
        if (i3 == 2) {
            return this.f166e;
        }
        a.f(this, "called getResId() on ");
        return 0;
    }

    public final String toString() {
        String str;
        if (this.f162a == -1) {
            return String.valueOf(this.f163b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f162a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f162a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f163b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f163b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f171j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f166e);
                if (this.f167f != 0) {
                    sb.append(" off=");
                    sb.append(this.f167f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f163b);
                break;
        }
        if (this.f168g != null) {
            sb.append(" tint=");
            sb.append(this.f168g);
        }
        if (this.f169h != f161k) {
            sb.append(" mode=");
            sb.append(this.f169h);
        }
        sb.append(")");
        return sb.toString();
    }
}
