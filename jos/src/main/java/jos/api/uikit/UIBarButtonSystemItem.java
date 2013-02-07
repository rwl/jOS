package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIBarButtonSystemItem {
    @Bind("UIBarButtonSystemItemDone") DONE,
    @Bind("UIBarButtonSystemItemCancel") CANCEL,
    @Bind("UIBarButtonSystemItemEdit") EDIT,
    @Bind("UIBarButtonSystemItemSave") SAVE,
    @Bind("UIBarButtonSystemItemAdd") ADD,
    @Bind("UIBarButtonSystemItemFlexibleSpace") FLEXIBLE_SPACE,
    @Bind("UIBarButtonSystemItemFixedSpace") FIXED_SPACE,
    @Bind("UIBarButtonSystemItemCompose") COMPOSE,
    @Bind("UIBarButtonSystemItemReply") REPLY,
    @Bind("UIBarButtonSystemItemAction") ACTION,
    @Bind("UIBarButtonSystemItemOrganize") ORGANIZE,
    @Bind("UIBarButtonSystemItemBookmarks") BOOKMARKS,
    @Bind("UIBarButtonSystemItemSearch") SEARCH,
    @Bind("UIBarButtonSystemItemRefresh") REFRESH,
    @Bind("UIBarButtonSystemItemStop") STOP,
    @Bind("UIBarButtonSystemItemCamera") CAMERA,
    @Bind("UIBarButtonSystemItemTrash") TRASH,
    @Bind("UIBarButtonSystemItemPlay") PLAY,
    @Bind("UIBarButtonSystemItemPause") PAUSE,
    @Bind("UIBarButtonSystemItemRewind") REWIND,
    @Bind("UIBarButtonSystemItemFastForward") FAST_FORWARD,
    @Bind("UIBarButtonSystemItemUndo") UNDO,
    @Bind("UIBarButtonSystemItemRedo") REDO,
    @Bind("UIBarButtonSystemItemPageCurl") PAGE_CURL
}
