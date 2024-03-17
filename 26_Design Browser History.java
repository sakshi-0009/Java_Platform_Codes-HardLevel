/* Problem Statement :-
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
*/

// Answer :-

class BrowserHistory {
    Page currentPage;
    public BrowserHistory(String homepage) {
        this.currentPage = new Page(homepage, null);
    }
    
    public void visit(String url) {
        Page page = new Page(url, this.currentPage);
        this.currentPage.next = page;
        this.currentPage = page;
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps; i ++) {
            if (this.currentPage.prev == null) {
                return this.currentPage.url;
            }
            this.currentPage = this.currentPage.prev;
        }
        return this.currentPage.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i ++) {
            if (this.currentPage.next == null) {
                return this.currentPage.url;
            }
            this.currentPage = this.currentPage.next;
        }
        return this.currentPage.url;
    }

    class Page {
        Page prev;
        Page next;
        String url;

        Page(String url, Page prev) {
            this.url = url;
            this.prev = prev;
        }
    }
}
