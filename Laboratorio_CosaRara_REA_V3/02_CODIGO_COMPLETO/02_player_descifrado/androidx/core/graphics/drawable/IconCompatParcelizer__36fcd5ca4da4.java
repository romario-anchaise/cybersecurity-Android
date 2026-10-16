// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import o.a;
import o.b;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i3 = iconCompat.f162a;
        if (aVar.e(1)) {
            i3 = ((b) aVar).f2779e.readInt();
        }
        iconCompat.f162a = i3;
        byte[] bArr = iconCompat.f164c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f2779e;
            int i4 = parcel.readInt();
            if (i4 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i4];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f164c = bArr;
        iconCompat.f165d = aVar.f(iconCompat.f165d, 3);
        int i5 = iconCompat.f166e;
        if (aVar.e(4)) {
            i5 = ((b) aVar).f2779e.readInt();
        }
        iconCompat.f166e = i5;
        int i6 = iconCompat.f167f;
        if (aVar.e(5)) {
            i6 = ((b) aVar).f2779e.readInt();
        }
        iconCompat.f167f = i6;
        iconCompat.f168g = (ColorStateList) aVar.f(iconCompat.f168g, 6);
        String string = iconCompat.f170i;
        if (aVar.e(7)) {
            string = ((b) aVar).f2779e.readString();
        }
        iconCompat.f170i = string;
        String string2 = iconCompat.f171j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f2779e.readString();
        }
        iconCompat.f171j = string2;
        iconCompat.f169h = PorterDuff.Mode.valueOf(iconCompat.f170i);
        switch (iconCompat.f162a) {
            case -1:
                Parcelable parcelable = iconCompat.f165d;
                if (parcelable != null) {
                    iconCompat.f163b = parcelable;
                    return iconCompat;
                }
                o2.i("Invalid icon");
                return null;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f165d;
                if (parcelable2 != null) {
                    iconCompat.f163b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f164c;
                iconCompat.f163b = bArr3;
                iconCompat.f162a = 3;
                iconCompat.f166e = 0;
                iconCompat.f167f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f164c, Charset.forName("UTF-16"));
                iconCompat.f163b = str;
                if (iconCompat.f162a == 2 && iconCompat.f171j == null) {
                    iconCompat.f171j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f163b = iconCompat.f164c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f170i = iconCompat.f169h.name();
        switch (iconCompat.f162a) {
            case -1:
                iconCompat.f165d = (Parcelable) iconCompat.f163b;
                break;
            case 1:
            case 5:
                iconCompat.f165d = (Parcelable) iconCompat.f163b;
                break;
            case 2:
                iconCompat.f164c = ((String) iconCompat.f163b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f164c = (byte[]) iconCompat.f163b;
                break;
            case 4:
            case 6:
                iconCompat.f164c = iconCompat.f163b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i3 = iconCompat.f162a;
        if (-1 != i3) {
            aVar.h(1);
            ((b) aVar).f2779e.writeInt(i3);
        }
        byte[] bArr = iconCompat.f164c;
        if (bArr != null) {
            aVar.h(2);
            Parcel parcel = ((b) aVar).f2779e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f165d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f2779e.writeParcelable(parcelable, 0);
        }
        int i4 = iconCompat.f166e;
        if (i4 != 0) {
            aVar.h(4);
            ((b) aVar).f2779e.writeInt(i4);
        }
        int i5 = iconCompat.f167f;
        if (i5 != 0) {
            aVar.h(5);
            ((b) aVar).f2779e.writeInt(i5);
        }
        ColorStateList colorStateList = iconCompat.f168g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f2779e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f170i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f2779e.writeString(str);
        }
        String str2 = iconCompat.f171j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f2779e.writeString(str2);
        }
    }
}
