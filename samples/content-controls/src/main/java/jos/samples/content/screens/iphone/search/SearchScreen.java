package jos.samples.content.screens.iphone.search;

import java.util.ArrayList;
import java.util.List;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIViewController;

public class SearchScreen extends UIViewController {

    @Outlet
    UISearchBar srchMain;

    @Outlet
    UITableView tblMain;

    /**
     * the dictionary that will hold our words
     */
    List<String> dictionary = null;

    /**
     * The table source that will hold our matches
     */
    WordsTableSource tableSource = null;

    public SearchScreen() {
        super("SearchScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        getNavigationItem().setTitle("Search Bar Example");

        // load our dictonary words
        loadWords();

        // create our table source and bind it to the table
        tableSource = new WordsTableSource();
        tblMain.setSource(tableSource);

        // wire up the search button clicked handler to hide the keyboard
        srchMain.searchButtonClicked ;//+= (s, e) => { srchMain.ResignFirstResponder(); };

        // refine the search results every time the text changes
        srchMain.textChanged ;//+= (s, e) => { RefineSearchItems(); };
    }

    /**
     * This loads our dictionary of words into our _dictionary object.
     */
    protected void loadWords()
    {
        dictionary = File.readAllLines("Content/WordList.txt").toList();
    }

    /**
     * is called when the text in the search box text changes. i use some simple
     * LINQ to refine the word list in our table source
     */
    protected void refineSearchItems()
    {
        // select our words
        tableSource.words = dictionary.where(w.contains(srchMain.text)).toList();

        // refresh the table
        tblMain.reloadData();
    }

    /**
     * A simple table source that displays a list of strings
     */
    protected static class WordsTableSource extends UITableViewSource
    {
        protected String cellIdentifier = "wordsCell";

        /**
         * The words to display in the table
         */
        public List<String> words = new ArrayList<String>();

        /**
         * called by the table to determine how many rows to create, in our case, it's the number
         * of words.
         */
        @Override
        public int rowsInSection (UITableView tableview, int section)
        {
            return words.size();
        }

        /**
         * called by the table to determine how many sections to create, in this case, we just have one
         */
        @Override
        public int numberOfSections (UITableView tableView)
        {
            return 1;
        }

        /**
         * called by the table to generate the cell to display. in this case, it's very simple
         * and just displays the word.
         */
        @Override
        public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath)
        {
            // declare vars
            UITableViewCell cell = tableView.dequeueReusableCell (cellIdentifier);
            String word = words.get(indexPath.getRow());

            // if there are no cells to reuse, create a new one
            if (cell == null) {
                cell = new UITableViewCell(UITableViewCellStyle.DEFAULT, cellIdentifier);
            }

            // set the item text
            cell.getTextLabel().setText(word);

            return cell;
        }

    }

}
