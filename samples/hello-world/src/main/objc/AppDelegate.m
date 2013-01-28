#import "AppDelegate.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
    
    self.label = [[[UILabel alloc] initWithFrame:CGRectMake(0.0f, 50.0f, 320.0f, 30.0f)] autorelease];
    self.label.text = @"Hello World!";
    self.label.textAlignment = NSTextAlignmentCenter;
    
    [self.window addSubview:self.label];
    [self.window makeKeyAndVisible];
    return YES;
}

- (void)dealloc
{
    [_window release];
    [_label release];
    [super dealloc];
}

@end
