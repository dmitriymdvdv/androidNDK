#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_androidnativeexample_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++ Bla bla";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_androidnativeexample_MainActivity_floatToInt(
        JNIEnv *env,
        jobject /* this */, jfloat x) {
    float hello = x;
    return (int)x;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_androidnativeexample_MainActivity_numberFromCPP(
        JNIEnv *env,
        jobject /* this */) {
    return (int)9999;
}
