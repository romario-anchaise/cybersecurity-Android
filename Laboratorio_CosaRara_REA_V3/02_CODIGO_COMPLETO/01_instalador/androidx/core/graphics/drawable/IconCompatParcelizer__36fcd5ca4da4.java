// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.graphics.drawable;

import U.a;
import U.b;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i2 = iconCompat.f1480a;
        if (aVar.e(1)) {
            i2 = ((b) aVar).f628e.readInt();
        }
        iconCompat.f1480a = i2;
        byte[] bArr = iconCompat.f1482c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f628e;
            int i3 = parcel.readInt();
            if (i3 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i3];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f1482c = bArr;
        iconCompat.f1483d = aVar.f(iconCompat.f1483d, 3);
        int i4 = iconCompat.f1484e;
        if (aVar.e(4)) {
            i4 = ((b) aVar).f628e.readInt();
        }
        iconCompat.f1484e = i4;
        int i5 = iconCompat.f1485f;
        if (aVar.e(5)) {
            i5 = ((b) aVar).f628e.readInt();
        }
        iconCompat.f1485f = i5;
        iconCompat.g = (ColorStateList) aVar.f(iconCompat.g, 6);
        String string = iconCompat.f1487i;
        if (aVar.e(7)) {
            string = ((b) aVar).f628e.readString();
        }
        iconCompat.f1487i = string;
        String string2 = iconCompat.f1488j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f628e.readString();
        }
        iconCompat.f1488j = string2;
        iconCompat.f1486h = PorterDuff.Mode.valueOf(iconCompat.f1487i);
        switch (iconCompat.f1480a) {
            case -1:
                Parcelable parcelable = iconCompat.f1483d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1481b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1483d;
                if (parcelable2 != null) {
                    iconCompat.f1481b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f1482c;
                    iconCompat.f1481b = bArr3;
                    iconCompat.f1480a = 3;
                    iconCompat.f1484e = 0;
                    iconCompat.f1485f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f1482c, Charset.forName("UTF-16"));
                iconCompat.f1481b = str;
                if (iconCompat.f1480a == 2 && iconCompat.f1488j == null) {
                    iconCompat.f1488j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1481b = iconCompat.f1482c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f1487i = iconCompat.f1486h.name();
        switch (iconCompat.f1480a) {
            case -1:
                iconCompat.f1483d = (Parcelable) iconCompat.f1481b;
                break;
            case 1:
            case 5:
                iconCompat.f1483d = (Parcelable) iconCompat.f1481b;
                break;
            case 2:
                iconCompat.f1482c = ((String) iconCompat.f1481b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1482c = (byte[]) iconCompat.f1481b;
                break;
            case 4:
            case 6:
                iconCompat.f1482c = iconCompat.f1481b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f1480a;
        if (-1 != i2) {
            aVar.h(1);
            ((b) aVar).f628e.writeInt(i2);
        }
        byte[] bArr = iconCompat.f1482c;
        if (bArr != null) {
            aVar.h(2);
            int length = bArr.length;
            Parcel parcel = ((b) aVar).f628e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1483d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f628e.writeParcelable(parcelable, 0);
        }
        int i3 = iconCompat.f1484e;
        if (i3 != 0) {
            aVar.h(4);
            ((b) aVar).f628e.writeInt(i3);
        }
        int i4 = iconCompat.f1485f;
        if (i4 != 0) {
            aVar.h(5);
            ((b) aVar).f628e.writeInt(i4);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f628e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f1487i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f628e.writeString(str);
        }
        String str2 = iconCompat.f1488j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f628e.writeString(str2);
        }
    }
}
