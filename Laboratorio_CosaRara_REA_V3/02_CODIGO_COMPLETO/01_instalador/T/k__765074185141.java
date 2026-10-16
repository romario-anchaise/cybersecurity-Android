// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import p029q.j;
import p041x.h;
import s.f;
import s.g;

/* JADX INFO: loaded from: classes.dex */
public final class k extends j {
    public static Font p(FontFamily fontFamily, int i2) {
        FontStyle fontStyle = new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iQ = q(fontStyle, font.getStyle());
        for (int i3 = 1; i3 < fontFamily.getSize(); i3++) {
            Font font2 = fontFamily.getFont(i3);
            int iQ2 = q(fontStyle, font2.getStyle());
            if (iQ2 < iQ) {
                font = font2;
                iQ = iQ2;
            }
        }
        return font;
    }

    public static int q(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // p029q.j
    public final Typeface c(Context context, f fVar, Resources resources, int i2) {
        try {
            FontFamily.Builder builder = null;
            for (g gVar : fVar.f4045a) {
                try {
                    Font fontBuild = new Font.Builder(resources, gVar.f4051f).setWeight(gVar.f4047b).setSlant(gVar.f4048c ? 1 : 0).setTtcIndex(gVar.f4050e).setFontVariationSettings(gVar.f4049d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(p(fontFamilyBuild, i2).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p029q.j
    public final Typeface d(Context context, h[] hVarArr, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (h hVar : hVarArr) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(hVar.f4180a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } else {
                        try {
                            Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(hVar.f4182c).setSlant(hVar.f4183d ? 1 : 0).setTtcIndex(hVar.f4181b).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(p(fontFamilyBuild, i2).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p029q.j
    public final Typeface e(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // p029q.j
    public final Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font fontBuild = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p029q.j
    public final h g(int i2, h[] hVarArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
