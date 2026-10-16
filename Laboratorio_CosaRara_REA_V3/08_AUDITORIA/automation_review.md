> Nota: revisión auxiliar con rutas y líneas de la exportación anterior. Las evidencias A10/A14/A15 de la nueva pasada prevalecen cuando resuelven una duda. No es fuente original.

# Static automation review

Static read-only inspection of pre-existing JADX recovery. No execution, rebuilding, server contact or repair.

## fake_lock_input_origin

M6 creates fake lock view y5, wires callback p2.a0, adds accessibility overlay (type 2032). y5.e receives user-submitted string; first attempt invokes ScreenMirrorService.j, which stores it as PIN/pattern/password. This is not extraction of arbitrary Google saved passwords.

Confidence: high static; execution unverified.

- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:8869`
- `02_player_descifrado/w1/y5__9c285c5c57b3.java.txt:863`
- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:3184`

## event_keylogger

B dispatches event types click 1, focus 8, text-change 16; text-change/focus queue only when f4314h enabled by K. c reads node/event text, beforeText, password flags. ScreenMirrorService initializes j5 and delegates incoming accessibility events to G4. Direct call path to j5.B not fully confirmed.

Confidence: high capability; connecting edge requires verification.

- `02_player_descifrado/w1/j5__b4ac157d4618.java.txt:789`
- `02_player_descifrado/w1/j5__b4ac157d4618.java.txt:316`
- `02_player_descifrado/w1/j5__b4ac157d4618.java.txt:914`
- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:22468`
- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:11258`

## boot_lifecycle

Manifest registers boot, locked boot, user unlocked/present, package replaced. onReceive branches on action and helper state, invoking recovery-related helpers. Does not survive uninstall; receiver needs installed app and OS delivery.

Confidence: high static; device effectiveness unknown.

- `02_player_descifrado/lyr/stable/runtime/keepalive/BootReceiver__3503f2238a8e.java.txt:21`
- `outputs/Laboratorio_CosaRara/02_Player_cargador/AndroidManifest.xml:136`

## apk_installer

CORRECTION: REA A10 confirms w1.cf.B(String):String invokes w1.z0.a(Context,File) at DEX code-unit offset187. Java grep missed cf.B because decompilation failed. Disassembly cf__74f76651.txt:1355-1494 shows local path checks: nonempty, existing file, positive size <=150MiB, canonical app-cache/external-cache containment, and installation-source authorization. No URL downloading in B. w1.ja.run command dispatcher invokes B (ja__276d98c9.txt:204-216). Session commit is not proof of successful installation and no third APK installation was observed.

Confidence: direct invocation confirmed by DEX/REA; runtime installation unobserved.

- `02_player_descifrado/w1/z0__a48ea0eface7.java.txt:23`
- `02_player_descifrado/lyr/stable/runtime/ApkInstallHelper$InstallResultReceiver__9a0d60be9eae.java.txt:15`

## wrapper_installer

Wrapper h(File) opens Android VIEW intent with APK MIME type via FileProvider; V0.e.run invokes h(file) in install branch. OS authorization/confirmation still relevant.

Confidence: high static.

- `01_instalador/lyr/stable/wrapper/MainActivity__019343676c80.java.txt:469`
- `01_instalador/V0/e__53f7e97dfc5a.java.txt:228`

## guard

l5 processes accessibility/foreground protection conditions; contains CoreProtectionGuard blocked-page logs. Do not equate all uninstall strings with anti-uninstall: other branches intentionally initiate self-uninstall.

Confidence: partial static; verify with REA.

- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:16658`
- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:17299`

## overlay_activation_wrapper

Small selector L6(int) invokes M6 on main thread or posts ua case1. pa.run case2 invokes L6 when view absent, persisted lock_mask_active and G0 true; background screenshot fallback or callbacks also invoke L6. Does not establish original command source.

Confidence: high static.

- `02_player_descifrado/lyr/stable/runtime/ScreenMirrorService__f5cac3c3a743.java.txt:8679`
- `02_player_descifrado/w1/pa__91f65ca626e6.java.txt:146`

## REA selectors

- `w1.y5.e`: Input origin and callback; java.lang.String
- `lyr.stable.runtime.ScreenMirrorService.M6`: Fake lock view and overlay wiring; int
- `w1.j5.B`: Event dispatch and queue gate; android.view.accessibility.AccessibilityEvent
- `lyr.stable.runtime.keepalive.BootReceiver.onReceive`: System-event entry point; Context, Intent
- `w1.cf.B`: DEX-confirmed installer caller; java.lang.String local file path
- `lyr.stable.runtime.ScreenMirrorService.l5`: Protection event gating; AccessibilityEvent, w1.zc, long
- `lyr.stable.wrapper.MainActivity.h`: Wrapper APK installer intent; java.io.File
- `lyr.stable.runtime.ScreenMirrorService.L6(int)`: small UI overlay dispatcher.

## Limits

- Resolve ScreenMirrorService.G4 -> j5.B caller path through dispatch object(s).
- M6 trigger sources and whether local automatic path versus remotely supplied action.
- Validate semantics against REA/bytecode where JADX has impossible null checks (j5.c source == null && source.isPassword; condition event.getText()!=null || event.getText().isEmpty). Do not fix as reconstructed original.
- None of these static artifacts establish event execution, permission grants, data theft or connected server on the user's phone.
- Resolve upstream transport into w1.ja.run; direct w1.cf.B -> w1.z0.a is confirmed.

