// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import p035u.d;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1479k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1481b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1488j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1480a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1482c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f1483d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1484e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1485f = 0;
    public ColorStateList g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1486h = f1479k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1487i = null;

    public final String toString() {
        String str;
        int iIntValue;
        if (this.f1480a == -1) {
            return String.valueOf(this.f1481b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f1480a) {
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
        switch (this.f1480a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1481b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1481b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1488j);
                sb.append(" id=");
                int i2 = this.f1480a;
                if (i2 == -1) {
                    int i3 = Build.VERSION.SDK_INT;
                    Object obj = this.f1481b;
                    if (i3 >= 28) {
                        iIntValue = d.a(obj);
                    } else {
                        iIntValue = 0;
                        try {
                            iIntValue = ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
                        } catch (IllegalAccessException e2) {
                            Log.e("IconCompat", "Unable to get icon resource", e2);
                        } catch (NoSuchMethodException e3) {
                            Log.e("IconCompat", "Unable to get icon resource", e3);
                        } catch (InvocationTargetException e4) {
                            Log.e("IconCompat", "Unable to get icon resource", e4);
                        }
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResId() on " + this);
                    }
                    iIntValue = this.f1484e;
                }
                sb.append(String.format("0x%08x", Integer.valueOf(iIntValue)));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1484e);
                if (this.f1485f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1485f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1481b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.f1486h != f1479k) {
            sb.append(" mode=");
            sb.append(this.f1486h);
        }
        sb.append(")");
        return sb.toString();
    }
}
