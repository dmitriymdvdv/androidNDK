#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_mycpplib_MyCppLib_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++ Bla bla";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_mycpplib_MyCppLib_floatToInt(
        JNIEnv *env,
        jobject /* this */, jfloat x) {
    return (int)x;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_mycpplib_MyCppLib_numberFromCPP(
        JNIEnv *env,
        jobject /* this */) {
    return (int) 222;
}
