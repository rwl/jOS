//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/lang/reflect/InvocationTargetException.java
//
//  Created by rwl on 2/1/13.
//

@class JavaLangThrowable;

#import "JreEmulation.h"
#import "java/lang/Exception.h"

#define JavaLangReflectInvocationTargetException_serialVersionUID 4085088731926701167

@interface JavaLangReflectInvocationTargetException : JavaLangException {
 @public
  JavaLangThrowable *target_;
}

@property (nonatomic, retain) JavaLangThrowable *target;

- (id)init;
- (id)initWithJavaLangThrowable:(JavaLangThrowable *)exception;
- (id)initWithJavaLangThrowable:(JavaLangThrowable *)exception
                   withNSString:(NSString *)detailMessage;
- (JavaLangThrowable *)getTargetException;
- (JavaLangThrowable *)getCause;
@end