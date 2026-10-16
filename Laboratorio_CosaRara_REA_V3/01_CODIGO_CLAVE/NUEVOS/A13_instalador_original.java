// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_2123bfc078a1b6479aba6936be1537e855b4bda48190c58597ad92d6ea6fb126
// Selector: {'path': 'C:\\Users\\Romario\\Downloads\\CosaRara.apk', 'class_name': 'lyr.stable.wrapper.MainActivity', 'method_name': 'h'}

public final void h(File file) {
    try {
        Uri uriC = FileProvider.c(this, getPackageName() + ".fileprovider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriC, "application/vnd.android.package-archive");
        intent.addFlags(1);
        intent.addFlags(268435456);
        startActivity(intent);
    } catch (Exception e2) {
        Log.w(f3569m0, "Install intent failed", e2);
        Toast.makeText(this, R.string.install_failed, 1).show();
    }
}
