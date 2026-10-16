// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class WallpaperItem implements Parcelable {
    public static final Parcelable.Creator<WallpaperItem> CREATOR = new Parcelable.Creator<WallpaperItem>() { // from class: lyr.stable.wrapper.wallpaper.WallpaperItem.1
        @Override // android.os.Parcelable.Creator
        public WallpaperItem createFromParcel(Parcel parcel) {
            return new WallpaperItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WallpaperItem[] newArray(int i2) {
            return new WallpaperItem[i2];
        }
    };
    public final String copyright;
    public final String id;
    public final String imageUrl;
    public final String thumbUrl;
    public final String title;

    public WallpaperItem(String str, String str2, String str3, String str4, String str5) {
        this.id = str;
        this.title = str2;
        this.copyright = str3;
        this.imageUrl = str4;
        this.thumbUrl = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.copyright);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.thumbUrl);
    }

    public WallpaperItem(Parcel parcel) {
        this.id = parcel.readString();
        this.title = parcel.readString();
        this.copyright = parcel.readString();
        this.imageUrl = parcel.readString();
        this.thumbUrl = parcel.readString();
    }
}
