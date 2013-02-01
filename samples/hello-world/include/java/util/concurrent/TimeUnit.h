//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/Classes/java/util/concurrent/TimeUnit.java
//
//  Created by rwl on 2/1/13.
//

@class JavaUtilConcurrentTimeUnitEnum;

#import "JreEmulation.h"
#import "java/lang/Enum.h"

typedef enum {
  JavaUtilConcurrentTimeUnit_DAYS = 0,
  JavaUtilConcurrentTimeUnit_HOURS = 1,
  JavaUtilConcurrentTimeUnit_MINUTES = 2,
  JavaUtilConcurrentTimeUnit_SECONDS = 3,
  JavaUtilConcurrentTimeUnit_MILLISECONDS = 4,
  JavaUtilConcurrentTimeUnit_MICROSECONDS = 5,
  JavaUtilConcurrentTimeUnit_NANOSECONDS = 6,
} JavaUtilConcurrentTimeUnit;

@interface JavaUtilConcurrentTimeUnitEnum : JavaLangEnum < NSCopying > {
 @public
  long long int value_;
}
@property (nonatomic, assign) long long int value;

+ (JavaUtilConcurrentTimeUnitEnum *)DAYS;
+ (JavaUtilConcurrentTimeUnitEnum *)HOURS;
+ (JavaUtilConcurrentTimeUnitEnum *)MINUTES;
+ (JavaUtilConcurrentTimeUnitEnum *)SECONDS;
+ (JavaUtilConcurrentTimeUnitEnum *)MILLISECONDS;
+ (JavaUtilConcurrentTimeUnitEnum *)MICROSECONDS;
+ (JavaUtilConcurrentTimeUnitEnum *)NANOSECONDS;
+ (IOSObjectArray *)values;
+ (JavaUtilConcurrentTimeUnitEnum *)valueOfWithNSString:(NSString *)name;
- (id)copyWithZone:(NSZone *)zone;
- (id)initWithLongInt:(long long int)value
         withNSString:(NSString *)name
              withInt:(int)ordinal;
- (long long int)convertWithLongInt:(long long int)sourceDuration
 withJavaUtilConcurrentTimeUnitEnum:(JavaUtilConcurrentTimeUnitEnum *)unit;
- (long long int)toDaysWithLongInt:(long long int)duration;
- (long long int)toHoursWithLongInt:(long long int)duration;
- (long long int)toMinutesWithLongInt:(long long int)duration;
- (long long int)toSecondsWithLongInt:(long long int)duration;
- (long long int)toMillisWithLongInt:(long long int)duration;
- (long long int)toMicrosWithLongInt:(long long int)duration;
- (long long int)toNanosWithLongInt:(long long int)duration;
- (long long int)convertWithLongInt:(long long int)sourceDurationNs;
@end
