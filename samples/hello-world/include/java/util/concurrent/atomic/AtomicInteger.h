//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/Classes/java/util/concurrent/atomic/AtomicInteger.java
//
//  Created by rwl on 2/1/13.
//

#import "JreEmulation.h"
#import "java/io/Serializable.h"

@interface JavaUtilConcurrentAtomicAtomicInteger : NSNumber < JavaIoSerializable > {
 @public
  int value_;
}

@property (nonatomic, assign) int value;

- (id)initWithInt:(int)initialValue;
- (id)init;
- (int)get;
- (void)setWithInt:(int)newValue;
- (void)lazySetWithInt:(int)newValue;
- (int)getAndSetWithInt:(int)newValue;
- (BOOL)compareAndSetWithInt:(int)expect
                     withInt:(int)update;
- (int)getAndIncrement;
- (int)getAndDecrement;
- (int)getAndAddWithInt:(int)delta;
- (int)incrementAndGet;
- (int)decrementAndGet;
- (int)addAndGetWithInt:(int)delta;
- (NSString *)description;
- (int)intValue;
- (long long int)longValue;
- (float)floatValue;
- (double)doubleValue;
@end