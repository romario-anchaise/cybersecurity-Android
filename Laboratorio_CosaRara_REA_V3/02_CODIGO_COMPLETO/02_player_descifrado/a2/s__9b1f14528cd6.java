// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.media.AudioManager;
import android.util.Log;
import lyr.stable.runtime.engine.SilentMusicKeepAliveService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements AudioManager.OnAudioFocusChangeListener {
    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i3) {
        int i4 = SilentMusicKeepAliveService.f2607m;
        Log.d("SilentMusicKA", "audio focus change=" + i3);
    }
}
