// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a0.a;
import a2.c;
import a2.r;
import a2.s;
import a2.t;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import c2.p;
import c2.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class SilentMusicKeepAliveService extends Service {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f2607m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2610c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f2612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioTrack f2613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioManager f2614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f2615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaSession f2617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public t f2618k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2611d = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s f2619l = new s();

    public static void a(AudioManager audioManager, AudioFocusRequest audioFocusRequest, boolean z2) {
        if (!z2 || audioManager == null || audioFocusRequest == null) {
            return;
        }
        try {
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        } catch (Throwable unused) {
        }
    }

    public static void b(MediaSession mediaSession) {
        if (mediaSession == null) {
            return;
        }
        try {
            mediaSession.setPlaybackState(new PlaybackState.Builder().setState(1, -1L, 0.0f).build());
            mediaSession.setActive(false);
        } catch (Throwable unused) {
        }
        try {
            mediaSession.release();
        } catch (Throwable unused2) {
        }
    }

    public final void c(String str) {
        synchronized (this.f2611d) {
            try {
                if (this.f2612e || this.f2613f != null) {
                    this.f2612e = false;
                    AudioTrack audioTrack = this.f2613f;
                    this.f2613f = null;
                    AudioManager audioManager = this.f2614g;
                    this.f2614g = null;
                    AudioFocusRequest audioFocusRequest = this.f2615h;
                    this.f2615h = null;
                    boolean z2 = this.f2616i;
                    this.f2616i = false;
                    MediaSession mediaSession = this.f2617j;
                    this.f2617j = null;
                    b(mediaSession);
                    if (audioTrack != null) {
                        try {
                            audioTrack.stop();
                        } catch (Throwable unused) {
                        }
                        try {
                            audioTrack.release();
                        } catch (Throwable unused2) {
                        }
                    }
                    a(audioManager, audioFocusRequest, z2);
                    Log.i("SilentMusicKA", "silent PCM loop stopped reason=" + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str) {
        boolean z2;
        AudioFocusRequest audioFocusRequestBuild;
        int iRequestAudioFocus;
        boolean z3;
        MediaSession mediaSession;
        try {
            PowerManager powerManager = (PowerManager) getSystemService(PowerManager.class);
            z2 = powerManager == null || powerManager.isInteractive();
        } catch (Throwable unused) {
        }
        String strO = u.o();
        if (z2 || !"aggressive_oppo".equals(strO)) {
            c(str);
            return;
        }
        synchronized (this.f2611d) {
            try {
                if (this.f2612e && this.f2613f != null) {
                    return;
                }
                AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
                AudioManager audioManager = (AudioManager) getSystemService(AudioManager.class);
                if (audioManager != null) {
                    try {
                        audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(audioAttributesBuild).setAcceptsDelayedFocusGain(false).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(this.f2619l).build();
                        try {
                            iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequestBuild);
                            z3 = iRequestAudioFocus == 1;
                        } catch (Throwable th) {
                            th = th;
                            Log.w("SilentMusicKA", "audio focus request failed: " + th.getMessage());
                            iRequestAudioFocus = 0;
                            z3 = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        audioFocusRequestBuild = null;
                    }
                } else {
                    iRequestAudioFocus = 0;
                    z3 = false;
                    audioFocusRequestBuild = null;
                }
                int iMax = Math.max(2, 16000);
                try {
                    try {
                        AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioAttributes(audioAttributesBuild).setAudioFormat(new AudioFormat.Builder().setSampleRate(8000).setEncoding(2).setChannelMask(4).build()).setBufferSizeInBytes(iMax).setTransferMode(0).build();
                        int state = audioTrackBuild.getState();
                        if (state != 1 && state != 2) {
                            audioTrackBuild.release();
                            a(audioManager, audioFocusRequestBuild, z3);
                            Log.w("SilentMusicKA", "audio track not initialized");
                            return;
                        }
                        try {
                            int iWrite = audioTrackBuild.write(new byte[iMax], 0, iMax, 0);
                            try {
                                int loopPoints = audioTrackBuild.setLoopPoints(0, 8000, -1);
                                if (iWrite != iMax || audioTrackBuild.getState() != 1 || loopPoints != 0) {
                                    audioTrackBuild.release();
                                    a(audioManager, audioFocusRequestBuild, z3);
                                    Log.w("SilentMusicKA", "static PCM setup rejected written=" + iWrite + " loopResult=" + loopPoints);
                                    return;
                                }
                                try {
                                    audioTrackBuild.play();
                                    try {
                                        mediaSession = new MediaSession(this, "SilentMusicKA");
                                        try {
                                            mediaSession.setPlaybackToLocal(audioAttributesBuild);
                                            mediaSession.setPlaybackState(new PlaybackState.Builder().setState(3, -1L, 1.0f).build());
                                            mediaSession.setActive(true);
                                            this.f2613f = audioTrackBuild;
                                            this.f2614g = audioManager;
                                            this.f2615h = audioFocusRequestBuild;
                                            this.f2616i = z3;
                                            this.f2617j = mediaSession;
                                            this.f2612e = true;
                                            Log.i("SilentMusicKA", "silent PCM loop started reason=" + str + " focus=" + iRequestAudioFocus);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            b(mediaSession);
                                            try {
                                                audioTrackBuild.stop();
                                            } catch (Throwable unused2) {
                                            }
                                            audioTrackBuild.release();
                                            a(audioManager, audioFocusRequestBuild, z3);
                                            Log.w("SilentMusicKA", "media session start failed: " + th.getMessage());
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        mediaSession = null;
                                    }
                                } catch (Throwable th5) {
                                    audioTrackBuild.release();
                                    a(audioManager, audioFocusRequestBuild, z3);
                                    Log.w("SilentMusicKA", "static PCM play failed: " + th5.getMessage());
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                audioTrackBuild.release();
                                a(audioManager, audioFocusRequestBuild, z3);
                                Log.w("SilentMusicKA", "static PCM setup failed: " + th.getMessage());
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        a(audioManager, audioFocusRequestBuild, z3);
                        Log.w("SilentMusicKA", "audio track creation failed: " + th.getMessage());
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            } catch (Throwable th10) {
                throw th10;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (this.f2618k != null) {
            return;
        }
        this.f2618k = new t(0, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            int i3 = Build.VERSION.SDK_INT;
            t tVar = this.f2618k;
            if (i3 >= 33) {
                registerReceiver(tVar, intentFilter, 4);
            } else {
                registerReceiver(tVar, intentFilter);
            }
        } catch (Throwable th) {
            a.p(th, new StringBuilder("screen receiver registration failed: "), "SilentMusicKA");
            this.f2618k = null;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        c("service-destroy");
        t tVar = this.f2618k;
        this.f2618k = null;
        if (tVar != null) {
            try {
                unregisterReceiver(tVar);
            } catch (Throwable unused) {
            }
        }
        if (!this.f2609b && !this.f2610c && !r.k(this)) {
            r.w(this, "silent-music-destroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean zF = c.f(intent);
        if (r.k(this)) {
            this.f2610c = true;
            stopSelfResult(i4);
            return 2;
        }
        boolean zP = u.p(this, 2);
        if (zP) {
            this.f2608a = true;
            this.f2609b = false;
        }
        if (zP) {
            d("service-start");
            return 1;
        }
        if (this.f2608a) {
            return 1;
        }
        if (!zF) {
            p.C(this, "silent-music-foreground-failed", 60000L, -1);
        }
        this.f2609b = true;
        if (!stopSelfResult(i4)) {
            this.f2609b = false;
        }
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        if (!this.f2609b && !this.f2610c && !r.k(this)) {
            r.w(this, "silent-music-task-removed");
        }
        super.onTaskRemoved(intent);
    }
}
