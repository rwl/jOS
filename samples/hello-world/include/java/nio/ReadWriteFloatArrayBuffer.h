//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/nio/src/main/java/common/java/nio/ReadWriteFloatArrayBuffer.java
//
//  Created by rwl on 2/1/13.
//

@class IOSFloatArray;
@class JavaNioFloatBuffer;

#import "JreEmulation.h"
#import "java/nio/FloatArrayBuffer.h"

@interface JavaNioReadWriteFloatArrayBuffer : JavaNioFloatArrayBuffer {
}

+ (JavaNioReadWriteFloatArrayBuffer *)copy__WithJavaNioFloatArrayBuffer:(JavaNioFloatArrayBuffer *)other
                                                                withInt:(int)markOfOther OBJC_METHOD_FAMILY_NONE;
- (id)initWithJavaLangFloatArray:(IOSFloatArray *)array;
- (id)initWithInt:(int)capacity;
- (id)initWithInt:(int)capacity
withJavaLangFloatArray:(IOSFloatArray *)backingArray
          withInt:(int)arrayOffset;
- (JavaNioFloatBuffer *)asReadOnlyBuffer;
- (JavaNioFloatBuffer *)compact;
- (JavaNioFloatBuffer *)duplicate;
- (BOOL)isReadOnly;
- (IOSFloatArray *)protectedArray;
- (int)protectedArrayOffset;
- (BOOL)protectedHasArray;
- (JavaNioFloatBuffer *)putWithFloat:(float)c;
- (JavaNioFloatBuffer *)putWithInt:(int)index
                         withFloat:(float)c;
- (JavaNioFloatBuffer *)putWithJavaLangFloatArray:(IOSFloatArray *)src
                                          withInt:(int)off
                                          withInt:(int)len;
- (JavaNioFloatBuffer *)slice;
@end
