// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
        mediaMetadataRetriever.setDataSource(mediaDataSource);
    }
}
